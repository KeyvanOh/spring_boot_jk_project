package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.UserVO;

@Mapper
public interface UserMapper {

	List<UserVO> getUser(String username);

	// UserVO getUser(String username);

}