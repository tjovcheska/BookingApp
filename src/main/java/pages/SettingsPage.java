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
import util.Helpers;

public class SettingsPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement settingsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']")
    private RemoteWebElement currencyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private RemoteWebElement privacyPolicyButton;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Settings page is loaded")
    public boolean settingsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(settingsText)).isDisplayed();
    }

    @Step("Click `Currency` button")
    public void clickCurrencyButton() {
        currencyButton.click();
    }

    @Step("Validate {0} currency")
    public boolean validateCurrency(String currency) {
        try {
            return driver.findElement(By.xpath(String.format("//android.widget.TextView[@text=\"Currency\"]/following-sibling::android.widget.TextView[@text='%s']", currency))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click `Privacy policy` button")
    public void clickPrivacyPolicyButton() {
        privacyPolicyButton.click();
    }
}
