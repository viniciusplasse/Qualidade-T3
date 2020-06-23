package steps;

import common.BasePage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RealizarCadastro_Falha extends BasePage {

    @BeforeClass
    public static void beforeScenario( ){
        acessarBrowser();
    }

    @AfterClass
    public static void afterScenario(){
        driver.quit();
    }

    @Test
    public void acessandoPaginaInicialSite(){
        acessandoSite();
    }

    @Test
    public void acessarFormulario(){
        visualizarForm();
    }

    @Test
    public void validarCamposObrigatorios(){
        //não preencher nenhum campo do formulario
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/input")).click();
    }

    @Test
    public void verificarMensagemDeErro(){
        Assert.assertEquals("3 errors proibiu que este usuário fosse salvo:",
                driver.findElement(By.xpath("//div[@id=\"error_explanation\"]//h2")).getText());
        
        Assert.assertEquals("Name translation missing: pt-BR.activerecord.errors.models.user.attributes.name.blank",
                driver.findElement(By.xpath("//div[@id=\"error_explanation\"]//ul//li[contains(.,\"name.blank\")]")).getText());

        Assert.assertEquals("Email translation missing: pt-BR.activerecord.errors.models.user.attributes.email.blank",
                driver.findElement(By.xpath("//div[@id=\"error_explanation\"]//ul//li[contains(.,\"email.blank\")]")).getText());

        Assert.assertEquals("Email translation missing: pt-BR.activerecord.errors.models.user.attributes.email.invalid",
                driver.findElement(By.xpath("//div[@id=\"error_explanation\"]//ul//li[contains(.,\"email.invalid\")]")).getText());
    }


}
