package steps;

import common.BasePage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerificarListaDeCompras extends BasePage {

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
    public void acessarPaginaDeListaCompras(){
        acessarListaDeCompras();
    }

    @Test
    public void verificarListaDeCompras() {
        Assert.assertEquals("Produto Leite Moça deve custar $7.00", "$7.00",
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[8]/td[3]")).getText());

        Assert.assertEquals("O primeiro item da lista deve ser Arroz", "Arroz",
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]")).getText());
    }
}
