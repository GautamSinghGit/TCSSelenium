package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.ResourceLeakDetector;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class RelativeLocators {

    static WebDriver driver;


    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

      //  Dimension d = new Dimension(900,900);
        Point p = new Point(200,200);
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();
      //  driver.manage().window().setSize(d);
      //  driver.manage().window().setPosition(p);
        newWIndow(driver);
       /* driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String t = driver.findElement(RelativeLocator.with(By.tagName("label")).above(By.cssSelector("[name='name']"))).getText();
        System.out.println(t);

        String p = driver.findElement(RelativeLocator.with(By.tagName("label"))

                .above(By.cssSelector("[value='Submit']"))).getText();
        System.out.println(p);

        driver.findElement(RelativeLocator.with(By.tagName("input"))
                .near(By.xpath("//label[text()='Check me out if you Love IceCreams!']"))).click();

        WebElement sradio = driver.findElement(By.id("inlineRadio1"));*/


    }


    public static void newWIndow(WebDriver driver) throws IOException {

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> w = driver.getWindowHandles();

        Iterator<String> i = w.iterator();
        String pa = i.next();
        String c = i.next();

        driver.switchTo().window(c);

        driver.get("https://rahulshettyacademy.com/#/index");
        driver.findElement(By.xpath("//a[normalize-space()='Courses']")).click();
        String cou = driver.findElements(By.cssSelector(".course-list a[href*='/p'] .course-listing-title")).get(1).getText();

        driver.switchTo().window(pa);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(cou);

        File f = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("logo.png"));

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getHeight());



    }
}
