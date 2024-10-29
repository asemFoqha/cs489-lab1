package org.edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) {

        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24"), 124, 0.55f),
                new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09f),
                new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99f),
        };


        printProductsInJsonFormat(products);
        System.out.println("----------------");
        printProductsInXMLFormat(products);
        System.out.println("----------------");
        printProductsInCSVFormat(products);

    }

    public static void printProductsInJsonFormat(Product[] products) {
        System.out.println("Printed in JSON Format:");

        System.out.println("[");

        Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .map(product -> String.format(
                        "  {\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}",
                        product.getProductId(), product.getName(), product.getDateSupplied(),
                        product.getQuantityInStock(), product.getUnitPrice()))
                .forEach(jsonString -> System.out.println(jsonString + ","));

        System.out.println("]");

    }

    public static void printProductsInXMLFormat(Product[] products) {
        System.out.println("Printed in XML Format:");
        System.out.println("<products>");
        Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .forEach(product -> System.out.printf(
                        "    <product" +
                                " productId=%d" +
                                " name=%s" +
                                " dateSupplied=%s" +
                                " quantityInStock=%d" +
                                " unitPrice=%.2f" +
                                " />\n",
                        product.getProductId(), product.getName(), product.getDateSupplied(),
                        product.getQuantityInStock(), product.getUnitPrice()));
        System.out.println("</Products>");
    }

    public static void printProductsInCSVFormat(Product[] products) {

        System.out.println("Printed in CSV format");
        Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .forEach(product -> System.out.println(
                        product.getProductId() + "," +
                                product.getName() + "," +
                                product.getDateSupplied() + "," +
                                product.getQuantityInStock() + "," +
                                product.getUnitPrice()
                ));

    }

}
