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

public class DropOffTimePage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drop-off time']")
    private RemoteWebElement dropOffTimeText;

    public DropOffTimePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Drop off time page is loaded")
    public boolean dropOffTimePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dropOffTimeText)).isDisplayed();
    }

    @Step("Choose {time} as drop off time")
    public void chooseDropOfTime(String time) {
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", time))).click();
    }
}
