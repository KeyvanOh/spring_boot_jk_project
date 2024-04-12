package edu.sejong.ex.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.MgrVO;

@Repository // DAO
public class EmpRepositoryImpl implements EmpRepository {
	@Autowired
	private DataSource dataSource;
	
	@Override
	// public List<DeptVO> selectList() {
	public List<EmpVO> selectList() {
		List<EmpVO> empList = new ArrayList<EmpVO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			String query = "select * from emp";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			/*
			EMPNO    NOT NULL NUMBER(4)    
			ENAME             VARCHAR2(10) 
			JOB               VARCHAR2(9)  
			MGR               NUMBER(4)    
			HIREDATE          DATE         
			SAL               NUMBER(7,2)  
			COMM              NUMBER(7,2)  
			DEPTNO            NUMBER(2)    
			Name     Null?    Type  			
			*/
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				//DeptVO dept = new DeptVO(deptno, dname, loc);
				EmpVO emp = new EmpVO(
					empno,
					ename,
					job,
					mgr,
					hiredate,
					sal,
					comm,
					deptno
				);
				empList.add(emp);
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
		return empList;
	}

	@Override
	public void insert(EmpVO empVO) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			String query = "insert into emp values (?, ?, ?, ?, ?, ?, ?, ?)";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//rs = preparedStatement.executeQuery();
			
			
			
			/*
			EMPNO    NOT NULL NUMBER(4)    
			ENAME             VARCHAR2(10) 
			JOB               VARCHAR2(9)  
			MGR               NUMBER(4)    
			HIREDATE          DATE         
			SAL               NUMBER(7,2)  
			COMM              NUMBER(7,2)  
			DEPTNO            NUMBER(2)    
			Name     Null?    Type  			
			*/	
			
			
			preparedStatement.setInt(1, empVO.getEmpno());
			
			preparedStatement.setString(2, empVO.getEname());
			preparedStatement.setString(3, empVO.getJob());
			preparedStatement.setInt(4, empVO.getMgr());
			preparedStatement.setDate(5, empVO.getHiredate());
			preparedStatement.setInt(6, empVO.getSal());
			preparedStatement.setInt(7, empVO.getComm());
			preparedStatement.setInt(8, empVO.getDeptno());
			
			preparedStatement.executeUpdate();
			/*
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptVO dept = new DeptVO(deptno, dname, loc);
				//deptList.add(dept);
			};
			*/

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
	public void delete(EmpVO empVO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			//String query = "insert into dept values (?, ?, ?)";
			//String query = "delete from dept where deptno = ?";
			String query = "delete from emp where empno = ?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//rs = preparedStatement.executeQuery();
			
			
			//preparedStatement.setInt(1, empVO.getDeptno());
			preparedStatement.setInt(1, empVO.getEmpno());
			
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
	public List<String> selectJobList() {
		//List<EmpVO> empList = new ArrayList<EmpVO>();
		List<String> jobList = new ArrayList<String>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			//String query = "select * from emp";
			String query = "select job from emp group by job";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			/*
			EMPNO    NOT NULL NUMBER(4)    
			ENAME             VARCHAR2(10) 
			JOB               VARCHAR2(9)  
			MGR               NUMBER(4)    
			HIREDATE          DATE         
			SAL               NUMBER(7,2)  
			COMM              NUMBER(7,2)  
			DEPTNO            NUMBER(2)    
			Name     Null?    Type  			
			*/
			
			while(rs.next()) {
				String job = rs.getString("job");
				
				jobList.add(job);
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
		return jobList;		
		
		
	}

	@Override
	public List<MgrVO> selectMgrList() {
		
		
		//List<EmpVO> empList = new ArrayList<EmpVO>();
		List<MgrVO> mgrList = new ArrayList<MgrVO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			//String query = "select * from emp";
			//String query = "select job from emp group by job";
			//String query = "select mgr from emp where mgr is not null group by mgr";
			String query = "select distinct e2.ename, e1.mgr from emp e1, emp e2 where e1.mgr = e2.empno";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			/*
			EMPNO    NOT NULL NUMBER(4)    
			ENAME             VARCHAR2(10) 
			JOB               VARCHAR2(9)  
			MGR               NUMBER(4)    
			HIREDATE          DATE         
			SAL               NUMBER(7,2)  
			COMM              NUMBER(7,2)  
			DEPTNO            NUMBER(2)    
			Name     Null?    Type  			
			*/
			
			while(rs.next()) {
				//String job = rs.getString("job");
				
				String ename = rs.getString("ename");
				int mgr = rs.getInt("mgr");
				
				MgrVO mgrVO = new MgrVO(ename, mgr);
				
				mgrList.add(mgrVO);
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
		return mgrList;		
		
		
		
	}

	@Override
	public List<Integer> selectDeptnosList() {
		
		List<Integer> deptnoList = new ArrayList<Integer>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			//String query = "select * from dept";
			//String query = "select * from emp";
			//String query = "select job from emp group by job";
			String query = "select deptno from emp where deptno is not null group by deptno";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			

			while(rs.next()) {
				//String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				
				deptnoList.add(deptno);
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
		return deptnoList;
		
		
		
		
	}

	
	
	
	
}