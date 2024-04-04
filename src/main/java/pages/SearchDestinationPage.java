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

public class SearchDestinationPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter destination']")
    private RemoteWebElement destinationTextField;

    public SearchDestinationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Search destination page is loaded")
    public boolean searchDestinationPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(destinationTextField)).isDisplayed();
    }

    @Step("Choose {0} ad destination")
    public void chooseDestination(String destination) {
        destinationTextField.sendKeys(destination);
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", destination))))).click();
    }
}
