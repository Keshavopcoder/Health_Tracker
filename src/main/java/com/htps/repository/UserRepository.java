//package com.htps.repository;
//
//import java.util.Optional;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//import com.htps.entities.User;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//	Optional<User>  findByEmail(String email);
//	//derived query method
//		boolean existsByEmail(String email);
//		
//		User findByUsername(String username);
//}


//

package com.htps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByTrainerTrainerId(Long trainerId);
}


