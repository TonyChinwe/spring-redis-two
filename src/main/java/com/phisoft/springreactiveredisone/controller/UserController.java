package com.phisoft.springreactiveredisone.controller;

import com.phisoft.springreactiveredisone.models.User;
import com.phisoft.springreactiveredisone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

   @PostMapping("/user")
   public ResponseEntity<String> saveUser(@RequestBody User user){
   boolean result=userService.saveUser(user);
   if(result){
       return ResponseEntity.ok("User created successfully");
   }else{
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
   }
   }

   @GetMapping("/users")
  public ResponseEntity<List<User>> fetchAllUser(){
   List<User> users;
   users=userService.fetchAllUsers();
   return ResponseEntity.ok(users);

  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id){
       User user=userService.fetchUserById(id);
       return ResponseEntity.ok(user);
  }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        boolean result=userService.deleteUserById(id);
        if(result) {
            return ResponseEntity.ok("Deleted");
        }else {
            return ResponseEntity.ok("User not found");

        }
    }
    @PutMapping("user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id){

        boolean result=userService.updateUserById(id);
        if(result) {
            return ResponseEntity.ok("Updated");
        }else {
            return ResponseEntity.ok("User not found");

        }
    }


}
