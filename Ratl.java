/*
Andrew Krutke
z1756942
Due 11/12016
Csci 470 Section 1
File including all the functions to use
for fraction math!

*/



/**
 *
 * @author Andrew Krutke
 */
public final class Ratl {
    private int num;
    private int denom;

    //no arg constructor
    //set Ratl to 0/1
    public Ratl() {
        num = 0;
        denom = 1;
    }

    //two int constructor
    //creates a ratl with a value in num/denom
    public Ratl(int num, int denom) {

        // gcd(num, denom);        //check the gcd
        this.num = num;
        this.denom = denom;
        if (denom < 0) {
            Ratl.negate(this);         //negate if denome is negative
        }

        reduce();       //reduce the fraction

    }

    //ratl constuctor
    //builds a new Ratl with the same value as its input
    public Ratl(Ratl a) {
        this.num = a.num;
        this.denom = a.denom;
    }

    //num getters
    public int getNum() {
        return num;
    }

    //denom getter
    public int getDenom() {
        return denom;
    }

    //num setters
    public void setNum(int num) {
        this.num = num;
    }

    //denom setter
    public void setDenom(int denom) {
        this.denom = denom;
    }

    //convert to string for printing
    @Override
    public String toString() {
        //print out the proper numbers
        return String.format("%d/%d", num, denom);
    }

    //reduce the fraction
    public void reduce() {

        int gcd = gcd(num, denom);      //check the gcd for a reducing factor

        if (gcd > 1) {
            this.num = this.num / gcd;          //reduce the numerator and denomanator
            this.denom = this.denom / gcd;
        }

        return;
    }

    //helper function to find gcd
    public static int gcd(int a, int b) {

        if (a == 0 || b == 0) {
            return Math.abs(a);     //make sure it isnt negative
        }
        return gcd(b, a % b);       //return b when a gcd is found
    }

    //make a fraction negative properly
    public static Ratl negate(Ratl a) {

        a.num = -a.num;      //make num negative
        a.denom = a.denom * -1;   //clear the denom of negative

        return a;
    }

    //static invert
    //make a/b into b/a
    public static Ratl invert(Ratl a) {

        int newNum = a.num;
        int newDen = a.denom;

        a.num = newDen;
        a.denom = newNum;

        return a;
    }

    //add a ratl b to a fraction
    public void add(Ratl b) {
        this.num = (this.num * b.denom) + (b.num * this.denom);
        this.denom = (this.denom * b.denom);

        if (b.denom < 0) {          //check for proper format
            negate(b);
        }

        b.reduce();         //call reduce
    }

    //add two fractions
    public static Ratl add(Ratl a, Ratl b) {
        Ratl frac = new Ratl(0, 0);    //create a temp rat object to store

        frac.num = (a.num * b.denom) + (b.num * a.denom);
        frac.denom = (a.denom * b.denom);

        frac.reduce();        //call reduce to simplify fraction

        if (frac.denom < 0) {       //check for proper format
            negate(frac);
        }
        return frac;
    }

    //subtract rationals
    public void sub(Ratl b) {
        Ratl frac = new Ratl(0, 0);
        this.num = frac.num;       //set b object to current input
        this.denom = frac.denom;

        if (frac.denom < 0) {      //check for proper format of fraction
            negate(b);
        }

        negate(frac);              //call negate to make adding acceptable
        add(frac);
        frac.reduce();               //reduce fraction to lowest form
    }

    //subtract fractions
    public static Ratl sub(Ratl a, Ratl b) {

        Ratl frac = new Ratl(0, 0);             //create temp fields
        Ratl frac2 = new Ratl(0, 0);

        frac.num = a.num;                       //store num and denom
        frac.denom = a.denom;
        frac2.num = b.num;
        frac2.denom = b.denom;

        negate(frac2);                          //negate a fraction to add a postive 
        frac = add(frac, frac2);                //to a negative

        if (frac.denom < 0) //check for negative denom
        {
            negate(frac2);
        }

        frac.reduce();              //reduce the fraction

        return frac;
    }

    //mult
    public void mult(Ratl b) {

        this.num = (this.num * b.num);          //MULTIPLE FRACTIONS!
        this.denom = (this.denom * b.denom);

        if (b.denom < 0) {          //check for proper format
            negate(b);
        }

        b.reduce();         //call reduce

    }

    //STATIC MULTIPLE!
    public static Ratl mult(Ratl a, Ratl b) {

        Ratl frac = new Ratl(0, 0);    //create a temp rat object to store

        frac.num = (a.num * b.num);
        frac.denom = (a.denom * b.denom);

        frac.reduce();        //call reduce to simplify fraction

        if (frac.denom < 0) {       //check for proper format
            negate(frac);
        }
        return frac;

    }

    public void div(Ratl b) {
        
      //   this.num = (this.num * b.num);          //MULTIPLE FRACTIONS!
     //    this.denom = (this.denom * b.denom);

      Ratl frac = new Ratl(0, 0);    //create a temp rat object to store

        frac.num = this.num;
        frac.denom = this.denom;
        
        invert(b);              //invert b
        frac.mult(b);           //use frac to call invert;
        
     
        if (frac.denom < 0) {          //check for proper format
            negate(frac);
        }

        frac.reduce();         //call reduce

    }

    //divide fractions
    public static Ratl div(Ratl a, Ratl b) {

        Ratl frac = new Ratl(0, 0);             //create temp fields
        Ratl frac2 = new Ratl(0, 0);

        frac.num = a.num;                       //store num and denom
        frac.denom = a.denom;                   //in temp fields
        frac2.num = b.num;
        frac2.denom = b.denom;

        invert(frac2);                  //invert the fraction of b

        frac = mult(frac, frac2);       //call mult on new invertaed frac2

        if (frac.denom < 0) {       //check for proper format
            negate(frac);
        }

        frac.reduce();              //reduce that thing!

        return frac;
    }
}

