package com.infra.demo;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class PrototypeDemo {  // protytpe design pattern Deep Copy

    public static void main(String[] args) {
        Foo foo = new Foo("demo", "demo1");
        Foo foo2 = SerializationUtils.roundtrip(foo);
        foo2.var2 = "demo3";
        System.out.println(foo);
        System.out.println(foo2);
    }
}

class Foo implements Serializable {

    public String var1,var2;

    public Foo(String var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                '}';
    }
}
