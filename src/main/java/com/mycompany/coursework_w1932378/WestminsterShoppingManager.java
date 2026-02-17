package com.mycompany.coursework_w1932378;

import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager{
    // CART OBJECT HERE BECAUSE IT IS USED IN MULTIPLE METHODS:
    ShoppingCart cart = new ShoppingCart();
    Scanner input = new Scanner(System.in);
  
    int totalProducts = 0;

//--(CONSOLE MENU:)-------------------------------------------------------------   
    public void consoleMenu() {
        int choosenOption = 8;
        while (choosenOption != 0) {
            System.out.println("----------------------------------------------------");
            System.out.println("Welcome to the Westminster Shopping Manager!");
            System.out.println("Please select from the following options below:");
            System.out.println("\t 1) Add a new product.");
            System.out.println("\t 2) Delete a product.");
            System.out.println("\t 3) Print the list of the products.");
            System.out.println("\t 4) Save in a file.");
            System.out.println("\t 5) Open Graphical User Interface.");
            System.out.println("\t 0) Quit menu.");
            System.out.println("----------------------------------------------------");
            
            System.out.println("Please choose an option: ");
            try {
                choosenOption = input.nextInt();
                switch (choosenOption) {
                    case 1 -> {
                        addProduct();
                    }
                    case 2 -> {
                        deleteProduct();
                    }
                    case 3 -> {
                        printList();
                    }
                    case 4 -> {
                        saveInFile();
                    }
                    case 5 -> {
                        ImplementationOfGUI myGUI = new ImplementationOfGUI();                 
                    }
                    case 0 -> {
                        System.out.println("Thank you for using our program!");
                    }
                    default -> {
                        System.out.println("Invalid menu option!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error! Something else then an Integer was entered! (Menu Options)");
                choosenOption = 0;
            }
        }
    }
    
//--(ADDING PRODUCT:)-----------------------------------------------------------
    @Override
    public void addProduct(){
        boolean error = true;
        while (error == true) {
            // GETTING USER CHOSEN OPTION:
            System.out.println("Would you like to enter an Electronic or Clothing product (e/c).");
            String productType = input.next();
            
            // CONVERTING THE CHOOSEN PRODUCT OPTION INTO A LOWER CASE CHARACTER IN CASE IT WAS CAPITAL:
            productType = productType.toLowerCase();

            // CHECKING THE CHOSEN OPTION (ELECTRONICS) 
            // AND IF THE TOTAL PRODUCTS ARE NOT OVER 50: 
            if ("e".equals(productType) && totalProducts != 50) {
                // GETTING THE ID OF THE ELECTRONIC PRODUCT:
                System.out.println("Please give me the ID of the product!");
                String proID = input.next();

                // GETTING THE NAME OF THE ELECTRONIC PRODUCT:
                System.out.println("Please give me the name of the product!");
                String proName = input.next();

                // GETTING THE AMOUNT OF ELECTRONIC PRODUCT(S) IN STOCK:
                System.out.println("Please give me the amount of product in stock!");
                int proAvailability;
                
                // CHECKING IF THE ENTERED VALUE IS AN INTEGER:
                try {
                    proAvailability = input.nextInt();

                    // GETTING THE PRICE OF THE ELECTRONIC PRODUCT:
                    System.out.println("Please give me the price of the product!");
                    int proPrice;
                    
                    // CHECKING IF THE ENTERED VALUE IS AN INTEGER:
                    try {
                        proPrice = input.nextInt();

                        // GETTING THE BRAND OF THE ELECTRONIC PRODUCT:
                        System.out.println("Please give me the brand of the product!");
                        String proBrand = input.next();

                        // GETTING THE WARRANTY OF THE ELECTRONIC PRODUCT:
                        System.out.println("Please give me the warranty of the product!");
                        String proWarranty = input.next();

                        // CREATING THE ELECTRONICS OBJECT 
                        // AND ADDING THE OBJECT TO THE LIST (IN PRODUCT CLASS)
                        // AND WE PUT THE RETURNED LIST INTO A NEW LIST (IN THIS CLASS)
                        // THE LIST WE CREATED IN THIS CLASS WILL BE ADDED TO THE SHOPPING CART CLASSES LIST
                        Electronics eItem = new Electronics(proID, proName, proAvailability, proPrice, proBrand, proWarranty);
                        ArrayList listOfElectronics = eItem.addToList();         
                        cart.addToList(listOfElectronics);
                        System.out.println(cart);

                        // ADDING TO THE TOTAL PRODUCTS:
                        totalProducts++;
                        
                    // CATCHING THE EXEPTION (INPUTMISSMATCH), TYPES OUT ERROR AND CATCHES THE ENTERED STRING
                    // SO THAT THE ENTERED STRING WONT GET USED AT THE BEGINING OF THE LOOP
                    // THEN CONTINUES THE LOOP
                    } catch (Exception e) {
                        System.out.println("Something other then an Integer was entered! (Price)");
                        String catchWrongInput = input.next();
                        continue;
                    }
                    
                // CATCHING THE EXEPTION (INPUTMISSMATCH), TYPES OUT ERROR AND CATCHES THE ENTERED STRING
                // SO THAT THE ENTERED STRING WONT GET USED AT THE BEGINING OF THE LOOP
                // THEN CONTINUES THE LOOP
                } catch (Exception e) {
                    System.out.println("Something other then an Integer was entered! (Availability)");
                    String catchWrongInput = input.next();
                    continue;
                }
            }
            // CHECKING THE CHOSEN OPTION (CLOTHING)
            // AND IF THE TOTAL PRODUCTS ARE NOT OVER 50:
            else if ("c".equals(productType) && totalProducts != 50) { 
                // GETTING THE ID OF THE CLOTHING PRODUCT:
                System.out.println("Please give me the ID of the product!");
                String proID = input.next();

                // GETTING THE NAME OF THE CLOTHING PRODUCT:
                System.out.println("Please give me the name of the product!");
                String proName = input.next();

                // GETTING THE AMOUNT OF CLOTHING PRODUCT(S) IN STOCK:
                System.out.println("Please give me the amount of product in stock!");
                int proAvailability;
                
                // CHECKING IF THE ENTERED VALUE IS AN INTEGER:
                try {
                    proAvailability = input.nextInt();
                    
                    // GETTING THE PRICE OF THE CLOTHING PRODUCT:
                    System.out.println("Please give me the price of the product!");
                    int proPrice;
                    
                    // CHECKING IF THE ENTERED VALUE IS AN INTEGER:
                    try {
                        proPrice = input.nextInt();
                        
                        // GETTING THE SIZE OF THE CLOTHING PRODUCT:
                        System.out.println("Please give me the size of the product!");
                        String proSize = input.next();

                        // GETTING THE COLOUR OF THE CLOTHING PRODUCT:
                        System.out.println("Please give me the colour of the product!");
                        String proColour = input.next();

                        // CREATING THE CLOTHING OBJECT 
                        // AND ADDING THE OBJECT TO THE LIST (IN PRODUCT CLASS)
                        // AND WE PUT THE RETURNED LIST INTO A NEW LIST (IN THIS CLASS)
                        // THE LIST WE CREATED IN THIS CLASS WILL BE ADDED TO THE SHOPPING CART CLASSES LIST
                        Clothing cItem = new Clothing(proID, proName, proAvailability, proPrice, proSize, proColour);            
                        ArrayList listOfClothing = cItem.addToList();         
                        cart.addToList(listOfClothing);
                        System.out.println(cart);

                        // ADDING TO THE TOTAL PRODUCTS:
                        totalProducts++;
                     
                    // CATCHING THE EXEPTION (INPUTMISSMATCH), TYPES OUT ERROR AND CATCHES THE ENTERED STRING
                    // SO THAT THE ENTERED STRING WONT GET USED AT THE BEGINING OF THE LOOP
                    // THEN CONTINUES THE LOOP
                    } catch (Exception e) {
                        System.out.println("Something other then an Integer was entered! (Price)");
                        String catchWrongInput = input.next();
                        continue;
                    }
                    
                // CATCHING THE EXEPTION (INPUTMISSMATCH), TYPES OUT ERROR AND CATCHES THE ENTERED STRING
                // SO THAT THE ENTERED STRING WONT GET USED AT THE BEGINING OF THE LOOP
                // THEN CONTINUES THE LOOP
                } catch (Exception e) {
                    System.out.println("Something other then an Integer was entered! (Availability)");
                    String catchWrongInput = input.next();
                    continue;
                }
            }

            // CHECKING THE CHOSEN OPTION (NOT CORRECT OPTION IS ENTERED): 
            else {
                System.out.println("Not a valid option for product or you reached the product limit (50)!");
            }
            error = false;
        }
    }

//--(DELETING PRODUCTS:)--------------------------------------------------------
    @Override
    public void deleteProduct(){
        // IMPORTING THE LIST FROM THE "ShoppingCart.java":
        List<Object> listOfProducts = cart.returnList();
        
        // ASKING FOR THE ID SO TTHE PROGRAM KNOW WHAT PRODUCT TO DELETE:
        System.out.print("Please enter an ID of the product you want to delete: ");
        String userEnteredID = input.next();
        
        // VARIABLE TO CHECK IF ITEM IS REMOVED:
        boolean ItemRemoved = false;
        
        // GOING THROUGHT THE LIST AND PUTTING THE PRODUCTS INTO A DIFFERENT LIST:
        for (int i = 0; i < listOfProducts.size(); i++) {
            
            // CONVERTING THE SINGLE PRODUCTS INTO AN OBJECT LIST:
            List <Object> innerProduct = (List <Object>) listOfProducts.get(i);
            // CONVERTING THE ID'S TO STRING SO IT CAN BE WORKED WITH:
            String returnedProductID = (String) innerProduct.get(0);
            
            // CHECKING IF THE ENTERED ID IS THE SAME AS ANY ID'S IN THE LIST:
            if (userEnteredID.equals(returnedProductID)) {
                // THEN REMOVING IT:
                cart.removeFromList(i);
                totalProducts--;
                System.out.println("Item removed! The total number of products: " + totalProducts);
                ItemRemoved = true;
            }            
        }  
        if (ItemRemoved == false) {
            System.out.println("Didn't find the matching item. Total number of products: " + totalProducts);
        }
    }
    
//--(PRINTING THE LIST:)--------------------------------------------------------
    @Override
    public void printList(){
        List<Object> listOfProducts = cart.returnList();
        List<String> StringProducts = new ArrayList<>();
        for (int i = 0; i < listOfProducts.size(); i++) {       
            StringProducts.add(String.valueOf(listOfProducts.get(i)));
        }
        // USING "String.CASE_INSENSITIVE_ORDER" TO ORDER CAPITAL AND NON-CAPITAL FIRST LETTERS
        // E.G.: [B, c, b, A, C] --> [A, B, b, c, C]
        StringProducts.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(StringProducts);
    }
   
//--(SAVING IN FILE:)-----------------------------------------------------------
    @Override
    public void saveInFile(){
        // CREATING THE FILE:
        try {
            File myFile = new File("savedProducts.txt");
            if (myFile.createNewFile()) {
                System.out.println("File has been created!");
            }
            else {
                System.out.println("File already exists! File Updated!");
            }
        } catch (IOException e) {
            System.out.println("Error while creating file!");
        }
   
        // WRITING IN FILE:
        try {      
            // CREATING THE WRITER OBJECT:
            FileWriter myWriter = new FileWriter("savedProducts.txt");
            // GET THE PRODUTCTS FROM THE CART:
            List<Object> listOfProducts = cart.returnList(); 
           // GET EACH INDUVIDUAL PRODUCT:
            List <Object> innerList;
            
            // WE PRINT EACH PRODUCT INFO FOR EACH PRODUCT:
            for (int i = 0; i < listOfProducts.size(); i++) {
                innerList = (List <Object>) listOfProducts.get(i);
                myWriter.write((String) innerList.get(0) + "\n");                               
                myWriter.write((String) innerList.get(1) + "\n");
                myWriter.write((int) innerList.get(2) + "\n");
                myWriter.write((float) innerList.get(3) + "\n");
                myWriter.write((String) innerList.get(4) + "\n");
                myWriter.write((String) innerList.get(5) + "\n");
                myWriter.write((String) innerList.get(6) + "\n");
                myWriter.write("\n");
            }            
            
            // CLOSE THE WRITER:
            myWriter.close();
            
        } catch (IOException e) {
            System.out.println("Error occurred while writing!");
        }
    }

//--(LOADING FROM FILE:)--------------------------------------------------------
    public ArrayList<ArrayList<String>> loadFromFile() {
        // NESTED ARRAYLIST:
        ArrayList<ArrayList<String>> productList = new ArrayList<>();
        try {
            // CREATING SCANNER OBJECT:
            File myFile = new File("savedProducts.txt");
            Scanner myReader = new Scanner(myFile);
            ArrayList<String> singleProductInfo = new ArrayList<>();
            // WHILE THE FILE HAS NEW LINES, THE PROGRAM ADDS IT TO THE "singleProductInfo" ARRAY,
            // IF THE READ LINE ISNT EMPTY (""),
            // IF IT IS IT ADDS THE "singleProductInfo" TO "productList" AND CREATES A NEW ARRAYLIST FOR "productList",
            // THIS IS BEACUSE IF THE PROGRAM WOULD CLEAR THAT ARRAY INSTEAD IT WOULD CLEAR THE NESTED ARRAYLIST REFERENCE AS WELL.
            while (myReader.hasNextLine()) {               
                String data = myReader.nextLine();
                if (data != "") {
                    singleProductInfo.add(data);
                }
                else {
                    productList.add(singleProductInfo);
                    singleProductInfo = new ArrayList<String>();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading!");
        }
        return productList;
    }
}    

//--(END OF CLASS WESTMINSTERSHOPPINGMANAGER)-----------------------------------
//--(LAST EDITED: 27/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------