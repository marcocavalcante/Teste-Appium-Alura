package com.alura.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    public final AppiumDriver  driver;
    private static AppiumDriverConfig _instance;
    public static AppiumDriverConfig Instance(){
        if(_instance == null){
            _instance = new AppiumDriverConfig();
        }
        return _instance;
    }

    private AppiumDriverConfig(){
        File apk = new File("C:\\Users\\Acer\\Desktop\\Eldorado\\Treinamento Eldorado\\Alura\\appium\\src\\main\\resources\\1820-appium-apk\\alura_esporte.apk");

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        URL urlConexao = null;
        try {
            urlConexao = new URL("http://127.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConexao,configuracoes);

    }

}
