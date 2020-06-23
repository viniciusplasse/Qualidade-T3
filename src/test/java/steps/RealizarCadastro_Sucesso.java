package steps;

import common.BasePage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealizarCadastro_Sucesso extends BasePage {

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
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")).click();
    }

    @Test
    public void preencherFormulario() {
        driver.findElement(By.id("user_name")).sendKeys("Vinicius");
        driver.findElement(By.id("user_lastname")).sendKeys("Plasse");
        driver.findElement(By.id("user_email")).sendKeys("qualidade_t3@puc.edu.br");
        driver.findElement(By.id("user_address")).sendKeys("Av. Ipiranga, 6681");
        driver.findElement(By.id("user_university")).sendKeys("PUC-RS");
        driver.findElement(By.id("user_profile")).sendKeys("Desenvolvedor FullStack");
        driver.findElement(By.id("user_gender")).sendKeys("Masculino");
        driver.findElement(By.id("user_age")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/input")).click();
    }

    @Test
    public void verificarMensagemDeExitoEDadosCadastrados(){
        Assert.assertEquals("Usuário Criado com sucesso", driver.findElement(By.xpath("//*[@id=\"notice\"]")).getText());
        Assert.assertEquals("Nome: Vinicius", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[1]")).getText());
        Assert.assertEquals("Ultimo Nome: Plasse", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[2]")).getText());
        Assert.assertEquals("Email: qualidade_t3@puc.edu.br", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[3]")).getText());
        Assert.assertEquals("Univercidade: PUC-RS", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[4]")).getText());
        Assert.assertEquals("Gênero: Masculino", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[5]")).getText());
        Assert.assertEquals("Profissão: Desenvolvedor FullStack", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[6]")).getText());
        Assert.assertEquals("Idade: 25", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[7]")).getText());
        Assert.assertEquals("Address: Av. Ipiranga, 6681", driver.findElement(By.xpath("//div[contains(@class, 'col s12 center')]//p[8]")).getText());
    }

}
