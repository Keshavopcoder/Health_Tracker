package com.htps.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserDaoTest {
	@Autowired
	private UserRepository userEntityRepository;
	@Autowired
	private PasswordEncoder encoder;

//	@Test
//	void testAddCustomer() {
//		UserEntity newUser=new UserEntity("a4", "b4", "a4@gmail.com", 
//				encoder.encode("5567"), UserRole.ROLE_CUSTOMER);
//		userEntityRepository.save(newUser);
//	}

}
