package org.example.saucedemo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@Builder(setterPrefix = "set")

public class LoginPage {
    WebDriver driver;
    WebElement elementUsername;
    WebElement elementPassword;
    WebElement elementButtonLogin;
    String username;
    String password;
}
