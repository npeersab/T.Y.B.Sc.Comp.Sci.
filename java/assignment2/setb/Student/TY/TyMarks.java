package TY;

public class TyMarks {

	private int php, java, oose, cn, syspro, tcs;

	public TyMarks(int p, int j, int o, int c, int s, int t) {

		php = p;
		java = j;
		oose = o;
		cn = c;
		syspro = s;
		tcs = t;
	}
	
	public int getTotal() {

		return php + java + oose + cn + syspro + tcs;
	}
}
