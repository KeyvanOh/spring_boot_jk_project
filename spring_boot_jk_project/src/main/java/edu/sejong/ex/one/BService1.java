package edu.sejong.ex.one;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;

@Service
public class BService1 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public List<BoardVO> selectBoardList() throws Exception {
		
		IBDAO dao = sqlSession.getMapper(IBDAO.class);
		
		return dao.listDAO();
		
	};
	
	
	

}
