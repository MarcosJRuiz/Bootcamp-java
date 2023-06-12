package br.com.sysmap;

import br.com.sysmap.driver.Api;
import br.com.sysmap.driver.Browser;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetoOtimizadoTest {


    @BeforeAll
    static void inicio() {
        Browser.abrirChrome("http://google.com");
    }

    @Test
    @Order(2)
    void validarSite() {
        boolean validate = Browser.elementoExiste(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Pesquisa Google']"));
        assertTrue(validate);
        System.out.println("Validado que estamos no site do google");
    }

    @Test
    @Order(3)
    void pesquisar()  {
        Browser.digitar(By.xpath("//*[@id='APjFqb']"), "facebook");
        Browser.clicar(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Pesquisa Google']"));
        Browser.aguardar(2);
        assertTrue(Browser.elementoExiste(By.xpath("//h3[text()='Facebook – entre ou cadastre-se']")));
        System.out.println("Validado que estamos na pagina de pesquisa do google");
    }

    @Test
    @Order(1)
    void validarNomeDaCidade()  {
        String cidade = "London";
        String valorApi = Api.currentWeather(cidade);
        assertEquals(cidade,valorApi);
        System.out.printf("Validado que retornou o valor da cidade: %s solicitado\n",valorApi);
    }





    @AfterAll
    static void fim() {
        Browser.fecharChrome();
    }


}
