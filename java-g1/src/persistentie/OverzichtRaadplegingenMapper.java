/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Address;
import domein.LesMateriaal;
import domein.Lid;
import domein.PrototypeRaadpleging;
import java.sql.*;
import domein.Raadpleging;
import java.util.ArrayList;
import java.util.List;

public class OverzichtRaadplegingenMapper {
    public List<PrototypeRaadpleging> geefAlleOverzichtenVanRaadplegingen(){
        List<PrototypeRaadpleging> lpr = new ArrayList<PrototypeRaadpleging>();
        try{
            Class.forName(Connectie.jdbcDriver);
            Connection conn = DriverManager.getConnection(Connectie.jdbcURL);
            PreparedStatement query = conn.prepareStatement("SELECT * FROM aspnet-ProjectenIIG1-B0BEA675-997B-4E19-A0B9-1807F727F288.Raadplegingen");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                String stad = rs.getString("stad");
                String straat = rs.getString("straat");
                int huisnummer = rs.getInt("huisnummer");
                int postcode = rs.getInt("postcode");
                String toevoegingHuisnummer = rs.getString("toevoeginghuisnummer");
                Address a = new Address(stad,straat,huisnummer,postcode,toevoegingHuisnummer);
                domein.Module mode = domein.Module.valueOf(rs.getString("module"));
                String id = rs.getString("Lid.id");
                String naam = rs.getString("naam");
                String voorNaam = rs.getString("voornaam");
                Date geboortedatum = rs.getDate("geboortedatum");
                Lid leden = new Lid(a,mode,id,naam,voorNaam,geboortedatum);
                int id2 = rs.getInt("LesMateriaal.id");
                String titel = rs.getString("titel");
                String link = rs.getString("link");
                LesMateriaal lm = new LesMateriaal(id2,titel,link);
                Date overeenstemming = rs.getDate("datumraadpleging");
                Raadpleging r = new Raadpleging(leden,lm,overeenstemming);
                lpr.add(new PrototypeRaadpleging(r));
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Kon de klasse niet vinden.");
        } catch (SQLException ex) {
            System.err.println("Kon geen verbinding maken met de SQL Databank.");
        }
        return lpr;
    }
}
