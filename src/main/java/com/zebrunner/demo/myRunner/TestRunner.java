package com.zebrunner.demo.myRunner;

import com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory;
import com.zebrunner.demo.manager.Driver;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@CucumberOptions(
        features = "src/main/java/com/zebrunner/demo/features/documentation.feature",
        glue = {"com/zebrunner/demo/stepDefinitions"}
)

public final class TestRunner extends CucumberRunner {

    private final String HUB_URL = "http://localhost:4444/wd/hub";

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpClass() throws Exception {
        RemoteWebDriver remoteWebdriver = null;

        Capabilities capability = getCapabilities();
        URL gridURL = getSeleniumHubUrl();

        remoteWebdriver = new RemoteWebDriver(gridURL, capability);

        log.info("Starting new session...");

        Driver.initDriver(remoteWebdriver);
    }

    @SneakyThrows
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        Driver.quitDriver();
        Thread.sleep(5000);
    }

    private URL getSeleniumHubUrl() {
        URL launcherHubUrl = RemoteWebDriverFactory.getSeleniumHubUrl();
        if (launcherHubUrl != null) {
            log.debug(String.valueOf(launcherHubUrl));
            return launcherHubUrl;
        }
        if (HUB_URL != null) {
            log.debug(HUB_URL);
            try {
                return new URL(HUB_URL);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Incorrect Selenium Grid URL", e);
            }
        }
        return null;
    }

    private Capabilities getCapabilities() {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("browserVersion", "latest");
        sauceOptions.setCapability("browserName", "chrome");
        sauceOptions.setCapability("screenResolution", "1920x1080");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);

        DesiredCapabilities launcherCapabilities = (DesiredCapabilities) RemoteWebDriverFactory.getCapabilities();
        Capabilities remoteCapabilities = launcherCapabilities.asMap().isEmpty() ? options : launcherCapabilities;

        remoteCapabilities.merge(options);

        log.debug(remoteCapabilities.toString());
        return remoteCapabilities;
    }
}