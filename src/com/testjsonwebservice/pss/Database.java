package com.testjsonwebservice.pss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	private static final String DATABASE_URL = "jdbc:derby://localhost:1527/myDB;user=me;password=mine";
	private static final String tableName = "psirts";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public static ArrayList<Psirt> getPsirts() {
    	return createConnection(); 
    }
    
    /**
     * Creates a connection with the Apache Derby database that holds the PSIRTs
     */
    private static ArrayList<Psirt> createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(DATABASE_URL); 
            return selectPsirts();
        }
        catch (Exception except)
        {
            except.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get all the psirts in the psirts table 
     * 
     * @return Psirt array with all psirts in the table
     */
    private static ArrayList<Psirt> selectPsirts()
    {
    	ArrayList<Psirt> psirts = new ArrayList<Psirt>();
        try
        {
        	if(conn == null) {
        		System.out.println("conn is null");
        	}
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            //ResultSetMetaData rsmd = results.getMetaData();
            while(results.next())
            {
            	Psirt p = new Psirt(); 
            	p.setHeadline(results.getString("headline"));
            	p.setAlertVersion(results.getString("alertversion"));
            	p.setAlertId(results.getString("alertid"));
            	p.setFirstPublished(results.getString("firstpublished")); 
            	p.setLastUpdated(results.getString("lastupdated"));
            	p.setImpact(results.getString("impact")); 
            	p.setUrl(results.getString("url"));
            	psirts.add(p);
            	
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        
        return psirts;
    }
}
