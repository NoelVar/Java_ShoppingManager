package com.mycompany.coursework_w1932378;

// IMPORTING THE ARRAY LIST CLASS:
import java.util.*;

public class ShoppingCart {
//--(INSTANCE VARIABLES:)-------------------------------------------------------
    List<Object> listOfProducts;
    public int totalCost;
    
//--(CONSTRUCTOR:)--------------------------------------------------------------
    public ShoppingCart() {
        this.listOfProducts = new ArrayList<>();
    }
        
//--(METHODS - ADD:)------------------------------------------------------------
    public void addToList(List<Object> product) {
        listOfProducts.add(product);
    }
    
//--(METHODS - REMOVE:)---------------------------------------------------------
    public void removeFromList(int removedItemIndex) {
        listOfProducts.remove(removedItemIndex);
    }
    
//--(METHODS - CLEAR:)----------------------------------------------------------
    public void clearList() {
        listOfProducts.clear();
    }

//--(METHODS - RETURNLIST)------------------------------------------------------
    public List<Object> returnList() { 
            return listOfProducts;
    }

//--(METHODS - CALCULATING TOTAL COST)------------------------------------------   
    public void calcTotalCost() {
        // GOING THROW ALL THE ELEMENTS IN THE "listOfProducts":
        for (int i = 0; i < listOfProducts.size(); i++) {
            // GETTING EVERY OBJECT IN THE LIST OF PRODUCTS;
            List <Object> innerList = (List <Object>) listOfProducts.get(i);    
            // GETTING THE PRICE OF EVERY PRODUCTS:
            int currentCost = (int) innerList.get(3);
            
            // ADDING THE CURRENT COST OF ONE PRODUCT TO THE TOTAL:
            this.totalCost = this.totalCost + currentCost;  
        }
        // PRINTING OUT THE TOTAL COST:
        System.out.println("The total cost is: " + this.totalCost);
    }
}

//--(END OF CLASS SHOPPINGCART)-------------------------------------------------
//--(LAST EDITED: 18/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------