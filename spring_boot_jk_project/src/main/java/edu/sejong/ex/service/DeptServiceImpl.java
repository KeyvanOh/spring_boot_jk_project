package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.DeptMapper;
import edu.sejong.ex.repository.DeptRepository;
import edu.sejong.ex.vo.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptRepository deptRepository;

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<DeptVO> getList() {
		System.out.println("getList()..");

		// return null;
		return deptRepository.selectList();
	}

	@Override
	public void register(DeptVO deptVO) {
		System.out.println("register()..");

		deptMapper.insert(deptVO);
	}
	@Override
	public void remove(DeptVO deptVO) {
		System.out.println("remove()..");
		deptMapper.delete(deptVO);
	}
	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectList();
	};
}