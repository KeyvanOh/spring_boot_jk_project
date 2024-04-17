package edu.sejong.ex.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sejong.ex.repository.RPSRepository;
import edu.sejong.ex.vo.RPSVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class RPSServiceImpl implements RPSService {
	@Autowired
	private RPSRepository rpsRepository;
	@Override
	public String[] getRPSList() {
		log.info("getRPSList()..");
		return rpsRepository.getRPSList();
	}
	@Override
	public RPSVO getJson(String rps1) {
		log.info("getJson()..");
		return rpsRepository.getRPSVO(rps1);
	}
}