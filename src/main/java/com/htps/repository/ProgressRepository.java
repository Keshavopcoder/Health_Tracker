//package com.htps.repository;
//
//import com.htps.entities.Progress;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProgressRepository extends JpaRepository<Progress, Long> {
//    Progress findByUserId(Long userId);
//}

package com.htps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htps.entities.Progress;
import com.htps.entities.User;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUser(User user);
}
