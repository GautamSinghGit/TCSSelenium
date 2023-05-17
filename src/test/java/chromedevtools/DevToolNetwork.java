package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;

import java.util.Optional;

public class DevToolNetwork {

    public static void main(String[] args) {
        ChromeOptions
                op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver(op);

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),request->{

            Request req = request.getRequest();
            System.out.println(req.getUrl());

        });
        devTools.addListener(Network.responseReceived(),response->{

            Response res  = response.getResponse();

            System.out.println(res.getStatus());
        });

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("[value='Submit']")).click();
    }
}
