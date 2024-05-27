import java.util.Scanner;

class ComplexNumbers{
	int real = 0;
	int imaginary = 0;
	public ComplexNumbers(int real, int imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}

	public void plus(ComplexNumbers c2){
		this.real = this.real + c2.real;
		this.imaginary= this.imaginary + c2.imaginary;
	}

	public void multiply(ComplexNumbers c2){
		int temp = this.real;
		this.real = ((this.real * c2.real) - (this.imaginary * c2.imaginary));

		// System.out.println(this.real); //-6
		// System.out.println(c2.imaginary); //2
		// System.out.println(c2.real); //1
		// System.out.println(this.imaginary); //5
		// System.out.println(this.imaginary = ((this.real * c2.imaginary) + (c2.real * this.imaginary)));
		// System.out.println(this.imaginary = ((this.real * c2.imaginary) ));
		// System.out.println(this.imaginary = ( (c2.real * this.imaginary) ));

		this.imaginary = ((temp * c2.imaginary) + (c2.real * this.imaginary));
	}

	public void print(){
		System.out.println(real + " + i" + imaginary);
	}
}

public class ComplexNumbersUse {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();
		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
}
