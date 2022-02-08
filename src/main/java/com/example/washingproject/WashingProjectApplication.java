package com.example.washingproject;


import com.example.washingproject.user.User;
import com.example.washingproject.user.UserRepository;
import com.example.washingproject.washer.Washer;
import com.example.washingproject.washer.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WashingProjectApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WasherRepository washerRepository;


    public static void main(String[] args) {
        SpringApplication.run(WashingProjectApplication.class, args);
        System.out.println("************* Application Started *************");
    }

    @PostConstruct
    public void init() {
        // Setting all the basics data for the first time
        User user = new User();
        user.setUserLogin();
        if (user.getUserName() != null) {
            User temp = userRepository.findUserByUserName(user.getUserName());
            if (temp == null) {
                userRepository.save(user);
            }
        }

        // Washing Machine Data
        Washer washer=new Washer();
        Washer temp=null;
        washer.setBooked(false);
        washer.setName("Machine 1");
        washer.setWeight("100 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 2");
        washer.setWeight("110 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 3");
        washer.setWeight("120 KG");
        washer.setAutoPower(false);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 4");
        washer.setWeight("200 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 5");
        washer.setWeight("300 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 6");
        washer.setWeight("290 KG");
        washer.setAutoPower(false);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 7");
        washer.setWeight("70 KG");
        washer.setAutoPower(false);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 8");
        washer.setWeight("240 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 9");
        washer.setWeight("500 KG");
        washer.setAutoPower(false);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }

        washer=new Washer();
        washer.setBooked(false);
        washer.setName("Machine 10");
        washer.setWeight("600 KG");
        washer.setAutoPower(true);
        temp=washerRepository.findWasherByName(washer.getName());
        if(temp == null){
            washerRepository.save(washer);
        }
    }
}
