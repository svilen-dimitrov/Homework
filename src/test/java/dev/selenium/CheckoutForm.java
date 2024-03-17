package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CheckoutForm extends MainDriver{
    @Test
    public void checkout(){
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement yourInformationText = driver.findElement(By.cssSelector(".title"));
        String text = yourInformationText.getText();
        assertTrue(text.contains("Checkout: Your Information"));
    }

    @Test
    public void fillCheckoutForm() {
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Svilen");
        lastName.sendKeys("Dimitrov");
        zipCode.sendKeys("9000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement paymentInfo = driver.findElement(By.cssSelector(".summary_info_label"));
        String textPaymentInfo = paymentInfo.getText();
        assertTrue(textPaymentInfo.contains("Payment Information"));
    }
    @Test
    public void checkFormMissingFirstName(){
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("");
        lastName.sendKeys("Dimitrov");
        zipCode.sendKeys("9000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement erorrFirstName = driver.findElement(By.cssSelector(".error-message-container"));
        String misingFirstNameText = erorrFirstName.getText();
        Assert.assertEquals(misingFirstNameText, "Error: First Name is required");
    }
    @Test
    public void checkFormMissingLastName(){
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Svilen");
        lastName.sendKeys("");
        zipCode.sendKeys("9000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement erorrFirstName = driver.findElement(By.cssSelector(".error-message-container"));
        String misingLastNameText = erorrFirstName.getText();
        Assert.assertEquals(misingLastNameText, "Error: Last Name is required");
    }
    @Test
    public void checkFormMissingZip(){
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Svilen");
        lastName.sendKeys("Dimitrov");
        zipCode.sendKeys("");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement erorrFirstName = driver.findElement(By.cssSelector(".error-message-container"));
        String misingLastNameText = erorrFirstName.getText();
        Assert.assertEquals(misingLastNameText, "Error: Postal Code is required");
    }
    @Test
    public void finishPurshase(){
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

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Svilen");
        lastName.sendKeys("Dimitrov");
        zipCode.sendKeys("9000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement ponyExpres =driver.findElement(By.cssSelector(".pony_express"));
        assertTrue(ponyExpres.isDisplayed());
    }
}

