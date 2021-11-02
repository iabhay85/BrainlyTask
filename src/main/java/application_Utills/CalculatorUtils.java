package application_Utills;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import pageObject.CalulatorPage;
import util.Common_Function;

public class CalculatorUtils {

	public CalulatorPage calulatorPageObj;
	public List<String> calulatorMsgList = new ArrayList<String>();
	public Common_Function cfObj = new Common_Function();

	public CalculatorUtils(AppiumDriver<MobileElement> driver) {
		calulatorPageObj = new CalulatorPage();
		PageFactory.initElements(new AppiumFieldDecorator(driver), calulatorPageObj);
	}

	public void typeMathematicalExpression(AppiumDriver<MobileElement> driver, String strExpression) {
		try {
			System.out.println("strExpression: " + strExpression);
			for (int i = 0; i < strExpression.length(); i++) {
				System.out.println("Char at: " + i + " is: " + strExpression.charAt(i));
				if (strExpression.charAt(i) == '1') {

				} else if (strExpression.charAt(i) == '2') {
					cfObj.commonClick(calulatorPageObj.getDigit2().get(0));

				} else if (strExpression.charAt(i) == '3') {

				} else if (strExpression.charAt(i) == '4') {

				} else if (strExpression.charAt(i) == '5') {

					cfObj.commonClick(calulatorPageObj.getDigit5().get(0));

				} else if (strExpression.charAt(i) == '6') {

					cfObj.commonClick(calulatorPageObj.getDigit6().get(0));

				} else if (strExpression.charAt(i) == '7') {

				} else if (strExpression.charAt(i) == '8') {

				} else if (strExpression.charAt(i) == '9') {

					cfObj.commonClick(calulatorPageObj.getDigit9().get(0));

				} else if (strExpression.charAt(i) == '0') {

					cfObj.commonClick(calulatorPageObj.getDigit0().get(0));

				} else if (strExpression.charAt(i) == '+') {

					cfObj.commonClick(calulatorPageObj.getOp_add().get(0));

				} else if (strExpression.charAt(i) == '/') {

					cfObj.commonClick(calulatorPageObj.getOp_div().get(0));

				} else if (strExpression.charAt(i) == '*') {

				} else if (strExpression.charAt(i) == '-') {

				} else if (strExpression.charAt(i) == 's' && strExpression.charAt(i + 1) == 'i'
						&& strExpression.charAt(i + 2) == 'n') {
					System.out.println("i am in sin");
					cfObj.commonClick(calulatorPageObj.getFun_sin().get(0));
					i = i + 3;
					System.out.println("value of i: " + i);
				} else if (strExpression.charAt(i) == 'p' && strExpression.charAt(i + 1) == 'i') {
					System.out.println("i am in pi");
					cfObj.commonClick(calulatorPageObj.getConst_pi().get(0));
					i = i + 1;
				} else if (strExpression.charAt(i) == ')') {
					System.out.println("i am at right parens");
					cfObj.commonClick(calulatorPageObj.getRightParens().get(0));

				} else if (strExpression.charAt(i) == '(') {
					System.out.println("i am at left parens");

					cfObj.commonClick(calulatorPageObj.getLeftParens().get(0));

				} else if (strExpression.charAt(i) == 'l') {
					cfObj.commonClick(calulatorPageObj.getFun_log().get(0));
					i = i + 3;
				} else if (strExpression.charAt(i) == 'e') {
					cfObj.commonClick(calulatorPageObj.getConst_e().get(0));
				} else if (strExpression.charAt(i) == 's' && strExpression.charAt(i + 1) == 'q'
						&& strExpression.charAt(i + 2) == 'r' && strExpression.charAt(i + 3) == 't') {
					cfObj.commonClick(calulatorPageObj.getOp_sqrt().get(0));
					i = i + 3;
				} else if (strExpression.charAt(i) == '^') {

					cfObj.commonClick(calulatorPageObj.getOp_pow().get(0));

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickEqual(AppiumDriver<MobileElement> driver) {
		try {
			cfObj.commonClick(calulatorPageObj.getoperatorEqual().get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean verifyPositiveResult(AppiumDriver<MobileElement> driver, String strExpectedResult) {
		boolean result = true;
		String strActualResult;
		try {
			strActualResult = calulatorPageObj.getResult_final().get(0).getText().toString();
			System.out.println("strActualResult: " + strActualResult);
			if (!strActualResult.equalsIgnoreCase(strExpectedResult)) {
				calulatorMsgList.add("Expected result: "+strExpectedResult+ " actual result: "+strActualResult);
				result = false;
			}

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean verifyNegativeResult(AppiumDriver<MobileElement> driver, String strExpectedResult) {
		boolean result = true;
		String strActualResult;
		try {
			strActualResult = calulatorPageObj.getResult_preview().get(0).getText().toString();
			System.out.println("strActualResult: " + strActualResult);
			if (!strActualResult.equalsIgnoreCase(strExpectedResult)) {
				calulatorMsgList.add("Expected result: "+strExpectedResult+ " actual result: "+strActualResult);
				result = false;
			}
		    (new TouchAction((PerformsTouchActions) driver)).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(calulatorPageObj.getDel().get(0))).withDuration(Duration.ofMillis(5))).release().perform();

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
