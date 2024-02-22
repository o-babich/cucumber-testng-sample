package com.zebrunner.demo.stepDefinitions;

import com.zebrunner.demo.manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

@Slf4j
public class DocumentationStepDefinition {

    public RemoteWebDriver driver = DriverManager.getDriver();

    @SneakyThrows
    @Given("^user is on Documentation page$")
    public void user_already_on_doc_page() {
        log.info("Navigating to Documentation Page...");

        DriverManager.getDriver().get("https://zebrunner.com/documentation/");
        Thread.sleep(1000);
        DriverManager.takeScreenshot();

        log.info("User is on Documentation Page");
    }

    @SneakyThrows
    @When("^select Reporting concepts$")
    public void select_reporting_concepts() {
        log.info("Selecting Reporting concepts...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Reporting concepts')]"));
        el.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Java$")
    public void select_java() {
        log.info("Selecting Java...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Java')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select TestNG$")
    public void select_testng() {
        log.info("Navigating to TestNG agent documentation...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'TestNG')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @Then("verify page title")
    public void verify_page_title() {
        log.info("Verifying page title...");

        String title = driver.findElement(By.xpath("//h1")).getText();
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
        Assert.assertEquals(title, "TestNG reporting agent", "Page title is not as expected");
    }

    @SneakyThrows
    @When("^select Core concepts$")
    public void select_core_concepts() {
        log.info("Selecting Core concepts...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Core concepts')]"));
        el.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Projects$")
    public void select_projects() {
        log.info("Selecting Projects...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Projects')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Test repository$")
    public void select_test_repo() {
        log.info("Navigating to Test repository...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Test repository')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Automation launches$")
    public void select_automation_launches() {
        log.info("Navigating to Automation launches...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Automation launches')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @Then("^verify Automation launches page title$")
    public void verify_automation_launches_page_title() {
        log.info("Verifying page title...");

        String title = driver.findElement(By.xpath("//h1")).getText();
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
        Assert.assertEquals(title, "Automation launches", "Page title is not as expected");
    }

    @SneakyThrows
    @When("^select Test Case management$")
    public void select_tcm() {
        log.info("Selecting Test Case management...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Test Case management')]"));
        el.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select TestRail$")
    public void select_testrail() {
        log.info("Selecting TestRail...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'TestRail')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Xray$")
    public void select_xray() {
        log.info("Navigating to Xray...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Xray')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Testing platforms$")
    public void select_tp() {
        log.info("Selecting Testing platforms...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Testing platforms')]"));
        el.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Zebrunner Selenium Grid$")
    public void select_zebrunner_grid() {
        log.info("Selecting Zebrunner Selenium Grid...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Zebrunner Selenium Grid')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Administration$")
    public void select_administration() {
        log.info("Selecting Administration...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Administration')]"));
        el.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);

        DriverManager.takeScreenshot();
    }

    @SneakyThrows
    @When("^select Onboarding$")
    public void select_onboarding() {
        log.info("Navigating to Onboarding...");

        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Onboarding')]"));
        el.click();
        Thread.sleep(1000);
        DriverManager.takeScreenshot();
    }
}