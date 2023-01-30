package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Select {
    public static boolean selectTrue(WebElement element){
        Assert.assertTrue(element.isSelected());
        return true;
    }
    public static boolean selectFalse(WebElement element){
        Assert.assertFalse(element.isSelected());
        return true;
    }
}
