/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import domein.DomeinController;
import domein.Overzichttype;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Deel1 {

    private final DomeinController dc;

    public Deel1() {
        dc = new DomeinController();
    }

    public void deel1() {
        Scanner sc = new Scanner(System.in);
        while (!sc.next().equals("Cancel")) {

            System.out.println("Selecteer uit een van volgende opties: ");
            dc.geefOverzicht().forEach((_item) -> {
                System.out.println(_item.toString());
            });
            System.out.println("Of annuleer met Cancel.");
            if (!sc.next().equals("Cancel")) {
                try {
                    dc.maakOverzicht(Overzichttype.valueOf(sc.next()));
                } catch (InputMismatchException ime) {
                    System.err.println("Geef een correct type in. ");
                }
            }
        }
    }
}
