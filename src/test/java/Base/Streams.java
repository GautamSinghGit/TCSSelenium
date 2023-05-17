package Base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Streams {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        String jsonfile = FileUtils
                .readFileToString
                        (new File(System.getProperty("user.dir") + "//src/test//resources//data.json"),
                                StandardCharsets.UTF_8);

        ObjectMapper map = new ObjectMapper();
        List<HashMap<String,String>> data = map.readValue(jsonfile, new TypeReference<List<HashMap<String,String>>>() {
        });

        System.out.println(data.get(0).get("email"));
        System.out.println(data.get(0).get("pwd"));


      //  fruitSorting();
       // regular();
    }

    public static void regular() {
        ArrayList<String> s = new ArrayList<>();
        s.add("Abhijeet");
        s.add("Alekhya");
        s.add("Rahul");
        s.add("Nikhil");
        s.add("Raj");
        s.add("Aayush");
        s.add("Rahul");
        s.add("Raj");

        s.stream().filter(e->e.startsWith("R")).filter(e->e.length()>4).map(String::toUpperCase).distinct().forEach(System.out::println);
        long a =s.stream().filter(e->e.startsWith("R")).filter(e->e.length()>4).map(String::toUpperCase).distinct().count();
        System.out.println(a);
    }

    public static void fruitSorting(){
        driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();



      List<String> fruittextsorted = driver.findElements(By.xpath("//tr//td[1]")).stream().map(e->e.getText()).toList();

       List<String> sortedlist = fruittextsorted.stream().sorted().toList();

        System.out.println(fruittextsorted.equals(sortedlist));


        List<String> p;
        do{
            List<WebElement> f = driver.findElements(By.cssSelector("tr td:first-child"));
           p =  f.stream().filter(e->e.getText().equals("Beans")).map(Streams::getPrice).toList();
          if (p.size()<1)
              driver.findElement(By.cssSelector("aria-label='Next'")).click();
        }while (p.size()<1);




    }
    public static String getPrice(WebElement e){
        return e.findElement(By.xpath(".//following-sibling::td")).getText();

    }




}
