package src;
import java.io.IOException;

class Main {

		public static void main(String args[]) {

		CoordinateListMatrix matrix = new CoordinateListMatrix(); 

		try {
			Parse.intoCoordinateList("../examples/matrix.txt", matrix);
		}
		catch(IOException err) {
			System.out.println("Error");
		}

		matrix.display();
		try {
			System.out.println("Det : " + matrix.determinant());
		}
		catch (Exception err) {
			System.out.println(err);
		}
		matrix.transpose();
		try {
			System.out.println("Trans Det : " + matrix.determinant());
		}
		catch (Exception err) {
			System.out.println(err);
		}
		// matrix.display();
	}
}

//TODO : Implement your own SPLIT or fix parsing