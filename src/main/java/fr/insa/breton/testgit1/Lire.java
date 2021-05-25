/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;
import java.util.concurrent.atomic.AtomicInteger;
import Terrain.*;
import java.awt.*;
import Terrain.Point;
/**
 *
 * @author Axel
 */
public class Barre {
    private Noeud n1;
    private Noeud n2;
    private int nB;
    private static AtomicInteger nextId=new AtomicInteger();
    private TypeDeBarre typeB;
    
    public Barre() {
        this.n1=new Noeud();
        this.n2=new Noeud();
        this.nB=nextId.incrementAndGet() - 1;
        this.typeB=new TypeDeBarre();
    }
    
    public Barre(Noeud n1,Noeud n2) {
        this.n1=n1;
        this.n2=n2;
        this.nB=nextId.incrementAndGet() - 1;
        this.typeB=new TypeDeBarre();      
    }
    
    public Barre(Noeud n1,Noeud n2,TypeDeBarre typeB ) {
        this.n1=n1;
        this.n2=n2;
        this.nB=nextId.incrementAndGet() - 1;
        this.typeB=typeB; 
    }
    
    public Noeud getN1() {
        return (this.n1);
    }
    
     public Noeud getN2() {
        return (this.n2);
    }
     
    public int getNB() {
        return (this.nB);
    }
      
    public void setN1(Noeud n1) {
        this.n1=n1;
    }
       
    public void setN2(Noeud n2) {
        this.n2=n2;
    }
    
    public void setNB(int nB) {
        this.nB=nB;
    }
    
    public double longueur() {
        Point P = new Point(this.n1.getNx(), this.n1.getNy());
        Point Q = new Point(this.n2.getNx(), this.n2.getNy());
        Segment S=new Segment(P,Q);
        return (S.longueur());
    }
    
    public String toString() {
        return ("Barre;"+this.nB+";"+this.typeB.getId()+";"+this.n1.getNN()+";"+this.n2.getNN()+";"+this.longueur());
    }
    
    public void draw(Graphics2D g) {
        BasicStroke line=new BasicStroke(5);
        g.setStroke(line);
        g.setColor(Color.blue);
        g.drawLine((int)this.n1.getNx(), (int)this.n1.getNy(), (int)this.n2.getNx(), (int)this.n2.getNy());
    }
    
    public double getAngle(Barre b2) {
        double angle = Math.atan2(b2.getN2().getNy() - b2.getN1().getNy(), b2.getN2().getNx() - b2.getN1().getNx()) - Math.atan2(this.getN2().getNy() - this.getN1().getNy(), this.getN2().getNx() - this.getN1().getNx());
        return(angle);
    } 
}


// Catalogue 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;

/**
 *
 * @author Axel
 */
public class Catalogue {
    private int nbBarre;
    private TypeDeBarre[] liste;
    
    public Catalogue() {
        this.nbBarre = 0;
        this.liste = new TypeDeBarre[0];
    }
    public Catalogue(int nbBarre) {
        this.nbBarre = nbBarre;
        this.liste = new TypeDeBarre[nbBarre];
    }
    public Catalogue(int nbBarre, TypeDeBarre[] liste) {
        this.liste = liste;
        this.nbBarre = nbBarre;
    }
    
    public int getNbBarre() {
        return(this.nbBarre);
    }
    
   public TypeDeBarre[] getListe() {
       return(this.liste);
   }
   
   public void setNbBarre(int nbBarre){
       this.nbBarre = nbBarre;
   }
   public void setListe(TypeDeBarre[] liste) {
       this.liste = liste;
   }
   public void setListeSpe(int numBarre, TypeDeBarre type) {
       this.liste[numBarre] = type ;
   }
   public String toString() {
       String S = "";
       int i;
       if (this.nbBarre !=0) {
           S = S + "\n";
       }
       for (i=0;i<this.nbBarre;i++) {
           if  (i==this.nbBarre - 1) {
               S = S + this.liste[i].toString();
           }
           else {
               S = S + this.liste[i].toString() + "\n";
           }
       }
       return(S);
   }
   
   
}


// Charge

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;

/**
 *
 * @author Axel
 */
public class Charge {
   private Noeud n1;
   private double mod;
   private double angle;
   
