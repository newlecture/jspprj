package com.newlecture.web.dao.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class FileNoticeDao implements NoticeDao {

	@Override
	public List<Notice> getList() {		
		List<Notice> notices = new ArrayList<>();		
		try {
			FileInputStream fis = new FileInputStream("D:\\java-1902\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
			
			Scanner fscan = new Scanner(fis, "UTF-8");			
			String line = "";			
			
			while(fscan.hasNextLine()){
				line = fscan.nextLine();
				Notice notice = new Notice(line.split(","));
				notices.add(notice);
			}
			
			fscan.close();
			fis.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return notices;
	}
	
	@Override
	public Notice get(int id) {
		Notice n = new Notice();
		
		try {
			FileInputStream fis = new FileInputStream("D:\\java-1902\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
			Scanner fscan = new Scanner(fis, "UTF-8");
			
			String line = "";
						
			if(fscan.hasNextLine()){ 
		    	line = fscan.nextLine();
				n = new Notice(line.split(","));
			}
				
			fscan.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

}
