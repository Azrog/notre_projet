package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DemoJdbc {
	
	   public static void sauverEnBase(String personne) {
	        String url = "jdbc:mysql://localhost/formation";
	        String login = "root";
	        String passwd = "";
	        java.sql.Connection cn =null;
	        java.sql.Statement st =null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cn = DriverManager.getConnection(url, login, passwd);
	            st = cn.createStatement();
	            String sql = "INSERT INTO javabd (personne) VALUES ('"+ personne +"')";
	            st.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                cn.close();
	                st.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	   public static String lireEnBase() {
	        String url = "jdbc:mysql://localhost/acar";
	        String login = "root";
	        String passwd = "";
	        String sortie = "";
	        ArrayList<String> bdd = new ArrayList<String>();
	        java.sql.Connection cn =null;
	        java.sql.Statement st =null;
	        java.sql.ResultSet rs = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cn = DriverManager.getConnection(url, login, passwd);
	            st = cn.createStatement();
	            String sql = "SELECT * FROM structure";
	            rs = st.executeQuery(sql);
	            while (rs.next())
	            {
	            	bdd.add(rs.getString("code_ville"));
	            }
	           for (int p = 0; p < bdd.size(); p++)
	            {
	        	   sortie = bdd.get(p);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                cn.close();
	                st.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
			return sortie;
	    }
	   
	


}

