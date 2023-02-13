package com.dextra.dextragames;

import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class StartAppTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedIOSDriver<MobileElement> driver;

    public static EnhancedIOSDriver<MobileElement> startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
       // capabilities.setCapability("udid", "auto");
        //capabilities.setCapability("bundleId", "io.appium.estudo");
        //capabilities.setCapability("xcodeOrgId", "799MC5XT56");
        //capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        //capabilities.setCapability("updatedWDABundleId", "com.androidiostesting22.WebDriverAgentRunner");
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/eduardomonegate/Documents/GitHub/flutter_appium_and_appCenter/AppCenterUITest-master/flutterappiumios.ipa");
        capabilities.setCapability(MobileCapabilityType.APP, "Users/eduardomonegate/Documents/GitHub/flutterappiumios/build/ios/iphonesimulator/Runner.app");


        URL url = new URL("http://localhost:4723/wd/hub");

//        application-identifier
//        799MC5XT56.io.appium.estudo
//        com.apple.developer.team-identifier
//        799MC5XT56
//        get-task-allow
//        true

        return Factory.createIOSDriver(url, capabilities);
    }


    @Test
    public void canStartAppInTest() throws MalformedURLException, InterruptedException {
        driver = startApp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"]").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"]").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"]").click();

        Thread.sleep(5000);
    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            driver.label("Stopping App");
            driver.quit();
        }
    }


}
//mvn -DskipTests -P prepare-for-upload package

//appcenter test run appium --app "NDDSmart-Aldebaran/estudo-android-flutter" --devices "NDDSmart-Aldebaran/teste" --app-path ../app-debug.apk --test-series "ui-test" --locale "en_US" --build-dir target/upload




//Para dispositivos reais e envio ao Appcenter

//{
//        "platformName": "IOS",
//        "appium:useNewWDA": false,
//        "appium:deviceName": "iPhone de Eduardo Monegate",
//        "appium:bundleId": "com.example.hpFlexMobile",
//        "appium:app": "/Users/eduardomonegate/Documents/GitHub/flutter_appium_and_appCenter/AppCenterUITest-master/hp_flex_mobile.ipa",
//        "appium:udid": "auto",
//        "appium:platformVersion": "12.0.0",
//        "appium:xcodeOrgId": "799MC5XT56",
//        "appium:xcodeSigningId": "NDD TECH LTDA",
//        "appium:updatedWDABundleId": "com.androidiostesting22.WebDriverAgentRunner",
//        "appium:automationName": "XCUITest"
//        }
