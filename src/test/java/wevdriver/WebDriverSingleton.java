package wevdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static volatile ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    private static final String URL = "https://oauth-stiffler8888-d3e3c:69630821-a2e1-4932-8af3-85137a45969c@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            synchronized (WebDriverSingleton.class) {
//                DesiredCapabilities caps = DesiredCapabilities.edge();
//                caps.setCapability("version", "latest");
//                caps.setCapability("platform", "Windows 10");
//                try {
//                    WebDriver webDriver = new RemoteWebDriver(new URL(URL), caps);
//                    driver.set(webDriver);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.set(null);
    }
}
