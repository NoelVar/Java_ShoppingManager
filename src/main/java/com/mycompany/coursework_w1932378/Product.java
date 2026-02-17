package com.mycompany.coursework_w1932378;

public abstract class Product {
//--(INSTANCE VARIBALES:)-------------------------------------------------------
    private String productID;
    private String productName;
    private int availableItems;
    private float productPrice;
    // PRODUCT TYPE WAS CREATED TO DISTINGUISH THE DIFFERENT TYPE OF ITEMS.
    private String productType;
    
//--(CONSTRUCTOR:)--------------------------------------------------------------
    public Product(String ID,
                   String Name,
                   int availability,
                   float price,
                   String type) {
      
        this.productID = ID;
        this.productName = Name;
        this.availableItems = availability;
        this.productPrice = price;
        this.productType = type; 
    }
    
//--(METHODS - GET:)------------------------------------------------------------
    // GET PRODUCT ID:
    public String getProductID() {
        return this.productID;
    }
    // GET PRODUCT NAME:
    public String getProductName() {
        return this.productName;
    }
    // GET AVAILABLE ITEMS:
    public int getAvailableItems() {
        return this.availableItems;
    }
    // GET PRODUCT PRICE:
    public float getProductPrice() {
        return this.productPrice;
    }
    // GET PRODUCT TYPE:
    public String getProductType() {
        return this.productType;
    }
    
//--(METHODS - SET:)------------------------------------------------------------
    // SET PRODUCT ID:
    public void setProductID(String ID) {
        this.productID = ID;
    }
    // SET PRODUCT NAME:
    public void setProductName(String Name) {
        this.productName = Name;
    }
    // SET AVAILABLE ITEMS:
    public void setAvailableItems(int availability) {
        this.availableItems = availability;
    }
    // SET PRODUCT PRICE:
    public void setProductPrice(int Price) {
        this.productPrice = Price;
    }
    // SET PRODUCT TYPE:
    public void setProductType(String type) {
        this.productType = type;
    }
    
//--(METHODS - toString:)-------------------------------------------------------
    // TO STRING (FOR TESTING PURPOSE):
    @Override
    public String toString(){
        return "Product ID: " + this.productID + "\n" +
               "Product Name: " + this.productName + "\n" +
               "Product Availability: " + this.availableItems + "\n" +
               "Product Price: £" + this.productPrice + "\n" +
               "Product Type: " + this.productType;
    }
}

//--(END OF CLASS PRODUCT)------------------------------------------------------
//--(LAST EDITED: 18/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------