package src;

public interface Matrix {

	int rows();
	int cols();
	void setRows(int n);
	void setCols(int n);



	void add(int row, int col, double data);
	void print();

	double get(int row, int col);
	double superGet(int row, int col); // doesnt check wether the index is inside the matrix
	void set(int row, int col, double val);
	void superSet(int row, int col, double val); // doesnt check wether the index is inside the matrix
	
	Matrix reducedMatrix(int row, int col); // returns the matrix but without the specified row and column 

	default void display() {
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

	default void transpose()
	{
		int size = cols()>=rows()?cols():rows();
		int i = 1; 
		int j = 2;
		int temp = rows();
		setRows(cols());
		setCols(temp);
		while (i < size && j < size)
		{
			int a = i;
			while (a <= rows()) {
				int b = j;
				while (b <= cols()) {
					double x = superGet(a, b);
					superSet(a, b, superGet(b, a));
					superSet(b, a, x);
					b++;
				}
				a++;
			}
			i++;
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

	default double recLaplace() {
		if (rows() == 2)
			return (get(1, 1) * get(2, 2) - get(1,2) * get(2, 1));
		else {
			int i = 1;
			double det = 0;
			while (i <= rows()) {
				if (get(1, i) != 0)
					{
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
}
