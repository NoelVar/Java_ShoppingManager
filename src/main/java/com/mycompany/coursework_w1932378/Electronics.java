package com.mycompany.coursework_w1932378;

// IMPORTING THE ARRAY LIST OBJECT:
import java.util.ArrayList;

public class Electronics extends Product{
//--(INSTANCE VARIABLES:)-------------------------------------------------------
    String eBrand;
    String eWarrantyPeriod;
    
//--(CONSTRUCTOR:)--------------------------------------------------------------
    public Electronics(String ID,
                       String Name,
                       int availability,
                       float price,
                       String brand,
                       String warranty) {
        
        // SUPER CALLS THE CONSTRUCTOR OF THE PRODUCT CLASS:
        super(ID, Name, availability, price, "Electronics");
        this.eBrand = brand;
        this.eWarrantyPeriod = warranty;
    }
    
//--(METHODS - GET:)------------------------------------------------------------
    // GET ELECTRONICS BRAND:
    public String getBrand() {
        return this.eBrand;
    }
    // GET ELECTRONICS WARRANTY PERIOD:
    public String getWarranty() {
        return this.eWarrantyPeriod;
    }
    
//--(METHODS - SET:)------------------------------------------------------------
    // SET ELECTRONICS BRAND:
    public void setBrand(String brand) {
        this.eBrand = brand;
    }
    // SET ELECTRONICS WARRANTY PERIOD:
    public void setWarranty(String warranty) {
        this.eWarrantyPeriod = warranty;
    }

//--(METHODS - ADDING TO LIST:)-------------------------------------------------
    public ArrayList addToList() {
        // ADDING INFORMATION TO AN ARRAYLIST:
        ArrayList<Object> listOfElectronics = new ArrayList<>();
        
        listOfElectronics.add(super.getProductID());
        listOfElectronics.add(super.getProductName());
        listOfElectronics.add(super.getAvailableItems());
        listOfElectronics.add(super.getProductPrice());
        listOfElectronics.add("Electronics");
        listOfElectronics.add(getBrand());
        listOfElectronics.add(getWarranty());
        
        return listOfElectronics;
    }
    
//--(METHODS - toString:)-------------------------------------------------------
    // TO STRING (FOR TESTING PURPOSE):
    @Override
    public String toString(){
        return super.toString() + "\n" +
               "Electronics Brand: " + this.eBrand + "\n" +
               "Electronics Warranty Period: " + this.eWarrantyPeriod + "\n";
    }
}

//--(END OF CLASS ELECTRONICS)--------------------------------------------------
//--(LAST EDITED: 18/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------