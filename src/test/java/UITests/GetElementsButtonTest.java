package UITests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetElementsButtonTest extends BaseTest {

    @Test
    public void getElementsPageTest(){
        String expectedResult = "https://demoqa.com/elements";

        page.navigate("https://demoqa.com/");
        page.waitForSelector("//div[@class='card mt-4 top-card']//div[@class='card-body']//h5[text()='Elements']");
        page.click("//div[@class='card mt-4 top-card']//div[@class='card-body']//h5[text()='Elements']");

        String actualResult = page.url();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfTextBoxAreClicked(){
        String expectedResult = "Text Box";
        page.navigate("https://demoqa.com/");

        page.waitForSelector("//div[@class='card mt-4 top-card']//div[@class='card-body']//h5[text()='Elements']");
        page.click("//div[@class='card mt-4 top-card']//div[@class='card-body']//h5[text()='Elements']");

        page.waitForSelector("//ul[@class='menu-list']//li[@class='btn btn-light ']//span[text()='Text Box']");
        page.click("//ul[@class='menu-list']//li[@class='btn btn-light ']//span[text()='Text Box']");

        String actualResult = page.textContent("//h1[@class='text-center']");

        Assert.assertEquals(actualResult, expectedResult);
    }
}
