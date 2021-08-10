package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    private static final By ACCOUNT_NAME = By.xpath("//div[@class='header_user_info']//a//span");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Return Account Name")
    public String getAccountName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_NAME));
        return driver.findElement(ACCOUNT_NAME).getText();
    }
}
