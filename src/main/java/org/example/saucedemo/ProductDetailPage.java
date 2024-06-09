package org.example.saucedemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@Builder(setterPrefix = "set")
public class ProductDetailPage {
    WebDriver driver;
    WebElement elementButtonAddToCart;
    WebElement elementIconShoppingCart;
}
