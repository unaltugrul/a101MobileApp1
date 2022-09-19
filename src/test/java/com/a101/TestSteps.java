package com.a101;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSteps {
    /*
    Given User taps to A101 application
    When User hovers mouse over <giyim ve aksesuar> module
    And User taps <Dizaltı Çorap> category from opened submenu
    And User taps first product
    Then Verify that color is black of the product
    And User taps <Sepete Ekle> button
    When User taps <Sepeti Görüntüle> button
    Then Verify that user can see the product in the basket
    And User taps <Sepeti Onayla> button
    And User taps <ÜYE OLMADAN DEVAM ET> button
    And User taps email address and clicks enter key
    When User taps <Yeni adres oluştur> link
    And User enters required information
    And User taps <Kaydet> button
    And User selects any radio button
    And User taps <Kaydet ve Devam Et> button
    And User enters wrong payment information and selects checkbox
    And User taps <Siparişi Tamamla> button
    Then Verify that user can see error message
    */
    AppiumDriver<MobileElement> driver;

    @Test
    public void paymentFailMessage() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("platformName","Android"); //1. yol
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"12.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Google_Pixel_3");
        desiredCapabilities.setCapability("appPackage", "org.studionord.a101");
        // Set your application's package name.

        desiredCapabilities.setCapability("appActivity", "org.studionord.a101.MainActivity");
        // Set your application's MainActivity i.e. the LAUNCHER activity name.
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        MobileElement iptalButton = driver.findElement(By.id("android:id/button2"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(iptalButton));
        try {

            iptalButton.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }






    }
}
