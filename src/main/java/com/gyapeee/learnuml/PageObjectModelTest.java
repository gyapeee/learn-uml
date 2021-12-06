package com.gyapeee.learnuml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectModelTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void givenLoginToJigsawThenGoesToMainPage(){
        // https://jigsaw.w3.org/HTTP/Basic/
        driver = new ChromeDriver();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
