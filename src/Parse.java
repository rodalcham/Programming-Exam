package src;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Parse {

	public static void intoCoordinateList(String filename, CoordinateListMatrix matrix) throws IOException {
		int row, col;
		double val;
		String[] parts;

		BufferedReader reader = new BufferedReader(new FileReader((filename)));
		String line = reader.readLine();

		// First extracting the size of the matrix
		if (line == null) {
			reader.close();
			throw new IOException("Invalid input");
		}
		parts = line.split(" ");
		if (parts.length != 2){
			reader.close();
			throw new IOException("Invalid input"); 
		}
		try {
			row = Integer.parseInt(parts[0]);
			col = Integer.parseInt(parts[1]);
		}
		catch(NumberFormatException err) {
			reader.close();
			throw new IOException("Invalid input"); 
		}
		if (row < 0 || col < 0) {
			reader.close();
			throw new IOException("Invalid input"); 
		}
		matrix.rows = row;
		matrix.cols = col;
		
		// Now taking each line out
		line = reader.readLine();
		while (line != null) {
			parts = line.split(" ");
			if (parts.length != 3){
				reader.close();
				throw new IOException("Invalid input"); 
			}
			try {
				row = Integer.parseInt(parts[0]);
				col = Integer.parseInt(parts[1]);
				val = Double.parseDouble(parts[2]);
			}
			catch(NumberFormatException err) {
				reader.close();
				throw new IOException("Invalid input"); 
			}
			if (row < 0 || col < 0) {
				reader.close();
				throw new IOException("Invalid input"); 
			}
			matrix.add(row, col, val);
			line = reader.readLine();
		}

		reader.close();
	}

}
