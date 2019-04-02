/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Sessie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessieMapper {
    public List<Sessie> geefSessies() {
        List<Sessie> ls = new ArrayList<Sessie>();
        try{
            Class.forName(Connectie.jdbcDriver);
            Connection conn = DriverManager.getConnection(Connectie.jdbcURL);
            PreparedStatement query = conn.prepareStatement("SELECT * FROM aspnet-ProjectenIIG1-B0BEA675-997B-4E19-A0B9-1807F727F288.Sessie");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String naam = rs.getString("naam");
                String beschrijving = rs.getString("beschrijving");
                Date datum = rs.getDate("datum");
                boolean gestart = rs.getBoolean("gestart");
                ls.add(new Sessie(id,naam,beschrijving,datum,gestart));
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("De klasse werd niet gevonden.");
        } catch (SQLException ex) {
            System.err.println("Er kon geen verbinding gemaakt worden met de databank.");
        }
        return ls;
    }
}
