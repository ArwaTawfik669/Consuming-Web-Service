//package com.example.consumingwebservice;
//
//import com.example.consumingwebservice.wsdl.*;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.math.BigInteger;
//
//@SpringBootApplication
//
//public class ConsumingWebServiceApplication {
//
//    public static void main(String[] args) {
//        //SpringApplication.run(RestServiceApplication.class, args);
//
//        SpringApplication.run(ConsumingWebServiceApplication.class, args);
//    }
//
//
//    @Bean
//    CommandLineRunner lookup(UserClient quoteClient) {
//        return args -> {
//            BigInteger id = BigInteger.valueOf(2);
//            BigInteger id2 = BigInteger.valueOf(6);
//            User leen = new User();
//            leen.setId(id);
//            leen.setAddress("Alexandriya");
//            leen.setName("Leen");
//
//            GetAllUserResponse response = quoteClient.getAllUser();
//            GetUserResponse response2 = quoteClient.getUser(id);
//            AddUserResponse response5 = quoteClient.addUser(leen);
//            UpdateUserResponse response3 = quoteClient.updateUser(id, leen);
//            DeleteUserResponse response4 = quoteClient.deleteUser(id2);
//            System.err.println(response.getUsers());
//            System.err.println(response2.getUser());
//            System.err.println(response3.getResult());
//            System.err.println(response4.getResult());
//        };
//    }
//
//    public ResponseEntity<String> getUserById(@RequestParam BigInteger id) throws JsonProcessingException {
//        UserClient s = new UserClient();
//        User result = s.getUser(id).getUser();
//        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
//    }
//
//}
