package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	//we can use android driver as well
	public ProductPage(AppiumDriver<AndroidElement>  driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
		//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
		private List <WebElement> addtoCart;
			
		//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		private WebElement cartButton;	
	
		public WebElement getcartButton() {
			return cartButton;
		}
		
		public List<WebElement> getaddtoCart() {
			return addtoCart;
		}
}
