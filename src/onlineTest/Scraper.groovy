
package onlineTest

import groovy.json.JsonOutput

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Scraper {
	private Element information;
	private Elements headers;
	private LinkedHashMap techMap 
	
	public Scraper(String url) {
		information = Jsoup.connect(url).get().select("#readme").first()
		headers = information.select("h2")
		techMap = new LinkedHashMap<String,ArrayList>()
		
		headers.each { header ->
			def techArr = []			
			def tableRows = header.nextElementSibling().select("tbody").select("tr")
			
			
			tableRows.each { row ->
				techArr.add(row.select("td").first().text())
			}
			techMap.put(header.text(), techArr)
		}
	}
	
	
	public void outputTechMapJson() {
		println( JsonOutput.prettyPrint(JsonOutput.toJson(techMap)) )
	}
	
	public static void main(String[] args) {

		def scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md")
		scraper.outputTechMapJson()
	}
}
