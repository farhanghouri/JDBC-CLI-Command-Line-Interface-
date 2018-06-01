package m;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLQueryReceiver implements QueryReceiver{

	Connection getConnectionFromPool() throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnectionFromPool(); 
	}
	 
	
	@Override
	public void selectQuery(String query) {
		System.out.println("select query execute");
        try{ 
	        Connection con = getConnectionFromPool();
	        System.out.println("Sucess");
	        Statement stmt = null;  // statement/query execute
	        ResultSet rs = null;    // output show
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        rs=stmt.executeQuery(query);
	         
	                System.out.println("Table: " + rs.getMetaData().getTableName(1));
	                for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
	                    System.out.print(rs.getMetaData().getColumnName(i)+"\t");
	                }
	                System.out.println();
			        while (rs.next()) { //till null
			        	for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){ 
			                System.out.print(rs.getString(i)+"\t");
		                }
			        	System.out.println();
			        }
			con.close(); 
	        
        }catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertQuery(String query) {
		System.out.println("insert query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Sucess");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateQuery(String query) {
		System.out.println("update query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Success");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteQuery(String query) {
		System.out.println("delete query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Success");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
