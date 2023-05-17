package Base;

import Pages.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver = null;
    public LoginPage loginPage;
    Properties prop = new Properties();
    public WebDriver init(){

        FileInputStream fis;
        try {
            System.out.println(System.getProperty("user.dir"));
          fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");

        switch (browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                //WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver","C://Users//admin//Documents//chromedriver_win32 (2)//chromedriver.exe");
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "headlessBrowser"-> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless");
                //WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver","D://chromedriver_win32 (2)//chromedriver.exe");
                driver = new ChromeDriver(options);
            }
            default -> {
                System.out.println("No browser Name found to execute scenario");
            }
        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            HelperPage.driver = driver;
            return driver;

    }

    public LoginPage launchApplication(){

        driver = init();
        String url = System.getProperty("url")!=null ? System.getProperty("url") : prop.getProperty("url");
        driver.get(url);

        return new LoginPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        loginPage = launchApplication();

    }

    @AfterMethod(alwaysRun = true)
    public void tear(){
        driver.close();
    }

    public List<HashMap<String,String>> getJsonToMap() throws IOException {


        String jsonfile = FileUtils
                .readFileToString
                        (new File(System.getProperty("user.dir") + "//src/test//resources//data.json"),
                                StandardCharsets.UTF_8);

        ObjectMapper map = new ObjectMapper();
        List<HashMap<String,String>> data = map.readValue(jsonfile, new TypeReference<List<HashMap<String,String>>>() {
        });

        return data;



    }

    public String getScreenshot(String testCaseName,WebDriver driver1) throws IOException {

        File f = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(f,new File(System.getProperty("user.dir")+"//src//reports//"+testCaseName+".png"));


        return System.getProperty("user.dir")+"//src//reports//"+testCaseName+".png";

    }

}
