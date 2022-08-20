package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day04_JavaFaker {
/*
TEST DATA : credentials, url, test environment,..
* Where do you get your test data?
* - Test Lead can provide
* - Business Analyst - BA (who wrote the AC-acceptance criteria)
* - Manual Testers - knows the functionality well.
* - Team Lead / Tech Lead
* - If you need a changing mock data then we can use faker
* - for api , i use swagger
* */
    @Test
    public void test1(){
//        1. create Faker object
        Faker faker = new Faker();
//        2. use faker object to generate mock
        String firstName = faker.name().firstName();
        System.out.println(firstName);

//        last name
        String lastName = faker.name().lastName();
        System.out.println(lastName);

//        username
        String username=faker.name().username();
        System.out.println(username);

//        title
        String title = faker.name().title();
        System.out.println(title);

//        city
        String city = faker.address().city();
        System.out.println(city);

//        state
        String state =faker.address().state();
        System.out.println(state);

//        full address
        String fullAddress = faker.address().fullAddress();
        System.out.println(fullAddress);

//        cell phone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

//        email
        String email = faker.internet().emailAddress();
        System.out.println(email);

//        zip
        String zip = faker.number().digits(5);//random 5 digit num
        System.out.println(zip);

//        zip
        String zipCode = faker.address().zipCode();
        System.out.println(zipCode);
    }
}
