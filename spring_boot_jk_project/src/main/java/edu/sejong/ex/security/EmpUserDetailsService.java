package edu.sejong.ex.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.EmpMapper;
import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.EmpVO2;
import edu.sejong.ex.vo.UserAuthorityVO;
import edu.sejong.ex.vo.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EmpMapper empMapper;
	//@Autowired
	//private CartMapper cartMapper;
	
	//@Autowired
	//private EmpMapper empMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// log.warn("Load User By UserVO member: " + username);
		log.warn("Load User By UserAuthorityVO member: " + username);
		// UserVO user = userMapper.getUser(username);
		// UserAuthorityVO user = userMapper.getUser(username);
		List<UserAuthorityVO> users = userMapper.getUser(username);

		// List<EmpVO2> emp = empMapper.getEmp(ename);
		EmpVO2 empVO = empMapper.getEmp("KING");
		// return null;
		// return user == null ? null : new UserDetailsVO(user);
		// return users == null ? null : new UserDetailsVO(user);
		//return users == null ? null : new UserDetailsVO(users.get(0));
		return users == null ? null : new UserDetailsVO(users.get(0), empVO);
	}
}