//package com.htps.controller;
//import com.htps.dto.UserDTO;
//import com.htps.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/username/{username}")
//    public UserDTO getUserByUsername(@PathVariable String username) {
//        return userService.getUserByUsername(username);
//    }
//}



///
package com.htps.controller;

import com.htps.dto.UserDTO;
import com.htps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/email/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
