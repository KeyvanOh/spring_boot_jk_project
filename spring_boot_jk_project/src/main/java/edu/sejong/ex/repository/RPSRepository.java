package edu.sejong.ex.repository;
import edu.sejong.ex.vo.RPSVO;
public interface RPSRepository {
	String[] getRPSList();
	RPSVO getRPSVO(String rps1);
}