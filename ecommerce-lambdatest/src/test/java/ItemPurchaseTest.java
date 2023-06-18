import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemPurchaseTest {
    private ItemPurchase itemPurchase;

    @Test(dataProvider = "ItemPurchase")
    public void ItemPurchase(String firstName, String lastName, String address, String city, String zipCode, String country, int state) {
        itemPurchase = new ItemPurchase(BaseTest.driver);
        itemPurchase.purchaseItem(firstName, lastName, address, city, zipCode, country, state);
        System.out.println("Item Purchase Test Passed");
    }


    @DataProvider(name = "ItemPurchase")
    public static Object[][] testData() {
        return new Object[][]{
                {"FirstName Test", "LastName Test", "Address Test", "City Test", "12345", "India", 0}
        };
    }

}
