/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanager;
import java.sql.*;
/**
 *
 * @author emanuelegargiulo
 */
public class RooManager {

    /**
     * @param args the command line arguments
     */
    
    static Connection con = null; 
            
    public static void main(String[] args) {
           String prova1 = "Select * from Anagrafica";

        //Crea Connessione
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/roomanager";
            con =  DriverManager.getConnection(url,"root","");
        }
        catch(Exception e) {
            System.out.println(e);
        }
                   readDB(prova1);

    }
    
    
    public static void updateDB(String query) {
                try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
                    System.out.println(result);               
        }
        catch (Exception e){
            System.out.println(e);
           if(e.toString().contains("Duplicate"))
             System.out.println("Gia' presente zio");
           if(e.toString().contains("cannot be null"))
             System.out.println("zio non puoi mettere null");
        }
    } 
    
        public static void readDB(String query) {
                try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
                    System.out.println(result.toString()); 
                    int i = 1;
                    while(result.next()) {                    
                        System.out.println(result.getDate(4));
                    }
                   
        }
        catch (Exception e){
            System.out.println(e);
           if(e.toString().contains("Duplicate"))
             System.out.println("Gia' presente zio");
           if(e.toString().contains("cannot be null"))
             System.out.println("zio non puoi mettere null");
        }
    } 
        

    
}
