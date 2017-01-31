
package Test;

import java.sql.SQLException;

public class MainTest {
    
    public static void main(String[] args) throws SQLException {
        
        System.out.println("ATTENZIONE: Svolgere i test partendo da DB vuoto!.\n");
        System.out.println("Stato attuale: DB Vuoto");
        
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