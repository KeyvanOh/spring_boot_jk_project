package edu.sejong.ex.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sejong.ex.vo.DeptVO;

@Repository // DAO
public class DeptRepositoryImpl implements DeptRepository {
	@Autowired
	private DataSource dataSource;
	
	@Override
	// public List<DeptVO> selectList() {
	public List<DeptVO> selectList() {
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from dept";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptVO dept = new DeptVO(deptno, dname, loc);
				deptList.add(dept);
			};

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		//return null;
		return deptList;
	}
	
	/*
	@Override
	public void insert(DeptVO deptVO) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			String query = "insert into dept values (?, ?, ?)";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//rs = preparedStatement.executeQuery();
			
			
			preparedStatement.setInt(1, deptVO.getDeptno());
			preparedStatement.setString(2, deptVO.getDname());
			preparedStatement.setString(3, deptVO.getLoc());
			
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
		
	}

	@Override
	public void delete(DeptVO deptVO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			//String query = "insert into dept values (?, ?, ?)";
			String query = "delete from dept where deptno = ?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//rs = preparedStatement.executeQuery();
			
			
			preparedStatement.setInt(1, deptVO.getDeptno());
			
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}				
	};
	*/
	
	
	
}