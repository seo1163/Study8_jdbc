package com.iu.s1.start;

import java.util.List;

import com.iu.s1.location.LocationDAO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.location.LocationView;
import com.iu.s1.utill.DBConnector;
import com.iu.s1department.DepartmentController;
import com.iu.s1department.DepartmentDAO;
import com.iu.s1department.DepartmentDTO;
import com.iu.s1department.DepartmentView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView();
	
		try {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(20);
			departmentDTO = departmentDAO.getOne(departmentDTO);
			//DepartmentDTO departmentDTO = departmentDAO.getOne(20);
			System.out.println(departmentDTO.getDepartment_name());
			DepartmentController dc =new DepartmentController();
			dc.start();
//			List<DepartmentDTO> ar= departmentDAO.getList();
//			departmentView.view(ar);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		System.out.println("DB 연동 테스트 끝");

		
	}

}
