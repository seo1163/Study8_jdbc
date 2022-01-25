package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.utill.DBConnector;

public class EmployeeDAO {
private DBConnector dbCo;
	
	public EmployeeDAO() {
		dbCo = new DBConnector();
		
	}
	
	public EmployeeDTO getOne(EmployeeDTO emp) throws Exception{
		EmployeeDTO employeeDTO = null;
		//1.DB에 로그인
		
		Connection conn = dbCo.getConnect();
		//2.Query문 작성
		String sql = "SELECT*FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		//3.Querry문 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		//4. ? 값을 세팅
				//st.set 데이터타입(int index, 값);
				// index 는 ?의 순서번호
				//그러나 oracle은 1번 부터 시작
		st.setInt(1, emp.getEmployee_id());
		//5. 최종 전송 후 결과 처리
		ResultSet rs =st.executeQuery();
		//1 row가 있거나 없거나
		if(rs.next()) {
			//데이터가 있을 때
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
			
		}
		//6. 자원 해제
		rs.close();
		st.close();
		conn.close();
		return employeeDTO;
		
		
		
	}
	
	// 전체조회
	
	public List<EmployeeDTO>getList() throws Exception{
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		Connection conn =dbCo.getConnect();
		
		String sql = "SELECT*FROM EMPLOYEES";
		
		PreparedStatement st= conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
			
			ar.add(employeeDTO);
			
		}
		
		rs.close();
		st.close();
		conn.close();
		
		return ar;
		
	}
	
	
}
