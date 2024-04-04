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

public class ResultsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/sr_toolbar")
    private RemoteWebElement searchDetailsField;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Save property to list'])[1]")
    private RemoteWebElement favoritesButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public ResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Results page is loaded")
    public boolean resultsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchDetailsField)).isDisplayed();
    }

    @Step("Validate {0} destination")
    public boolean validateDestination(String destination) {
        try {
            return driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", destination))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate {0} stay dates")
    public boolean validateStayDates(String stayDates) {
        try {
            return driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", stayDates))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click `Favorites` button")
    public void clickFavoritesButton() {
        favoritesButton.click();
    }

    @Step("Click `Back` button")
    public void clickBackButton() {
        backButton.click();
    }
}
