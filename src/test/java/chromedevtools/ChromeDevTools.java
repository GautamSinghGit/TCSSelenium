package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.emulation.Emulation;



import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChromeDevTools {


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--incognito");
       // Map<String, Object> prefs = new HashMap<String, Object>();

      //  prefs.put("profile.default_content_setting_values.notifications", 2);

     //   options.setExperimentalOption("prefs",prefs);
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        //send command to CDP methods -> CDP method ill invoke and get access to dv tools4
        /*Map<String,Object> map = new HashMap();
        map.put("latitude",40);
        map.put("longitude",3);
        map.put("accuracy",1);*/


       // driver.executeCdpCommand("Emulation.setGeolocationOverride",map);

        devTools.send(Emulation.setGeolocationOverride(Optional.of(40),Optional.of(74),Optional.of(1)));

        driver.manage().window().maximize();
        driver.get("");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("Nextflix", Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h3[text()='Netflix - Watch TV Shows Online, Watch Movies Online']")).click();





    }



}
