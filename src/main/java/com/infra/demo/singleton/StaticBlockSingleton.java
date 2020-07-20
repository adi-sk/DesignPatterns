package com.infra.demo.singleton;

public class StaticBlockSingleton {

    // if your constructor throws error always use static block singleton
    public static StaticBlockSingleton instance;

    private StaticBlockSingleton() throws Exception{
        int i = 1/0;
    }
    static {
        try {
            instance = new StaticBlockSingleton();
        }
        catch (Exception e){
            System.err.println("something went wrong while creating singleton object !"+e);
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

}


