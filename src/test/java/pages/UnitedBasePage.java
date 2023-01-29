package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {
    public UnitedBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[class*='3SjnI'] a")
    public List<WebElement> mainMenuItems;
    @FindBy(css = "ul[class*='3RNBj'] li")
    public List<WebElement> bookTravelMenuItems;
}
