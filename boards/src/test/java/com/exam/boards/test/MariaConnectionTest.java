package com.exam.boards.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class MariaConnectionTest {
	
	private static final String DRIVER ="org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/pstadb_board";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	     
	
	@Test
	public void testConntion() throws Exception {
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
		Class.forName(DRIVER);
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(connection);
		} catch (Exception e ){
			e.printStackTrace();
		}
	}
	

}
