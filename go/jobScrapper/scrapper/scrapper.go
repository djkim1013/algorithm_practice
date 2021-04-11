package scrapper

import (
	"encoding/csv"
	"fmt"
	"log"
	"net/http"
	"os"
	"strconv"
	"strings"

	"github.com/PuerkitoBio/goquery"
)

type jobCard struct {
	id       string
	title    string
	location string
	salary   string
	summary  string
}

//Scrape : job scrapper
func Scrape(term string) {
	var baseURL string = "https://kr.indeed.com/jobs?q=" + term + "&limit=50"
	var jobs []jobCard
	totalPages := getPageNum(baseURL)
	fmt.Println("total page:", totalPages)
	c := make(chan []jobCard)
	for i := 0; i < totalPages; i++ {
		go getPage(i, baseURL, c)
	}
	for i := 0; i < totalPages; i++ {
		job := <-c
		jobs = append(jobs, job...)
	}
	writeJobs(jobs)
}

func getPage(page int, url string, mainC chan<- []jobCard) {
	var jobs []jobCard
	c := make(chan jobCard)
	pageURL := url + "&start=" + strconv.Itoa(page*50)
	fmt.Println("Requesting", pageURL)
	res, err := http.Get(pageURL)
	checkErr(err)
	defer res.Body.Close()
	doc, err := goquery.NewDocumentFromReader(res.Body)
	checkErr(err)
	searchCards := doc.Find(".jobsearch-SerpJobCard")
	searchCards.Each(func(i int, s *goquery.Selection) {
		go makeJobCard(s, c)
	})
	for i := 0; i < searchCards.Length(); i++ {
		job := <-c
		jobs = append(jobs, job)
	}
	mainC <- jobs
}

func writeJobs(jobs []jobCard) {
	file, err := os.Create("jobs.csv")
	checkErr(err)
	w := csv.NewWriter(file)
	defer w.Flush()
	headers := []string{"ID", "Title", "location", "salary", "summary"}
	wErr := w.Write(headers)
	checkErr(wErr)
	c := make(chan []string)
	for _, job := range jobs {
		go writeJob(job, c)
	}
	for i := 0; i < len(jobs); i++ {
		err := w.Write(<-c)
		checkErr(err)
	}
}

func writeJob(job jobCard, c chan<- []string) {
	jobSlice := []string{"https://kr.indeed.com/viewjob?jk=" + job.id, job.title, job.location, job.salary, job.summary}
	c <- jobSlice
}

func cleanString(str string) string {
	return strings.Join(strings.Fields(strings.TrimSpace(str)), " ")
}

func makeJobCard(src *goquery.Selection, c chan jobCard) {
	id, _ := src.Attr("data-jk")
	title := cleanString(src.Find(".title>a").Text())
	location := cleanString(src.Find(".sjcl").Text())
	salary := cleanString(src.Find(".salaryText").Text())
	summary := cleanString(src.Find(".summary").Text())
	c <- jobCard{
		id:       id,
		title:    title,
		location: location,
		salary:   salary,
		summary:  summary}
}

func getPageNum(url string) int {
	pages := 0
	res, err := http.Get(url)
	checkErr(err)
	checkCodes(res)

	defer res.Body.Close()

	doc, err := goquery.NewDocumentFromReader(res.Body)
	checkErr(err)
	doc.Find(".pagination").Each(func(i int, s *goquery.Selection) {
		pages = s.Find("a").Length()
	})

	return pages
}

func checkErr(err error) {
	if err != nil {
		log.Fatalln(err)
	}
}

func checkCodes(res *http.Response) {
	if res.StatusCode != 200 {
		log.Fatalln("Request failed:", res.StatusCode)
	}
}
