package com.infra.demo.singleton;

public class LazySingletonDemo {

    private static LazySingletonDemo lazySingletonDemo;

    private LazySingletonDemo() {
        System.out.println("LazySingleton initialized!");
    }

    /*// issue is the race condition.
    public static LazySingletonDemo getInstance(){
        if(lazySingletonDemo == null){
            lazySingletonDemo = new LazySingletonDemo();
        }
        return lazySingletonDemo;
    }*/

    /*//one option to synchronized method
    public static synchronized LazySingletonDemo getInstance(){
        if(lazySingletonDemo == null){
            lazySingletonDemo = new LazySingletonDemo();
        }
        return lazySingletonDemo;
    }*/

    //double check locking-- better option
    public static synchronized LazySingletonDemo getInstance() {
        if (lazySingletonDemo == null) {
            synchronized (LazySingletonDemo.class) {
                if (lazySingletonDemo == null) {
                    lazySingletonDemo = new LazySingletonDemo();
                }
            }
        }
        return lazySingletonDemo;
    }
}
