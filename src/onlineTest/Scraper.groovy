
package onlineTest

import groovy.json.JsonOutput

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Scraper {
	private Element information
	private Elements headers
	private LinkedHashMap techMap 
	
	public Scraper(String url) {
		information = Jsoup.connect(url).get().select("#readme").first()
		if(information.is(null)) {
			throw new Exception("That webpage cannot be scraped")
		}
		headers = information.select("h2")
		techMap = new LinkedHashMap<String,ArrayList>()
		
		headers.each { header ->
			def techArr = []	
			def tableRows = header.nextElementSibling().select("tbody").select("tr")
			
			tableRows.each { row ->
				techArr.add(row.select("td").first().text())
			}
			addToTechMap(header.text(), techArr);
		}
	}
	
	public void addToTechMap(String header, ArrayList tech) {
		if(header.isEmpty()) {
			throw new Exception("Cannot add empty header")
		}
		if(tech.is(null)) {
			throw new Exception("Cannot add null array to map")
		}
		if(tech.isEmpty()) {
			throw new Exception("Cannot add empty array to map")
			
		}
		if(techMap.is(null)) {
			throw new Exception("Cannot put to null object")
		}
		techMap.put(header, tech)
	}
	
	public LinkedHashMap getTechMap() {
		return techMap;
	}
	public String outputTechMapJson() {
		return JsonOutput.prettyPrint(JsonOutput.toJson(techMap)) 
	}
	
	public static void main(String[] args) {
		def scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md")
		println(scraper.outputTechMapJson())
	}
}
