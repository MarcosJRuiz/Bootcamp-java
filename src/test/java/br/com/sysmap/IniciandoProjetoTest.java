package br.com.sysmap;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IniciandoProjetoTest {

    @Test
    void inicio(){
        // Exemplo do caminho do chromedriver dentro do Windows
        // System.setProperty("webdriver.chrome.driver", "C:\\APP\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/local/.app/dev/tools/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Pesquisa Google']"));
        boolean validate = elements.size() != 0;
        assertTrue(validate);
        System.out.println("Validado que estamos no site do google");
    }

}
