package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.AssertJUnit.assertEquals;

public class ActionsAndSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
    }


    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement input = driver.findElement(By.id("target"));

        input.sendKeys(Keys.ESCAPE);

        WebElement message = driver.findElement(By.id("result"));
        assertEquals(message.getText(),"You entered: ESCAPE");

        Thread.sleep(3000);

    }

    @AfterMethod
    public void after() {
        //driver.quit();
    }
}

