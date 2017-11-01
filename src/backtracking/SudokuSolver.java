<<<<<<< HEAD
/*
 * SudokuSolver.java
 * --------------------------------------------------------------------------------------------------------------------
 * This program is used to solve a given sudoku riddle in form of an int array of variable size via backtracking.
 * 
 * Runtime:
 * Be keN the amount of already given ints in the field.
 * Given the best-case scenario, the minimum rutime is capped given via Om(((n-k)^3).
 * This is explained as we would have to fill (n-k)^2 fields and check each with isPossible() in 0(n).
 * 
 * Given the worst-case scenario, every single possible solution to the n^2 riddle would be needed to be given.
 * Therefore the runtime caps out at 0((n-k)^n). So please do not attempt to use this algorithm with large fields.
 */

package backtracking;

public class SudokuSolver {
	
	
	/*CONSTRUCTORS*/
	
	/**
	 * Constructor in case the algorithm is supposed to be started manually via the solve() method.
	 * @param sudokuField the given sudoku game as an int array.
	 */
	public SudokuSolver(int[][] sudokuField){
		this.field = sudokuField;
		this.given = new boolean[field.length][field.length];
 	}
	/**
	 * Constructor which immediately starts the solving process, unless the given boolean is false.
	 * This constructor is recommended for public use.
	 * 
	 * @param sudokuField the given sudoku game as an int array
	 * @param solve the boolean
	 */
	public SudokuSolver(int[][] sudokuField, boolean solve){
		this.field = sudokuField;
		this.given = new boolean[field.length][field.length];
		if(solve)solve();
 	}
	
	
	/*MAIN METHODS*/
	
	/**
	 * Runs the solving algorithm. but does not return the resulting solution.
	 */
	public void solve(){
		for(int i = 0; i < field.length; i++){
			for(int j = 0; j < field[i].length; j++){
				if(field[i][j] != 0)given[i][j] = true;
			}
		}
		insert(0,0);
	}
	
	/**
	 * Runs the solving algorithm and returns the solution.
	 * This method is recommended for outside users.
	 * 
	 * @return the solved sudoku riddle as an int[][].
	 */
	public int[][] getSolution(){
		solve();
		return getSudokuField();
	}
	

	/*SECONDARY METHODS*/
	
	/**
	 * This method is the primary form of the algorithm.
	 * It is subject to change as optimization is often found through constant improvement.
	 * The basic algorithm follows a recursive backtracking pattern in which it uses brute-force and tryouts.
	 * 
	 * @param x 
	 * @param y
	 */
	private void insert(int x, int y){
		if(given[x][y]){	//constant value
			if(x == field.length - 1 && y == field.length - 1){ //reached last field
				return;
			}else if(y == field.length - 1){ //new line
				insert(x++, 0);
				return;
			}else{ //next field
				insert(x, y++);
				return;
			}
		}		
		if(x == field.length - 1 && y == field.length - 1){	//variable
			success = true;
			return;
		}else{
			while(field[x][y] <= field.length){
				if(success)return;
				field[x][y]++;
				if(isPossible(x,y)){
					//if-tree
					if(y == field.length - 1){ //new line
						insert(x++, 0);
						return;
					}else{ //next field
						insert(x, y++);
						return;
					}
				}
			}
			field[x][y] = 0;
			return;
		}
	}
	
	/**
	 * Checks if a possible solution is not interfering with any of the given numbers in the field iteratively.
	 * Runtime is 0(n). Only use this method with valid fields, as it also evaluates the -1 integer.
	 * 
	 * @param x the x pos of the given number in the sudoku field
	 * @param y the y pos of the given number in the sudoku field
	 * @return false if there is a number blocking yours and true if the move was legal.
	 */
	private boolean isPossible(int x, int y){
		for(int i = 0; i < field.length; i++){
			if(field[x][i] == field[x][y] && i != y){ //checks the horizontal
				return false;
			}
			if(field[i][y] == field[x][y] && i != x){ //checks the vertical
				return false;
			}
		}
		for(int i = 0; i < 4; i++){ //checks the 4 diagonal lines from the given point
			int xi = x;
			int yi = y;
			while(xi < field.length - 1 && yi < field.length - 1 && xi > 0 &&  yi > 0){
				switch(i){
				case 0:	//upper left
					xi--; yi--;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 1:	//upper right
					xi--; yi++;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 2:	//lower left
					xi++; yi--;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 3:	//lower right
					xi++; yi++;
					if(field[xi][yi] == field[x][y])return false;
					break;
				}
			}
		}
		return true;
	}
	
	/**
	 * Private method for developer to check the outcome of their changes to the algorithm.
	 * Goes through the solution and checks if all fields are correct.
	 * Runtime is capped at 0(n^3).
	 * 
	 * @return true if the solution is correct, false otherwise
	 */
	private boolean errorCheck(){
		for(int i = 0; i < field.length; i++){ 
			for(int j = 0; j < field.length; j++){ 
				if(!isPossible(i, j) || field[i][j] == -1)return false;
			}
		}
		return true;
	}
	
	
	/*INSTANCE VARIABLES*/
	private int[][] field;
	private boolean[][] given; //original sudoku field to check if current field is set
	private boolean success;
	
	
	/*GETTERS-AND-SETTERS*/
	public int[][] getSudokuField(){
		return field;
	}
	public void setSudokuField(int[][] newField){
		this.field = newField;
	}
}
=======
/*
 * SudokuSolver.java
 * --------------------------------------------------------------------------------------------------------------------
 * This program is used to solve a given sudoku riddle in form of an int array of variable size via backtracking.
 * 
 * Runtime:
 * Be keN the amount of already given ints in the field.
 * Given the best-case scenario, the minimum rutime is capped given via Om(((n-k)^3).
 * This is explained as we would have to fill (n-k)^2 fields and check each with isPossible() in 0(n).
 * 
 * Given the worst-case scenario, every single possible solution to the n^2 riddle would be needed to be given.
 * Therefore the runtime caps out at 0((n-k)^n). So please do not attempt to use this algorithm with large fields.
 */

