package core;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static core.Config.PLATFORM_AND_BROWSER;

public class BaseTest {

    private Browser browser;

    protected Page page;
    private BrowserContext context;
    private boolean isTraceEnabled = false;

    /**
     * Инициализация браузера и его настроек перед запуском всех тестов в классе
     */
    @BeforeClass
    public void setUp() {
        //инициализация браузера с настройками
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(PLATFORM_AND_BROWSER));

        //создаем контекст для браузера
        context = browser.newContext();

        //трейсинг замедляет скорость заполнение полей
        if(isTraceEnabled){
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));
        }
        //создаем новую страницу
        page = context.newPage();
    }

    /**
     * Закрывает браузер после выполнения всех тестов в классе
     */
    @AfterClass
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }
}
