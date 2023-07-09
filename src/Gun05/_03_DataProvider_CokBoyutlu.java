package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {

    @Test(dataProvider = "UserData")
    void UsernameProvider(String username, String password) {
        System.out.println("User =" + username + password);
    }

    @DataProvider
    public Object[][] UserData(){

        Object [][] data={

                {"A", "1"},
                {"B","2"},
                {"C","3"},
                {"D","4"},
        };

        return data;
    }
}
