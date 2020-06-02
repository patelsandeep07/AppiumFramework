package Practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.FormPage;
import PageObjects.ProductPage;
import Practice.AppiumFramework.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommece_TC_7 extends Base {

		@Test
		public void totalValidation() throws IOException, InterruptedException {
		// Code Optimization Assert cart item is same as selected 
			
		service =startServer();	
		
		AndroidDriver<AndroidElement> driver = Capabilities("GenralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//clcik on text box and send name 
		FormPage formPage = new FormPage(driver);
		formPage.getnameField().sendKeys("Hello");
		driver.hideKeyboard();
		//select gender 
		formPage.getgenderOption().click();
		//click on place 
		formPage.getcountrySelection().click();
		//scroll to place argentina
		
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
		
		//click on place
		formPage.getcountrySelection().click();
		// click on letsshop
		formPage.getletsShop().click();
		//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//add to cart 2 items form 1 page 
		ProductPage prod = new ProductPage(driver);
		prod.getaddtoCart().get(0).click();
		//once click on add to cart object gets changed to added to cart, so if we give index as 1 for below code it wil lthrow an error for index out of bound as it change to 0 as add to casrt field changed in earlier case 
		prod.getaddtoCart().get(0).click();
		
		// clcik on cart button 
		prod.getcartButton().click();
		
		//give some wait or appium will take value from 1st page as object are same on last page as well 
		Thread.sleep(4000);
		
		//get  ammount value of item 
		CheckoutPage co = new CheckoutPage(driver);
		int count = co.getproductPrice().size();
		double sumofProduct = 0;
		for (int i=0; i<count; i++) {
			String amount = co.getproductPrice().get(i).getText();
			double amount1 = getAmount(amount);
			sumofProduct = sumofProduct + amount1;
		}
		System.out.println("Sum of Product " + sumofProduct);
		
		//compare sumofamount 
		String total = co.gettotalAmount().getText();
		double totalValue = getAmount(total);
		System.out.println("Total of Product " + totalValue);
		Assert.assertEquals(totalValue,sumofProduct);
		driver.closeApp();
		service.stop();
		}
	
	@BeforeTest
	public void killAllNodes() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM nodes.exe");
	}
	public static double getAmount(String Value)
	{
		Value = Value.substring(1);
		double amount2value = Double.parseDouble(Value);
		return amount2value; 
		
	}
}
