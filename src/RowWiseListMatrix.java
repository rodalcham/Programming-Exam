package src;

public class RowWiseListMatrix implements Matrix{

		private static class RowWiseListNode {
		int col;
		double data;
		RowWiseListNode next;

		public RowWiseListNode(int col, double data) {
			this.col = col;
			this.data = data;
			this.next = null;
		}
	}

	int rows;
	int cols;
	RowWiseListNode data[];
	
	public void init(int r, int c) {
		rows = r;
		cols = c;
		int max = r >= c ? r : c;
		data = new RowWiseListNode[max];
		for (int i = 0; i < rows; i++) {
			data[i] = null;
		}
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

	public void appendToList(int row,  int col, double val) {
		RowWiseListNode head = data[row - 1];

		if (head == null) {
			data[row - 1] = new RowWiseListNode(col, val);
		}
		else {
			RowWiseListNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new RowWiseListNode(col, val);
		}
	}
	
	public void add(int row, int col, double val) throws Exception{
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new Exception("Out of bounds");
		if (val == 0)
			return;
		appendToList(row, col, val);
	}

	public double get(int row, int col) throws Exception{
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new Exception("Out of bounds");
		RowWiseListNode curr = data[row - 1];
		while (curr != null) {
			if (col == curr.col) {
				return curr.data;
			}
			curr = curr.next;
		}
		return 0;
	}
	public double superGet(int row, int col) throws Exception{
		if (row < 1 || col < 1)
			throw new Exception("Out of bounds");
		RowWiseListNode curr = data[row - 1];
		while (curr != null) {
			if (col == curr.col) {
				return curr.data;
			}
			curr = curr.next;
		}
		return 0;
	}
	public void set(int row, int col, double val) throws Exception{
		if (row < 1 || col < 1 || row > rows || col > cols)
			throw new Exception("Out of bounds");
		RowWiseListNode curr = data[row - 1];
		RowWiseListNode prev = null;
		while (curr != null) {
			if (col == curr.col) {
				if (val == 0){
					if (prev != null)
						prev.next = curr.next;
					else
						data[row - 1] = curr.next;
				}
				else {
					curr.data = val;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		if (val != 0)
			add(row, col, val);
	}
	public void superSet(int row, int col, double val) throws Exception{
		if (row < 1 || col < 1)
			throw new Exception("Out of bounds");
		RowWiseListNode curr = data[row - 1];
		RowWiseListNode prev = null;
		while (curr != null) {
			if (col == curr.col) {
				if (val == 0){
					if (prev != null)
						prev.next = curr.next;
					else
						data[row - 1] = curr.next;
				}
				else {
					curr.data = val;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		if (val != 0)
			add(row, col, val);
	}
	
	public RowWiseListMatrix reducedMatrix(int row, int col) throws Exception{
		RowWiseListMatrix ret = new RowWiseListMatrix();
		ret.init(rows - 1, cols - 1);

		for (int i = 0; i < rows; i++) {
			if (i == rows)
				continue;
			RowWiseListNode old = data[i];
			while (old != null) {
				if (old.col != col) {
					int newRow = i;	
					int newCol = old.col;	
					if (newRow > row)
						newRow--;
					if (newCol > col)
						newCol--;
					ret.add(newRow, newCol, old.data);
					}
				old = old.next;
			}
		}
		return ret;
	}

}