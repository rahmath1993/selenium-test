package org.example.saucedemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@Builder(setterPrefix = "set")
public class CartPage {
    WebDriver driver;
    WebElement elementButtonCheckout;
    WebElement elementFirstName;
    WebElement elementLastName;
    WebElement elementZipCode;
    WebElement elementButtonContinue;
    String firstName;
    String lastName;
    String zipCode;
}
