package pages;

import org.openqa.selenium.WebDriver;

public class UserInfoPage extends AbsPage{
    public UserInfoPage(WebDriver driver) {

        super(driver, "/lk/biography/personal/");
    }
}
