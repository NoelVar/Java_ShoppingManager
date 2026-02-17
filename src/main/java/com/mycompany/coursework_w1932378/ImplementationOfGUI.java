
package com.mycompany.coursework_w1932378;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class ImplementationOfGUI extends JFrame{

    int rowIndex;
    String dropDownState;
    WestminsterShoppingManager mg = new WestminsterShoppingManager();
    ArrayList <ArrayList <String>> cartData = new ArrayList<>();
    ArrayList <ArrayList <String>> productsForTable = new ArrayList<>();
    ArrayList <String> productData = new ArrayList<>();
    
    public ImplementationOfGUI() {
        // CREATING THE FRAME:
        JFrame frame = new JFrame(); 

        // CREATING THE TOP PANEL (THIS IS WHERE THE TABLE IS):
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        
        // CREATIN INNER TOP AND BOTTOM PANEL IN THE TOP PANEL:
        JPanel innerTopPanel = new JPanel(new FlowLayout());
        JPanel innerBottomPanel = new JPanel(new BorderLayout());
        
        // CREATING THE BOTTOM PANEL (THIS IS WHERE THE DETAILS ARE):
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(7, 1));
        
        // PADDING BETWEEN THE TOP AND BOTTOM PANELS:
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        
        // CREATING THE OUTER PANEL WHICH WILL BE ON THE FRAME (CONTAINS TOP AND BOTTOM):
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new GridLayout(2, 1));
        
        // CREATING BUTTONS:
        JButton openShoppingCart = new JButton("Shopping Cart");
        JButton addButton = new JButton("Add to Shopping Cart");
        
        // CREATING THE PANEL FOR THE BUTTONS (AND PADDING FOR THE openShoppingCart):
        JPanel openButtonPanel = new JPanel(new BorderLayout());
        openButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        JPanel addButtonPanel = new JPanel();
        
        // CREATING DROPDOWN MENU WITH THE SELECTABLE OPTIONS AS A LIST:
        JLabel categorySelector = new JLabel("Select Product Category");
        String typeList[] = {"All", "Electronic", "Clothing"};
        
        JComboBox dropDownMenu = new JComboBox(typeList);
        JPanel dropDownPanel = new JPanel();
        
        // STYLING COMPONENTS:
        Font boldFont = new Font("Arial", Font.BOLD, 12);
        Font notBoldFont = new Font("Arial", ~Font.BOLD, 12);
        Color noStock = new Color(255, 0, 0);
        Color lowStock = new Color(248, 143, 61);
        
        // CREATING A NESTED ARRAYLIST: 
        ArrayList <ArrayList <String>> productInfo = new ArrayList<>();
        
        // HEADER NAMES:
        String column[]={"Product ID", "Name", "Category", "Price(£)", "Info"}; 
        
        // CREATING THE TABLE AND SETTING THE ROW HEIGHT:
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tableModel);
        
        // USING THE RETURNED ARRAYLIST TO GET ALL THE PRODUCT INFORMATION,
        // THEN WE ADD IT TO AN OBJECT LIST WHICH WILL BE ADDED AS A ROW TO THE TABLE:
        productsForTable = mg.loadFromFile();
        for (int i = 0; i < productsForTable.size(); i++) {
                String id = productsForTable.get(i).get(0);
                String name = productsForTable.get(i).get(1);
                String amount = productsForTable.get(i).get(2);
                String price = productsForTable.get(i).get(3);
                String type = productsForTable.get(i).get(4);
                String brandSize = productsForTable.get(i).get(5);
                String warrantyColour = productsForTable.get(i).get(6);
                
                Object[] productInfoForTable = {id, name, type, price, brandSize + ", " + warrantyColour};
                // ADDING THE LISTS TO THE "productForTable" NESTED LIST:
                productInfo.add(productsForTable.get(i));
                
                tableModel.addRow(productInfoForTable);
            
        }      
        table.setRowHeight(40);
        
        // CREATING A DROP DOWN LISTENER:  
        dropDownMenu.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                // THE PROGRAM CHECKS WHICH OPTION IS SELECTED ("currentState"),
                // STORES THE ITEM NAME IN "dropDownState":
                int currentState = e.getStateChange();
                dropDownState = e.getItem().toString();
                
                // CLEARING THE TABLE FROM THE ITEMS (TO BE ABLE TO ONLY SHOW THE SELECTED TYPES):
                try {
                    for (int i = 1; i < productsForTable.size()-1; i++) {
                        tableModel.removeRow(0);
                    }
                    productInfo.clear();
                } catch (Exception exc) {}
                // ONLY RUNS IF ITS THE SELECTED OPTION (IF ITS SELECTED IT EQUALS TO 1 IF NOT ITS 2):
                if (currentState == 1){
                    // CHECKS THE TYPE OF CHOOSEN OPTION AND PUTS THE CORRECT ROWS BACK:
                    if ("Electronic".equals(dropDownState)){
                        for (int i = 0; i < productsForTable.size(); i++) {
                            String id = productsForTable.get(i).get(0);
                            String name = productsForTable.get(i).get(1);
                            String amount = productsForTable.get(i).get(2);
                            String price = productsForTable.get(i).get(3);
                            String type = productsForTable.get(i).get(4);
                            String brandSize = productsForTable.get(i).get(5);
                            String warrantyColour = productsForTable.get(i).get(6);
                            if ("Electronics".equals(type)){
                                Object[] productInfoForTable = {id, name, type, price, brandSize + ", " + warrantyColour};                            
                                productInfo.add(productsForTable.get(i));
                                tableModel.addRow(productInfoForTable);
                            }                        
                        }
                    }
                    // CHECKS THE TYPE OF CHOOSEN OPTION AND PUTS THE CORRECT ROWS BACK:
                    else if ("Clothing".equals(dropDownState)){
                        for (int i = 0; i < productsForTable.size(); i++) {
                            String id = productsForTable.get(i).get(0);
                            String name = productsForTable.get(i).get(1);
                            String amount = productsForTable.get(i).get(2);
                            String price = productsForTable.get(i).get(3);
                            String type = productsForTable.get(i).get(4);
                            String brandSize = productsForTable.get(i).get(5);
                            String warrantyColour = productsForTable.get(i).get(6);
                            if ("Clothing".equals(type)){
                                Object[] productInfoForTable = {id, name, type, price, brandSize + ", " + warrantyColour};                            
                                productInfo.add(productsForTable.get(i));
                                tableModel.addRow(productInfoForTable);
                            }  
                        }
                    }
                    // ALL THE ROWS GET PUT BACK:
                    else {
                        for (int i = 0; i < productsForTable.size(); i++) {
                            String id = productsForTable.get(i).get(0);
                            String name = productsForTable.get(i).get(1);
                            String amount = productsForTable.get(i).get(2);
                            String price = productsForTable.get(i).get(3);
                            String type = productsForTable.get(i).get(4);
                            String brandSize = productsForTable.get(i).get(5);
                            String warrantyColour = productsForTable.get(i).get(6);

                            Object[] productInfoForTable = {id, name, type, price, brandSize + ", " + warrantyColour};
                            productInfo.add(productsForTable.get(i));
                            tableModel.addRow(productInfoForTable);
                        }
                    }
                }
            }
        });
        
        // IMPORTING TABLE CELL RENDERING TO ALIGN EVERY CELL TO MIDDLE:
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
       
        
        // ALIGNING EACH COLUMN TO MIDDLE USING A FOR LOOP:
        for (int i = 0; i < 5; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
                        
        // CREATING THE SCROLL PANE SO WE CAN SCROLL IN THE TABLE:
        JScrollPane scrollPane = new JScrollPane(table);       
        innerBottomPanel.add(scrollPane, BorderLayout.CENTER); 
        
        // STYLING TABLE HEADER (MAKING IT BOLD):
        table.getTableHeader().setFont(boldFont);
        
        // CREATING THE DETAILS & ADDING THEM TO THE BOTTOM PANEL:
        JLabel detail = new JLabel("Selected Product - Details");
        JLabel text1 = new JLabel("Product Id: ");
        JLabel text2 = new JLabel("Category: ");
        JLabel text3 = new JLabel("Name: ");
        JLabel text4 = new JLabel("Size/Brand: ");
        JLabel text5 = new JLabel("Color/Warranty: ");
        JLabel text6 = new JLabel("Items Available: ");
        bottomPanel.add(detail);
        bottomPanel.add(text1);
        bottomPanel.add(text2);
        bottomPanel.add(text3);
        bottomPanel.add(text4);
        bottomPanel.add(text5);
        bottomPanel.add(text6);
               
        // LISTENING FOR THE EVENTS THAT OCCOUR ON THE TABLE:
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                // GETTING THE CLICKED ROW INDEX:
                rowIndex = table.getSelectedRow();
                // UPDATING THE TEXT IN THE DETAIL LABLES, DEPENDING ON THE TYPE OF PRODUCT:
                if ("Electronics".equals(productInfo.get(rowIndex).get(4))) {
                    text1.setText("Product Id: " + productInfo.get(rowIndex).get(0));
                    text2.setText("Category:  " + productInfo.get(rowIndex).get(4));
                    text3.setText("Name: " + productInfo.get(rowIndex).get(1));
                    text4.setText("Brand: " + productInfo.get(rowIndex).get(5));
                    text5.setText("Warranty: " + productInfo.get(rowIndex).get(6));
                    text6.setText("Items Available: " + productInfo.get(rowIndex).get(2));
                    
                    int amount = Integer.valueOf(productInfo.get(rowIndex).get(2));
                    if (amount == 0){
                        text6.setForeground(noStock);
                    }
                    else if (amount < 5) {
                        text6.setForeground(lowStock);
                    }
                    else {
                        text6.setForeground(Color.BLACK);
                    }   
                }
                else {
                    text1.setText("Product Id: " + productInfo.get(rowIndex).get(0));
                    text2.setText("Category:  " + productInfo.get(rowIndex).get(4));
                    text3.setText("Name: " + productInfo.get(rowIndex).get(1));
                    text4.setText("Size: " + productInfo.get(rowIndex).get(5));
                    text5.setText("Colour: " + productInfo.get(rowIndex).get(6));
                    text6.setText("Items Available: " + productInfo.get(rowIndex).get(2));
                    
                    int amount = Integer.valueOf(productInfo.get(rowIndex).get(2));
                    if (amount == 0){
                        text6.setForeground(noStock);
                    }
                    else if (amount < 5) {
                        text6.setForeground(lowStock);
                    }
                    else {
                        text6.setForeground(Color.BLACK);
                    } 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });
        
        // FONT CHANGES (BOLD/NOT BOLD):
        detail.setFont(boldFont);
        text1.setFont(notBoldFont);
        text2.setFont(notBoldFont);
        text3.setFont(notBoldFont);
        text4.setFont(notBoldFont);
        text5.setFont(notBoldFont);
        text6.setFont(notBoldFont);
        
        // SETTING A BORDER & ADDING THE TOP AND BOTTOM TO THE PANEL, WHICH IS ADDED TO THE FRAME:
        openButtonPanel.add(openShoppingCart, BorderLayout.EAST);
        addButtonPanel.add(addButton);
        dropDownPanel.add(dropDownMenu);
        innerTopPanel.add(categorySelector);
        innerTopPanel.add(dropDownMenu);
        topPanel.add(innerTopPanel);
        topPanel.add(innerBottomPanel);
        outerPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        outerPanel.add(topPanel);        
        outerPanel.add(bottomPanel);
        frame.add(outerPanel);
        frame.add(openButtonPanel, BorderLayout.NORTH);
        frame.add(addButtonPanel, BorderLayout.SOUTH);
        
        // SHOPPING CART IMPLEMENTATION:
        openShoppingCart.addActionListener(new ActionListener() {            
            float totalCost = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                // CREATING NEW FRAME:
                JFrame shoppingCartFrame = new JFrame();
                
                // CREATING PANEL TO DEVIDE THE BOTTOM AND TOP PART:
                JPanel panelOnFrame = new JPanel(new GridLayout(2, 1));
                panelOnFrame.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
                
                // TOP AND BOTTOM PANEL CREATION:
                JPanel topPanel = new JPanel(new BorderLayout());                
                JPanel bottomPanel = new JPanel(new GridLayout(2, 2));
                
                // LISTS FOR DATA AND COLUMN NAMES:
                try {  
                    String columnNames [] = {"Product", "Quantity", "Price"};   
                    DefaultTableModel tableModelForCart = new DefaultTableModel(columnNames, 0);
                    JTable itemsInCartTable = new JTable(tableModelForCart);
                    JButton removeButton = new JButton("Remove from Cart!");
                    JPanel buttonPanel = new JPanel();
                    
                    // GETTING THE ADDED PRODUCTS AND PUTING THEM IN THE TABLE:
                    for (int i = 0; i < cartData.size(); i++) {
                        String productInfo = cartData.get(i).get(0);
                        int productCount = 0;
                        productCount++;
                        String productPrice = cartData.get(i).get(2);
                        float price = 0;
                        // CONVERTING STRING TO FLOAT:
                        try {
                            price = Float.valueOf(productPrice);
                            totalCost += price;
                            
                        } catch (Exception ex) {
                            System.out.println("ERROR! Invalid price!" + price);
                        }
                        
                        Object[] individualData = {productInfo, productCount, price};
                        tableModelForCart.addRow(individualData);
                    }        
                                                        
                    // CREATING LABELS FOR THE TOTAL COST:
                    JLabel totalText = new JLabel("Total:");
                    String costTotal = String.valueOf(totalCost);
                    JLabel total = new JLabel("£"+costTotal);
                    
                    // SETTING FONT:
                    totalText.setFont(notBoldFont);
                    total.setFont(notBoldFont);
                    
                    // TOTAL COST:
                    JLabel finalText = new JLabel("Final Total");
                    JLabel finalPrice = new JLabel("£"+costTotal);

                    // USING A FOR LOOP TO ADJUST THE ITEMS TO THE MIDDLE:
                    for (int i = 0; i < 3; i++) {
                        itemsInCartTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    }
                    // MAKING THE HEADERS BOLD AND ADJUSTING THE HEIGHTS, PADDING:
                    itemsInCartTable.getTableHeader().setFont(boldFont);
                    itemsInCartTable.getTableHeader().setPreferredSize(new Dimension(70,70));
                    itemsInCartTable.setRowHeight(70);
                    bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 250, 0, 0)); 

                    // CREATING A SCROLLPANE AND ADDING THE LIST TO IT:
                    JScrollPane scrollPane2 = new JScrollPane(itemsInCartTable);
                    topPanel.add(scrollPane2, BorderLayout.CENTER);   

                    // REMOVE ITEM FROM CART AND REMOVE COST OF ITEM:
                    removeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // INITIALIZING VARIABLES:
                            boolean finnished = false;
                            int selectedRow = -1;
                            // THIS RUNS TO SLOW THE REMOVING PROCESS DOWN (TO REMOVE PRICE):
                            // ONLY REMOVES ITEMS IF THERE ARE ITEMS IN THE CART:
                            if (!cartData.isEmpty()) {
                                while (finnished != true){
                                    selectedRow = itemsInCartTable.getSelectedRow();
                                    // IF THERES NO SELECTED ROW IT WILL REMOVE THE FIRST:
                                    if (selectedRow == -1) {
                                        selectedRow = 0;
                                    }
                                    Object amount = tableModelForCart.getValueAt(selectedRow, 2);
                                    String amountInString = String.valueOf(amount);
                                    totalCost = totalCost - Float.valueOf(amountInString);
                                    finnished = true;
                                }
                            }
                            // THIS ONLY RUNS IF THERE IS A SELECTED ITEM:
                            // REMOVING FROM TABLE AND DATA LIST, UPDATING THE LABLES:
                            if (selectedRow >= 0) {
                                // REMOVING FROM CART:
                                tableModelForCart.removeRow(selectedRow);
                                cartData.remove(selectedRow);
                                
                                // ADDING THE REMOVED PRODUCT BACK TO THE LIST OF PRODUCTS:
                                int amount = Integer.valueOf(productInfo.get(rowIndex).get(2));
                                amount += 1;                
                                String amountInString = String.valueOf(amount);
                                productInfo.get(rowIndex).set(2, amountInString);
                                
                                // UPDATING COST:
                                String totalCostString = String.valueOf(totalCost);
                                total.setText("£" + totalCostString);
                                finalPrice.setText("£" + totalCostString);
                            }
                        }
                    });
                    
                    // ADDING COMPONENTS TO PANELS, AND FRAME:
                    buttonPanel.add(removeButton);
                    bottomPanel.add(totalText);
                    bottomPanel.add(total);
                    bottomPanel.add(finalText);
                    bottomPanel.add(finalPrice);
                    panelOnFrame.add(topPanel);
                    panelOnFrame.add(bottomPanel);
                    shoppingCartFrame.add(panelOnFrame);
                    shoppingCartFrame.add(buttonPanel, BorderLayout.SOUTH);   
                    
                    // SETTING FRAME ATTRIBUTES:
                    shoppingCartFrame.setSize(600, 600);    
                    shoppingCartFrame.setVisible(true);
                    shoppingCartFrame.setTitle("Shopping Cart");
                    
                    // IF THE CART IS CLOSED THE TOTAL BECOMES 0,
                    // THIS IS BEACUSE IF THE PROGRAM WOULDNT DO THAT,
                    // THE PRICE WOULD INCREASE EVERYTIME THE CART IS REOPENED WITH SOMETHING IN IT:
                    shoppingCartFrame.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e){ 
                             totalCost = 0;
                        }
                    });
                        
                    // COMMENTED OUT BECAUSE IT WOULD CLOSE THE WHOLE GUI INSTED OF JUST THE CART:
                    //shoppingCartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (Exception ex) {
                    JFrame emptyCart = new JFrame();
                    
                    JLabel emptyText = new JLabel("ERROR! Can't open cart!");
                    
                    emptyCart.add(emptyText, BorderLayout.CENTER);
                    
                    emptyCart.setSize(100, 100);    
                    emptyCart.setVisible(true);
                    emptyCart.setTitle("Shopping Cart");
                    // COMMENTED OUT BECAUSE IT WOULD CLOSE THE WHOLE GUI INSTED OF JUST THE CART:
                    //emptyCart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        
        // ADD TO SHOPPING CART IMPLEMENTATION:
        addButton.addActionListener(new ActionListener() {
            int amount;
            @Override
            public void actionPerformed(ActionEvent e) {
                amount = Integer.valueOf(productInfo.get(rowIndex).get(2));
                if (amount > 0) {         
                    // GETTING DATA INTO THE CART:
                    productData.add(productInfo.get(rowIndex).get(0) + " " + productInfo.get(rowIndex).get(1) + " " + productInfo.get(rowIndex).get(4) + " " + productInfo.get(rowIndex).get(5));
                    productData.add(productInfo.get(rowIndex).get(2));
                    productData.add(productInfo.get(rowIndex).get(3));

                    // REMOVING THE AMOUNT OF PRODUCTS THAT GET INTO THE CART:
                    amount -= 1;                
                    String amountInString = String.valueOf(amount);
                    productInfo.get(rowIndex).set(2, amountInString);
                    text6.setText("Items Available: " + amountInString);

                    cartData.add(productData);   
                    // NEW INSTANCE OF ARRAYLIST SO THE REFRENCE IS NOT CLEARED:
                    productData = new ArrayList<String>();
                    
                    JFrame itemAdded = new JFrame();
                    
                    JLabel emptyText = new JLabel(productInfo.get(rowIndex).get(1) + " has been added to the cart!");
                    
                    itemAdded.add(emptyText, BorderLayout.CENTER);
                    
                    itemAdded.setSize(250, 200);    
                    itemAdded.setVisible(true);
                    itemAdded.setTitle("Manager!");
                    
                }
                else {
                    JFrame cantAdd = new JFrame();
                    
                    JLabel emptyText = new JLabel("ERROR! Item cant be added to the Cart!");
                    
                    cantAdd.add(emptyText, BorderLayout.CENTER);
                    
                    cantAdd.setSize(250, 200);    
                    cantAdd.setVisible(true);
                    cantAdd.setTitle("Manager!");
                }
            }
        });
        
        // SETTING BASIC ATTRIBUTES OF THE FRAME:
        frame.setSize(850, 600);    
        frame.setVisible(true);
        frame.setTitle("Westminster Shopping Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}

//--(END OF CLASS IMPLEMENTATIONOFGUI)------------------------------------------
//--(LAST EDITED: 30/12/2023)---------------------------------------------------
//--(DOCUMENT BY: Noel Varga [w1932378])----------------------------------------
