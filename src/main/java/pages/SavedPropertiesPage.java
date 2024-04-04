package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SavedPropertiesPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='My next trip'])[1]")
    private RemoteWebElement myNextTripText;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public SavedPropertiesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Saved properties page is loaded")
    public boolean savedPropertiesPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(myNextTripText)).isDisplayed();
    }

    @Step("Validate {0} property")
    public boolean validateProperty(String text) {
        try {
            return driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click `Back` button")
    public void clickBackButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backButton)).click();
    }
}
