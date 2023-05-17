package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Calendar_Table {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

       // DesiredCapabilities dcap = new DesiredCapabilities();
        // dcap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"NONE");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--remote-allow-origins=*");
      //  options.merge(dcap);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://www.ixigo.com/");



     //   WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
       // w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Date of travel']")));

      //  driver.findElement(By.id("form-field-travel_comp_airline")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[placeholder='Depart']")).click();
        String depmon = "January 2024";
        String depday = "14";

        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM yyyy");

        String p = f.format(d.plusYears(1));
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd");
        String  p1 = f1.format(d);
        if(depmon.equals(p) && Integer.parseInt(depday)>(Integer.parseInt(p1)-2)){
            System.out.println("You can select date until "+p+"  "+(Integer.parseInt(p1)-2));
        }

       else if(depmon.equals(p)){

           while (!driver.findElement(By.cssSelector(".rd-next+div")).getText().contains((depmon))) {

               driver.findElement(By.className("rd-next")).click();
           }

           List<WebElement> date = driver.findElements(By.cssSelector(".rd-next+div+table td"));
           date.stream().filter(e->

                   {
                       System.out.println(e.getText());
                       return   e.getText().contains(depday);
                   }
           ).findFirst().get().click();
       }
        else {
           while (!driver.findElement(By.cssSelector(".rd-back+div")).getText().contains((depmon))) {

               driver.findElement(By.className("rd-next")).click();
           }

           List<WebElement> date = driver.findElements(By.cssSelector(".rd-back+div+table td"));
           date.stream().filter(e->

                   {
                       System.out.println(e.getText());
                       return   e.getText().contains(depday);
                   }
           ).findFirst().get().click();
       }






       /* for(WebElement e :date){
            System.out.println(e.getText());
            if (e.getText().contains(depday)) {
                e.click();
                break;
            }
        }*/

    }
}
