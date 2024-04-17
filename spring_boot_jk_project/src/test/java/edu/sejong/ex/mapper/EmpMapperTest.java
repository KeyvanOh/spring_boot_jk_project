package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpMapperTest {

	@Autowired
	private EmpMapper empMapper;

	@Test
	void selectEmpSalgradeListtest() {
		// fail("Not yet implemented");
		assertNotNull(empMapper.selectEmpSalgradeList());

	}

}