   public Charge(Noeud n1, double mod, double angle){
       this.n1=n1;
       this.mod=mod;
       this.angle=angle;
   }
   public Noeud getn1() {
       return(this.n1);
   }
   public void setn1(Noeud n1) {
       this.n1 = n1;
   }
   public double getMod(){
       return(this.mod);
   }
   public double getAngleC(){
       return(this.angle);
   }
   public void setMod(double mod){
       this.mod = mod;
   }
   public void setAngle(double angle) {
       this.angle = angle;
   }
   
}


// Noeud

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Axel
 */
public class Noeud {
    private int nN;
    private static AtomicInteger nextId = new AtomicInteger();
    private double nx;
    private double ny;
    
    
    public Noeud() {
        this.nN = nextId.incrementAndGet() - 1;
        this.nx = 0;
        this.ny = 0;
    }
    public Noeud (double nx, double ny) {
        this.nx = nx;
        this.ny = ny;
        this.nN = nextId.incrementAndGet() - 1;
    }
    
    public int getNN() {
        return(this.nN);
    }
    public void setNN(int nN) {
        this.nN = nN;
    }
    public double getNx(){
        return(this.nx);
    }
    public double getNy(){
        return(this.ny);
    }
    public void setNx(double nx){
        this.nx = nx;
    }
    public void setNy(double ny){
        this.ny = ny;
    }
    
    public double getAngle(Noeud n2, Noeud n3) {
        double angle = Math.atan2(n3.getNy()-this.getNy(),n3.getNx()-this.getNx()) - Math.atan2(n2.getNy()-this.getNy(), n2.getNx()-this.getNx());
        return (angle);
    }
}

// Noeud Appui 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;
import Terrain.*;
/**
 *
 * @author Axel
 */
public class NoeudAppui extends Noeud {
    
    private Triangle tT;
    private int idS;
    private double posN;
    private boolean deplacementT;
    
    public NoeudAppui (Triangle tT, int idS, double posN, boolean deplacementT){
        this.tT = tT;
        this.idS = idS;
        this.posN = posN;
        this.deplacementT = deplacementT;
        if (this.idS == 0){
            this.setNx((this.posN)*this.tT.getP1().getPx() + (1-(this.posN))*this.tT.getP2().getPx());
            this.setNy((this.posN)*this.tT.getP1().getPy() + (1-(this.posN))*this.tT.getP2().getPy());
        }
        if (this.idS == 1) {
            this.setNx((this.posN)*this.tT.getP2().getPx() + (1-(this.posN))*this.tT.getP3().getPx());
            this.setNy((this.posN)*this.tT.getP2().getPy() + (1-(this.posN))*this.tT.getP3().getPy());
        }
        if (this.idS == 2){
            this.setNx((this.posN)*this.tT.getP3().getPx() + (1-(this.posN))*this.tT.getP1().getPx());
            this.setNy((this.posN)*this.tT.getP3().getPy() + (1-(this.posN))*this.tT.getP1().getPy());
        }
    }
    
    public Triangle getTT() {
        return(this.tT);
    }
    public int getNumPdS(){
        return(this.idS);
    }
    public double getPosN() {
        return(this.posN);
    }
    public boolean getDeplacementT() {
        return(this.deplacementT);
    }
    public void setTT(Triangle tT) {
        this.tT = tT;
    }
    public void setNumPdS(int numPdS) {
        this.idS = numPdS;
    }
    public void setPostN(double posN) {
        this.posN = posN;
    }
    public void setDeplacementT(boolean deplacementT) {
        this.deplacementT = deplacementT;
    }
    public String toString() {
        if (this.deplacementT == true) {
            return("AppuiSimple;"+this.getNN()+";"+this.tT.getNT()+";"+this.idS+";"+this.posN);
        }else{
            return("AppuiDouble;"+this.getNN()+";"+this.tT.getNT()+";"+this.idS+";"+this.posN);
        }
    }
}

// Noeud simple

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;

/**
 *
 * @author Axel
 */
public class NoeudSimple extends Noeud {
    public NoeudSimple(){
    }
    public NoeudSimple(double nx, double ny) {
        this.setNx(nx);
        this.setNy(ny);
    }
    public String toString() {
        return("NoeudSimple;"+this.getNN()+";("+this.getNx()+","+this.getNy()+")");
    }
}

// Treillis/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;
import Terrain.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Axel
 */
public class Treillis {
    private Terrain terrain;
    private ZoneConstructible ZnCt;
    private Catalogue catalogue;
    private int nbNoeud;
    private int nbBarre;
    private Noeud[] listeNoeud;
    private Barre[] listeBarre;
    
