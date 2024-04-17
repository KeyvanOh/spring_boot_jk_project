package edu.sejong.ex.service;
import edu.sejong.ex.vo.RPSVO;
public interface RPSService {
	String[] getRPSList();
	RPSVO getJson(String rps1);
}