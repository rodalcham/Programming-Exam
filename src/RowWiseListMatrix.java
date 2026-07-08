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

	


}