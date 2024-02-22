package com.zebrunner.demo.stepDefinitions;

import com.zebrunner.demo.manager.Driver;
import com.zebrunner.demo.manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class Hook {
    public RemoteWebDriver driver = DriverManager.getDriver();

    @Before
    public void updateName(Scenario scenario) throws InterruptedException {
        log.info(scenario.getName() + " scenario is started!");
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            DriverManager.takeScreenshot();
            log.error(scenario.getName() + " is failed!");
        } else {
            log.info(scenario.getName() + " is passed");
        }
        log.debug(driver.getSessionId().toString());
        Driver.quitDriver();
    }

}