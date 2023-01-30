package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import utilities.Select;
import utilities.WindowHandler;

public class MainMenuTest extends UnitedBase{

    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();
    }
    /**
     * Test Case 1: Validate "Main menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see “Main menu” navigation items
     * |BOOK                              |
     * |MY TRIPS                          |
     * |TRAVEL INFO            |
     * |MILEAGEPLUS® PROGRAM|
     * |DEALS                             |
     * |HELP                              |
     */
    @Test(priority = 1, description = "Validate 'Main menu' navigation items")
    public void validateMainMenuItems(){
        String[] mainMenuItemsNames = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
        for (int i = 0; i < unitedBasePage.mainMenuItems.size(); i++) {
            Assert.assertTrue(unitedBasePage.mainMenuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedBasePage.mainMenuItems.get(i).getText(),mainMenuItemsNames[i]);
        }
    }
    /**
     * Test Case 2: Validate "Book travel menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see "Book travel menu" navigation items
     * |Book             |
     * |Flight Status|
     * |Check-in       |
     * |My trips        |
     */
    @Test(priority = 2,description = "Validate 'Book travel menu' navigation items")
    public void validateBookTravelMenu(){
    String[] bookMenuTravelItemsNames = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < unitedBasePage.bookTravelMenuItems.size(); i++) {
            Assert.assertTrue(unitedBasePage.bookTravelMenuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedBasePage.bookTravelMenuItems.get(i).getText(),
                    bookMenuTravelItemsNames[i]);
        }
    }
    /**
     * Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     * And validate "One-way" radio button is displayed, is enabled but is not selected
     * When user clicks on "One-way" radio button
     * Then validate "One-way" radio button is selected while "Roundtrip" radio button is
     * deselected
     */
    @Test(priority = 3, description = "Validate 'Round-trip' and 'One-way' radio buttons")
    public void validateRadioButtons(){
        String[] labelText = {"Roundtrip", "One-way"};
        for (int i = 0; i < unitedBasePage.radioButtonsInput.size(); i++) {
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtonsInput.get(i).isEnabled());
            Assert.assertEquals(unitedBasePage.radioButtonsLabel.get(i).getText(), labelText[i]);
        }
        Select.selectTrue(unitedBasePage.radioButtonsInput.get(0));
        Select.selectFalse(unitedBasePage.radioButtonsInput.get(1));
        unitedBasePage.radioButtonsLabel.get(1).click();
        Select.selectTrue(unitedBasePage.radioButtonsInput.get(1));
        Select.selectFalse(unitedBasePage.radioButtonsInput.get(0));
    }
    /**
     * Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
     * And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
     * When user clicks both checkboxes
     * Then validate both checkboxes are selected
     * When user clicks on both selected checkboxes again
     * Then validate both checkboxes are deselected
     */
    @Test(priority = 4, description = "Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateCheckboxes(){
        Assert.assertTrue(unitedBasePage.bookWithMilesLabel.isDisplayed());
        Assert.assertEquals(unitedBasePage.bookWithMilesLabel.getText(),"Book with miles");
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckbox.isEnabled());
        Select.selectFalse(unitedBasePage.bookWithMilesCheckbox);

        Assert.assertTrue(unitedBasePage.flexibleDatesLabel.isDisplayed());
        Assert.assertEquals(unitedBasePage.flexibleDatesLabel.getText(),"Flexible dates");
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckbox.isEnabled());
        Select.selectFalse(unitedBasePage.flexibleDatesCheckbox);

        unitedBasePage.bookWithMilesLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Select.selectTrue(unitedBasePage.bookWithMilesCheckbox);
        Select.selectTrue(unitedBasePage.flexibleDatesCheckbox);

        unitedBasePage.bookWithMilesLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Select.selectFalse(unitedBasePage.bookWithMilesCheckbox);
        Select.selectFalse(unitedBasePage.flexibleDatesCheckbox);
    }
    /**
     * Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
     * Miami, FL, US (MIA)”
     * Given user is on "https://www.united.com/en/us"
     * When user selects "One-way" ticket radio button
     * And user enters "Chicago, IL, US (ORD)" to from input box
     * And user enters "Miami, FL, US (MIA)" to to input box
     * And user selects "Feb 28" to the dates input box
     * And user selects "2 Adults" from travelers selector
     * And user selects "Business or First" from cabin dropdown
     * And user clicks on "Find Flights" button
     * Then validate departure equals to "DEPART ON: February 28"
     */
    @Test(priority = 5, description = "Validate One-way ticket search results")
            public void validateTicketSearch(){
        unitedBasePage.radioButtonsLabel.get(1).click();
        unitedBasePage.fromInputBox.clear();
        unitedBasePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedBasePage.destinationInputBox.clear();
        unitedBasePage.destinationInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedBasePage.date.clear();
        unitedBasePage.date.sendKeys("Feb 28");
        unitedBasePage.date.click();
        unitedBasePage.travelersSelector.click();
        unitedBasePage.plusOneAdult.click();
        unitedBasePage.clickOnCabinTypeOption("Business or First");
        unitedBasePage.findFlightsButton.click();
        WindowHandler.switchToChildWindow();
        Assert.assertTrue(unitedBasePage.result.isDisplayed());
        Assert.assertEquals(unitedBasePage.result.getText(),"DEPART ON: February 28");
    }
}
