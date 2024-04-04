package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.qameta.allure.Step;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;

    public DesiredCapabilities capabilities = new DesiredCapabilities();
    protected Helpers helpers;
    protected LandingPage landingPage;
    protected StaysPage staysPage;
    protected SearchDestinationPage searchDestinationPage;
    protected SelectDatesPage selectDatesPage;
    protected SelectRoomsAndGuestsPage selectRoomsAndGuestsPage;
    protected  ResultsPage resultsPage;
    protected BottomNavigationBar bottomNavigationBar;
    protected SavedPropertiesPage savedPropertiesPage;
    protected SignInPage signInPage;
    protected SettingsPage settingsPage;
    protected CurrencyPage currencyPage;
    protected PrivacyPolicyPage privacyPolicyPage;
    protected SavedPage savedPage;
    protected GeniusLoyaltyProgramPage geniusLoyaltyProgramPage;
    protected DiscoverGeniusLevelsPage discoverGeniusLevelsPage;
    protected CarRentalPage carRentalPage;
    protected PickUpLocationPage pickUpLocationPage;
    protected DropOffLocationPage dropOffLocationPage;
    protected DatePage datePage;
    protected PickUpTimePage pickUpTimePage;
    protected DropOffTimePage dropOffTimePage;
    protected CarResultsPage carResultsPage;

    protected FilterCarsPage filterCarsPage;

    @BeforeMethod
    @Step("Set up the driver")
    public void setUp() {

        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(UiAutomator2Options.AVD_OPTION, getProperty("device.name"));
        capabilities.setCapability(UiAutomator2Options.AUTOMATION_NAME_OPTION, getProperty("automation.name"));
        capabilities.setCapability(UiAutomator2Options.APP_OPTION, getProperty("path.to.app"));
        capabilities.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION, getProperty("app.activity"));
        capabilities.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION, getProperty("app.package"));
        capabilities.setCapability(UiAutomator2Options.NO_RESET_OPTION, false);
        capabilities.setCapability(UiAutomator2Options.FULL_RESET_OPTION, true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        helpers = new Helpers();

        landingPage = new LandingPage(driver);
        staysPage = new StaysPage(driver);
        searchDestinationPage = new SearchDestinationPage(driver);
        selectDatesPage = new SelectDatesPage(driver);
        selectRoomsAndGuestsPage = new SelectRoomsAndGuestsPage(driver);
        resultsPage = new ResultsPage(driver);
        bottomNavigationBar = new BottomNavigationBar(driver);
        savedPropertiesPage = new SavedPropertiesPage(driver);
        signInPage = new SignInPage(driver);
        settingsPage = new SettingsPage(driver);
        currencyPage = new CurrencyPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        savedPage = new SavedPage(driver);
        geniusLoyaltyProgramPage = new GeniusLoyaltyProgramPage(driver);
        discoverGeniusLevelsPage = new DiscoverGeniusLevelsPage(driver);
        carRentalPage = new CarRentalPage(driver);
        pickUpLocationPage = new PickUpLocationPage(driver);
        dropOffLocationPage = new DropOffLocationPage(driver);
        datePage = new DatePage(driver);
        pickUpTimePage = new PickUpTimePage(driver);
        dropOffTimePage = new DropOffTimePage(driver);
        carResultsPage = new CarResultsPage(driver);
        filterCarsPage = new FilterCarsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Tear down the driver")
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
