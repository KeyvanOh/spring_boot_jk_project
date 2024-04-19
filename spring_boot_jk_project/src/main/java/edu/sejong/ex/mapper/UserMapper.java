package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.UserAuthorityVO;
//import edu.sejong.ex.vo.UserVO;
import edu.sejong.ex.vo.UserVO;

@Mapper
public interface UserMapper {

	// List<UserVO> getUser(String username);
	List<UserAuthorityVO> getUser(String username);

	// UserVO getUser(String username);

	// public int insertUser(UserVO userVO);
	public void insertUser(UserVO userVO);

	public void insertAuthorities(UserVO UserVO);
}