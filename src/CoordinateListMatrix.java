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

	public void add(int row, int col, double data) {
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
}
