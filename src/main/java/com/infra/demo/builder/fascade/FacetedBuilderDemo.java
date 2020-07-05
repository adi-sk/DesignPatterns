package com.infra.demo.builder.fascade;

public class FacetedBuilderDemo {

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                            .lives()
                                .city("Mumbai")
                                .street("12345")
                            .works()
                                .at("ZSE")
                                .as("SE")
                                .income(12312)
                        .build();
        System.out.println(person);
    }
}

class Person {
    //address
    public String streetAddress, city;

    //employment
    public String companyName, position;
    public int annulaIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annulaIncome=" + annulaIncome +
                '}';
    }
}

class PersonBuilder {
    protected Person person = new Person();

    public AddressBuilder lives() {
        return new AddressBuilder(person);
    }

    public JobBuilder works() {
        return new JobBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class AddressBuilder extends PersonBuilder { // why Base builder extended, to switch from one sub builder to other
    public AddressBuilder(Person person) {
        this.person = person;
    }

    public AddressBuilder street(String street) {
        this.person.streetAddress = street;
        return this;
    }

    public AddressBuilder city(String city) {
        this.person.city = city;
        return this;
    }

}

class JobBuilder extends PersonBuilder {

    public JobBuilder(Person person) {
        this.person = person;
    }

    public JobBuilder at(String company) {
        this.person.companyName = company;
        return this;
    }

    public JobBuilder as(String position) {
        this.person.position = position;
        return this;
    }

    public JobBuilder income(int income) {
        this.person.annulaIncome = income;
        return this;
    }
}




