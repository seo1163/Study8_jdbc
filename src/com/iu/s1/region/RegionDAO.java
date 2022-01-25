package com.iu.s1.region;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.s1.utill.DBConnector;

public class RegionDAO {

	private DBConnector dbConnector;

	public RegionDAO() {
		dbConnector = new DBConnector();

	}
	//대륙정보 수정 setUpdate, name 수정
	
	public int setUpdate(RegionDTO regionDTO) throws Exception{
		int result=0;
		Connection con = dbConnector.getConnect();
		
		String sql = "UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id());
		
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	//대륙정보 삭제 setDelete
	public int setDelete(RegionDTO regionDTO) throws Exception{
		int result = 0;
		
		Connection con = dbConnector.getConnect();
		
		
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, regionDTO.getRegion_id());
		
		
		 result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	

	// 대륙정보 추가
	public int setInsert(RegionDTO regionDTO) throws Exception {
		
		//java는 기본적으로 auto commit 임
		//auto commit 해제
		
		
		// 1. DB 연결
		Connection con = dbConnector.getConnect();
		
		con.setAutoCommit(false);
		// 2. SQL Query문 생성
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES(?,?)";
		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		//auto commit으로 재설정
		con.setAutoCommit(true);
		
		// 6. 자원해제
		st.close();
		con.close();
		
		return result;
		
	}
	
	//전체조회
	
}