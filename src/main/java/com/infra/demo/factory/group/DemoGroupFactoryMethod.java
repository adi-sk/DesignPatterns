package com.infra.demo.factory.group;

//here we will have factory methods in the different class but at the same time access to the constructors
public class DemoGroupFactoryMethod {
    public static void main(String[] args) {
        Point.PointFactory.newCartesianPoint(2,3);
        Point.PointFactory.newPolarPoint(3,230);
    }
}

class Point {
    private double x, y;
    private Point(double x, double y) { // made constructor private
        this.x = x;
        this.y = y;
    }

   public static class PointFactory{ // we can use this nested factory method as well s normal class to achieve the same but then we need to make construcor public
       public static Point newCartesianPoint(double x, double y) {
           return new Point(x, y);
       }

       public static Point newPolarPoint(double rho, double theta){
           return new Point(rho*Math.cos(theta),rho*Math.sin(theta));
       }
   }
}