package edu.sejong.ex.security;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.UserAuthorityVO;
import edu.sejong.ex.vo.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// log.warn("Load User By UserVO member: " + username);
		log.warn("Load User By UserAuthorityVO member: " + username);
		// UserVO user = userMapper.getUser(username);
		// UserAuthorityVO user = userMapper.getUser(username);
		List<UserAuthorityVO> users = userMapper.getUser(username);
		// return null;
		// return user == null ? null : new UserDetailsVO(user);
		// return users == null ? null : new UserDetailsVO(user);
		return users == null ? null : new UserDetailsVO(users.get(0));
	}
}