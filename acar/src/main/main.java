package main;

import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws SQLException {
		new viewframe(DemoJdbc.lireEnBase());
		
		System.out.println(DemoJdbc.lireEnBase());
		
    }
	

}
