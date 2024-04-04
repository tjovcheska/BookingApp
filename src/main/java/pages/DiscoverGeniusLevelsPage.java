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

public class DiscoverGeniusLevelsPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/genius_levels_title")
    private RemoteWebElement discoverGeniusLevelsElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius Level 3']")
    private RemoteWebElement geniusLevel3Text;

    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;

    public DiscoverGeniusLevelsPage (AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Discover genius levels page is loaded")
    public boolean discoverGeniusLevelsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(discoverGeniusLevelsElement)).isDisplayed();
    }

    @Step("Swipe to Genius Level 3")
    public void swipeToGeniusLevel3() {
        swipeHorizontallyN(driver, Directions.LEFT, 2);
    }

    @Step("Validate Genius Level 3")
    public void validateGeniusLevel3() {
        geniusLevel3Text.isDisplayed();
    }

    @Step("Click `Got it` button")
    public void clickGotItButton() {
        gotItButton.click();
    }
}