    public Treillis() {
        this.terrain = new Terrain();
        this.catalogue = new Catalogue();
        this.nbNoeud = 0;
        this.nbBarre = 0;
        this.listeNoeud = new Noeud[0];
        this.listeBarre = new Barre[0];
    }
    public Treillis(Terrain terrain, Catalogue catalogue) {
        this.terrain = terrain;
        this.catalogue = catalogue;
    }
    public Treillis(Terrain terrain, Catalogue catalogue, int nbNoeud, int nbBarre) {
        this.terrain = terrain;
        this.catalogue = catalogue;
        this.nbNoeud =  nbNoeud;
        this.nbBarre = nbBarre;
    }
    public Treillis(Terrain terrain,ZoneConstructible ZnCt, Catalogue catalogue, int nbNoeud, int nbBarre, Noeud[] listeNoeud, Barre[] listeBarre) {
        this.terrain = terrain;
        this.ZnCt = ZnCt;
        this.catalogue = catalogue;
        this.nbNoeud = nbNoeud;
        this.nbBarre = nbBarre;
        this.listeNoeud = listeNoeud;
        this.listeBarre = listeBarre;
    }
    
    public Terrain getTerrain() {
        return(this.terrain);
    }
    public Catalogue getCatalogue(){
        return(this.catalogue);
    }
    public int getNbNoeud() {
        return(this.nbNoeud);
    }
    public int getNbBarre() {
        return (this.nbBarre);
    }
    public Noeud[] getListeNoeud(){
        return(this.listeNoeud);
    }
    public Barre[] getListeBarre(){
        return(this.listeBarre);
    }
    public Noeud getListeNoeudSpe(int numNoeud) {
        return(this.listeNoeud[numNoeud]);
    }
    public Barre getListeBarreSpe(int numBarre) {
        return(this.listeBarre[numBarre]);
    }
    public ZoneConstructible getZnCt() {
        return ZnCt;
    }
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
    public void setNbNoeud(int nbNoeud) {
        this.nbNoeud = nbNoeud;
    }
    public void setNbBarre(int nbBarre) {
        this.nbBarre = nbBarre;
    }
    public void setListeNoeud(Noeud[] listeNoeud) {
        this.listeNoeud = listeNoeud;
    }
    public void setListeBarre(Barre[] listeBarre) {
        this.listeBarre = listeBarre;
    }
    public void setListeNoeudSpe(Noeud noeud, int numNoeud) {
        this.listeNoeud[numNoeud] = noeud ;
    }
    public void setListeBarreSpe(Barre barre, int numBarre) {
        this.listeBarre[numBarre] = barre;
    }
    public void setZnCt(ZoneConstructible ZnCt) {
        this.ZnCt = ZnCt;
    }
    
