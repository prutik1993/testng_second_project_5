package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;

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
    String[] bookMenuTravelItemsNames = {"Book", "Flight Status", "Check-in", "My trips"};

    }
}
