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
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void paymentFailMessage() throws InterruptedException {
        //user clicks to "YUKLE" for updating
        driver.findElement(MobileBy.id("android:id/button1")).click();

        //User taps hamburger button

        try {
            List<MobileElement> hamburgerButton = driver.findElements(MobileBy.className("android.widget.TextView"));
            hamburgerButton.get(0).click();
        }catch (Exception e){
            List<MobileElement> mainPicture = driver.findElements(MobileBy.className("android.widget.ImageView"));
            mainPicture.get(0).click();
            driver.findElement(MobileBy.className("android.widget.TextView")).click();

        }



        //User taps <GİYİM & AKSESUAR> category from opened submenu
        driver.findElement(By.xpath("//android.widget.TextView")).click();

        //User taps "Kadın İç Giyim"
        driver.findElement(By.xpath("(//android.widget.TextView)[8]")).click();

        //User taps "Dizaltı Çorap"
        driver.findElement(By.xpath("(//android.widget.TextView)[14]")).click();

        //User taps first product
        driver.findElement(By.xpath("(//android.widget.TextView)[12]")).click();

        //Verify that color is black of the product
        Assertions.assertEquals("SİYAH",driver.findElement(MobileBy.xpath("//*[@text='SİYAH']")).getAttribute("text"));

        //Verify that user can see the product in the basket
        Assertions.assertTrue(driver.findElement(MobileBy.xpath("//*[@text='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")).isDisplayed());

        //User taps <Sepeti Onayla> button
        driver.findElement(MobileBy.xpath("//*[@text='SEPETİ ONAYLA']")).click();

        //User taps <ÜYE OLMADAN DEVAM ET> button
        driver.findElement(MobileBy.xpath("//*[@text='ÜYE OLMADAN DEVAM ET']")).click();

        //User enters email address
        String emailAddress = faker.internet().emailAddress();
        driver.findElement(MobileBy.xpath("//*[@text='E-posta Adresiniz']")).sendKeys(emailAddress);


        //user select check box
        List<MobileElement> checkBox = driver.findElements(MobileBy.className("android.view.ViewGroup"));
        checkBox.get(3).click();


        //User taps <GÖNDER> button
        driver.findElement(MobileBy.xpath("//*[@text='GÖNDER']")).click();

        //User accepts the cookies
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("//*[@text='Kabul Et']"))));
        }catch (Exception e){

        }

        driver.findElement(MobileBy.xpath("//*[@text='Kabul Et']")).click();

        //User taps <Yeni adres oluştur>
        //driver.findElement(MobileBy.xpath("//*[@text='\uE919 Yeni adres oluştur']")).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.className("android.view.View"))));
        }catch (Exception e){

        }

        List<MobileElement> yeniAdresOlustur = driver.findElements(MobileBy.className("android.view.View"));
        for (MobileElement mobileElement : yeniAdresOlustur) {
            if (mobileElement.getAttribute("text").contains("Yeni adres oluştur")){
                mobileElement.click();
            }
        }
        Thread.sleep(1000);

        //User enters required information
        List<MobileElement> informationBoxes = driver.findElements(MobileBy.className("android.widget.EditText"));
        informationBoxes.get(0).sendKeys("Home");
        informationBoxes.get(1).sendKeys(faker.name().firstName());
        informationBoxes.get(2).sendKeys(faker.name().lastName());
        informationBoxes.get(3).sendKeys("3126477178");
        driver.findElement(MobileBy.xpath("//*[@text='Seçiniz']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='İSTANBUL']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='Seçiniz']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='ADALAR']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='Seçiniz']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='BURGAZADA MAH']")).click();

        String fulLAddres = faker.address().fullAddress();
        informationBoxes.get(4).sendKeys( " ");
        informationBoxes.get(4).sendKeys( "397 Hettinger Prairie Alexandria Connecticut");

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(945,900))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
                .moveTo(PointOption.point(945, 440))
                .release()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("//*[@text='KAYDET']"))));
        List<MobileElement> kaydetButton = driver.findElements(MobileBy.className("android.widget.Button"));
        kaydetButton.get(1).click();
        //driver.findElement(MobileBy.xpath("//*[@text='KAYDET']")).click();

        //User selects any radio button
        Thread.sleep(2000);
        List<MobileElement> radioButton = driver.findElements(MobileBy.className("android.widget.RadioButton"));
        radioButton.get(radioButton.size()-1).click();



    }

}
