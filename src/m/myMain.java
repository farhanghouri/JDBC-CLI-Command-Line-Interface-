 
package m;

import java.sql.*;
import java.util.Scanner;

public class myMain {
	  
	public static void main(String[] args){
		
		 /***************
		 * use singleton pattern,command pattern
		 * use connection pooling
		 * use custom connection
		 */
	        boolean flag = false;
	        QueryReceiver queryRecevier = new MySQLQueryReceiver();
		    Command command = null;
		  

	        Scanner cin = new Scanner(System.in);
		    do{
		    flag = false;
		    System.out.print("SQL>");
	        String query = cin.nextLine(); 
	           
	        switch ((query.contains(" ") ? query.split(" ")[0] : query).toLowerCase()) {
			case "select":
				command = new SelectQueryCommand(queryRecevier);
				break;
			case "update":
				command = new UpdateQueryCommand(queryRecevier);
				break; 
			case "delete":
				command = new DeleteQueryCommand(queryRecevier);
				break;
			case "insert":
				command = new InsertQueryCommand(queryRecevier);
				break;
			default:
				flag = true;
				System.out.println("invalid input.");
				break;
			}

	        
	        if(!flag){
		        QueryInvoker queryInvoker = new QueryInvoker(command);
		        queryInvoker.execute(query);
	        }
	        
		    }while(true);
	 
	}

}
