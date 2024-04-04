package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class PickUpLocationPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/search_query_edittext")
    private RemoteWebElement pickupLocationTextField;

    public PickUpLocationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Pick up location page is loaded")
    public boolean pickUpLocationPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickupLocationTextField)).isDisplayed();
    }

    @Step("Add {0} as pick up location")
    public void addPickUpLocation(String location) {
        pickupLocationTextField.sendKeys(location);
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", location))).click();
    }
}
