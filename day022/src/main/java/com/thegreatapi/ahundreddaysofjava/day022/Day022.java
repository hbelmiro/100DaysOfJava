package com.thegreatapi.ahundreddaysofjava.day022;

import java.util.List;

public class Day022 {

    public static void main(String[] args) {
        List<Order> orders = readOrders();

        String bands = orders.stream()
                             .map(Order::customer)
                             .map(Customer::band)
                             .reduce((band1, band2) -> String.join(";", band1, band2))
                             .orElse("None");

        System.out.println(bands);
        /* Prints:
        Pink Floyd;Black Sabbath;Ozzy Osbourne
         */
    }

    private static List<Order> readOrders() {
        var gilmour = new Customer("David Gilmour", "Pink Floyd");
        var iommi = new Customer("Toni Iommi", "Black Sabbath");
        var rhoads = new Customer("Randy Rhoads", "Ozzy Osbourne");

        var strato = new Product("Fender", "Stratocaster");
        var sg = new Product("Gibson", "SG");
        var lesPaul = new Product("Gibson", "Les Paul");
        var rr = new Product("Jackson", "RR");

        return List.of(
                new Order(gilmour, List.of(strato)),
                new Order(iommi, List.of(sg)),
                new Order(rhoads, List.of(lesPaul, rr))
        );
    }

    static record Customer(String name, String band) {
    }

    static record Product(String brand, String modelName) {
    }

    static record Order(Customer customer, List<Product> products) {
    }
}
