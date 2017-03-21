/*
Andrew Krutke
z1756942
Due 11/12016
Csci 470 Section 1
Test  driver to create a bunch of fraction math!

*/


public class Hw3{
    public static void main(String[] args) {
        
       

        Ratl a = new Ratl(3, 5);
        Ratl b = new Ratl(7, 11);

        Ratl j = new Ratl(5, -25);
        
        j.reduce();
       
        
        System.out.println(a);
        System.out.println(b);

        System.out.println(j);
        
     
        
      Ratl c;
      c = Ratl.add(j, b);
      
      System.out.println(c);
     
      Ratl z;
      z = Ratl.sub(a, j);
      System.out.printf("static: %s - %s = %s%n", a, j, z);
      
      System.out.printf("static: %s + %s = %s%n", j, b, c);
      
      Ratl d = new Ratl(a);
      d.add(b);
      System.out.printf("member: %s + %s = %s%n%n", a, b, d);
      
      c = Ratl.sub(new Ratl(3, 5), new Ratl(7, 11));
      System.out.printf("3/5 - 7/11 = %s%n", c);

      c = Ratl.mult(new Ratl(3, 6), new Ratl(7, 11));
      System.out.printf("3/6 * 7/11 = %s%n", c);

      c = Ratl.div(new Ratl(7, 11), new Ratl(3, 6));
      System.out.printf("7/11 / 3/6 = %s%n%n", c);


      c = Ratl.div(new Ratl(7, 11), new Ratl(7, 11));
      System.out.printf("7/11 / 7/11 = %s%n", c);

      c = Ratl.div(new Ratl(14, 11), new Ratl(7, 11));
      System.out.printf("14/11 / 7/11 = %s%n", c);


      System.out.printf("%n");
      testGCD(6, 10);
      testGCD(6, 6);
      testGCD(10, 6);
      testGCD(6, 12);
      testGCD(6, 16);
      testGCD(3, 5);
      
      
   }

  public static void testGCD(int a, int b)
    {
        System.out.printf("gcd of %d and %d is %d%n", a, b,
                          Ratl.gcd(a, b));
        return;
}
    
    }
   

