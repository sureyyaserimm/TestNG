package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
 * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
 * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
 * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
 * XML filer file gruplama, paralel, ve farklı testleri koordine edip birarada çalıştırmak için kullanılır.
 */
// bu metoda dataprovider görevi verildi.
// DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.


public class _02_DataProvider {

    @Test(dataProvider = "myDatas")
    void UsernameTest(String username){
        System.out.println("username =" + username);
    }

    @DataProvider //bu metoda dataProvider görevi verildi
    public Object[] myDatas(){ //DataProvider olarak kullanılacak metodun tipi Object olmak zorunda.
        Object[] users={"A","B","C","D"};
        return users;
    }

    /**************************************************/

    @Test(dataProvider = "myDatas2")
    void UsernameTest(int id){
        System.out.println("username =" + id);
    }

    @DataProvider //bu metoda dataProvider görevi verildi
    public Object[] myDatas2(){ //DataProvider olarak kullanılacak metodun tipi Object olmak zorunda.
        Object[] users2={1,2,3,4};
        return users2;
    }
}
