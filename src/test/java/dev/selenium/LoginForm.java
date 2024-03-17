package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginForm extends MainDriver {
    @Test
    public void LoginCorrect() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();


        WebElement productsPageTitle = driver.findElement(By.className("title"));
        Assert.assertEquals(productsPageTitle.getText(), "Products");
    }


    @Test
    public void loginFailed() {

        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-message-container"));
        String test = errorMsg.getText();
        Assert.assertEquals(test, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void colorErrorCheck() {


        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();
        WebElement errorTextElement = driver.findElement(By.cssSelector(".error-message-container"));
        String color = errorTextElement.getCssValue("color");
        Assert.assertEquals(color, "rgba(19, 35, 34, 1)");

    }

    @Test
    public void loginFailedMissingUserName() {

        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-message-container"));
        String test = errorMsg.getText();
        Assert.assertEquals(test, "Epic sadface: Username is required");
    }

    @Test
    public void loginFailedMissingPassword() {

        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-message-container"));
        String test = errorMsg.getText();
        Assert.assertEquals(test, "Epic sadface: Password is required");
    }

    @Test
    public void addToCart() {
        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();
        WebElement sauceLabsBack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBack.click();

        WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        assertTrue(remove.isDisplayed());
    }

    @Test
    public void cart() {
        WebElement usernameField = driver.findElement(By.cssSelector("[name = 'user-name']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[name = 'password']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login-button']"));
        loginButton.click();
        WebElement sauceLabsBack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBack.click();

        WebElement cart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cart.click();

        WebElement yourCartText = driver.findElement(By.cssSelector(".title"));
        String text = yourCartText.getText();
        assertTrue(text.contains("Your Cart"));
    }
}


