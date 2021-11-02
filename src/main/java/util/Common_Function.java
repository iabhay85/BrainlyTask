package util;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("unused")
public class Common_Function {
	static String seleniumRemoteAddress = null;
	static String strDeviceName;
	static String strEnv;
	static String strRunMode;
	static String strAppPackage;
	static String userName = null, accessKey = null;
	static String strFilePath = null;
	static String strApkPath = null;
	static String strAppActivity;

	static {
		strDeviceName = System.getProperty("deviceId");
		userName = System.getProperty("userName");
		accessKey = System.getProperty("accessKey");
		System.out.println("strDeviceName " + strDeviceName);
		strEnv = System.getProperty("env");
		strEnv = "Staging";
		strRunMode = System.getProperty("runMode");
		strRunMode = "local";
		strAppPackage = "com.google.android.calculator";
		strAppActivity = "com.android.calculator2.Calculator";
		if (strRunMode.equalsIgnoreCase("local")) {
			seleniumRemoteAddress = "http://localhost:4723/wd/hub";
			strDeviceName = "c00baef1";
		} else if (strRunMode.equalsIgnoreCase("cloud")) {
			strDeviceName = "OnePlus 7T";
			seleniumRemoteAddress = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
			strFilePath = System.getProperty("apkId");
		}

	}

	public AppiumDriver<MobileElement> commonStartAndOpenURLBrowser()
			throws ParserConfigurationException, SAXException, IOException {

		DesiredCapabilities capability = null;
		AppiumDriver<MobileElement> driver = null;
		try {
			File filePath = new File(System.getProperty("user.dir"));
			File appDir = new File(filePath, "/src/main/resources");
			File app = new File(appDir, "calculator.apk");
			capability = new DesiredCapabilities();
			capability.setCapability("deviceName", strDeviceName);
			capability.setCapability(CapabilityType.VERSION, "10.0");
			capability.setCapability("platformName", "Android");
			capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
			capability.setCapability("appPackage", strAppPackage);
			capability.setCapability("appActivity", strAppActivity);
			capability.setCapability("clearDeviceLogsOnStart", true);
			capability.setCapability("noReset", false);
			capability.setCapability("unicodeKeyboard", false);
			capability.setCapability("resetKeyboard", false);
			if (strRunMode.equalsIgnoreCase("cloud")) {
				capability.setCapability("app", strFilePath);
			} else {
				capability.setCapability("app", app.getAbsolutePath());
			}
			System.out.println("capability " + capability);
			driver = new AppiumDriver<MobileElement>(new URL(seleniumRemoteAddress), capability);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println(driver.executeScript("mobile:batteryInfo"));

		}

		catch (

		Exception e) {
			e.printStackTrace();

		} finally {

		}
		return driver;
	}

	public void commonClick(MobileElement iclickInfo) throws IOException, SAXException, ParserConfigurationException {

		try {
			iclickInfo.click();
			Thread.sleep(500);

		} catch (Exception e) {

		}
	}

	public void commonClick(WebElement iclickInfo) throws IOException, SAXException, ParserConfigurationException {

		try {
			iclickInfo.click();
			Thread.sleep(500);

		} catch (Exception e) {

		}
	}

	/**
	 * @param iTextBoxInfo WebElement reference
	 * @param sText        String type text which will be set in text box
	 * @return boolean True/False as a result on the basis of findings
	 * @throws IOException                  if IO exception occurred
	 * @throws ParserConfigurationException if parse configuration exception
	 *                                      occurred
	 * @throws SAXException                 if SAX exception occurred
	 */
	public boolean commonSetTextTextBox(WebElement iTextBoxInfo, String sText)
			throws IOException, ParserConfigurationException, SAXException {

		boolean Result = false;
		try {
			iTextBoxInfo.clear();
			iTextBoxInfo.click();
			iTextBoxInfo.sendKeys(sText);
			Result = commonVerifyValueTextBox(iTextBoxInfo, sText);

		} catch (Exception ex) {
			Result = false;
		}
		return Result;
	}

