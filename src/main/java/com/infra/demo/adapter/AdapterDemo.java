package com.infra.demo.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        Pen pen = new PenAdapter();
        Assignment assignment = new Assignment();
        assignment.setPen(pen);
        assignment.writeAssignment("DONE!");

    }

}

class Assignment{
    private Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String str){
        pen.write(str);
    }
}

interface Pen{
    public void write(String str);
}

//we will use PenAdapter to create an interface which will connect Pen to BallPen

class PenAdapter implements Pen{
    BallPen pen = new BallPen();
    @Override
    public void write(String str) {
        pen.writeWithBallPen(str);
    }
}


//consider you do not have access to following class's source code, you just have this class as dependecy in your code.

class BallPen{
    public void writeWithBallPen(String str){
        System.out.println(str);
    }
}
