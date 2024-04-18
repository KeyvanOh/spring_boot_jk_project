package edu.sejong.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	void test() {
		// fail("Not yet implemented");

		// System.out.println(userMapper.getUser("admin"));

		for (UserVO vo : userMapper.getUser("admin")) {
			// log.info(vo);
			System.out.println(vo);
		}

	}

}
