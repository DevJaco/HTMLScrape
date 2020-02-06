package onlineTest;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScraperTest {

 
  @Test
  public void ScrapeInfoTest() {
    Scraper scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
    Assert.assertNotNull(scraper);
  }
  
  @Test
  public void addToMapTest() {
	Scraper scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
	String header = "asd";
	ArrayList<String> tech = new ArrayList<String>();
	tech.add("a");
	tech.add("b");
	
	scraper.addToTechMap(header, tech);
	Assert.assertEquals(scraper.getTechMap().size(), 5);

  }
  
  @Test 
  public void outputJsonTest() {
	Scraper scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
	Assert.assertEquals(scraper.outputTechMapJson(), "{\n" + 
			"    \"Programming Stack\": [\n" + 
			"        \"Java 8 / JVM\",\n" + 
			"        \"Groovy\",\n" + 
			"        \"Egis Kernel\",\n" + 
			"        \"Hibernate / JPA\",\n" + 
			"        \"Jetty\",\n" + 
			"        \"Hazelcast\",\n" + 
			"        \"PostgreSQL / MySQL / SQL Server\",\n" + 
			"        \"Lucene\",\n" + 
			"        \"TestNG\",\n" + 
			"        \"C#\",\n" + 
			"        \"Electron\",\n" + 
			"        \"Golang\",\n" + 
			"        \"Python\",\n" + 
			"        \"Markdown\",\n" + 
			"        \"Gitbook\",\n" + 
			"        \"ES6 / Babel\",\n" + 
			"        \"NPM\",\n" + 
			"        \"Yarn\",\n" + 
			"        \"Gulp\",\n" + 
			"        \"Selenium/Webdriver\",\n" + 
			"        \"Karma / Jasmine\",\n" + 
			"        \"ExtJS\",\n" + 
			"        \"Angular (1 or 2)\",\n" + 
			"        \"Vue.js\",\n" + 
			"        \"WebComponents / Polymer 2.0\",\n" + 
			"        \"React\"\n" + 
			"    ],\n" + 
			"    \"Build Stack\": [\n" + 
			"        \"Gradle\",\n" + 
			"        \"Ant\",\n" + 
			"        \"Babel / Gulp\",\n" + 
			"        \"npm\",\n" + 
			"        \"Github\",\n" + 
			"        \"CircleCI\",\n" + 
			"        \"AppVeyor\",\n" + 
			"        \"Jenkins\",\n" + 
			"        \"Codacy\",\n" + 
			"        \"Codecov\",\n" + 
			"        \"Amazon S3\",\n" + 
			"        \"Nexus / JFrog\"\n" + 
			"    ],\n" + 
			"    \"Infrastructure\": [\n" + 
			"        \"Ubuntu LTS\",\n" + 
			"        \"Docker\",\n" + 
			"        \"PostgreSQL\",\n" + 
			"        \"ansible\",\n" + 
			"        \"VMWare ESXi\",\n" + 
			"        \"VMWare vCenter\",\n" + 
			"        \"Amazon EC2\",\n" + 
			"        \"Amazon S3\",\n" + 
			"        \"Amazon DynomoDB\",\n" + 
			"        \"Cloudflare\",\n" + 
			"        \"Google Drive\",\n" + 
			"        \"Sendgrid\",\n" + 
			"        \"Google Apps\",\n" + 
			"        \"Hipchat\",\n" + 
			"        \"Slack\",\n" + 
			"        \"Trello\",\n" + 
			"        \"Fortigate\",\n" + 
			"        \"Dell\",\n" + 
			"        \"Docker Hub\"\n" + 
			"    ],\n" + 
			"    \"Monitoring\": [\n" + 
			"        \"Dripstat\",\n" + 
			"        \"Plumbr\",\n" + 
			"        \"Newrelic\",\n" + 
			"        \"Pagerduty\",\n" + 
			"        \"Nodegrid\",\n" + 
			"        \"health dashboard\"\n" + 
			"    ]\n" + 
			"}" + 
			"");
  }
}
