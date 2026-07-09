package src;

class Main {

		public static void main(String args[]) {

		CoordinateListMatrix m1 = new CoordinateListMatrix(); 
		RowWiseListMatrix m2 = new RowWiseListMatrix();

		try {
			m1.Parse("../examples/2x5.txt");
			m2.Parse("../examples/3x3.txt");

			System.out.println("Coordinate Linked List Matrix:\n");
			m1.display();
			System.out.println("\nAnd it's transposed:\n");
			m1.transpose();
			m1.display();
			m1.transpose();
			
			System.out.println("\nRow Wise Linked List Matrix:\n");
			m2.display();
			System.out.println("\nAnd it's transposed:\n");
			m2.transpose();
			m2.display();
			m2.transpose();

			// System.out.println("Determinant : " + m2.determinant());
			// m2.transpose();
			// System.out.println("Transposed Determinant : " + m2.determinant());
		}
		catch(Exception err) {
			System.out.println("Error: " + err);
			return;
		}

		
	// 	try {
	// 	}
	// 	catch (Exception err) {
	// 		System.out.println(err);
	// 		return;
	// 	}
	}
}

//TODO : Implement your own SPLIT or fix parsing