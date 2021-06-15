package espminvest.poo.user.common.controller;

import espminvest.poo.user.common.datatype.UserBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("service.user")
public interface UserController {

    public static final String BASE_URL = "/api/v1/users";

    // Accepting xxx-form-urlencoded
    @PostMapping(path = BASE_URL, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserBean saveUser(@RequestBody @ModelAttribute UserBean user);

    @GetMapping(path = BASE_URL + "/{id}")
    public UserBean getUserById(@PathVariable String id);

    @GetMapping(path = BASE_URL)
    public List<UserBean> getUsers();

    @DeleteMapping(path = BASE_URL + "/{id}")
    public void deleteUser(@PathVariable String id);

}
