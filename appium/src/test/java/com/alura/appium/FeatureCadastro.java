package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;


public class FeatureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriverConfig driver = AppiumDriverConfig.Instance();

        LoginPageObject telaLogin = new LoginPageObject(driver.driver);
        telaLogin.buscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("Marco", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemErro());
        driver.driver.navigate().back();

    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriverConfig driver = AppiumDriverConfig.Instance();

        LoginPageObject telaLogin = new LoginPageObject(driver.driver);
        telaLogin.buscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin = telaCadastro.cadastrar("Marco", "123", "123");
        telaLogin.buscarElementos();


    }


}