	/**
	 * @param iTextBoxInfo   WebElement reference
	 * @param sExpectedValue String type expected value
	 * @return boolean True/False as a result on the basis of verification pass or
	 *         fail
	 * @throws IOException                  if IO exception occurred
	 * @throws SAXException                 if SAX exception occurred
	 * @throws ParserConfigurationException if parser configuration exception
	 *                                      occurred
	 */
	public boolean commonVerifyValueTextBox(WebElement iTextBoxInfo, String sExpectedValue)
			throws IOException, SAXException, ParserConfigurationException {

		String sTempStr = null;
		boolean Result = false;

		try {
			sExpectedValue = sExpectedValue.trim().toLowerCase();

			sTempStr = iTextBoxInfo.getAttribute("value").trim().toLowerCase();

			if ((sTempStr.contains(sExpectedValue))) {
				Result = true;
			} else {
				Result = false;
			}
		} catch (Exception e) {
			Result = false;
		}
		return Result;
	}

	public JsonObject getJsonData(String strfileLocation) {
		JsonElement jsonData = null;
		try {
			jsonData = new JsonParser().parse(new FileReader(strfileLocation));
			System.out.println(jsonData.getAsJsonObject());
			System.out.println(jsonData.getAsJsonObject().get("मराठी").getAsJsonObject().get("title"));
		} catch (Exception e) {

		}
		return jsonData.getAsJsonObject();
	}

	public Boolean scrollByID(String xpath, AppiumDriver<MobileElement> driver) {
		Boolean result = false;
		try {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
					+ "instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + xpath + "\").instance(0));"))
					.click();

			result = true;

