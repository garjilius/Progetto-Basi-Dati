
package Test;

import java.sql.SQLException;

public class MainTest {
    
    public static void main(String[] args) throws SQLException {
        
        System.out.println("STATO ATTUALE: Database vuoto.\n");
        
        System.out.println("----------------------------------------------------\n");
        
        new TestInsert().start();
        
        System.out.println("----------------------------------------------------\n");
        
        new TestRead().start();
        
        System.out.println("----------------------------------------------------\n");
        
        new TestUpdate().start();
        
        System.out.println("----------------------------------------------------\n");
        
        new TestRead().start();
    }
    
}