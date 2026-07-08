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

		matrix.print();
	}
}
