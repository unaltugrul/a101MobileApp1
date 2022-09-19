package com.a101;

import com.google.common.base.Verify;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSteps {
    /*

    When
    And
    And
    Then
    And
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
        //User taps to A101 application
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"12.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Google_Pixel_3");
        desiredCapabilities.setCapability("appPackage", "org.studionord.a101");
        desiredCapabilities.setCapability("appActivity", "org.studionord.a101.MainActivity");
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(MobileBy.id("android:id/button2")).click();

        //User taps hamburger button
       driver.findElement(By.ByXPath.xpath("(//android.widget.TextView)[1]")).click();

        //User taps <GİYİM & AKSESUAR> category from opened submenu
        driver.findElement(By.xpath("//android.widget.TextView")).click();

        //User taps "Kadın İç Giyim"
        driver.findElement(By.xpath("(//android.widget.TextView)[8]")).click();

        //User taps "Dizaltı Çorap"
        driver.findElement(By.xpath("(//android.widget.TextView)[14]")).click();

        //User taps first product
        driver.findElement(By.xpath("(//android.widget.TextView)[12]")).click();

        //Verify that color is black of the product
        //driver.findElement(By.xpath(""))

        //User taps <Sepete Ekle> button



    }

}
