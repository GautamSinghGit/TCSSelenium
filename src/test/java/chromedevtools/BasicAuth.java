package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import  java.net.URI;


import java.util.function.Predicate;

public class BasicAuth {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

       Predicate<URI> url = uri-> uri.getHost().contains("httpbin.org");

        ((HasAuthentication)driver).register(url,UsernameAndPassword.of("foo","bar"));

        driver.get("https://httpbin.org/basic-auth/foo/bar");

    }
}
