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

public class GeniusLoyaltyProgramPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement geniusLoyaltyProgramText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Genius Levels']")
    private RemoteWebElement aboutGeniusLevelsButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public GeniusLoyaltyProgramPage (AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Genius loyalty program page is loaded")
    public boolean geniusLoyaltyProgramPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusLoyaltyProgramText)).isDisplayed();
    }

    @Step("Click `About genius levels` button")
    public void clickAboutGeniusLevelsButton() {
        swipeVerticallyN(driver, Directions.UP, 5);
        aboutGeniusLevelsButton.click();
    }

    @Step("Click `Back` button")
    public void clickBackButton() {
        backButton.click();
    }
}
