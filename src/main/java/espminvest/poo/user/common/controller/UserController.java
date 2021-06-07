package espminvest.poo.user.common.controller;

import espminvest.poo.user.common.datatype.UserBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service.user")
public interface UserController {

    @PostMapping(path = "/users")
    public ResponseEntity<Object> saveUser(@RequestBody UserBean user);



}
