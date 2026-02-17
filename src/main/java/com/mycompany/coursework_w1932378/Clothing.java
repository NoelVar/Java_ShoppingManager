package com.mycompany.coursework_w1932378;

// IMPORTING THE ARRAY LIST OBJECT:
import java.util.ArrayList;

public class Clothing extends Product{
//--(INSTANCE VARIABLES:)-------------------------------------------------------
    String clothingSize;
    String clothingColour;
    
//--(CONSTRUCTOR:)--------------------------------------------------------------
    public Clothing(String ID,
                    String Name,
                    int availability,
                    float price,
                    String size,
                    String colour) {
        
        // SUPER CALLS THE CONSTRUCTOR OF THE PRODUCT CLASS:
        super(ID, Name, availability, price, "Clothing");
        this.clothingSize = size;
        this.clothingColour = colour;
    }
    
//--(METHODS - GET:)------------------------------------------------------------
    // GET CLOTHING SIZE:
    public String getSize() {
        return this.clothingSize;
    }
    // GET CLOTHING COLOUR:
    public String getColour() {
        return this.clothingColour;
    }
    
//--(METHODS - SET:)------------------------------------------------------------
    // SET CLOTHING SIZE:
    public void setSize(String size) {
        this.clothingSize = size;
    }
    // SET CLOTHING COLOUR:
    public void setColour(String colour) {
        this.clothingColour = colour;
    }

//--(METHODS - ADDING TO LIST:)-------------------------------------------------
    public ArrayList addToList() {
        // ADDING INFORMATION TO AN ARRAYLIST:
        ArrayList<Object> listOfClothing = new ArrayList<>();
        
        listOfClothing.add(super.getProductID());
        listOfClothing.add(super.getProductName());
        listOfClothing.add(super.getAvailableItems());
        listOfClothing.add(super.getProductPrice());
        listOfClothing.add("Clothing");
        listOfClothing.add(getSize());
        listOfClothing.add(getColour());
        
        return listOfClothing;
    }
        
//--(METHODS - toString:)-------------------------------------------------------
    // TO STRING (FOR TESTING PURPOSE):
    @Override
    public String toString(){
        return super.toString() + "\n" +
               "Clothing Size: " + this.clothingSize + "\n" +
               "Clothing Colour: " + this.clothingColour + "\n";
    }
}

//--(END OF CLASS CLOTHING)-----------------------------------------------------
//--(LAST EDITED: 18/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------

