package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Regression Tests")
@Feature("Booking Tests")
public class BookingTests extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify booking button actions and validations")
    @Test(testName = "Booking test 1")
    public void bookingTest1() {

        Assert.assertTrue(landingPage.landingPageLoaded(), "Landing page is not loaded");

        landingPage.clickCloseButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        staysPage.clickChooseDestination();
        Assert.assertTrue(searchDestinationPage.searchDestinationPageLoaded(), "Search destination page is not loaded");

        searchDestinationPage.chooseDestination("Skopje");
        Assert.assertTrue(selectDatesPage.selectDatesPageLoaded(), "Select dates page is not loaded");

        selectDatesPage.chooseDates("24 April 2024", "28 April 2024");
        selectDatesPage.clickSelectDatesButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        staysPage.clickSelectRoomsAndGuests();
        Assert.assertTrue(selectRoomsAndGuestsPage.selectRoomsAndGuestsPageLoaded(), "Select rooms and guests page is not loaded");

        selectRoomsAndGuestsPage.clickIncreaseRoomsCount();
        selectRoomsAndGuestsPage.clickIncreaseAdultsCount();
        selectRoomsAndGuestsPage.clickApplyButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        staysPage.clickSearchButton();
        Assert.assertTrue(resultsPage.resultsPageLoaded(), "Results page is not loaded");

        Assert.assertTrue(resultsPage.validateDestination("Skopje"), "Incorrect destination");
        Assert.assertTrue(resultsPage.validateStayDates("Apr 24 - Apr 28"), "Incorrect dates");

        resultsPage.clickFavoritesButton();
        resultsPage.clickBackButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        bottomNavigationBar.clickSaved();
        Assert.assertTrue(savedPropertiesPage.savedPropertiesPageLoaded(), "Saved properties page is not loaded");

        savedPropertiesPage.validateProperty("Apr 24 – Apr 28 (4 nights)");
        savedPropertiesPage.validateProperty("2 adults");
        savedPropertiesPage.clickBackButton();
        Assert.assertTrue(savedPage.savedPageLoaded(), "Saved page is not loaded");

        bottomNavigationBar.clickSignIn();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded");

        signInPage.clickSettingsButton();
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");

        settingsPage.clickCurrencyButton();
        Assert.assertTrue(currencyPage.currencyPageLoaded(), "Currency page is not loaded");

        currencyPage.changeCurrency("Euro");
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");
        Assert.assertTrue(settingsPage.validateCurrency("Euro (€)"), "Incorrect currency");

        settingsPage.clickPrivacyPolicyButton();
        Assert.assertTrue(privacyPolicyPage.privacyPolicyPageLoaded(), "Privacy Policy page is not loaded");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify booking button actions and validations")
    @Test(testName = "Booking test 2")
    public void bookingTest2() {

        Assert.assertTrue(landingPage.landingPageLoaded(), "Landing page is not loaded");

        landingPage.clickCloseButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        bottomNavigationBar.clickSignIn();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded");

        signInPage.geniusLoyaltyProgramButton();
        Assert.assertTrue(geniusLoyaltyProgramPage.geniusLoyaltyProgramPageLoaded(), "Genius loyalty program Page is not loaded");

        geniusLoyaltyProgramPage.clickAboutGeniusLevelsButton();
        Assert.assertTrue(discoverGeniusLevelsPage.discoverGeniusLevelsPageLoaded(), "Discover genius levels page is not loaded");

        discoverGeniusLevelsPage.swipeToGeniusLevel3();
        discoverGeniusLevelsPage.validateGeniusLevel3();
        discoverGeniusLevelsPage.clickGotItButton();
        Assert.assertTrue(geniusLoyaltyProgramPage.geniusLoyaltyProgramPageLoaded(), "Genius loyalty program page is not loaded");

        geniusLoyaltyProgramPage.clickBackButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded");

        bottomNavigationBar.clickSearch();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        staysPage.clickCarRentalButton();
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(), "Car rental page is not loaded");

        carRentalPage.disableReturnToSameLocationButton();
        carRentalPage.validatePickUpLocationDisplayed();
        carRentalPage.validateDropOffLocationDisplayed();
        carRentalPage.clickPickUpLocation();
        Assert.assertTrue(pickUpLocationPage.pickUpLocationPageLoaded(), "Pick up location page is not loaded");

        pickUpLocationPage.addPickUpLocation("Skopje");
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(), "Car rental page is not loaded");

        carRentalPage.clickDropOffLocation();
        dropOffLocationPage.addDropOffLocation("Ohrid");
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(), "Car rental page is not loaded");

        carRentalPage.clickPickUpDate();
        Assert.assertTrue(datePage.datePageLoaded(), "Pick up date page is not loaded");

        datePage.chooseDate("24 April 2024");
        datePage.clickSelectDatesButton();
        carRentalPage.clickPickUpTime();
        Assert.assertTrue(pickUpTimePage.pickUpTimePageLoaded(), "Pick up time page is not loaded");

        pickUpTimePage.choosePickUpTime("8:15 AM");
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(), "Car rental page is not loaded");

        carRentalPage.clickDropOffDate();
        Assert.assertTrue(datePage.datePageLoaded(), "Date page is not loaded");

        datePage.chooseDate("27 April 2024");
        datePage.clickSelectDatesButton();
        carRentalPage.clickDropOffTime();
        Assert.assertTrue(dropOffTimePage.dropOffTimePageLoaded(), "Drop off time page is not loaded");

        dropOffTimePage.chooseDropOfTime("11:00 AM");
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(), "Car rental page is not loaded");

        carRentalPage.clickDriverAgeField();
        carRentalPage.addDriverAge("35");
        carRentalPage.clickSearchButton();
        Assert.assertTrue(carResultsPage.carResultsPageLoaded(), "Car results page is not loaded");

        carResultsPage.clickFilterButton();
        Assert.assertTrue(filterCarsPage.filterCarsPageLoaded(), "Filter cars page is not loaded");

        filterCarsPage.filterCarsBy("Automatic");
        filterCarsPage.clickShowResultsButton();
        Assert.assertTrue(carResultsPage.carResultsPageLoaded(), "Car results page is not loaded");

        carResultsPage.validateCarResults("Automatic");
    }
}
