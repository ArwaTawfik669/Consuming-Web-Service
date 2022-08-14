package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

@RestController
@RequestMapping("/user")
public class UserController extends WebServiceGatewaySupport {
    public UserController() {
    }
//
//    @GetMapping("/all")
//    public ResponseEntity<String> getAllUsers() {
//
//        String s = "";
//        if (repository != null)
//            for (User a : repository.findAll()) {
//                s += a + "\n";
//            }
//        return ResponseEntity.status(HttpStatus.OK).body(s);
//    }


    @GetMapping("/")
    public ResponseEntity<String> getUserById(@RequestParam BigInteger id) throws JsonProcessingException {
        UserClient s = userClient(marshaller());
        System.out.println(id);
        User result = s.getUser(id).getUser();
        return ResponseEntity.status(HttpStatus.OK).body(result.getName() + " , " + result.getAddress());
    }


    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }


    public UserClient userClient(Jaxb2Marshaller marshaller) {
        UserClient client = new UserClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}


//
//    @GetMapping("/gender/{gender}")
//
//
//    public ResponseEntity<String> getAllUsersWithASpecificGender(@PathVariable Gender gender) throws JsonProcessingException {
//
//        String s = "";
//        for (User u : repository.findAll()) {
//            if (u.getGender().equals(gender))
//                s += u + "\n";
//
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(s);
//    }
//
//    @PostMapping("/")
//
//    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
////        if (users == null) users = new HashMap<Integer, User>();
////        users.put(count, user);
//        try {
//            repository.save(user);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());//return only new user
//
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());//return only new user
//    }
//
//    @PutMapping("/")
//    public ResponseEntity<String> UpdateUser(@RequestParam String id, User user) {
//        Optional<User> userInfo = repository.findById(id);
//        if (userInfo.isPresent()) {
//            User realUser = userInfo.get();
//            realUser.setName(user.getName());
//            realUser.setAddress(user.getAddress());
//            realUser.setGender(user.getGender());
//            realUser.setDateOfBirth((user.getDateOfBirth()));
//            realUser.setMobileList(user.getMobileList());
//        }
//        try {
//            repository.save(user);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());//return only new user
//
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());//return only new user
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<String> DeleteUser(@RequestBody String id) {
//        Optional<User> u = repository.findById(id);
//        repository.deleteById(id);
//
////        users.remove(id);
//        return ResponseEntity.status(HttpStatus.OK).body(u.toString());
//
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity handle(ConstraintViolationException constraintViolationException) {
//        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
//        String errorMessage = "";
//        if (!violations.isEmpty()) {
//            StringBuilder builder = new StringBuilder();
//            violations.forEach(violation -> builder.append(" " + violation.getMessage()));
//            errorMessage = builder.toString();
//        } else {
//            errorMessage = "ConstraintViolationException occured.";
//        }
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
//}