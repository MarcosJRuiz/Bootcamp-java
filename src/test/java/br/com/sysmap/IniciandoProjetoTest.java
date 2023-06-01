package br.com.sysmap;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IniciandoProjetoTest {

    @Test
    void inicio(){
        // Exemplo do caminho do chromedriver dentro do Windows
        // System.setProperty("webdriver.chrome.driver", "C:\\APP\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/local/.app/dev/tools/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println("Navegador aberto");
    }

}
