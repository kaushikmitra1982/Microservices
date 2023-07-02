package techworld.spring.boot.crud.springbootcrudapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techworld.spring.boot.crud.springbootcrudapp.entity.User;
import techworld.spring.boot.crud.springbootcrudapp.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {


    public UserService userService;


    // build create User Rest API
    // Endpoint## http://localhost:<Port>/api/v1/users/user
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(user==null)
            return new ResponseEntity<>("User object is mandatory", HttpStatus.BAD_REQUEST);
        User savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
    // build get all users REST API
    // Endpoint## http://localhost:<Port>/api/v1/users/all
    @GetMapping("/all")
    public  ResponseEntity<?>  getAllTheUsers(){
        List<User> users=userService.getAllUsers();
        if(users.isEmpty())
            return new ResponseEntity<>("No user available in database to display", HttpStatus.NO_CONTENT);
        return new ResponseEntity<> (users, HttpStatus.OK);

    }
    // Create get user by userid REST API
    // Endpoint## http://localhost:<Port>/api/v1/users/user/{id}
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("id")  Long userId)  {
        User user = userService.getUserById(userId).get();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
     //Create update user  REST API
    // Endpoint## http://localhost:<Port>/api/v1/users/user
     @PutMapping("/user")
     public ResponseEntity<User> updateUser(@RequestBody User user)
     {
         User updatedUser = userService.updateUser(user);
         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
     }
    // Create delete user  REST API
    // Endpoint## http://localhost:<Port>/api/v1/users/user/{id}
    // Build Delete User REST API
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }


}
