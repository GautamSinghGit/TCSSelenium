package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.fetch.Fetch;
import org.openqa.selenium.devtools.v101.network.model.Request;


import java.util.Optional;

public class Fetchcommand {


    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        devTools.send(Fetch.enable(Optional.empty(),Optional.empty()));

        devTools.addListener(Fetch.requestPaused(),request-> {

            Request req = request.getRequest();
            String mockUrl = null;
            if (req.getUrl().contains("shetty")) {
                mockUrl = req.getUrl().replace("shetty", "BadGuy");

                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockUrl),
                        Optional.of(req.getMethod()),Optional.empty()
                        ,Optional.empty(),Optional.of(true)
                ));
            }
            else{
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(req.getUrl()),
                        Optional.of(req.getMethod()),Optional.empty()
                        ,Optional.empty(),Optional.of(true)
                ));
            }


        });

        driver.get("");


    }
}
