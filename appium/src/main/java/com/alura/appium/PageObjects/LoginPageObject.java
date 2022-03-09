package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObjectBase {

    private MobileElement botaoCadastro;
    private MobileElement botaoLogin;
    private final By campoBotaoLoginId;
    private final By campoBotaoCadastroId;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        campoBotaoLoginId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        campoBotaoCadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void buscarElementos(){
        botaoLogin = (MobileElement) driver.findElement(campoBotaoLoginId);
        botaoCadastro = (MobileElement) driver.findElement(campoBotaoCadastroId);
    }

    public CadastroPageObject irParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