    public String toString() {
        File file = new File("C:/Users/Axel/Videos/Documents/NetBeansProjects/ProjetS2Treillis/src/main/java/Liste_des_treillis/1.txt");
        String S ="";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                S = S + line + "\n";
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return(S);
    }
    public void toText(String lien) {
    int i;
    File file = new File(lien);
        String S ="";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            bufferedWriter.write(this.ZnCt.toString());
            bufferedWriter.newLine();
            for (i=0;i<this.terrain.getNombreTriangle();i++) {
                bufferedWriter.write(this.terrain.getSolSpe(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write("FINTRIANGLES");
            bufferedWriter.write(this.catalogue.toString());
            bufferedWriter.newLine();
            bufferedWriter.write("FINCATALOGUE");
            bufferedWriter.newLine();
            for (i=0;i<this.nbBarre;i++) {
                bufferedWriter.write(this.listeNoeud[i].toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write("FINNOEUDS");
            bufferedWriter.newLine();
            for (i=0;i<this.nbBarre;i++) {
                bufferedWriter.write(this.listeBarre[i].toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write("FINBARRES");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g) {
        int i;
        BasicStroke line3 = new BasicStroke(3);
        g.setStroke(line3);
        g.setColor(Color.green);
        for (i=0;i<this.terrain.getNombreTriangle();i++) {
            Triangle T = this.terrain.getSolSpe(i);
            g.drawLine((int)T.getP1().getPx(), (int)T.getP1().getPy(), (int)T.getP2().getPx(), (int)T.getP2().getPy());
            g.drawLine((int)T.getP2().getPx(), (int)T.getP2().getPy(), (int)T.getP3().getPx(), (int)T.getP3().getPy());
            g.drawLine((int)T.getP3().getPx(), (int)T.getP3().getPy(), (int)T.getP1().getPx(), (int)T.getP1().getPy());
        }
        
        BasicStroke line5 = new BasicStroke(5);
        g.setStroke(line5);
        g.setColor(Color.blue);
        for (i=0;i<this.nbBarre;i++) {
            Barre B = this.listeBarre[i];
            g.drawLine((int)B.getN1().getNx(), (int)B.getN1().getNy(), (int)B.getN2().getNx(), (int)B.getN2().getNy());        
        }
        
        for (i=0;i<this.nbNoeud;i++) {
            Noeud N = this.listeNoeud[i];
            if (N instanceof NoeudAppui) {
                g.setColor(Color.blue);
            }
            if (N instanceof NoeudAppui) {
                NoeudAppui M = (NoeudAppui)N;
                if (M.getDeplacementT() == true) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);
                }
            }
        g.translate(-5,-5);
        g.fillOval((int)N.getNx(),(int)N.getNy(),10,10);
        g.translate(5,5);
        }
    }
        
}


// TypeDeBarre

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treillis;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Axel
 */
public class TypeDeBarre {
    
    private int id;
    private static AtomicInteger nextId = new AtomicInteger();
    private double coutAuM;
    private double longueurMin;
    private double longueurMax;
    private double resMaxT;
    private double resMaxC;
    
    public TypeDeBarre() {
        this.id = 0;
        this.coutAuM = 0;
        this.longueurMin = 0;
        this.longueurMax = 0;
        this.resMaxT = 0;
        this.resMaxC = 0;
    }
    public TypeDeBarre(double coutAuM, double longueurMin, double longueurMax, double resMaxT, double resMaxC) {
        this.id = nextId.incrementAndGet();
        this.coutAuM = coutAuM;
        this.longueurMin = longueurMin;
        this.longueurMax = longueurMax;
        this.resMaxT = resMaxT;
        this.resMaxC = resMaxC;
    }
    
    public double getCoutAuM() {
        return(this.coutAuM);
    }
    public int getId() {
        return(this.id);
    }
    public double getLongueurMin() {
        return (this.longueurMin);
    }
    public double getLongueurMax() {
        return (this.longueurMax);
    }
    public double getResMaxT() {
        return(this.resMaxT);
    }
    public double getRestMaxC() {
        return(this.resMaxC);
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String toString() {
        return("TypeBarre;"+this.id+";"+this.coutAuM+";"+this.longueurMin+";"+this.longueurMax+";"+this.resMaxT+";"+this.resMaxC);
    }
}


// Main

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetS2;
import java.util.*;
import Terrain.*;
import Treillis.*;
import java.awt.Graphics2D;
/**
 *
 * @author Axel
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Définissez la zone constructible :");
        System.out.println("Xmin :");
        double xmin = Lire.d();
        System.out.println("Xmax :");
        double xmax = Lire.d();
        System.out.println("Ymin :");
        double ymin = Lire.d();
        System.out.println("Ymax :");
        double ymax = Lire.d();
        ZoneConstructible ZnCt = new ZoneConstructible(xmin,xmax,ymin,ymax);
        System.out.println(ZnCt.toString()); 
        ArrayList<Triangle> ter = new ArrayList<Triangle>();
        System.out.println("Définition du/des triangle(s) terrain :");
        char q = 'Y';
        while (q == 'Y') {
            System.out.println("Définissez les coordonnées des trois points du triangle:");
            System.out.println("Abscisse P1 :");
            double x1 = Lire.d();
            System.out.println("Ordonnée P1 :");
            double y1 = Lire.d();
            Point p1 = new Point(x1,y1);
            System.out.println("Abscisse P2 :");
            double x2 = Lire.d();
            System.out.println("Ordonnée P2 :");
            double y2 = Lire.d();
            Point p2 = new Point(x2,y2);
            System.out.println("Abscisse P3 :");
            double x3 = Lire.d();
            System.out.println("Ordonnée P3 :");
            double y3 = Lire.d();
            Point p3 = new Point(x3,y3);
            Triangle T = new Triangle(p1,p2,p3);
            ter.add(T);
            
            System.out.println("Voulez-vous saisir un autre triangle terrain ? (Y pour oui, N pour non)");
            q = Lire.c();
        
        }
        System.out.println(ter);
        Triangle [] sol = new Triangle[ter.size()];
        for (int i=0;i<ter.size();i++) {
            sol [i] = ter.get(i);
        }
        Terrain terrain = new Terrain(sol);
        ArrayList<Noeud> noeud = new ArrayList<Noeud>();
        System.out.println("Création des noeuds :");
        char q2 = 'Y';
        while (q2 == 'Y') {
            System.out.println("Quel type de noeud souhaitez-vous créer ? (1 pour noeud simple, 2 pour appui)");
            int n = Lire.i();
            if ((n != 1) && (n != 2)) {
                System.out.println("Rentrez 1 pour noeud simple ou 2 pour noeud appui.");
                n=Lire.i();
            }
            if (n == 1) {
                System.out.println("Définissez les coordonnées du noeud :");
                System.out.println("Abscisse :");
                double x = Lire.d();
                System.out.println("Ordonnée :");
                double y = Lire.d();
                NoeudSimple N = new NoeudSimple(x,y);
                noeud.add(N);
            }
            if (n == 2) {
                System.out.println("Donnez l'identifiant du triangle terrain sur lequel le noeud sera fixé :");
                int tt = Lire.i();
                System.out.println("S0 :"+ter.get(tt).getS1().toString());
                System.out.println("S1 :"+ter.get(tt).getS2().toString());
                System.out.println("S2 :"+ter.get(tt).getS3().toString());
                System.out.println("Choisissez 0,1 ou 2 pour choisir le segment sur lequel le noeud sera fixé :");
                int idS = Lire.i();
                if (idS != 0 && idS != 1 && idS !=2){
                    System.out.println("Choisissez 0,1 ou 2 pour choisir le segment sur lequel le noeud sera fixé :");
                    idS = Lire.i();
                }
                double posN=0;
                if (idS == 0) {
                System.out.println("Rentrez une valeur entre 0 et 1 pour indiquer l'emplacement sur le segment(distance relative du point "+ter.get(tt).getP1().toString()+" au point "+ter.get(tt).getP2().toString()+")");
                posN = Lire.d();
                }
                if (idS == 1) {
                System.out.println("Rentrez une valeur entre 0 et 1 pour indiquer l'emplacement sur le segment(distance relative du point "+ter.get(tt).getP2().toString()+" au point "+ter.get(tt).getP3().toString()+")");
                posN = Lire.d();
                }
                if (idS == 2) {
                System.out.println("Rentrez une valeur entre 0 et 1 pour indiquer l'emplacement sur le segment(distance relative du point "+ter.get(tt).getP3().toString()+" au point "+ter.get(tt).getP1().toString()+")");
                posN = Lire.d();
                }
                System.out.println(posN);
                System.out.println("Le noeud est-il fixe ou mobile sur le segment choisi ? (F pour fixe, M pour mobile)");
                char d = Lire.c();
                boolean deplacementT=false;
                if (d == 'F') {
                    deplacementT = false;
                } 
                if (d == 'M') {
                    deplacementT = true ;
                }
                NoeudAppui N = new NoeudAppui(ter.get(tt),idS,posN,deplacementT);
                noeud.add(N);  
            }
            System.out.println("Voulez-vous créer un autre noeud ? (Y pour oui, N pour non)");
            q2=Lire.c();
        }
        System.out.println(noeud);
        ArrayList<TypeDeBarre> cata = new ArrayList<TypeDeBarre>();
        System.out.println("Inventaire des différents types de barres :");
        char q3 = 'Y';
        while (q3 == 'Y') {
            System.out.println("Quel est le coût au mètre ?");
            double coutAuM = Lire.d();
            System.out.println("Quelle est la longueur minimale d'une barre de ce type ?");
            double longueurMin = Lire.d();         
            System.out.println("Quelle est la longueur maximale d'une barre de ce type ?");
            double longueurMax = Lire.d();
            System.out.println("Quelle est la résistance maximale à la tension d'une barre de ce type ? ");
            double resMaxT = Lire.d();
            System.out.println("Quelle est la résistance maximale à la compression d'une barre de ce type ? ");
            double resMaxC = Lire.d(); 
            TypeDeBarre type = new TypeDeBarre(coutAuM,longueurMin,longueurMax,resMaxT,resMaxC);
            cata.add(type);
            System.out.println("Voulez-vous ajouter un autre type de barre à l'inventaire ?");
            q3=Lire.c();
        }
        System.out.println(cata);
        TypeDeBarre [] liste = new TypeDeBarre[cata.size()];
        for (int i=0;i<cata.size();i++) {
            liste [i] = cata.get(i);
        }
        Catalogue catalogue = new Catalogue(cata.size(), liste);
        System.out.println("Catalogue :");
        System.out.println(catalogue.toString());
        ArrayList<Barre> barre = new ArrayList<Barre>();
        System.out.println("Définition des barres :");
        char q4 = 'Y';
        while (q4 == 'Y') {
            System.out.println("Donnez l'identifiant du premier noeud :");
            int n1 = Lire.i();
            System.out.println("Donnez l'identifiant du second noeud :");
            int n2 = Lire.i();
            System.out.println("Choisissez le type de la barre créée : (rentrez l'identifiant correspondant de l'iventaire)");
            int typeB = Lire.i();
            Barre ba = new Barre(noeud.get(n1), noeud.get(n2), cata.get(typeB-1));
            barre.add(ba);
            System.out.println("Voulez-vous créer une autre barre ?");
            q4=Lire.c();
        }
        System.out.println(barre);
    }  
}

// Lire 

package ProjetS2;

import java.io.*;

/**
version améliorée par Raphaël Schruoffeneger ; MIQ2 INSA Strasbourg 2013 
*/

public class Lire
{    
    //-------------------------------------------------------
    public static String S() // lire une chaine de caracteres
    {
        String x;
	char c;
	boolean erreur;
		
	do
	{
            x = "";
            erreur = false;
            
            try
            {
                while((c = (char)System.in.read()) != '\n')
		{
                    if (c != '\r')
                    {
                        x += c;
                    }
                }
            }
            catch(IOException e)
            {
                System.out.print(" > Veuillez entrer une chaine de caracteres : ");
                erreur = true;
            }
	} while(erreur);
		
	return x;
    } // fin de String S()


    //----------------------------------------------------
    public static byte b() // lire un nombre entier (byte)
    {
        byte x;
        boolean erreur;
        
        do
        {
            x = 0;
            erreur = false;
            
            try
            {
                x = Byte.parseByte(S());
            }
            catch(NumberFormatException e)
            {
                System.out.println(" > Veuillez entrer un nombre entier (byte) : ");
                erreur = true;
            }
        } while(erreur);
        
        return x;
    } // fin de byte b()

    
    //------------------------------------------------------
    public static short s() // lire un nombre entier (short)
    {
        short x;
        boolean erreur;
        
        do
        {
            x = 0;
            erreur = false;
            
            try
            {
                x = Short.parseShort(S());
            }
            catch(NumberFormatException e)
            {
                System.out.println(" > Veuillez entrer un nombre entier (short) : ");
                erreur = true;
            }
        } while(erreur);
    
    return x;
    } // fin de short s()
     
    
    //--------------------------------------------------
    public static int i() // lire un nombre entier (int)
    {
        String chaine;
        int x;
        boolean erreur;
 	 	
        do
        {
            x = 0;
            chaine = S();
            erreur = false;

            try
            {
                x = Integer.parseInt(chaine);
            }
            catch(NumberFormatException e)
            {
                if(chaineEstUnEntier(chaine))
                {
                    System.out.print(" > Votre nombre depasse les limites de stockage du format (int) !\n"
                        + " > Veuillez entrer un nombre compris entre "
                        + separer(Integer.MIN_VALUE) + " et "
                        + separer(Integer.MAX_VALUE) + " : ");
                }
                else
                {
                    System.out.print(" > Veuillez entrer un nombre entier (int) : ");
                }

                erreur = true;
            }	
        } while(erreur);
		
        return x;
    } // fin de int i()
        
    
    //----------------------------------------------------
    public static long l() // lire un nombre entier (long)
    {
        long x;
        boolean erreur;
 	
        do
        {
            x = 0;
            erreur = false;
            
            try
            {
                x = Long.parseLong(S());
            }
            catch(NumberFormatException e)
            {
                System.out.println(" > Veuillez entrer un nombre entier (long) : ");
                erreur = true;
            }
        } while(erreur);
        
        return x;
    } // fin de long l()
    
    
    //------------------------------------------------------
    public static double d() // lire un nombre reel (double)
    {
        double x;
        boolean erreur;
	  	
	do
	{
            x = 0;
            erreur = false;
	 		
            try
            {
                x = Double.parseDouble(S());
            }
            catch(NumberFormatException e)
            {
                System.out.print(" > Veuillez entrer un nombre reel (double) : ");
                erreur = true;
            }
        } while(erreur);
	 	 	
        return x ;
    } // fin de double d()
        
    
    //----------------------------------------------------
    public static float f() // lire un nombre reel (float)
    {
        float x;
        boolean erreur;
        
        do
        {
            x = 0;
            erreur = false;
            
            try
            {
                x = Float.parseFloat(S());
            }
            catch(NumberFormatException e)
            {
                System.out.println(" > Veuillez entrer un nombre reel (float) : ");
                erreur = true;
            }
        } while(erreur);
	
        return x;
    } // fin de float f()

    
    //-----------------------------------------
    public static char c() // lire un caractere
    {
        String chaine;
        
        chaine = S();
        
        if (chaine.length() == 0)
        {
            return '\n';
        }
        else
        {
            return chaine.charAt(0);
        }
    } // fin de char c()
        
    
    //----------------------------------------------------
    public static int choix(int nbrChoix) // lire un choix
    {
        int x;
        boolean erreur;
        
        do
        {
            x = 0;
            erreur = false;

            try
            {
                x = Integer.parseInt(S());
            }
            catch(NumberFormatException e)
            {
                System.out.print(" > Veuillez taper un numero compris entre 1 et " + nbrChoix + " : ");
                erreur = true;
            }

            if(!erreur && (x < 1 || x > nbrChoix))
            {
                System.out.print(" > Veuillez taper un numero compris entre 1 et " + nbrChoix + " : ");
                erreur = true;
            }
        } while(erreur);

        return x;
    } // fin de int choix(int nbrChoix)


    //----------------------------------------------------------------------------------------------
    public static int entierSupEgal(int min) // lire un nombre entier superieur ou egal a un minimun
    {
        String chaine;
        int x;
        boolean erreur;
        
        do
        {
            x = 0;
            chaine = S();
            erreur = false;

            try
            {
                x = Integer.parseInt(chaine);
            }
            catch(NumberFormatException e)
            {
                if(chaineEstUnEntier(chaine))
                {
                    System.out.print(" > Votre nombre depasse les limites de stockage du format (int) !\n"
                        + " > Veuillez entrer un nombre compris entre "
                        + separer(min) + " et " + separer(Integer.MAX_VALUE) + " : ");
                }
                else
                {
                    System.out.print(" > Veuillez entrer un nombre entier superieur ou egal a " + separer(min) + " : ");
                }

                erreur = true;
            }

            if(!erreur && x < min)
            {
                erreur = true;
                System.out.print(" > Veuillez entrer un nombre entier superieur ou egal a " + separer(min) + " : ");
            }
        } while(erreur);

        return x;
    } // fin de int entierSupEgal(int min)
    
    
    //----------------------------------------------------------------------------------------------
    public static int entierInfEgal(int max) // lire un nombre entier inferieur ou egal a un maximum
    {
        String chaine;
        int x;
        boolean erreur;
        
        do
        {
            x = 0;
            chaine = S();
            erreur = false;

            try
            {
                x = Integer.parseInt(chaine);
            }
            catch(NumberFormatException e)
            {
                if(chaineEstUnEntier(chaine))
                {
                    System.out.print(" > Votre nombre depasse les limites de stockage du format (int) !\n"
                        + " > Veuillez entrer un nombre compris entre "
                        + separer(Integer.MIN_VALUE) + " et " + separer(max) + " : ");
                }
                else
                {
                    System.out.print(" > Veuillez entrer un nombre entier inferieur ou egal a " + separer(max) + " : ");
                }

                erreur = true;
            }

            if(!erreur && x > max)
            {
                erreur = true;
                System.out.print(" > Veuillez entrer un nombre entier inferieur ou egal a " + separer(max) + " : ");
            }
        } while(erreur);

        return x;
    } // fin de int entierInfEgal(int max)
    
    
    //---------------------------------------------------------------------------------------------------------
    public static int entierCompris(int min, int max) // lire un nombre entier compris dans un intervalle ferme
    {
        String chaine;
        int x;
        boolean erreur;
        
        do
        {
            x = 0;
            chaine = S();
            erreur = false;

            try
            {
                x = Integer.parseInt(chaine);
            }
            catch(NumberFormatException e)
            {
                System.out.print(" > Veuillez entrer un nombre entier compris entre " + separer(min) + " et " + separer(max) + " : ");
                erreur = true;
            }

            if(!erreur && (x < min || x > max))
            {
                erreur = true;
                System.out.print(" > Veuillez entrer un nombre entier compris entre " + separer(min) + " et " + separer(max) + " : ");
            }
        } while(erreur);

        return x;
    } // fin de int entierCompris(int min, int max)


    //-------------------------------------------------------
    public static int choixBinaire() // lire un choix binaire
    {
        int x;
        boolean erreur;
        
        do
        {
            x = 0;
            erreur = false;

            try
            {
                x = Integer.parseInt(S());
            }
            catch(NumberFormatException e)
            {
                System.out.print(" > Veuillez taper '1' ou '2' ! ");
                erreur = true;
            }

            if(!erreur && x!= 1 && x!= 2)
            {
                System.out.print(" > Veuillez taper '1' ou '2' ! ");
                erreur = true;
            }
        } while(erreur);

        return x;
    } // fin de int choixBinaire()


    //----------------------------------------------------------------------------------------
    public static boolean chaineEstUnEntier(String chaine) // test si une chaine est un entier
    {
        int i;
        boolean estUnEntier;

        if(chaine.length() > 0)
        {
            if((chaine.charAt(0) < '0' || chaine.charAt(0) > '9') && chaine.charAt(0) != '-' || chaine.equals("-"))
            {
                estUnEntier = false;
            }
            else
            {
                i = 1;
                estUnEntier = true;

                while(i < chaine.length() && estUnEntier)
                {
                    if(chaine.charAt(i) < '0' || chaine.charAt(i) > '9')
                    {
                        estUnEntier = false;
                    }

                    i++;
                }
            }
        }
        else
        {
            estUnEntier = false;
        }

        return estUnEntier;
    } // fin de boolean chaineEstUnEntier(String chaine)
    
    
    //-------------------------------------------------------------------------------------------------------------------
    public static boolean chaineEstUnEntierPositif(String chaine) // test si une chaine est un entier strictement positif
    {
        int i;

        if(chaineEstLEntierNul(chaine))
        {
            return false;
        }
        
        if(chaine.length() > 0)
        {
            i = 0;

            while(i < chaine.length())
            {
                if(chaine.charAt(i) < '0' || chaine.charAt(i) > '9')
                {
                    return false;
                }

                i++;
            }
            
            return true;
        }
        else
        {
            return false;
        }
    } // fin de boolean chaineEstUnEntierPositif(String chaine)
    
    
    //-------------------------------------------------------------------------------------------------------------------
    public static boolean chaineEstUnEntierNegatif(String chaine) // test si une chaine est un entier strictement negatif
    {
        int i;

        if(chaineEstLEntierNul(chaine))
        {
            return false;
        }
        
        if(chaine.length() > 1)
        {
            if(chaine.charAt(0) != '-')
            {
                return false;
            }
            
            i = 1;

            while(i < chaine.length())
            {
                if(chaine.charAt(i) < '0' || chaine.charAt(i) > '9')
                {
                    return false;
                }

                i++;
            }
            
            return true;
        }
        else
        {
            return false;
        }
    } // fin de boolean chaineEstUnEntierNegatif(String chaine)
    
    
    //---------------------------------------------------------------------------------------------
    public static boolean chaineEstLEntierNul(String chaine) // test si une chaine est l'entier nul
    {
        int i;

        if(chaine.length() > 0)
        {
            if(chaine.charAt(0) == '-')
            {
                if(chaine.length() == 1)
                {
                    return false;
                }
                
                i = 1;
            }
            else
            {
                i = 0;
            }

            while(i < chaine.length())
            {   
                if(chaine.charAt(i) != '0')
                {
                    return false;
                }

                i++;
            }
            
            return true;
        }
        else
        {
            return false;
        }
    } // fin de boolean chaineEstLEntierNul(String chaine)
    
    
    //---------------------------------------------------------------------------------------------------------------
    public static String separer(int nombre) // separe les grands nombres par groupes de 3 chiffres avec des virgules
    {
        String converti, resultat;
        int i, k;
        
        converti = Integer.toString(nombre);
        resultat = "";
        k = 0;

        for(i = converti.length()-1; i >= 0; i--)
        {
            resultat = converti.charAt(i) + resultat;
            k++;
            
            if(k % 3 == 0 && i != 0 && !(i == 1 && converti.charAt(0) == '-'))
            {
                resultat = ',' + resultat;
            }
        }

        return resultat;
    } // fin de String separer(int nombre)
}