package backtracking;

public class SudokuSolver {
	
	
	/*CONSTRUCTORS*/
	
	/**
	 * Constructor in case the algorithm is supposed to be started manually via the solve() method.
	 * @param sudokuField the given sudoku game as an int array.
	 */
	public SudokuSolver(int[][] sudokuField){
		this.field = sudokuField;
		this.given = sudokuField;
 	}
	/**
	 * Constructor which immediately starts the solving process, unless the given boolean is false.
	 * This constructor is recommended for public use.
	 * 
	 * @param sudokuField the given sudoku game as an int array
	 * @param solve the boolean
	 */
	public SudokuSolver(int[][] sudokuField, boolean solve){
		this.field = sudokuField;
		this.given = sudokuField;
		if(solve)solve();
 	}
	
	
	/*MAIN METHODS*/
	
	/**
	 * Runs the solving algorithm. but does not return the resulting solution.
	 */
	public void solve(){
		for(int i = 0; i < field.length; i ++){ //checks if the sudoku field is according to the rules
			if(field[i].length != field.length){
				return;
			}
		}
		insert(0,0);
	}
	
	/**
	 * Runs the solving algorithm and returns the solution.
	 * This method is recommended for outside users.
	 * 
	 * @return the solved sudoku riddle as an int[][].
	 */
	public int[][] getSolution(){
		solve();
		return getSudokuField();
	}
	

	/*SECONDARY METHODS*/
	
	/**
	 * This method is the primary form of the algorithm.
	 * It is subject to change as optimization is often found through constant improvement.
	 * The basic algorithm follows a recursive backtracking pattern in which it uses brute-force and tryouts.
	 * 
	 * @param x 
	 * @param y
	 */
	private void insert(int x, int y){
		if(field[x][y] == given[x][y]){	//constant value
			//if-tree
			if(x == field.length - 1 && y == field.length - 1){ //reached last field
				return;
			}else if(y == field.length - 1){ //new line
				insert(x++, 0);
				return;
			}else{ //next field
				insert(x, y++);
				return;
			}
		}		
		if(x == field.length - 1 && y == field.length - 1){	//variable
			success = true;
			return;
		}else{
			while(field[x][y] <= field.length){
				if(success)return;
				field[x][y]++;
				if(isPossible(x,y)){
					//if-tree
					if(y == field.length - 1){ //new line
						insert(x++, 0);
						return;
					}else{ //next field
						insert(x, y++);
						return;
					}
				}
			}
			field[x][y] = 0;
			return;
		}
	}
	
	/**
	 * Checks if a possible solution is not interfering with any of the given numbers in the field iteratively.
	 * Runtime is 0(n). Only use this method with valid fields, as it also evaluates the -1 integer.
	 * 
	 * @param x the x pos of the given number in the sudoku field
	 * @param y the y pos of the given number in the sudoku field
	 * @return false if there is a number blocking yours and true if the move was legal.
	 */
	private boolean isPossible(int x, int y){
		for(int i = 0; i < field.length; i++){
			if(field[x][i] == field[x][y] && i != y){ //checks the horizontal
				return false;
			}
			if(field[i][y] == field[x][y] && i != x){ //checks the vertical
				return false;
			}
		}
		for(int i = 0; i < 4; i++){ //checks the 4 diagonal lines from the given point
			int xi = x;
			int yi = y;
			while(xi < field.length - 1 && yi < field.length - 1 && xi > 0 &&  yi > 0){
				switch(i){
				case 0:	//upper left
					xi--; yi--;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 1:	//upper right
					xi--; yi++;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 2:	//lower left
					xi++; yi--;
					if(field[xi][yi] == field[x][y])return false;
					break;
				case 3:	//lower right
					xi++; yi++;
					if(field[xi][yi] == field[x][y])return false;
					break;
				}
			}
		}
		return true;
	}
	
	/**
	 * Private method for developer to check the outcome of their changes to the algorithm.
	 * Goes through the solution and checks if all fields are correct.
	 * Runtime is capped at 0(n^3).
	 * 
	 * @return true if the solution is correct, false otherwise
	 */
	private boolean errorCheck(){
		for(int i = 0; i < field.length; i++){ 
			for(int j = 0; j < field.length; j++){ 
				if(!isPossible(i, j) || field[i][j] == -1)return false;
			}
		}
		return true;
	}
	
	
	/*INSTANCE VARIABLES*/
	private int[][] field;
	private final int[][] given; //remembers the original sudoku field for reference
	private boolean success;
	
	
	/*GETTERS-AND-SETTERS*/
	public int[][] getSudokuField(){
		return field;
	}
	public void setSudokuField(int[][] newField){
		this.field = newField;
	}
}
>>>>>>> e9a64c1c8635925534704892c1ce7eb4e96c2a40
