package com.infra.demo.singleton;

import java.io.*;

public class SerializationProblem {
    static void saveToFile(BasicSingletonProb obj, String filename) throws Exception {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

            objectOutputStream.writeObject(obj);

        }
    }

    static BasicSingletonProb readFormFile(String filename) throws Exception{
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            return (BasicSingletonProb) objectInputStream.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingletonProb instance = BasicSingletonProb.getInstance();
        instance.setVar1("demo1");
        instance.setVar2("demo2");

        saveToFile(instance,"demo2.bin");

        instance.setVar1("changed");

        BasicSingletonProb instance2 = readFormFile("demo2.bin");

        System.out.println(instance == instance2);

        System.out.println(instance);
        System.out.println(instance2);

    }

}

class BasicSingletonProb implements Serializable {
    private String var1,var2;
    private static final BasicSingletonProb INSTANCE = new BasicSingletonProb();

    private BasicSingletonProb(){

    }
    private BasicSingletonProb(String var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public static BasicSingletonProb getInstance() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                '}';
    }

    /* here, if we do not add this method then the jvm deserialization will create new object of this instance
        so we have to tell resolver to always return static obect INSTANCE to maintain singleton nature.
    * */
    protected Object readResolve(){
        return INSTANCE;
    }

}
