//(TERRAIN)
//POINT
package Terrain;
public class Point {
    
    private double px;
    private double py;
    
    public Point () {
        this.px=0;
        this.py=0;
    }
    
    public Point (double p) {
        this.px=p;
        this.py=p;
    }
    
    public Point (double px, double py) {
        this.px=px;
        this.py=py;         
    }
    
    public double getPx() {
        return (this.px);
    }
    
    public double getPy() {
        return (this.py);
    }
    
    public void setPx(double px) {
        this.px=px;
    }
    
    public void setPy(double py) {
        this.py=py;
    }
    
    public String toString() {
        return ("("+this.px+","+this.py+")");
    }
}




//SEGMENT
package Terrain;
import static java.lang.Math.sqrt;
import java.awt.*;
public class Segment {
    
    private Point p1;
    private Point p2;
    
    public Segment () {
        this.p1=new Point();
        this.p2=new Point();
    }
    
    public Segment (Point p) {
        this.p1=p;
        this.p2=new Point();
    }
    
    public Segment (Point p1, Point p2) {
        this.p1=p1;
        this.p2=p2;
    }
    
    public Point getP1 () {
        return (this.p1);
    }
    
    public Point getP2 () {
        return (this.p2);
    }
    
    public double longueur () {
        return (sqrt(((this.p2.getPx()-this.p1.getPx())*(this.p2.getPx()-this.p1.getPx()))+(this.p2.getPy()-this.p1.getPy())*(this.p2.getPy()-this.p1.getPy())));
    }
    
    public String toString() {
        return ("Segment("+this.p1+","+this.p2+","+this.longueur()+")");
    }
    
    public void draw(Graphics2D g) {
        BasicStroke line=new BasicStroke(3);
        g.setStroke(line);
        g.setColor(Color.green);
        g.drawLine((int)this.p1.getPx(), (int)this.p1.getPy(), (int)this.p2.getPx(), (int)this.p2.getPy());
    }
    
}


//TERRAIN
package Terrain;
import javax.swing.*;
import java.awt.*;
public class Terrain {
    private int nombreTriangle;
    private Triangle [] sol;
    
    public Terrain() {
        this.nombreTriangle=1;
        this.sol=new Triangle [this.nombreTriangle];
        this.sol[0]=new Triangle();
    }
    
    public Terrain(Triangle sol) {
        this.nombreTriangle=1;
        this.sol=new Triangle [this.nombreTriangle];
        this.sol[0]=sol;
    }
    
    public Terrain(Triangle[] sol) {
        this.nombreTriangle=sol.length;
        this.sol=new Triangle [this.nombreTriangle];
        this.sol=sol;     
        }
    
    public int getNombreTriangle() {
        return(this.nombreTriangle);
    }
    
    public Triangle[] getSol() {
        return(this.sol);
    }
    
    public Triangle getSolSpe(int numTriangle) {
        return(this.sol[numTriangle]);
    }
    
    public void draw(Graphics2D g) {
        BasicStroke line=new BasicStroke (3);
        g.setStroke(line);
        g.setColor(Color.green);
        int i;
        for (i=0;i<this.nombreTriangle;i++) {
            g.drawLine((int)this.sol[i].getP1().getPx(), (int)this.sol[i].getP1().getPy(), (int)this.sol[i].getP2().getPx(), (int)this.sol[i].getP2().getPy());
            g.drawLine((int)this.sol[i].getP2().getPx(), (int)this.sol[i].getP2().getPy(), (int)this.sol[i].getP3().getPx(), (int)this.sol[i].getP3().getPy());
            g.drawLine((int)this.sol[i].getP3().getPx(), (int)this.sol[i].getP3().getPy(), (int)this.sol[i].getP1().getPx(), (int)this.sol[i].getP1().getPy());

        }
    } 
}

//TRIANGLE

package Terrain;
import java.util.concurrent.atomic.AtomicInteger;
public class Triangle {
    
    private Point p1;
    private Point p2;
    private Point p3;
    private Segment s1;
    private Segment s2;
    private Segment s3;
    private int nT;
    private static AtomicInteger nextId=new AtomicInteger();
    
    public Triangle() {
        this.p1=new Point();
        this.p2=new Point();
        this.p3=new Point();
        this.s1=new Segment();
        this.s2=new Segment();
        this.s3=new Segment();
        this.nT=nextId.incrementAndGet()-1;
    }
    
    public Triangle(Point p1, Point p2,Point p3) {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.s1=new Segment(p1,p2);
        this.s2=new Segment(p2,p3);
        this.s3=new Segment(p3,p1);
        this.nT=nextId.incrementAndGet()-1;
    }
    
    public Point getP1() {
        return(this.p1);
    }
    
    public Point getP2() {
        return(this.p2);
    }
    
    public Point getP3() {
        return(this.p3);
    }
    
    public Segment getS1() {
        return(this.s1);
    }
    
    public Segment getS2() {
        return(this.s2);
    }
    
    public Segment getS3 () {
        return(this.s3);
    }
    
    public int getNT() {
        return(this.nT);
    }
    
    public void setNT(int nT) {
        this.nT=nT;
    }
    
    public String toString() {
        return("Triangle;"+this.nT+";"+this.p1+";"+this.p2+";"+this.p3);
    }
}


//ZONECONSTRUCTIBLE

package Terrain;
public class ZoneConstructible {
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;
    
    public ZoneConstructible (double xmin, double xmax, double ymin, double ymax) {
        this.xmin=xmin;
        this.xmax=xmax;
        this.ymin=ymin;
        this.ymax=ymax;                
    }
    
    public double getXmin() {
        return xmin;
    }
    
    public double getXmax() {
        return xmax;
    }
    
    public double getYmin() {
        return ymin;
    }
    
    public double getYmax() {
        return ymax;
    }
    
    public String toString() {
        return("Zone Constructible: "+this.xmin+";"+this.xmax+";"+this.ymin+";"+this.ymax+";");
    }
}


//(TREILLIS)
//BARRE
package Treillis;
import java.util.concurrent.atomic.AtomicInteger;
import Terrain.*;
import java.awt.*;
import Terrain.Point;

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
    
    public void draw(Graphic2D g) {
        BasicStroke line=new basicStroke(5);
        g.setStroke(line);
        g.setColor(Color.blue);
        g.drawLine((int)this.n1.getNx(), (int)this.n1.getNy(), (int)this.n2.getNx(), (int)this.n2.getNy());
    }
    
    public double getAngle (Barre b2) {
        double angle=Math.atan2(b2.getN2().getNy()-b2.getN1().getNy(), b2.getN2().getNx()-b2.getN1().getNx()) - Math.atan2(this.getN2().getNy()-this.getN1()getNy(), this.getN2().getNx()-this.getN1()getNx() )., nB)
    }
    
}
