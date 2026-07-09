package src;

import java.io.BufferedReader;
import java.io.FileReader;

public interface Matrix {

	int rows();
	int cols();
	void setRows(int n);
	void setCols(int n);

	void add(int row, int col, double data)  throws Exception;

	double get(int row, int col)  throws Exception;
	double superGet(int row, int col)  throws Exception; // doesnt check wether the index is inside the matrix
	void set(int row, int col, double val)  throws Exception;
	void superSet(int row, int col, double val)  throws Exception; // doesnt check wether the index is inside the matrix
	
	Matrix reducedMatrix(int row, int col) throws Exception; // returns the matrix but without the specified row and column 

	void init(int r, int c);

	default void display()  throws Exception{
		int i = 1;
		while (i <= rows()) {
			int j = 1;
			while (j <= cols()) {
				System.out.print(get(i, j) + " ");
				j++;
			}
			System.out.println("");
			i++;
		}
	}

	default void superDisplay()  throws Exception{
		int i = 1;
		int max = rows()>=cols()?rows():cols();
		while (i <= max) {
			int j = 1;
			while (j <= max) {
				System.out.print(superGet(i, j) + " ");
				j++;
			}
			System.out.println("");
			i++;
		}
	}

	default void transpose() throws Exception
	{
		int size = cols()>=rows()?cols():rows();
		int a = 1;
		int j = 2;
		int temp = rows();
		setRows(cols());
		setCols(temp);

		while (a <= size) {
			int b = j;
			while (b <= size) {
				double x = superGet(a, b);
				superSet(a, b, superGet(b, a));
				superSet(b, a, x);
				b++;
			}
			a++;
			j++;
		}
		}


	default double determinant() throws Exception{
		if (rows() != cols())
			throw new Exception("Determinant undefined for non-sqaure matrices.");
		if (rows() == 1)
			return get(1, 1);
		return recLaplace();
	}
	
	default double recLaplace()  throws Exception{
		if (rows() == 2)
			return (get(1, 1) * get(2, 2) - get(1,2) * get(2, 1));
		else {
			int i = 1;
			double det = 0;
			while (i <= rows()) {
				if (get(1, i) != 0) {
					if (i % 2 != 0)
						det += get(1, i) * reducedMatrix(1, i).recLaplace();
					else
						det -= get(1, i) * reducedMatrix(1, i).recLaplace();
				}
				i++;
			}
				return det;
		}
	}

	default void Parse(String filename) throws Exception {
		int row, col;
		double val;
		String[] parts;
		
		BufferedReader reader = new BufferedReader(new FileReader((filename)));
		String line = reader.readLine();
		
		// First extracting the size of the matrix
		if (line == null) {
			reader.close();
			throw new Exception("Invalid input");
		}
		parts = line.split(" ");
		if (parts.length != 2){
			reader.close();
			throw new Exception("Invalid input"); 
		}
		try {
			row = Integer.parseInt(parts[0]);
			col = Integer.parseInt(parts[1]);
		}
		catch(NumberFormatException err) {
			reader.close();
			throw new Exception("Invalid input"); 
		}
		if (row <= 0 || col <= 0) {
			reader.close();
			throw new Exception("Invalid input"); 
		}
		init(row, col);
		
		// Now taking each line out
		line = reader.readLine();
		while (line != null) {
			parts = line.split(" ");
			if (parts.length != 3){
				reader.close();
				throw new Exception("Invalid input"); 
			}
			try {
				row = Integer.parseInt(parts[0]);
				col = Integer.parseInt(parts[1]);
				val = Double.parseDouble(parts[2]);
			}
			catch(NumberFormatException err) {
				reader.close();
				throw new Exception("Invalid input"); 
			}
			if (row < 1 || col < 1) {
				reader.close();
				throw new Exception("Invalid input"); 
			}
			set(row, col, val);
			line = reader.readLine();
		}

		reader.close();
	}
}
