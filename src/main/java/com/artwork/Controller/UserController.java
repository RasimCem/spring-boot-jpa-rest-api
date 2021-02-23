package com.artwork.Controller;

import com.artwork.Model.UserDO;
import com.artwork.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/",consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDO> createUser(@RequestBody UserDO userDO){
        UserDO createdUser = userService.createUser(userDO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value="/{user_id}")
    public ResponseEntity<UserDO> getUser(@PathVariable(value="user_id") Long user_id){
        UserDO user = userService.getUser(user_id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
