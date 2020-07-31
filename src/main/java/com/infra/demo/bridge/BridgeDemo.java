package com.infra.demo.bridge;
//shape --> Circle,Square.
//Renderer --> Vector,Raster.
//we do not want to end up making 2 x 2  classes to achieve this instead we will use bridge design pattern


public class BridgeDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(new VectorRenderer(),2);
        circle.draw();
        circle.resize(2);
        circle.draw();

        Square square = new Square(new RasterRenderer(),2);
        square.draw();
        square.resize(3);
        square.draw();
    }
}

interface Renderer{
    public void renderCircle(float radius);

    public void renderSquare(float side);
}

class VectorRenderer implements Renderer{

    @Override
    public void renderCircle(float radius) {
        System.out.println("Circle Vector renderer with radius : " + radius);
    }

    @Override
    public void renderSquare(float side) {
        System.out.println("square Vector renderer with side : " + side);
    }
}

class RasterRenderer implements Renderer{

    @Override
    public void renderCircle(float radius) {
        System.out.println("Circle Raster renderer with radius : " + radius);
    }

    @Override
    public void renderSquare(float side) {
        System.out.println("square Raster renderer with side : " + side);
    }
}

// this abstract works as a bridge between shapes and renderers.
abstract class Shape{
    Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);

}

class Circle extends Shape{

    private float radius;
    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer,float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius = radius*factor;
    }
}

class Square extends Shape{

    private float side;
    public Square(Renderer renderer) {
        super(renderer);
    }

    public Square(Renderer renderer,float radius) {
        super(renderer);
        this.side = radius;
    }

    @Override
    public void draw() {
        renderer.renderSquare(side);
    }

    @Override
    public void resize(float factor) {
        side = side *factor;
    }
}


