
package onlineTest

import groovy.json.JsonOutput

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Scraper {
	private Element information;
	private Elements headers;
	private LinkedHashMap techMap ;
	private ArrayList techList ;
	
	public Scraper(String url) {
		information = Jsoup.connect(url).get().select("#readme").first()
		headers = information.select("h2")
		techMap = new LinkedHashMap<String,ArrayList>()
		techList = new ArrayList<String>()
		
		headers.each { header ->
			setTechList(header)
			try {
				appendToMap(header)
			}catch(Exception e) {
				println(e.getMessage())
			}
			
		}
	}
	
	
	public void setTechList(Element header) {
		techList.clear()
		def tableRows = header.nextElementSibling().select("tbody").select("tr")
		tableRows.each { row ->
			techList.add(row.select("td").first().text())
		}
	}
	
	public void appendToMap(Element header) {
		if(!checkTechListEmpty()) {
			techMap.put(header.text(), techList)
		}
		else {
			throw new Exception("Tech list was not initialised")
		}
	}
	
	public boolean checkTechListEmpty() {
		return techList.isEmpty()
	}
	
	public void outputTechMapJson() {
		println( JsonOutput.prettyPrint(JsonOutput.toJson(techMap)) )
	}
	
	public static void main(String[] args) {

		def scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md")
		scraper.outputTechMapJson()
	}
}
