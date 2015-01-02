package com.sundeepmachado;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class GoogleSearch {
  
      public static WebDriver driver = null;
      public static WebDriverWait wait = null;
   
	// This is the initial setup before the test is carried out
	@BeforeMethod
      public void setUp() throws IOException {
                      // This specifies which driver you want to use. If you want to use IE or Chrome you need to 
                      //add the corresponding drivers 
                     driver = new FirefoxDriver();
                      //Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
                      driver.manage().timeouts().implicitlyWait(110, TimeUnit.MILLISECONDS);
                      wait = new WebDriverWait(driver, 20);

      }
      // This method will go to a URL you want to test, in this case google
      private void getUrl(String URLString) {
    	  System.out.println("In Get URL");
          driver.get(URLString);
}
    // This method enters a keyword into the google search box, since autocompletion is on Google takes you to next page where
    // it displays search results
    
	public void enterQuery(String query)throws InterruptedException {
		 // If anything is present in Google search input (id =q), clear it
		 driver.findElement(By.name("q")).clear();
		 // Just enter the query string in the Google search input box
         driver.findElement(By.name("q")).sendKeys(query);
         
	}
	
	// gets the title of page from the current page
	public String findTitle( )throws InterruptedException {
		String title= driver.getTitle();
		return title;
	}
	
	
	// This is done after the tests are finished. Important to close the driver after you finish your work.
	@AfterMethod
	public void tearDown() {
		  driver.close();
		 }
		 
	
	@Test
	public void googleSearchTest()  throws Exception{
		
		GoogleSearch search = new GoogleSearch();
		search.getUrl("http://google.com");
		search.enterQuery("sundeep machado");
		
		Assert.assertEquals(search.findTitle(),"Google");
	}

}