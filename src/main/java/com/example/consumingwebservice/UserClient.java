package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

//@RestController
//@RequestMapping("/user")

public class UserClient extends WebServiceGatewaySupport {
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(UserClient.class);

    // @GetMapping("/")
    public GetUserResponse getUser(BigInteger id) {

        GetUserRequest request = new GetUserRequest();
        request.setId(id);

        log.info("Requesting location for " + id);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }

    //  @GetMapping("/all")
    public GetAllUserResponse getAllUser() {

        GetAllUserRequest request = new GetAllUserRequest();


        GetAllUserResponse response = (GetAllUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }

    public AddUserResponse addUser(User u) {

        AddUserRequest request = new AddUserRequest();
        request.setUser(u);
        AddUserResponse response = (AddUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }

    public DeleteUserResponse deleteUser(BigInteger id) {

        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(id);
        DeleteUserResponse response = (DeleteUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }

    public UpdateUserResponse updateUser(BigInteger id, User u) {

        UpdateUserRequest request = new UpdateUserRequest();
        request.setId(id);
        request.setUser(u);
        UpdateUserResponse response = (UpdateUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }

}
