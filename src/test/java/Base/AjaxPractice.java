package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AjaxPractice {

   public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
       // driver.get("https://www.amazon.in/");

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& ACTION CLASS &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

       /* Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();

        String h = "hello";

        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.LEFT_SHIFT,h);
        a.click(driver.findElement(By.id("twotabsearchtextbox"))).keyDown( .SHIFT).sendKeys("hello")
                .sendKeys("   ").keyUp(Keys.SHIFT).sendKeys("amazon").build().perform();


        a.contextClick(driver.findElement(By.id("twotabsearchtextbox"))).build().perform();
*/

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //driver.findElement(By.id("opentab")).click(); // ---- New Tab
      /*  driver.findElement(By.id("openwindow")).click();

        Set<String> tab = driver.getWindowHandles();

        Iterator<String> it = tab.iterator();
        String pW = it.next();
        String cW = it.next();
        driver.switchTo().window(cW);
        System.out.println(driver.getTitle());

        driver.switchTo().window(pW);
        System.out.println(driver.getTitle());*/

        WebElement foot = driver.findElement(By.xpath("//table[@class='gf-t']//td[1]/ul"));

        List<WebElement> footlinks = foot.findElements(By.tagName("a"));

        for(int i=1;i<footlinks.size();i++){

            String c = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footlinks.get(i).sendKeys(c);
        }

        Set<String> wh = driver.getWindowHandles();


        for (String s : wh) {
            driver.switchTo().window(s);
            if (driver.getTitle().contains("Practice"))
                continue;
            System.out.println(driver.getTitle());
        }






    }


}
