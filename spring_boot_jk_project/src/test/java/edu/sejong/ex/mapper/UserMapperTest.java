package edu.sejong.ex.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Disabled
	@Test
	void getUserTest() {
		// fail("Not yet implemented");

		// System.out.println(userMapper.getUser("admin"));

		/*
		 * for (UserAuthorityVO vo : userMapper.getUser("admin")) { // log.info(vo);
		 * System.out.println(vo); }
		 */
	}

	@Test
	void insertUserTest() {

		// public int insertUser(UserVO userVO);
		// public void insertAuthorities(UserVO UserVO);

		// UserVO userVO = new UserVO("u3", "1234", 1);

		// userMapper.insertUser(userVO);
		// userMapper.insertAuthorities(userVO);

	}

	@Test
	void testInsertUser() {
		UserVO user = new UserVO();
		user.setUsername("member2");
		user.setPassword(new BCryptPasswordEncoder().encode("member2"));
		user.setEnabled(1);

		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		//userMapper.insertAuthoritiesAdmin(user);

	}

}
