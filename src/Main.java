package src;

class Main {

		public static void main(String args[]) {

		CoordinateListMatrix m1 = new CoordinateListMatrix(); 
		RowWiseListMatrix m2 = new RowWiseListMatrix();

		
		// BASIC TESTS
		System.out.println("\n=> BASIC TESTS:\n");
		
		try {
			
			m1.Parse("../examples/3x3.txt");
			m2.Parse("../examples/5x5.txt");
			
			System.out.println("\nCoordinate Linked List Matrix:\n");
			m1.display();
			System.out.println("\nDeterminant : " + m1.determinant());
			System.out.println("\nAnd it's transposed:\n");
			m1.transpose();
			m1.display();
			System.out.println("\nTransposed Determinant : " + m1.determinant());
			m1.transpose();
			
			System.out.println("\n\nRow Wise Linked List Matrix:\n");
			m2.display();
			System.out.println("\nDeterminant : " + m2.determinant());
			System.out.println("\nAnd it's transposed:\n");
			m2.transpose();
			m2.display();
			System.out.println("\nTransposed Determinant : " + m2.determinant());
			m2.transpose();
			
		}
		catch(Exception err) {
			System.out.println("Error: " + err);
			return;
		}
		
		// NON-SQUARE TESTS
		System.out.println("\n\n=> NON-SQUARE TESTS:\n");
		
		CoordinateListMatrix m3 = new CoordinateListMatrix(); 
		RowWiseListMatrix m4 = new RowWiseListMatrix();

		try {
			m3.Parse("../examples/2x5.txt");
			m4.Parse("../examples/1x2.txt");

			System.out.println("\nCoordinate Linked List Matrix:\n");
			m3.display();
			System.out.println("\nAnd it's transposed:\n");
			m3.transpose();
			m3.display();
			System.out.println("\nAnd the transposed's transposed:\n");
			m3.transpose();
			m3.display();

			
			System.out.println("\n\nRow Wise Linked List Matrix:\n");
			m4.display();
			System.out.println("\nAnd it's transposed:\n");
			m4.transpose();
			m4.display();
			m4.transpose();
			System.out.println("\nAttempting to get determinant...\n");
			m3.determinant();
		}
		catch(Exception err) {
			System.out.println("Error: " + err.getMessage());
		}
		
		// LARGE MATRIX TEST
		System.out.println("\n\n=> LARGE MATRIX TEST:");
		System.out.println("Using the example given...\n");
		
		CoordinateListMatrix m5 = new CoordinateListMatrix(); 
		RowWiseListMatrix m6 = new RowWiseListMatrix();

		try {
			m5.Parse("../examples/matrix.txt");
			m6.Parse("../examples/matrix.txt");

			System.out.println("\nCoordinate Linked List Matrix:\n");
			System.out.println("\nDeterminant: " + m5.determinant());
			m5.transpose();
			System.out.println("The transposed's determinant: " + m5.determinant() + "\n");
			m5.transpose();
			
			
			System.out.println("\n\nRow Wise Linked List Matrix:\n");
			System.out.println("\nDeterminant: " + m6.determinant());
			m6.transpose();
			System.out.println("The transposed's determinant: " + m6.determinant() + "\n");
			m6.transpose();

		}
		catch(Exception err) {
			System.out.println("Error: " + err.getMessage());
		}
	}
}
