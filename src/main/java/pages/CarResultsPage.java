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

public class CarResultsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/fragment_container_view")
    private RemoteWebElement carResultsPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter']")
    private RemoteWebElement filterButton;

    public CarResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Car results page is loaded")
    public boolean carResultsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(carResultsPage)).isDisplayed();
    }

    @Step("Click `Filter` button")
    public void clickFilterButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(filterButton)).click();
    }

    @Step("Validate that first Car is {0}")
    public void validateCarResults(String type) {
        driver.findElement(By.xpath(String.format("(//android.widget.TextView[contains(@text, '%s')])[1]", type))).click();
    }
}
