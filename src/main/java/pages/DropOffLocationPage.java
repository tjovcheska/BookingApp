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

public class DropOffLocationPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Drop-off location']")
    private RemoteWebElement dropOffLocationTextField;

    public DropOffLocationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Drop off location page is loaded")
    public boolean dropOffLocationPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dropOffLocationTextField)).isDisplayed();
    }

    @Step("Add {0} as drop off location")
    public void addDropOffLocation(String location) {
        dropOffLocationTextField.sendKeys(location);
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", location))).click();
    }
}
