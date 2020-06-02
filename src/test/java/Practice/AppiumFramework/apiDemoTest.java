package Practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Dependencies;
import PageObjects.HomePage;
import PageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class apiDemoTest extends Base{
	
	//as dataprovider in diffrent class need to give dataProviderClass with name 
	@Test (dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException {
	
	service = startServer();		
		
	AndroidDriver<AndroidElement> driver = Capabilities("apiDemo");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	HomePage h = new HomePage(driver);
	h.Preference.click();
	
	Thread.sleep(3000);
	Preferences p = new Preferences(driver);
	p.Dependencies.click();
	
	Dependencies d = new Dependencies(driver);
	d.wifiCheckbox.click();
	d.WifiSetting.click();
	d.WifiInput.sendKeys(input);
	
	d.Button.get(1).click();
	driver.closeApp();
	service.stop();
	}
	
	
	
}
