package com.iu.s1.start;

import java.util.Scanner;

import com.iu.s1.employee.EmployeeController;
import com.iu.s1.location.LocationController;
import com.iu.s1.region.RegionController;
import com.iu.s1department.DepartmentController;

public class FrontController {
	
	private Scanner sc;
	private DepartmentController departmentController;
	private EmployeeController employeeController;
	private LocationController locationController;
	private RegionController regionController;
	
	public FrontController() {
		sc = new Scanner(System.in);
		departmentController = new DepartmentController();
		//LocationController
		locationController = new LocationController();
		employeeController = new EmployeeController();
		regionController = new RegionController();
		
	}
	
	public void mainStart() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 지역 관리");
			System.out.println("4. 대륙 관리");
			System.out.println("5. 프로그램 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				employeeController.start();
				//employeeController의 start 메서드 호출
				break;
				
			case 2:
				departmentController.start();
				break;
				
			case 3:
				//locationController start 메서드 호출
				locationController.start();
				
				break;
			case 4:
				regionController.start();
			default :
				flag = false;
			}
			
		}
			
		
		
	}
	
}
