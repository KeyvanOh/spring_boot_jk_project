package edu.sejong.ex.repository;
import org.springframework.stereotype.Repository;
import consts.Const;
import edu.sejong.ex.vo.RPSVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class RPSRepositoryImpl implements RPSRepository {
	@Override
	public String[] getRPSList() {
		log.info("getRPSList()..");
		return Const.rpsList;
	}
	@Override
	public RPSVO getRPSVO(String rps1) {
		log.info("getRPSVO()..");
		return new RPSVO(rps1);
	}
}