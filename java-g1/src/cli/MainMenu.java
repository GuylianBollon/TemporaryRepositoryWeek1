/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import domein.DomeinController;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class MainMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecteer 1 om overzichten te krijgen. ");
        if ("1".equals(sc.next())) {
            Deel1 deel1 = new Deel1();
            deel1.deel1();
        }
    }

}
