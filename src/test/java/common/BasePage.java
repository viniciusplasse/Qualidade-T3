package common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    protected void visualizarForm(){
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")).click();
    }

}
