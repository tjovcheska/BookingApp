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

public class FilterCarsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by']")
    private RemoteWebElement filterCarsPageText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show results']")
    private RemoteWebElement showResultsButton;

    public FilterCarsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Filter cars page is loaded")
    public boolean filterCarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(filterCarsPageText)).isDisplayed();
    }

    @Step("Click cars by {0}")
    public void filterCarsBy(String type) {
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", type))).click();
    }

    @Step("Click `Show results` button")
    public void clickShowResultsButton() {
        showResultsButton.click();
    }
}
