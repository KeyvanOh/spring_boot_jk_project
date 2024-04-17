package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptVO2;
import edu.sejong.ex.vo.EmpVO2;

@SpringBootTest
class EmpDept2MapperTest {

	@Autowired
	private EmpDept2Mapper empDept2Mapper;

	@Test
	void test() {
		// fail("Not yet implemented");
		// assertNotNull(empDept2Mapper.selectList());

		// System.out.println(empDept2Mapper.selectList());

		/*
		 * List<EmpDept2VO> list = empDept2Mapper.selectList(); assertNotNull(list);
		 * System.out.println(list);
		 * 
		 * for (EmpDept2VO e : list) { System.out.println(e); };
		 */

		List<EmpVO2> listEmp = empDept2Mapper.selectListEmp();
		List<DeptVO2> listDept = empDept2Mapper.selectListDept();

		assertNotNull(listEmp);
		assertNotNull(listDept);

		for (int i = 0; i < listEmp.size(); i++) {
			//System.out.println(listEmp.get(i));
			//System.out.println(listDept.get(i));

			// let

			// emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname

			int empno = listEmp.get(i).getEmpno();
			String ename = listEmp.get(i).getEname();
			int sal = listEmp.get(i).getSal();
			int deptno = listEmp.get(i).getDeptno();
			String dname = listDept.get(i).getDname();
			
			String str = "";
			
			str += "empno: ";
			str += empno;
			str += ", ename: ";
			str += ename;
			str += ", sal: ";
			str += sal;
			str += ", deptno: ";
			str += deptno;
			str += ", dname: ";
			str += dname;
			//str += "\n";
			
			System.out.println(str);
			
			
			

		}
		;

	}
}
