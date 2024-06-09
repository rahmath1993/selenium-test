package org.example.saucedemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@Builder(setterPrefix = "set")
public class CheckoutDetailPage {
    WebDriver driver;
    WebElement elementInventorySauceLabsBackpack;
    WebElement elementInventorySauceLabsBikeLight;
    WebElement elementPriceTotal;
    WebElement elementButtonFinish;
    WebElement elementButtonBackToHome;
    WebElement elementHomeScreen;
    WebElement elementBurgerMenu;
}
