<<<<<<< HEAD
/*
 * This class is solely for the purpose of testing and demoing the solver.
 * It might later on be the basis for an executable jar.
 */

import backtracking.SudokuSolver;

public class Main_Runner {
	public static void main(String[] args){
		int[][] sudoku = {
			//   1,2,3,4,5,6,7,8,9
				{0,0,0,0,0,0,0,0,0},	//1
				{0,0,0,0,0,0,0,0,0},	//2
				{0,0,0,0,0,0,0,0,0},	//3
				{0,0,0,0,0,0,0,0,0},	//4
				{0,0,0,0,0,0,0,0,0},	//5
				{0,0,0,0,0,0,0,0,0},	//6
				{0,0,0,0,0,0,0,0,0},	//7
				{0,0,0,0,0,0,0,0,0},	//8
				{0,0,0,0,0,0,0,0,0}		//9
		};
		SudokuSolver sol = new SudokuSolver(sudoku, true);
		printT(sol.getSudokuField());
	}
	
	private static void printT(int[][] table){
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				System.out.print(table[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
}
=======
import backtracking.SudokuSolver;

public class Main_Runner {
	public static void main(String[] args){
		int[][] sudoku = {	//6x6 sudoku
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1}				
		};
		SudokuSolver sol = new SudokuSolver(sudoku);
	}
}
>>>>>>> e9a64c1c8635925534704892c1ce7eb4e96c2a40
