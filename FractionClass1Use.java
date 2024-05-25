// package fraction;

class FractionClass1 {
    private int numer;
    private int denom;

    void setNumer(int numer){
        this.numer = numer;
    }
    void setDenom(int denom){
        this.denom = denom;
    }
    int getNumer(){
        return numer;
    }
    int getDenom(){
        return denom;
    }

    void print(){
        simplify();
        System.out.println(numer + "/" + denom);
    }

    private void simplify(){
        int gcd = 1;
        int smaller = Math.min(numer,denom);
        for (int i = 2; i < smaller; ++i){
            if ((numer % i == 0) && (denom % i == 0))
                gcd = i;
        }
        numer = numer/gcd;
        denom = denom/gcd;
    }

    void increment(){
        numer = numer + denom;
        simplify();
    }
    
    public void add(FractionClass1 f2){
        this.numer = (this.numer * f2.denom) + (f2.numer * this.denom);
        this.denom = this.denom * f2.denom;
        simplify();
    }

    public static FractionClass1 add(FractionClass1 f1, FractionClass1 f2){
        int newNumer = (f1.numer * f2.denom) + (f2.numer * f1.denom);
        int newDenom = f1.denom * f2.denom;
        FractionClass1 f3 = new FractionClass1();
        f3.setNumer(newNumer);
        f3.setDenom(newDenom);
        f3.simplify();
        return f3;
    }
    
}

public class FractionClass1Use {
    public static void main(String[] args) {
        FractionClass1 fr = new FractionClass1();
        fr.setNumer(4);
        fr.setDenom(6);
        System.out.println("Numerator is : " + fr.getNumer()); 
        System.out.println("Denominator is : " + fr.getDenom()); 
        System.out.print("The fraction is : "); 
        fr.print();

        // System.out.print("Incremented value is : " ); 
        // fr.increment();
        // fr.print();

        System.out.println("\n");
        
        FractionClass1 fr1 = new FractionClass1();
        fr1.setNumer(8);
        fr1.setDenom(3);
        System.out.println("Numerator is : " + fr1.getNumer()); 
        System.out.println("Denominator is : " + fr1.getDenom()); 
        System.out.print("The fraction is : "); 
        fr1.print();
        
        // System.out.print("Incremented value is : " ); 
        // fr1.increment();
        // fr1.print();

        System.out.println("\n");
        
        fr.add(fr1);
        System.out.print("The fraction sum using non-static add() is : "); 
        fr.print();
        
        System.out.println("\n");
        
        FractionClass1 f3 = FractionClass1.add(fr,fr1);
        System.out.print("The fraction sum using static add() is : "); 
        f3.print();
        
    }
}