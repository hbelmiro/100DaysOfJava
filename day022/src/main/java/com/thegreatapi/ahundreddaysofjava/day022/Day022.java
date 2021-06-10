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
        Customer gilmour = new Customer("David Gilmour", "Pink Floyd");
        Customer iommi = new Customer("Toni Iommi", "Black Sabbath");
        Customer rhoads = new Customer("Randy Rhoads", "Ozzy Osbourne");

        Product strato = new Product("Fender", "Stratocaster");
        Product sg = new Product("Gibson", "SG");
        Product lesPaul = new Product("Gibson", "Les Paul");
        Product rr = new Product("Jackson", "RR");

        return List.of(
                new Order(gilmour, List.of(strato)),
                new Order(iommi, List.of(sg)),
                new Order(rhoads, List.of(lesPaul, rr))
        );
    }

    record Customer(String name, String band) {
    }

    record Product(String brand, String modelName) {
    }

    record Order(Customer customer, List<Product> products) {
    }
}