			System.out.println("element is displayed ");

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public String randomPhoneNumber(long len, String start) {
		String num = null;
		try {
			if (len > 10)
				throw new IllegalStateException("To many digits");
			long tLen = (long) Math.pow(10, len - 1) * 9;

			long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

			String tVal = start + number + "";

			num = tVal.substring(0, 10);

			if (num.length() != len) {

				throw new IllegalStateException("The random number '" + num + "' is not '" + len + "' digits");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to generate Random Mobile number");

		}
		return num;
	}

	public static String getCurrentDateTime() {
		LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		return currentDateTime.toString();
	}

	public int getRandomNumber(int start, int end) {
		Random rand = new Random();
		int randomNum = rand.nextInt((end - start) + 1) + start;
		return randomNum;
	}

	/**
	 * @param iTextBoxInfo WebElement reference
	 * @param sText        String type text which will be set in text box
	 * @return boolean True/False as a result on the basis of findings
	 * @throws IOException                  if IO exception occurred
	 * @throws ParserConfigurationException if parse configuration exception
	 *                                      occurred
	 * @throws SAXException                 if SAX exception occurred
	 */
	public boolean commonSetTextTextBox_Action(AppiumDriver<MobileElement> driver, String sText)
			throws IOException, ParserConfigurationException, SAXException {

		boolean Result = false;
		try {
			Actions action = new Actions(driver);
			action.sendKeys(sText).perform();
		} catch (Exception ex) {
			Result = false;
		}
		return Result;
	}

	@SuppressWarnings("rawtypes")
	public void sendKeys(AppiumDriver<MobileElement> driver, String sText) {
		try {
			if (!strRunMode.equalsIgnoreCase("Cloud")) {
				List enterText = Arrays.asList("text", sText);

				Map<String, Object> cmd = ImmutableMap.of("command", "input", "args", enterText);

				driver.executeScript("mobile: shell", cmd);
			} else {
				commonSetTextTextBox_Action(driver, sText);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public boolean scrollUtillTheElementFound(AppiumDriver<MobileElement> driver, String elementToFind) {
		boolean result = true, isFound = false;
		int count = 0;
		try {

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			List<MobileElement> elements = driver.findElements(By.xpath(elementToFind));
			isFound = elements.size() > 0;
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = size.width;
			int height = size.height;
			int middleOfX = width / 2;
			int startYCoordinate = (int) (height * .7);
			int endYCoordinate = (int) (height * .2);
			while (!isFound && count < 5) {
				count = count + 1;
				action.press(PointOption.point(middleOfX, startYCoordinate))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
				isFound = driver.findElements(By.xpath(elementToFind)).size() > 0;
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("error in scroll");
			result = false;
		}
		return isFound;
	}

	public String getLangaugeKey(String strLangauge) {
		String strLanguagekey = null;
		try {
			if (strLangauge.equalsIgnoreCase("English")) {
				strLanguagekey = "en_IN";
			} else if (strLangauge.equalsIgnoreCase("Marathi")) {
				strLanguagekey = "mr_IN";
			} else if (strLangauge.equalsIgnoreCase("Hinglish")) {
				strLanguagekey = "hr_IN";
			} else if (strLangauge.equalsIgnoreCase("Hindi")) {
				strLanguagekey = "hi_IN";
			} else if (strLangauge.equalsIgnoreCase("Panjabi")) {
				strLanguagekey = "pa_IN";
			} else if (strLangauge.equalsIgnoreCase("Tamil")) {
				strLanguagekey = "ta_IN";
			} else if (strLangauge.equalsIgnoreCase("Telugu")) {
				strLanguagekey = "te_IN";
			} else if (strLangauge.equalsIgnoreCase("Gujarati")) {

				strLanguagekey = "gu_IN";
			} else if (strLangauge.equalsIgnoreCase("Assamese")) {

				strLanguagekey = "as_IN";
			} else if (strLangauge.equalsIgnoreCase("Bengali")) {

				strLanguagekey = "bn_IN";
			} else if (strLangauge.equalsIgnoreCase("Kannada")) {

				strLanguagekey = "kn_IN";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return strLanguagekey;

	}

	public static String convert(String str) {

		// Create a char array of given String
		char ch[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {

			// If first character of a word is found
			if (i == 0 && ch[i] != ' ' || ch[i] != ' ' && ch[i - 1] == ' ') {

				// If it is in lower-case
				if (ch[i] >= 'a' && ch[i] <= 'z') {

					// Convert into Upper-case
					ch[i] = (char) (ch[i] - 'a' + 'A');
				}
			}

			// If apart from first character
			// Any one is in Upper-case
			else if (ch[i] >= 'A' && ch[i] <= 'Z')

				// Convert into Lower-Case
				ch[i] = (char) (ch[i] + 'a' - 'A');
		}

		// Convert the char array to equivalent String
		String st = new String(ch);
		System.out.println("new string: " + st);
		return st;
	}

	/**
	 * @param iTextBoxInfo WebElement reference
	 * @param sText        String type text which will be set in text box
	 * @return boolean True/False as a result on the basis of findings
	 * @throws IOException                  if IO exception occurred
	 * @throws ParserConfigurationException if parse configuration exception
	 *                                      occurred
	 * @throws SAXException                 if SAX exception occurred
	 */
	@SuppressWarnings("deprecation")
	public boolean commonClearAndSendKeys(AppiumDriver<MobileElement> driver, MobileElement iTextBoxInfo, String sText)
			throws IOException, ParserConfigurationException, SAXException {

		boolean Result = true;
		String prefieldText;
		try {
			iTextBoxInfo.click();
			prefieldText = iTextBoxInfo.getText().toString();
			prefieldText = prefieldText.split(",")[0];
			for (int i = 0; i < prefieldText.length(); i++) {
				// driver.pressKeyCode(67);
				Thread.sleep(500);
			}
			if (strRunMode.equalsIgnoreCase("cloud")) {
				commonSetTextTextBox_Action(driver, sText);
			} else {
				commonSetTextTextBox_Action(driver, sText);
			}
			driver.hideKeyboard();
		} catch (Exception ex) {
			Result = false;
		}
		return Result;
	}

	public MobileElement commonGetElement(AppiumDriver<MobileElement> driver, String elementforWait,
			String strfindType) {
		MobileElement element = null;
		try {
			if (strfindType.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(elementforWait));
			} else if (strfindType.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(elementforWait));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return element;
	}

	public List<MobileElement> commonGetElements(AppiumDriver<MobileElement> driver, String elementforWait,
			String strfindType) {
		List<MobileElement> element = null;
		try {
			if (strfindType.equalsIgnoreCase("xpath")) {
				element = driver.findElements(By.xpath(elementforWait));
			} else if (strfindType.equalsIgnoreCase("id")) {
				element = driver.findElements(By.id(elementforWait));
			} else if (strfindType.equalsIgnoreCase("class")) {
				element = driver.findElements(By.className(elementforWait));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return element;
	}

	public static String getCurrentDateInGivenFormat(String dateFormat) {
		SimpleDateFormat DateFor;
		String stringDate = null;
		try {
			Date date = new Date();
			DateFor = new SimpleDateFormat(dateFormat);
			stringDate = DateFor.format(date);
			System.out.println("Date Format with E, dd MMM yyyy:" + stringDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stringDate;
	}

	public void closePopUpIfExist(AppiumDriver<MobileElement> driver) {
		List<MobileElement> popups;
		try {
			Thread.sleep(10000);
			popups = commonGetElements(driver, "android.widget.ImageView", "class");
			if (popups.size() == 2) {
				commonClick(popups.get(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public String getTimedifference(long start, long end) {
		String strTime = null;
		try {
			NumberFormat formatter = new DecimalFormat("#0.00000");
			strTime = formatter.format((end - start) / 1000d) + " seconds";
			System.out.println(strTime);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

		return strTime;

	}

	public static String getFutureDateTime(String currentDate, int numberOfDays) {
		String newDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();

			c.setTime(sdf.parse(currentDate));

			// Incrementing the date by n day
			c.add(Calendar.DAY_OF_MONTH, numberOfDays);
			newDate = sdf.format(c.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newDate;
	}

	public static String getCurrentate(String strPattern) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strPattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		return date;
	}

	public static Integer RandomNumber(int start, int end) {
		Random rand = new Random();
		int randomNum = rand.nextInt((end - start) + 1) + start;
		return randomNum;

	}

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			date = formatter.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean isSorted(List<Date> dateString) {
		for (int i = 0; i < dateString.size() - 1; ++i) {
			System.out.println(dateString.get(i));
			if (dateString.get(i).compareTo(dateString.get(i + 1)) > 0)
				return false;
		}
		return true;
	}

	public boolean scrollUpUtillTheElementFound(AppiumDriver<MobileElement> driver, String elementToFind) {
		boolean result = true, isFound = false;
		int count = 0;
		try {

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			List<MobileElement> elements = driver.findElements(By.xpath(elementToFind));
			isFound = elements.size() > 0;
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = size.width;
			int height = size.height;
			int middleOfX = width / 2;
			int endYCoordinate = (int) (height * .7);
			int startYCoordinate = (int) (height * .2);
			while (!isFound && count < 5) {
				count = count + 1;
				action.press(PointOption.point(middleOfX, startYCoordinate))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
				isFound = driver.findElements(By.xpath(elementToFind)).size() > 0;
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("error in scroll");
			result = false;
		}
		return isFound;
	}

	/**
	 * @param iTextBoxInfo WebElement reference
	 * @param sText        String type text which will be set in text box
	 * @return boolean True/False as a result on the basis of findings
	 * @throws IOException                  if IO exception occurred
	 * @throws ParserConfigurationException if parse configuration exception
	 *                                      occurred
	 * @throws SAXException                 if SAX exception occurred
	 */
	@SuppressWarnings("deprecation")
	public boolean commonClearTextAndSendKeys(AppiumDriver<MobileElement> driver, MobileElement iTextBoxInfo,
			String sText) throws IOException, ParserConfigurationException, SAXException {

		boolean Result = true;
		String prefieldText;
		try {
			iTextBoxInfo.click();
			prefieldText = iTextBoxInfo.getText().toString();
			prefieldText = prefieldText.split(",")[0];
			for (int i = 0; i < prefieldText.length(); i++) {
				// driver.pressKeyCode(67);
			}
			if (strRunMode.equalsIgnoreCase("cloud")) {
				commonSetTextTextBox_Action(driver, sText);
			} else {
				commonSetTextTextBox_Action(driver, sText);
			}
		} catch (Exception ex) {
			Result = false;
		}
		return Result;
	}

}
