package br.com.sysmap;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IniciandoProjetoTest {

    static WebDriver driver;

    @BeforeAll
    static void inicio() {
        // Exemplo do caminho do chromedriver dentro do Windows
        // System.setProperty("webdriver.chrome.driver", "C:\\APP\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/local/.app/dev/tools/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://google.com");

        System.out.println("Navegador aberto");
    }

    @Test
    void validarSite() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Pesquisa Google']"));
        boolean validate = elements.size() != 0;
        assertTrue(validate);

        System.out.println("Validado que estamos no site do google");
    }

    @Test
    void pesquisar() throws InterruptedException {
        WebElement barra = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        barra.sendKeys("facebook");

        WebElement btnPesquisar = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Pesquisa Google']"));
        btnPesquisar.click();

        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//h3[text()='Facebook – entre ou cadastre-se']"));
        boolean validate = elements.size() != 0;
        assertTrue(validate);
        System.out.println("Validado que estamos na pagina de pesquisa do google");

    }

    @AfterAll
    static void fim() {
        driver.quit();
        System.out.println("Navegador fechado");
    }

}
