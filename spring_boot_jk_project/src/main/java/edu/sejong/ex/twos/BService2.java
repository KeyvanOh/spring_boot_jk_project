package edu.sejong.ex.twos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.vo.BoardVO;

@Service
public class BService2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public List<BoardVO> selectBoardList() throws Exception {
		
		//IBDAO dao = sqlSession.getMapper(IBDAO.class);
		
		//return dao.listDAO();
		return sqlSession.selectList("board.selectBoardList");
		
	};
	
	
	public List<BoardVO> selectBoardPagingList(int page) throws Exception {
		return sqlSession.selectList(
			"board.selectBoardPagingList", page
		);
	};
	
	
	

}
