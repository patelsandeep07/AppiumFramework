package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dependencies {
	
	//we can use android driver as well
	public Dependencies(AppiumDriver<AndroidElement>  driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement wifiCheckbox;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement WifiSetting;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement WifiInput;
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> Button;
	
	
	
}
