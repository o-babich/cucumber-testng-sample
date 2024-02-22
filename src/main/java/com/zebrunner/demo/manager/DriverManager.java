package com.zebrunner.demo.manager;

import com.zebrunner.agent.core.registrar.Screenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

public class DriverManager {
  private DriverManager() {
  }

  private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

  public static RemoteWebDriver getDriver() {
    return driver.get();
  }

  static void setDriver(RemoteWebDriver driverref) {
    if (Objects.nonNull(driverref)) {
      driver.set(driverref);
    }
  }

  static void unload() {
    driver.remove();
  }

  public static void takeScreenshot() {
    try {
      // Capture the screenshot as a file
      File screenshot = ((TakesScreenshot) getDriver() ).getScreenshotAs(OutputType.FILE);

      // Read the bytes of the screenshot file
      byte[] screenshotBytes = Files.readAllBytes(screenshot.toPath());

      // Upload the screenshot bytes using a method named Screenshot.upload
      // You might need to replace this method with the actual method you use to upload the screenshot
      // Pass the screenshot bytes and a timestamp to uniquely identify the screenshot
      Screenshot.upload(screenshotBytes, System.currentTimeMillis());
    } catch (Exception e) {
      // If an error occurs during the process, throw a runtime exception with a meaningful error message
      throw new RuntimeException("Error while taking a screenshot", e);
    }
  }
}
