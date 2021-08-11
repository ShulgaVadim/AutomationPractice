package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAddressesPage extends BasePage {

    private static final By FIRSTNAME = By.xpath("//span[@class='address_name'][1]");
    private static final By LASTNAME = By.xpath("//span[@class='address_name'][2]");
    private static final By ADDRESS = By.xpath("//span[@class='address_address1']");
    private static final By CITY = By.xpath("//ul[@class='last_item item box']//li[5]/span[1]");
    private static final By STATE = By.xpath("//ul[@class='last_item item box']//li[5]/span[2]");
    private static final By POSTAL_CODE = By.xpath("//ul[@class='last_item item box']//li[5]/span[3]");
    private static final By PHONE = By.xpath("//span[@class='address_phone_mobile']");

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstName() {
        return driver.findElement(FIRSTNAME).getText();
    }

    public String getLastName() {
        return driver.findElement(LASTNAME).getText();
    }

    public String getAddress() {
        return driver.findElement(ADDRESS).getText();
    }

    public String getCity() {
        return driver.findElement(CITY).getText().replaceAll(",", "");
    }

    public String getState() {
        return driver.findElement(STATE).getText();
    }

    public String getPostalCode() {
        return driver.findElement(POSTAL_CODE).getText();
    }

    public String getPhone() {
        return driver.findElement(PHONE).getText();
    }
}
