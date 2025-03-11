//package com.htps.service;
//
//import org.modelmapper.ModelMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.htps.custom_exceptions.ApiException;
//import com.htps.dto.Signup;
//import com.htps.entities.User;
//
//import com.htps.repository.UserRepository;
//
//import com.htps.dto.UserDTO;
//import com.htps.entities.User;
//import com.htps.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//	//dep : dao layer i/f
//		@Autowired
//		private UserRepository userDao;
//		//dep
//		@Autowired
//		private ModelMapper mapper;
//		//dep 
//		@Autowired
//		private PasswordEncoder encoder;
//	@Override
//	public Signup userRegistration(Signup reqDTO) {
//		//dto --> entity
//		User user=mapper.map(reqDTO, User.class);
//		if(userDao.existsByEmail(reqDTO.getEmail()))
//			throw new ApiException("Email already exists !!!");
//		
//		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
//		return mapper.map(userDao.save(user), Signup.class);
//	}
//	  @Override
//	    public UserDTO getUserByUsername(String username) {
//	        User user = userDao.findByUsername(username);
//	        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
//	    }
//
//}




////////
package com.htps.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htps.custom_exceptions.ApiException;
import com.htps.dto.Signup;
import com.htps.dto.UserDTO;
import com.htps.entities.User;
import com.htps.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Signup userRegistration(Signup reqDTO) {
        User user = mapper.map(reqDTO, User.class);
        if (userDao.existsByEmail(reqDTO.getEmail()))
            throw new ApiException("Email already exists !!!");

        user.setPassword(encoder.encode(user.getPassword())); 
        return mapper.map(userDao.save(user), Signup.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        Optional<User> optionalUser = userDao.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new ApiException("User not found with email: " + email);
        }
        User user = optionalUser.get();
        return new UserDTO(user.getUserId(), user.getFirstName() + " " + user.getLastName(), user.getEmail(), user.getRole().toString());
    }
}

