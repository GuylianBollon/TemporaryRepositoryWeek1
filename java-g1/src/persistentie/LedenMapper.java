/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Address;
import domein.Lid;
import domein.Module;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LedenMapper {
    public List<Lid> geefAlleLeden(){
        List<Lid> leden = new ArrayList<Lid>();
        try{
            Class.forName(Connectie.jdbcDriver);
            Connection conn = DriverManager.getConnection(Connectie.jdbcURL);
            PreparedStatement query = conn.prepareStatement("SELECT * FROM aspnet-ProjectenIIG1-B0BEA675-997B-4E19-A0B9-1807F727F288.Lid");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                String stad = rs.getString("stad");
                String straat = rs.getString("straat");
                int huisnummer = rs.getInt("huisnummer");
                int postcode = rs.getInt("postcode");
                String toevoegingHuisnummer = rs.getString("toevoeginghuisnummer");
                Address a = new Address(stad,straat,huisnummer,postcode,toevoegingHuisnummer);
                Module mode = Module.valueOf(rs.getString("module"));
                String id = rs.getString("id");
                String naam = rs.getString("naam");
                String voorNaam = rs.getString("voornaam");
                Date geboortedatum = rs.getDate("geboortedatum");
                leden.add(new Lid(a,mode,id,naam,voorNaam,geboortedatum));
            }
        }catch(SQLException sqle){
            System.err.println("Er kon geen verbinding gemaakt worden met de databank. ");
        } catch (ClassNotFoundException ex) {
            System.err.println("De klasse werd niet gevonden.");
        }
        return leden;
    }
}
