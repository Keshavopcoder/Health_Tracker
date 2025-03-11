//package com.htps.service;
//
//import com.htps.dto.Signup;
//import com.htps.dto.*;
//
//
//public interface UserService {
//	
//	Signup userRegistration(Signup reqDTO);
//	UserDTO getUserByUsername(String username);
//}


/////

package com.htps.service;

import com.htps.dto.Signup;
import com.htps.dto.UserDTO;

public interface UserService {
    Signup userRegistration(Signup reqDTO);
    UserDTO getUserByEmail(String email);
}
