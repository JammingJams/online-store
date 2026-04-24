package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Product {
    private String SKU;
    private String productName;
    private double price;
    private String department;

    public Product() {
        this.SKU = SKU;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    //Getters are here!
    public String getSKU() {return SKU;}
    public String getProductName() {return productName;}
    public double getPrice() {return price;}
    public String getDepartment() {return department;}

    //Setters are here!
    public void setSKU(String SKU) {this.SKU = SKU;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setPrice(double price) {this.price = price;}
    public void setDepartment(String department) {this.department = department;}

    //This reads the products file and organizes it
    public static ArrayList<Product> getProductList() {
        ArrayList<Product> listProducts = new ArrayList<>();
    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));

        String text;
        bufferedReader.readLine();

        while ((text = bufferedReader.readLine()) != null) {

            String[] tempArray = text.split("\\|");

            Product items = new Product();

            try {
                items.setSKU(tempArray[0]);
                items.setProductName(tempArray[1]);
                items.setPrice(Double.parseDouble(tempArray[2]));
                items.setDepartment(tempArray[3]);
            }
            catch (NumberFormatException e) {e.printStackTrace();}

            listProducts.add(items);
        }
        bufferedReader.close();

    }
    catch (IOException e) {e.printStackTrace();}
    return listProducts;
    }

    //This method helps with searching for an item
    public static ArrayList<Product> searchProducts(ArrayList<Product> products, String userInput) {
        ArrayList<Product> results = new ArrayList<>();
        for (Product p : products) {
            if
                (p.getProductName().toLowerCase().contains(userInput)
                || p.getDepartment().toLowerCase().contains(userInput)
                || p.getSKU().toLowerCase().contains(userInput)) {
                results.add(p);
            }
        }    return results;
    }

}

