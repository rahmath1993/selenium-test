package saucedemo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.example.saucedemo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.steps.SauceDemoSteps;
import java.time.Duration;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoTest {

    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);

    @Steps
    private SauceDemoSteps steps;

    @Test
    public void loginUsingLockedUser() {
        WebDriver driver = new ChromeDriver();
        steps.openBrowser(driver);
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        LoginPage loginPage = LoginPage.builder()
                .setDriver(driver)
                .setElementUsername(username)
                .setElementPassword(password)
                .setElementButtonLogin(loginButton)
                .setUsername("locked_out_user")
                .setPassword("secret_sauce")
                .build();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        steps.login(loginPage);
        steps.verifyLoginUsingLockedUser(loginPage);

        driver.quit();

    }


    @Test
    public void loginUsingStandardUser() {
        WebDriver driver = new ChromeDriver();
        steps.openBrowser(driver);
        driver.manage().window().maximize();



        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        LoginPage loginPage = LoginPage.builder()
                .setDriver(driver)
                .setElementUsername(username)
                .setElementPassword(password)
                .setElementButtonLogin(loginButton)
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .build();

        steps.login(loginPage);

        HomePage homePage = HomePage.builder()
                .setDriver(driver)
                .build();

        WebElement addToCartSauceLabsBackpack = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        homePage.setElementAddToCartSauceLabsBackpack(addToCartSauceLabsBackpack);
        steps.addToCartSauceLabsBackpack(homePage);

        WebElement inventoryItemSauceLabsBikeLight = driver.findElement(By.id("item_0_title_link"));
        homePage.setElementInventoryItemSauceLabsBikeLight(inventoryItemSauceLabsBikeLight);
        steps.inventoryItemSauceLabsBikeLight(homePage);

        ProductDetailPage productDetailPage = ProductDetailPage.builder()
                .setDriver(driver)
                .build();

        WebElement buttonAddToCart = driver.findElement(By.name("add-to-cart"));
        productDetailPage.setElementButtonAddToCart(buttonAddToCart);
        steps.addToCartSauceLabsBikeLight(productDetailPage);

        WebElement iconShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        productDetailPage.setElementIconShoppingCart(iconShoppingCart);
        steps.iconShoppingCart(productDetailPage);

        CartPage cartPage = CartPage.builder()
                .setDriver(driver)
                .setFirstName("dummy")
                .setLastName("")
                .setZipCode("28654")
                .build();

        WebElement buttonCheckout = driver.findElement(By.name("checkout"));
        cartPage.setElementButtonCheckout(buttonCheckout);
        steps.checkout(cartPage);

        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement zipCode = driver.findElement(By.name("postalCode"));
        WebElement buttonContinue = driver.findElement(By.name("continue"));

        cartPage.setElementFirstName(firstName);
        cartPage.setElementLastName(lastName);
        cartPage.setElementZipCode(zipCode);
        cartPage.setElementButtonContinue(buttonContinue);
        steps.fillForm(cartPage);
        steps.verifyRequiredLastName(cartPage);

        cartPage.setLastName("user");
        steps.fillLastName(cartPage);

        CheckoutDetailPage checkoutDetailPage = CheckoutDetailPage.builder()
                .setDriver(driver)
                .build();

        WebElement priceTotal = driver.findElement(By.className("summary_total_label"));
        checkoutDetailPage.setElementPriceTotal(priceTotal);
        steps.verifyTotalPrice(checkoutDetailPage);

        WebElement inventorySauceLabsBackpack = driver.findElement(By.id("item_4_title_link"));
        WebElement inventorySauceLabsBikeLight = driver.findElement(By.id("item_0_title_link"));
        checkoutDetailPage.setElementInventorySauceLabsBackpack(inventorySauceLabsBackpack);
        checkoutDetailPage.setElementInventorySauceLabsBikeLight(inventorySauceLabsBikeLight);
        steps.verifyListProduct(checkoutDetailPage);

        WebElement buttonFinish = driver.findElement(By.name("finish"));
        checkoutDetailPage.setElementButtonFinish(buttonFinish);
        steps.clickFinish(checkoutDetailPage);

        WebElement buttonBackToHome = driver.findElement(By.name("back-to-products"));
        checkoutDetailPage.setElementButtonBackToHome(buttonBackToHome);
        steps.clickBackToHome(checkoutDetailPage);

        WebElement homeScreen = driver.findElement(By.className("app_logo"));
        checkoutDetailPage.setElementHomeScreen(homeScreen);
        steps.verifyHomeScreen(checkoutDetailPage);

        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        checkoutDetailPage.setElementBurgerMenu(burgerMenu);
        steps.clickBurgerMenu(checkoutDetailPage);

        LogoutPage logoutPage = LogoutPage.builder()
                .setDriver(driver)
                .build();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logoutPage.setElementLogout(logout);
        steps.clickLogout(logoutPage);

       WebElement loginScreen = driver.findElement(By.className("login_logo"));
        logoutPage.setElementLoginLogo(loginScreen);
        steps.verifyLoginScreen(logoutPage);

//      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.quit();
    }

}
