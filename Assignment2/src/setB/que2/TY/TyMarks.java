package setB.que2.TY;

// class file to store ty marks
public class TyMarks {
	private int php, java, oose, cn, syspro, tcs;

	// parameterized constructor
	public TyMarks(int p, int j, int o, int c, int s, int t) {
		php = p;
		java = j;
		oose = o;
		cn = c;
		syspro = s;
		tcs = t;
	}

	// return total marks
	public int getTotal() {
		return php + java + oose + cn + syspro + tcs;
	}
}
