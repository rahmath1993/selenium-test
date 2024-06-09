package saucedemo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.saucedemo.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoSteps {

    private static final Logger logger = LoggerFactory.getLogger(SauceDemoSteps.class);

    @Step
    public void openBrowser(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
    }


    @Step
    public void verifyLoginUsingLockedUser(LoginPage loginPage) {
        WebDriver driver = loginPage.getDriver();

        WebElement message = driver.findElement(By.cssSelector("h3"));
        String value = message.getText();

        assertEquals("Epic sadface: Sorry, this user has been locked out.", value);
    }

    @Step
    public void login(LoginPage loginPage) {
        loginPage.getElementUsername().sendKeys(loginPage.getUsername());
        loginPage.getElementPassword().sendKeys(loginPage.getPassword());
        loginPage.getElementButtonLogin().click();
    }

    @Step
    public void addToCartSauceLabsBackpack(HomePage homePage) {
        homePage.getElementAddToCartSauceLabsBackpack().click();
    }

    @Step
    public void inventoryItemSauceLabsBikeLight(HomePage homePage) {
        homePage.getElementInventoryItemSauceLabsBikeLight().click();
    }

    @Step
    public void addToCartSauceLabsBikeLight(ProductDetailPage productDetailPage) {
        productDetailPage.getElementButtonAddToCart().click();
    }

    @Step
    public void iconShoppingCart(ProductDetailPage productDetailPage) {
        productDetailPage.getElementIconShoppingCart().click();
    }

    @Step
    public void checkout(CartPage cartPage) {
        cartPage.getElementButtonCheckout().click();
    }

    @Step
    public void fillForm(CartPage cartPage) {
        cartPage.getElementFirstName().sendKeys(cartPage.getFirstName());
        cartPage.getElementLastName().sendKeys(cartPage.getLastName());
        cartPage.getElementZipCode().sendKeys(cartPage.getZipCode());
        cartPage.getElementButtonContinue().click();
    }

    @Step
    public void fillLastName(CartPage cartPage) {
        cartPage.getElementLastName().sendKeys(cartPage.getLastName());
        cartPage.getElementButtonContinue().click();
    }

    @Step
    public void verifyRequiredLastName(CartPage cartPage) {
        WebDriver driver = cartPage.getDriver();

        WebElement message = driver.findElement(By.cssSelector("h3"));
        String value = message.getText();

        assertEquals("Error: Last Name is required", value);
    }

    @Step
    public void verifyTotalPrice(CheckoutDetailPage checkoutDetailPage) {
        WebDriver driver = checkoutDetailPage.getDriver();

        WebElement message = driver.findElement(By.className("summary_total_label"));
        String value = message.getText();

        assertEquals("Total: $43.18", value);
    }

    @Step
    public void verifyListProduct(CheckoutDetailPage checkoutDetailPage) {
        WebDriver driver = checkoutDetailPage.getDriver();

        WebElement sauceLabsBackpack = driver.findElement(By.id("item_4_title_link"));
        WebElement sauceLabsBikeLight = driver.findElement(By.id("item_0_title_link"));
        String valueSauceLabsBackpack = sauceLabsBackpack.getText();
        String valueSauceLabsBikeLight = sauceLabsBikeLight.getText();

        assertEquals("Sauce Labs Backpack", valueSauceLabsBackpack);
        assertEquals("Sauce Labs Bike Light", valueSauceLabsBikeLight);
    }

    @Step
    public void clickFinish(CheckoutDetailPage checkoutDetailPage) {
        checkoutDetailPage.getElementButtonFinish().click();
    }

    @Step
    public void clickBackToHome(CheckoutDetailPage checkoutDetailPage) {
        checkoutDetailPage.getElementButtonBackToHome().click();
    }

    @Step
    public void verifyHomeScreen(CheckoutDetailPage checkoutDetailPage) {
        WebDriver driver = checkoutDetailPage.getDriver();

        WebElement message = driver.findElement(By.className("app_logo"));
        String value = message.getText();

        assertEquals("Swag Labs", value);
    }

    @Step
    public void clickBurgerMenu(CheckoutDetailPage checkoutDetailPage) {
        checkoutDetailPage.getElementBurgerMenu().click();
    }

    @Step
    public void clickLogout(LogoutPage logoutPage) {
        logoutPage.getElementLogout().click();
    }

    @Step
    public void verifyLoginScreen(LogoutPage logoutPage) {
        WebDriver driver = logoutPage.getDriver();

        WebElement message = driver.findElement(By.className("login_logo"));
        String value = message.getText();

        assertEquals("Swag Labs", value);
    }
}
