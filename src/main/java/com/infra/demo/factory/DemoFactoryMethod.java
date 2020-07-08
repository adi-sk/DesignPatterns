package com.infra.demo.factory;

// creating object of cartesian co-ordinate and polar co-ordinate according to user's requirements
// but here we will use factory methods to achieve this, we will not use constructor of the Point object
// as maintainig different constructor and pushing this logic to constructor leads to override hell
public class DemoFactoryMethod {
    public static void main(String[] args) {
        Point.newPolarPoint(3,230);
        Point.newCartesianPoint(3,2);
    }
}

class Point{
    private double x,y;

    private Point(double x, double y) { // made constructor private
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y){
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho,double theta){
        return new Point(rho*Math.cos(theta),rho*Math.sin(theta));
    }

}

