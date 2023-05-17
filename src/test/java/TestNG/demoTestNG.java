package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class demoTestNG {

    public Map<Integer,String> m = new HashMap<>();
    @Test
    @Parameters({"browser","url"})
    public void test(String b,String u){
        System.out.println(b+" "+u);
    }

    @Test()
    public void test1(){
        System.out.println("start");
      //  System.out.println(m1.get("user"));
        System.out.println("end");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }


    @DataProvider(name = "get")
    public Object[][] get(){

        Map<Object,Object> m = new HashMap<>();
        Object data1[][] = new Object[2][1];
        m.put("user","Rahul");
        m.put("pwd","AAyush");


        data1[0][0] = m;
        m=new HashMap<>();

        m.put("user","Nikhil");
        m.put("pwd","Raj");
        data1[1][0] = m;

        /*data1[0][1] = "Password";
        data1[1][0] = "Rahul";
        data1[1][1] = "Aayush";
*/
       Object data[][] = {{"name","Raj"},{"Rahul","Nikhil"}};

        return data1;

    }

}
