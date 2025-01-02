package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	

	public WebDriver driver;

	public LoginPage loginpage ;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();

		loginpage = new LoginPage(driver);



	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

              driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
      
          loginpage.enterEmail(emailAdd);
          loginpage.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {

          loginpage.clickOnLoginButton();
          Thread.sleep(4000);

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		 String ActualTitle = driver.getTitle();
		 if(ActualTitle.equals(expectedTitle))
		 {
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		loginpage.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() {
		
		driver.close();
		driver.quit();


	}



}
