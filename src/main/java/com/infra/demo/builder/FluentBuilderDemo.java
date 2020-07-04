package com.infra.demo.builder;

public class FluentBuilderDemo {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person aditya = personBuilder.withName("Aditya").withAge(23).build();
        System.out.println(aditya);

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Person aditya2 = employeeBuilder.withName("Aditya").withAge(23).withProfession("DEV").build();
        System.out.println(aditya2);
    }
}
class Person{
    protected String name;
    protected int age;
    private String profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
class PersonBuilder<T extends PersonBuilder<T>>{ //this is recursive generics
    protected Person person = new Person();

    public T withName(String name){
        this.person.setName(name);
        return returnSelf();
    }
    public T withAge(int age){
        this.person.setAge(age);
        return returnSelf();
    }
    public Person build(){
        return person;
    }

    protected T returnSelf(){
        return (T) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder withProfession(String profession){
        person.setProfession(profession);
        return returnSelf();
    }

    @Override
    protected EmployeeBuilder returnSelf() {
        return this;
    }
}



