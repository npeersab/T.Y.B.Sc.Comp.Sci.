package SY;

public class SyMarks {

	private int comp, maths, elec, eng;

	public SyMarks(int c, int m, int e, int en) {
		
		comp = c;
		maths = m;
		elec = e;
		eng = en;
	}

	public int getTotal() {

		return comp + maths + elec + eng;

	}
}


	
