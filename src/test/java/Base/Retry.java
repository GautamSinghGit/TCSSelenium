package Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int limit = 1;

    @Override
    public boolean retry(ITestResult result) {
        if(count<limit){
            count++;
            System.out.println(count);
            return true;
        }
        return false;
    }
}
