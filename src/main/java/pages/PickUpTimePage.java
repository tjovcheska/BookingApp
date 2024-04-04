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
import util.Helpers;

public class PickUpTimePage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pickup time']")
    private RemoteWebElement pickUpTimeText;

    public PickUpTimePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Pick up time page is loaded")
    public boolean pickUpTimePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickUpTimeText)).isDisplayed();
    }

    @Step("Choose {time} as pick up time")
    public void choosePickUpTime(String time) {
        swipeVerticallyN(driver, Directions.DOWN, 2);
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", time))).click();
    }
}
