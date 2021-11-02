package stepDefinitions;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.xml.sax.SAXException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import application_Utills.CalculatorUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import util.Common_Function;

public class StepDefinition {

	public static AppiumDriver<MobileElement> driver;
	public Common_Function cfObj = new Common_Function();
	public CalculatorUtils calulatorUtitlObj;

	@When("I go to the calculator application")
	public void i_go_to_the_calculator_application() {

		try {
			driver = cfObj.commonStartAndOpenURLBrowser();
			calulatorUtitlObj = new CalculatorUtils(driver);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^I type \"([^\"]*)\" in the input field$")
	public void i_type_in_the_input_field(String string) throws Throwable {
		calulatorUtitlObj.typeMathematicalExpression(driver, string);
	}

	@When("^I click \"([^\"]*)\" button$")
	public void i_click_button(String arg1) throws Throwable {
		calulatorUtitlObj.clickEqual(driver);
	}

	@Then("^\"([^\"]*)\" result is displaying in the result field$")
	public void result_is_displaying_in_the_result_field(String string) throws Throwable {
		boolean result;
		result = calulatorUtitlObj.verifyPositiveResult(driver, string);
		Assert.assertEquals(result, true);
	}

	@When("^I type \"([^\"]*)\"$")
	public void i_type(String string) throws Throwable {
		calulatorUtitlObj.typeMathematicalExpression(driver, string);
	}

	@Then("^\"([^\"]*)\" result is displayed in the result field$")
	public void result_is_displayed_in_the_result_field(String string) throws Throwable {
		boolean result;
		result = calulatorUtitlObj.verifyPositiveResult(driver, string);
		Assert.assertEquals(result, true, calulatorUtitlObj.calulatorMsgList.toString());
	}

	@Then("^\"([^\"]*)\" red validation message appears in the result field$")
	public void red_validation_message_appears_in_the_result_field(String string) throws Throwable {
		boolean result;
		result = calulatorUtitlObj.verifyNegativeResult(driver, string);
		Assert.assertEquals(result, true, calulatorUtitlObj.calulatorMsgList.toString());
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "//target/cucumber-reports/screenshots//"
						+ screenshotName + ".png");
				// Copy taken screenshot from source location to destination location
				FileUtils.copyFile(sourcePath, destinationPath);
				//Files.copy(sourcePath, destinationPath);
			} catch (IOException e) {
			}
		}
	}
	
	@After(order = 0)
    public void tearDown() {
        driver.quit();
    }

}
