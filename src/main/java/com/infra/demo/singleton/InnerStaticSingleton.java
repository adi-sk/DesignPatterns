package com.infra.demo.singleton;

//Lazily Initialized Inner Class Singleton (Bill Pugh singleton) --- highly optimized.
public class InnerStaticSingleton {
    private InnerStaticSingleton() {
        System.out.println("Initializing inner static !");
    }

    public static class Helper {
        private static final InnerStaticSingleton INNER = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance(){
        return Helper.INNER;
    }
}
