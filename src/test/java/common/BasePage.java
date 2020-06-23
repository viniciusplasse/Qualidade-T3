package common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    protected static WebDriver driver;

    public static void acessarBrowser(){
        try {
            System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void acessandoSite() {
        driver.get("https://automacaocombatista.herokuapp.com/treinamento/home");
        Assert.assertEquals( "Automação com Batista", driver.getTitle());
    }

}
