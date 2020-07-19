package com.infra.demo.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        BasicSingleton basicObj = BasicSingleton.getBasicObj();
        basicObj.setVar1("demo");
        basicObj.setVar2("demo2");

        System.out.println(basicObj);

        BasicSingleton basicObj2 = BasicSingleton.getBasicObj();

        System.out.println(basicObj2);

    }

}

class BasicSingleton{
    private String var1,var2;

    private static final BasicSingleton basicObj = new BasicSingleton();

    private BasicSingleton(){

    }
    private BasicSingleton(String var1, String var2) {
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

    public static BasicSingleton getBasicObj() {
        return basicObj;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                '}';
    }
}
