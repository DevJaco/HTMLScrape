package onlineTest

import groovy.json.JsonOutput

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Scraper {
	
	public static void main(String[] args) {

		def doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get()
		
		//Scraping headers
		def block = doc.select("#readme").first()
		def headers = block.select("h2")
		
		//Map in order to store the information for JSON output
		
		def obj = [:]
		
		headers.each { header -> 
			
			//Array in order to hold the list of technologies
			
			
			def techlist = []
			
			//println(header.text())
			//println()
			
			//A table always follows a header and therefore we can use the nextElementSibling function
			def table = header.nextElementSibling()
			def tableRows = table.select("tbody").select("tr")
			
			//Adding the tech to the array
			tableRows.each { row ->
				techlist.add(row.select("td").first().text())
				//println(row.select("td").first().text())
			
			}
			
			obj.put(header.text(), techlist)
			//println JsonOutput.prettyPrint(JsonOutput.toJson(obj))
		}
		
		println JsonOutput.prettyPrint(JsonOutput.toJson(obj))
	}
}


