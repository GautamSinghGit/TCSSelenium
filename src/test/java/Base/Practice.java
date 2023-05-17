package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Practice {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

      /*  Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        List<String> l = s.getOptions().stream().map(WebElement::getText).toList();
        for (String element : l) {
            System.out.println(element);

        }
        s.selectByVisibleText("USD");
        s.selectByIndex(2);
        System.out.println(s.getFirstSelectedOption().getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("(//a[@value='GOI'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='AIP'])[2]")).click();

        driver.findElement(By.id("autosuggest")).sendKeys("In");
        Thread.sleep(2000);
        WebElement e1 =  driver.findElements(By.cssSelector("#ui-id-1 a")).stream().filter(e->e.getText().equals("India")).findFirst().get();
        e1.click();
        
        driver.findElement(By.className("ui-state-highlight")).click();

       */

        //%%%%%%%%
        // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% %%%%%%%%%%%%%%

        //SWITCH PRACTICE
       /* driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("Rahul");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();*/
        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

        //ECOMMERCE PRACRTICE

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] p = {"Brocolli", "Cucumber", "Pumpkin"};

        List<String> al = Arrays.asList(p);
        driver.findElements(By.cssSelector(" h4[class='product-name']")).stream()
                .filter(e -> al.contains(e.getText().split("-")[0].trim()))
                .map(e -> driver.findElement(By.xpath("//h4[text()='" + e.getText() + "']/following-sibling::div[2]"))).forEach(e -> e.click());

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();

       // Thread.sleep(2000);
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2));
          w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']")));

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("promoBtn")).click();

          FluentWait<WebDriver> ew = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(8))
                  .pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
          ew.until(e->e.findElement(By.className("promoInfo")));
          String v = driver.findElement(By.className("promoInfo")).getText();
          System.out.println(v);





    }
}
