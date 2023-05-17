package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ScrollingPage {


    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);
        // options.setExperimentalOption("excludeSwitches", Arrays.asList("--disable-popup-notification"));
        options.addArguments("--disable-notification");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);



       /* driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,600)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> lb = driver.findElements(By.cssSelector(".tableFixHead tbody tr td:nth-child(4)"));

        lb.forEach(e-> System.out.println(e.getText()));*/
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> bl = driver.findElements(By.cssSelector("div#gf-BIG td li+li a"));


        for (WebElement e:bl){

            String u = e.getAttribute("href");

            HttpURLConnection co = (HttpURLConnection)      new URL(u).openConnection();

            co.setRequestMethod("HEAD");
            co.connect();
            int p = co.getResponseCode();
            System.out.println(p);
            if(p>400){
                System.out.println(e.getText());

                break;
            }
        }




    }

}
