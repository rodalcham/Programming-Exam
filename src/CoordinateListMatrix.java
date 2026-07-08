package src;
public class CoordinateListMatrix implements Matrix{

	private static class CoordinateListNode {
		int row;
		int col;
		double data;
		CoordinateListNode next;

		public CoordinateListNode(int row, int col, double data) {
			this.row = row;
			this.col = col;
			this.data = data;
			this.next = null;
		}
	}

	int rows;
	int cols;
	CoordinateListNode head = null;

	public CoordinateListMatrix() {

	}

	public int rows() {
		return rows;
	}
	
	public int cols() {
		return cols;
	}

	public void setRows(int n) {
		rows = n;
	}
	
	public void setCols(int n) {
		cols = n;
	}

	public void add(int row, int col, double data) {
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new IndexOutOfBoundsException("Out of bounds");
		if (data == 0)
			return;
		if (head == null) {
			head = new CoordinateListNode(row, col, data);
		}
		else {
			CoordinateListNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new CoordinateListNode(row, col, data);
		}
	}

	public void print() {
		CoordinateListNode curr = head;
			while (curr != null) {
				System.out.println("Row: " + curr.row + " Col: " + curr.col + " Val: " + curr.data);
				curr = curr.next;
			}
	}

	public double get(int row, int col){
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new IndexOutOfBoundsException("Out of bounds");
		CoordinateListNode curr = head;
		while (curr != null) {
			if (row == curr.row && col == curr.col) {
				return curr.data;
			}
			curr = curr.next;
		}
		return 0;
	}

	public double superGet(int row, int col){
		if (row < 1 || col < 1)
			throw new IndexOutOfBoundsException("Out of bounds");
		CoordinateListNode curr = head;
		while (curr != null) {
			if (row == curr.row && col == curr.col) {
				return curr.data;
			}
			curr = curr.next;
		}
		return 0;
	}

	public void set(int row, int col, double val){
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new IndexOutOfBoundsException("Out of bounds");
		CoordinateListNode curr = head;
		CoordinateListNode prev = null;
		while (curr != null) {
			if (row == curr.row && col == curr.col) {
				if (val == 0){
					if (prev != null)
						prev.next = curr.next;
					else
						head = curr.next;
				}
				else {
					curr.data = val;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		add(row, col, val);
	}
	
	public void superSet(int row, int col, double val){
		if (row < 1 || col < 1 )
			throw new IndexOutOfBoundsException("Out of bounds");
		CoordinateListNode curr = head;
		CoordinateListNode prev = null;
		while (curr != null) {
			if (row == curr.row && col == curr.col) {
				if (val == 0){
					if (prev != null)
						prev.next = curr.next;
					else
						head = curr.next;
				}
				else {
					curr.data = val;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		add(row, col, val);
	}

	public CoordinateListMatrix reducedMatrix(int row, int col) {
		if (head == null)
			return null;

		CoordinateListMatrix ret = new CoordinateListMatrix();
		ret.setRows(rows - 1);
		ret.setCols(cols - 1);

		CoordinateListNode old = head;
		while (old != null) {
			if (old.row != row && old.col != col) {
				int newRow = old.row;	
				int newCol = old.col;	
				if (newRow > row)
					newRow--;
				if (newCol > col)
					newCol--;
				ret.add(newRow, newCol, old.data);
				}
			old = old.next;
		}
		return ret;
	}
}
