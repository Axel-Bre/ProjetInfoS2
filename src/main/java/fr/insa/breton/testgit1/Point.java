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
public class Point {
    private double abscisse;
    private double ordonnee;
    private int id;
    
    //constructeurs
    public Point (int id, double abscisse, double ordonnee) {
        this.abscisse=abscisse;
        this.ordonnee=ordonnee;
        this.id=id;
    }
    public Point (int id){
        this.id=id;
    }
    
    @Override
    public String toString(){
        return ("Coordonnées du point"+this.id+" : ( "+this.abscisse+";"+this.ordonnee+")");
    }
    public String toShortString(){
        return ("(" +this.abscisse+";"+this.ordonnee+")");
    }
    
    //get - set
    
    public double getAbscisse() {
        return abscisse;
    }
    public double getOrdonnee() {
        return ordonnee;
    }
    public int getId(){
        return id;
    }
    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse ;
    }
    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }
    }
    
    

