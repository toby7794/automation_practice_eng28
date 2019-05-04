package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckoutPageFirstHalf {

    private WebDriver driver;
    private String checkoutPageURL = "http://automationpractice.com/index.php?controller=order&step=1";
    private By billingAndDeliveryButton = By.id("addressesAreEquals");
    private By addNewAddressButton = By.linkText("Add a new address");
    private By saveNewAddressButton = By.id("submitAddress");
    private By deliveryAddressesElements = By.id("id_address_delivery");

    private List<String> deliveryAddressesList;


    public CheckoutPageFirstHalf(WebDriver driver) {
        this.driver = driver;
        }

    public WebElement findElement(By element){
        return driver.findElement(element);}

    public List<WebElement> findElements(By element){
        return driver.findElements(element);}

    public void goToCheckOutPage(){
        driver.navigate().to(checkoutPageURL);
    }

    public CheckoutPageFirstHalf togglebillingAndDeliveryButtonDropDownBox(){
        findElement(billingAndDeliveryButton).click();
        return this;
    }

    public CheckoutPageFirstHalf clickAddNewAddress(){
        findElement(addNewAddressButton);
        return this;
    }

    public CheckoutPageFirstHalf saveNewAddressButton(){
        findElement(saveNewAddressButton);
        return this;
    }

    private List<String> getDeliveryAddressesElements() {

        ArrayList<String> deliveryAddresses = new ArrayList<>();
        WebElement dropdown = driver.findElement(deliveryAddressesElements);
        List<WebElement> deliveryOptions = dropdown.findElements(By.tagName("option"));
        Iterator<WebElement> it = deliveryOptions.iterator();
        while (it.hasNext()) {
            deliveryAddresses.add(it.next().getText().trim());
        }
        deliveryAddressesList = deliveryAddresses;
        return deliveryAddressesList;
    }

    public boolean checkDeliveryAddress(String address){
        getDeliveryAddressesElements();
        return deliveryAddressesList.contains(address);
    }





//temporary methods to get to the address page
     public CheckoutPageFirstHalf step1(){
        driver.findElement(By.id("header_logo")).click();
        return this;
     }

    public CheckoutPageFirstHalf step2(){
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
        return this;
    }

    public CheckoutPageFirstHalf step3(){
        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }

    public CheckoutPageFirstHalf step4() {
        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }

    public CheckoutPageFirstHalf step5(){
        driver.findElement(By.id("email")).sendKeys("engineering.28.sstvw@gmail.com");
        return this;
    }

    public CheckoutPageFirstHalf step6(){
        driver.findElement(By.id("passwd")).sendKeys("3NG_s8SSTVW");
        return this;
    }

    public CheckoutPageFirstHalf step7(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("SubmitLogin")).click();
        return this;
    }


}
