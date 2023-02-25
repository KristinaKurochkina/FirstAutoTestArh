package factories;

import exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public interface IFactory {
    WebDriver createDriver() throws BrowserNotSupportedException;
}