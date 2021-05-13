/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.breton.testgit1;

/**
 *
 * @author Axel
 */
public class Main {
    public static void main(String[] args) {
    int id=1;
    System.out.println("abscisse du pt");
    double abscisse = Lire.d();
    System.out.println("ordonnee du pt");
    double ordonnee = Lire.d();
    Point m =new Point(id,abscisse,ordonnee);
    }
}
