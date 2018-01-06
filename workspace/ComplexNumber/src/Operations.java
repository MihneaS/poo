
public class Operations {
	public ComplexNumber ad(ComplexNumber z1, ComplexNumber z2){
		ComplexNumber z3 = new ComplexNumber();
		z3.re = z1.re + z2.re;
		z3.im = z1.im + z2.im;
		return z3;
	}
	
	public ComplexNumber mult(ComplexNumber z1, ComplexNumber z2) {
		ComplexNumber z3 = new ComplexNumber();
		z3.re = z1.re*z2.re - z1.im*z2.im;
		z3.im = z1.re*z2.im + z1.im*z2.re;
		return z3;
	}
	
	public static void main (String[] args){
		ComplexNumber z1 = new ComplexNumber();
		ComplexNumber z2 = new ComplexNumber();
		Operations op = new Operations();
		z1.im = 2;
		z1.re = 2;
		z2.im = 5;
		z2.re = 5;
		ComplexNumber z3 = op.ad(z1, z2);
		ComplexNumber z4 = op.mult(z1, z2);
		System.out.println(z3.re + " " + z3.im);
		System.out.println(z4.re + " " + z4.im);
	}
}
