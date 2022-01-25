package com.iu.s1.region;

import java.util.Scanner;

public class RegionController {
	
	
	private RegionDAO regionDAO;
	private RegionInput regionInput;
	private RegionView regionView;
	private Scanner sc;
	
	public RegionController() {
		regionInput = new RegionInput();
		regionDAO = new RegionDAO();
		regionView = new RegionView();
		sc= new Scanner(System.in);
		
		
	}
	
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. Region 추가");
			System.out.println("2. Region 수정");
			System.out.println("3. Region 삭제");
			System.out.println("4. 나   가   기");
			
			int select = sc.nextInt();
			RegionDTO regionDTO=null;
			switch(select) {
			case 1:
				regionDTO = regionInput.setInsert();
				int result = regionDAO.setInsert(regionDTO);
				String message="Fail";
				if(result>0) {
					message="Success";						
				}
				regionView.view(message);
				break;
			case 2:
				regionDTO = regionInput.setInsert();
				int result3 = regionDAO.setUpdate(regionDTO);
				String message3 = "UPDATE FAIL";
				if(result3>0) {
					message3="UPDATE SUCCESS";
					
				}
				regionView.view(message3);
				
				break;
			case 3:
				regionDTO = regionInput.setDelete();
				int result2 = regionDAO.setDelete(regionDTO);
				String message2="DELETE Fail";
				if(result2>0) {
					message2="DELETE Success";
					
				}
				regionView.view(message2);
				
				break;
			default:
					check=false;
			
			
			}
			
			
			
		}
		
		
	}
	
}
