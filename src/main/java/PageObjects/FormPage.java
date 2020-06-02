package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	//we can use android driver as well
	public FormPage(AppiumDriver<AndroidElement>  driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	//driver.findElementByXPath("//*[@text='Female']").click();
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement genderOption;
	
	//driver.findElementById("android:id/text1").click();
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	//driver.findElementByXPath("//*[@text='Argentina']").click();
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	private WebElement selectCountry;
	
//	/driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public WebElement getnameField(){
		System.out.println("GetName field display");
		return nameField;
	}
	
	public WebElement getgenderOption() {
		return genderOption;
	}
	
	public WebElement getcountrySelection() {
		return countrySelection;
	}
	
	public WebElement getselectCountry() {
		return selectCountry;
	}
	
	public WebElement getletsShop() {
		return letsShop;
	}

	

	
}
