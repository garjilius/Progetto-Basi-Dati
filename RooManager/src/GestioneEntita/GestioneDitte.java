/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneEntita;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author emanuelegargiulo
 */
public class GestioneDitte {
    
    public Vector leggiDitte() throws SQLException {
        Vector ditteEsterne = new Vector();
        String query = "SELECT * FROM DittaEsterna";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            ditteEsterne.add(result.getString("Nome"));
        }
        return ditteEsterne;
    }
    
    public static String leggiPIVADitta(String nome) throws SQLException {
        String query = "Select PIVA FROM DittaEsterna WHERE Nome = '%s'";
         query = String.format(query, nome);       
        String PIVALetta = "";
         ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            PIVALetta = result.getString("PIVA");
        }
         return PIVALetta;
    }
    
}
 