package setB.que2.TY;

// class file to store ty marks
public class TyMarks {
	private int php, java, oose, cn, syspro, tcs;

	// parameterized constructor
	public TyMarks(int php, int java, int oose, int cn, int syspro, int tcs) {
		this.php = php;
		this.java = java;
		this.oose = oose;
		this.cn = cn;
		this.syspro = syspro;
		this.tcs = tcs;
	}

	// return total marks
	public int getTotal() {
		return php + java + oose + cn + syspro + tcs;
	}
}
