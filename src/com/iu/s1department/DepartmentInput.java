package com.iu.s1department;

import java.util.Scanner;

public class DepartmentInput {
	
	private Scanner sc;
	
	public DepartmentInput() {
		
		sc = new Scanner(System.in);
	}
	
	public DepartmentDTO setDelelte() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("삭제할 DEPARTMENT ID를 입력");
		departmentDTO.setDepartment_id(sc.nextInt());
	
		return departmentDTO;
		
	}
	
	public DepartmentDTO setInsert() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("추가할 DEPARTMENT ID를 입력");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.println("추가할 DEPARTMENT NAME을 입력");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("추가할 MANAGER ID를 입력");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.println("추가할 LOCATION ID를 입력");
		departmentDTO.setLocation_id(sc.nextInt());
		
		return departmentDTO;
	}

}
