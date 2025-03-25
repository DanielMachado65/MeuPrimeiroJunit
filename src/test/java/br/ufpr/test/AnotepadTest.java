package br.ufpr.test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.*;

public class AnotepadTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void setupAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void tearDownAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setup() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        context.close();
    }

    @Test
    void testCriacaoNotaAnotepad() {
        // Navega até o site com timeout aumentado e aguardando o DOMContentLoaded
        page.navigate("https://pt.anotepad.com", new Page.NavigateOptions()
                .setTimeout(60000) // aumenta para 60 segundos
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)); // espera até que o DOM esteja carregado

        // Preenche o campo de título
        page.fill("#edit_title", "Entrega trabalho TEST DAS 2024");

        // Preenche o campo de conteúdo com nome e matrícula
        page.fill("#edit_textarea", "Nome: João Silva\nMatrícula: 123456");

        // Clica no botão "Salvar"
        page.click("#btnSaveNote");

        // Aguarda que o elemento de mensagem de sucesso seja visível
        Locator msgSuccess = page.locator("p.alert.alert-warning").first();
        msgSuccess.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        // Recupera o texto da mensagem e verifica se contém a substring esperada
        String successText = msgSuccess.innerText();
        Assertions.assertTrue(successText.contains("Você salvou sua nota como"),
                "A nota não foi salva corretamente. Texto exibido: " + successText);
    }
}
