package SY;

// class to store sy marks
public class SyMarks {

	private int comp, maths, elec, eng;

	// parametrized constructor
	public SyMarks(int c, int m, int e, int en) {
		
		comp = c;
		maths = m;
		elec = e;
		eng = en;
	}

	// return total of all marks
	public int getTotal() {

		return comp + maths + elec + eng;

	}
}


	
