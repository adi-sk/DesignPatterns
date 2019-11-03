package com.infra.demo.OCP;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DemoOCPMain {
    public static void main(String args[]){
        List<Product> products = Arrays.asList( new Product("home",Color.RED,Size.SMALL),
                                                new Product("car",Color.GREEN,Size.LARGE),
                                                new Product("bike",Color.YELLOW,Size.SMALL));

        ProductFilter pf = new ProductFilter();
        pf.filter(products,new SizeSpecification(Size.SMALL))
                .forEach(product -> {
                    System.out.println("- " + product.getName() + " is " + Size.SMALL.name());
                });

    }
}

enum Color{
    RED,GREEN,YELLOW;
}

enum Size{
    SMALL,MEDIUM,LARGE;
}

class Product{
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

interface Specification<T>{
    boolean isSatisfied(T item);
}

interface AwesomeFilter<T>{
    Stream<T> filter(List<T> items,Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
    private Color color;

    ColorSpecification(Color color) {
        this.color = color;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return color == item.getColor();
    }
}

class SizeSpecification implements Specification<Product>{
    private Size size;

    SizeSpecification(Size size) {
        this.size = size;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return size == item.getSize();
    }
}

class ProductFilter implements AwesomeFilter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}
