package br.com.sysmap.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Exemplo do caminho do chromedriver dentro do Windows
    // C:\\APP\\drivers\\chromedriver.exe
    private static final String DRIVER_CHROME = "/usr/local/.app/dev/tools/drivers/chromedriver";

    static WebDriver driver;

    public static void abrirChrome(String url) {
        System.setProperty("webdriver.chrome.driver", DRIVER_CHROME);
        driver = new ChromeDriver();
        driver.get(url);
        System.out.println("Navegador aberto");
    }

    public static void fecharChrome() {
        driver.quit();
        System.out.println("Navegador fechado");
    }

}
