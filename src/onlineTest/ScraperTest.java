package onlineTest;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class ScraperTest {

 
  @Test
  public void ScrapeInfoTest() {
    Scraper scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
  }
  
  @Test
  public void addToMapTest() {
	Scraper scraper = new Scraper("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
	String header = "asd";
	ArrayList<String> tech = new ArrayList<String>();
	tech.add("a");
	tech.add("b");
	
	scraper.addToTechMap(header, tech);

  }
}
