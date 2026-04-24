package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineShopApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //User shopingcart hashmap
        HashMap<Integer, Product> userCart = new HashMap<>();
        String userInput = "";
        ArrayList<Product> products = Product.getProductList();
        ArrayList<Product> search = Product.searchProducts(products, userInput);


        boolean userInApp = true;
        boolean userInProduct = true;
        boolean userInCheckout = true;

        while (userInApp) {

            userInProduct = true;
            userInCheckout = true;
            System.out.println("Welcome to the Online.complex!");
            System.out.println("(P) Displays our products!");
            System.out.println("(D) Displays whats in your cart!");
            System.out.println("(X) Leave the complex :(");
            userInput = sc.nextLine().replaceAll("\\s+","").trim().toUpperCase();
            switch (userInput) {
                case ("P") -> {
                    for (Product c : products) {
                        System.out.printf("%s|%s|$%.2f|%s\n", c.getSKU(), c.getProductName(), c.getPrice(), c.getDepartment());
                    }
                    while (userInProduct) {
                        //This will be adding to your cart
                        System.out.println("(S) Search and filter out items you want to buy!");
                        System.out.println("(A) Add a product into your cart!");
                        System.out.println("(X) Exit out into the homepage!");
                        userInput = sc.nextLine().replaceAll("\\s+","").trim().toUpperCase();
                        switch (userInput) {
                            case ("S") -> {
                                System.out.println("Search by Product Name, Price, or Department!");
                                userInput = sc.nextLine().replaceAll("\\s+","").trim().toLowerCase();
                                search = Product.searchProducts(products, userInput);
                                Product.searhResults(products, search);

                            }
                            case ("A") -> {
                                System.out.println("Type in a name product you want to add!");
                                userInput = sc.nextLine().replaceAll("\\s+","").trim().toLowerCase();
                                search = Product.searchProducts(products, userInput);

                            }
                            case ("X") -> {userInProduct = false;}
                            default -> {System.out.println("Incorrect userInput!");}
                        }

                    }

                }

                case ("D") -> {
                    while (userInCheckout) {
                        //This will be the Checkout!
                        System.out.println("(C) Checkout all your products!");
                        System.out.println("(R) Removes products from your cart!");
                        System.out.println("(X) Exit out into the homepage!");
                        userInput = sc.nextLine().replaceAll("\\s+","").trim().toUpperCase();
                        switch (userInput) {
                            case ("C") -> {
                                System.out.println("Hey this works!!");
                            }
                            case ("R") -> {
                                System.out.println("Hey this works!");
                            }
                            case ("X") -> {userInCheckout = false;}
                            default -> {System.out.println("Incorrect userInput!");}
                        }

                    }
                }

                case ("X") -> {userInApp = false;}

                default -> {System.out.println("Incorrect userInput!");}


            }

        }

    }

}
