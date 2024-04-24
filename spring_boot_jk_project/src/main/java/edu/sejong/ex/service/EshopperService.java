package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.UserVO;

public interface EshopperService {
	void register(UserVO UserVO);

	List<String> login(String username, String password);
}