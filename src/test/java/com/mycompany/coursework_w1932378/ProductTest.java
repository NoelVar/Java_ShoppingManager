/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.coursework_w1932378;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author varno
 */
public class ProductTest {
    
    public ProductTest() {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of getProductID method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testGetProductID() {
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testGetProductName() {
    }

    /**
     * Test of getAvailableItems method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testGetAvailableItems() {
    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testGetProductPrice() {
    }

    /**
     * Test of getProductType method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testGetProductType() {
    }

    /**
     * Test of setProductID method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testSetProductID() {
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testSetProductName() {
    }

    /**
     * Test of setAvailableItems method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testSetAvailableItems() {
    }

    /**
     * Test of setProductPrice method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testSetProductPrice() {
    }

    /**
     * Test of setProductType method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testSetProductType() {
    }

    /**
     * Test of toString method, of class Product.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        Electronics e = new Electronics("B1", "TV", 8, 250, "Samsung", "2years");
        
        e.setBrand("Hisense");
        assertEquals("B1", e.getProductID());
        assertEquals("TV", e.getProductName());
        assertEquals(8, e.getAvailableItems());
        assertEquals(250, e.getProductPrice());
        assertEquals("Hisense", e.getBrand());
        assertEquals("2years", e.getWarranty());
        
        Clothing c = new Clothing("A1", "Hoodie", 11, 60, "M", "Grey");
               
        assertEquals("A1", c.getProductID());
        assertEquals("Hoodie", c.getProductName());
        assertEquals(11, c.getAvailableItems());
        assertEquals(60, c.getProductPrice());
        assertEquals("M", c.getSize());
        assertEquals("Grey", c.getColour());
    }

    public class ProductImpl extends Product {

        public ProductImpl() {
            super("", "", 0, 0.0F, "");
        }
    }
    
}
