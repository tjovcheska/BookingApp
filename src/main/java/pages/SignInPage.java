package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class SignInPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in or create account']")
    private RemoteWebElement signInText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement settingsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement geniusLoyaltyProgramButton;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Sign in page is loaded")
    public boolean signInPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInText)).isDisplayed();
    }

    @Step("Click `Settings` button")
    public void clickSettingsButton() {
        scrollToElementWithText(driver, "Settings");
        settingsButton.click();
    }

    @Step("Click `Genius loyalty program` button")
    public void geniusLoyaltyProgramButton() {
        geniusLoyaltyProgramButton.click();
    }
}
