package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class DropDown {  WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
    }


//    @Test
//    public void dropDown() throws InterruptedException {
//
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//
//        WebElement select = driver.findElement(By.id("dropdown"));
//
//
//        Select dropDown = new Select(select);
//        dropDown.selectByVisibleText("Option 1");
//        dropDown.selectByValue("2");
//        Thread.sleep(3000);
//
//    }
//    @Test
//    public void dropDown() throws InterruptedException {
//
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//
//        WebElement select = driver.findElement(By.cssSelector(".form-select"));
//
//
//        Select dropDown = new Select(select);
//        dropDown.selectByValue("1");
//        dropDown.selectByVisibleText("Two");
//        dropDown.selectByIndex(3);
//        Thread.sleep(3000);
//
//    }
@Test
public void DataTable() throws InterruptedException {

    driver.get("https://the-internet.herokuapp.com/tables");

    List<WebElement> emails = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td[3]"));
    for (WebElement email: emails){
        System.out.println(email.getText());
    }



    Thread.sleep(3000);

}
    @AfterMethod
    public void after() {
        //driver.quit();
    }
}
