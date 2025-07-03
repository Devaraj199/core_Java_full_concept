package org.coreconcepts.general.codings;

import java.util.*;
import java.util.stream.Collectors;

public class Practice3 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.8, Arrays.asList("Chess Club", "Debate Team")),
                new Student("Bob", 3.2, Arrays.asList("Football", "Chess Club")),
                new Student("Charlie", 3.9, Arrays.asList("Drama Club", "Math Olympiad")),
                new Student("Diana", 3.5, Arrays.asList("Debate Team", "Student Council")),
                new Student("Eve", 3.0, Arrays.asList("Football", "Drama Club"))
        );
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200, 4),
                new Product("Smartphone", "Electronics", 800, 5),
                new Product("Headphones", "Electronics", 200, 5),
                new Product("Chair", "Furniture", 150, 3),
                new Product("Desk", "Furniture", 300, 4)
        );

        // Best practice: Find best value product (highest rating, then lowest price)
        Optional<Product> max = products.stream()
                .max(Comparator.comparingInt(Product::getRating).thenComparing(Product::getPrice,Comparator.reverseOrder()));
        System.out.println(max.get());

        // Find best product in each category
        Map<String, Optional<Product>> collect = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getRating)
                                .thenComparing(Product::getPrice, Comparator.reverseOrder()))));
//        collect.forEach((k,v)-> System.out.println(k+v));


    }
}

class Product {
    private String name;
    private String category;
    private double price;
    private int rating;

    // Constructor, getters, setters...
    public Product(String name, String category, double price, int rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return String.format("Product{name='%s', category='%s', price=%.2f, rating=%d}",
                name, category, price, rating);
    }
}

class Student {
    private String name;
    private double gpa;
    private List<String> activities;

    // Constructor, getters, setters...
    public Student(String name, double gpa, List<String> activities) {
        this.name = name;
        this.gpa = gpa;
        this.activities = activities;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public List<String> getActivities() { return activities; }

    @Override
    public String toString() {
        return String.format("Student{name='%s', gpa=%.2f, activities=%s}",
                name, gpa, activities);
    }
}

