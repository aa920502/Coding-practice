// Problem


// Given a maze some of whose the cells are blocked. 
// The left top cell is the entry point and right bottom cell is the exit point. 
// Find the shortest path, if possible, from entry to exit through non blocked cells.
// For example
// Given maze

// _|_|_|_|_|#|_|_|_|_|
// _|_|#|_|#|_|_|_|#|#|
// _|#|_|_|_|#|#|#|_|#|
// _|#|_|_|_|#|_|_|#|_|
// #|_|#|#|_|_|_|_|_|_|
// #|_|_|_|_|_|_|#|_|_|
// #|_|_|#|_|_|_|_|_|_|
// #|_|_|_|_|_|_|_|#|_|
// _|_|_|#|_|#|#|_|_|#|
// #|#|#|#|_|#|_|_|_|_|

// Shortest path
// (0,1),(0,2),(0,3),(1,3),(2,3),(2,4),(3,4),(4,4),(4,5),(4,6),(5,6),(6,6),(6,7),(7,7),(8,7),(8,8),(9,8),(9,9)

import java.util.LinkedList;
import java.util.List;

public class Maze{

 	public static void main(String[] args){
		boolean[][] maze = new boolean[10][10];
		MakeRandomMaze(maze);
		PrintMaze(maze);
		List<LinkedList<Cell>> path = FindShortestPath(maze);
		if (path == null){
			System.out.println("No path possible");
			return;
		}
		System.out.println(path.size());

		if(path.size()>0){
			for(int i=0;i<path.size();i++){
				System.out.println(path.get(i).size());
			}
		}
		
	}

	private static LinkedList<LinkedList<Cell>> FindShortestPath(boolean[][] maze){
		
		int[][] levelMatrix = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; ++i){
			for (int j = 0; j < maze[0].length; ++j){
				levelMatrix[i][j] = maze[i][j] == true ? -1 : 0;
			}
		}

		// Use BFS to build level matrix
		LinkedList <Cell> queue = new LinkedList <>();
		Cell start = new Cell(0, 0);
		Cell end = new Cell(maze.length - 1, maze[0].length - 1);
		queue.add(start);
		levelMatrix[start.row][start.col] = 1;
		while (!queue.isEmpty()){
			Cell cell = queue.poll();
			if (cell == end)
				break;
			int level = levelMatrix[cell.row][cell.col];
			Cell[] nextCells = new Cell[4];
			nextCells[3] = new Cell(cell.row, cell.col - 1);
			nextCells[2] = new Cell(cell.row - 1, cell.col);
			nextCells[1] = new Cell(cell.row, cell.col + 1);
			nextCells[0] = new Cell(cell.row + 1, cell.col);

			for (Cell nextCell : nextCells){
				if (nextCell.row < 0 || nextCell.col < 0)
					continue;
				if (nextCell.row == maze.length || nextCell.col == maze[0].length)
			 		continue;
				if (levelMatrix[nextCell.row][nextCell.col] == 0){
			 		queue.add(nextCell);
			 		levelMatrix[nextCell.row][nextCell.col] = level + 1;
				}
			}
		}

		if (levelMatrix[end.row][end.col] == 0) return null;
		

		LinkedList<LinkedList<Cell>> path = new LinkedList<LinkedList<Cell>>();
		Cell cell = end;
		GetAllPath(path, new LinkedList<Cell>(), start, cell, levelMatrix, maze);

  		return path;
	}


	public static void GetAllPath(LinkedList<LinkedList<Cell>> path, LinkedList<Cell> tmp, Cell start, Cell cell,int[][] levelMatrix,boolean[][] maze){
		LinkedList<Cell> ll = new LinkedList<>();
		ll.addAll(tmp);
		ll.add(cell);
		if(cell.equals(start)){
			path.add(ll);
			return;
		}

		int level = levelMatrix[cell.row][cell.col];
		Cell[] nextCells = new Cell[4];
		nextCells[0] = new Cell(cell.row + 1, cell.col);
		nextCells[1] = new Cell(cell.row, cell.col + 1);
		nextCells[2] = new Cell(cell.row - 1, cell.col);
		nextCells[3] = new Cell(cell.row, cell.col - 1);
		for (Cell nextCell : nextCells){
			if (nextCell.row < 0 || nextCell.col < 0)
				continue;
			if (nextCell.row == maze.length|| nextCell.col == maze[0].length)
				continue;
			if (levelMatrix[nextCell.row][nextCell.col] == level - 1){
				GetAllPath(path, ll, start, nextCell, levelMatrix,maze);
			}
		}
	}

	private static void PrintMaze(boolean[][] maze){
		for (int i = 0; i < maze.length; ++i){
	   		for (int j = 0; j < maze[i].length; ++j){
	   			if (maze[i][j])
	     			System.out.print("#|");
	    		else
	     			System.out.print("_|");
	   		}
	   		System.out.println();
	  	}
	 }

	private static void MakeRandomMaze(boolean[][] maze){
		for (int i = 0; i < maze.length; ++i){
	   		for (int j = 0; j < maze[0].length; ++j){
	    		maze[i][j] = (int) (Math.random() * 3) == 1;
	   		}
	  	}
	  	maze[0][0] = false;
	  	maze[maze.length - 1][maze[0].length - 1] = false;
	}

	private static class Cell{
		public int row;
		public int col;

		public Cell(int row, int column){
	   		this.row = row;
	  		this.col = column;
	  	}

	  	@Override
	  	public boolean equals(Object obj){
		   	if (this == obj)
		    	return true;
		   	if ((obj == null) || (obj.getClass() != this.getClass()))
		    	return false;
		   	Cell cell = (Cell) obj;
		   	if (row == cell.row && col == cell.col)
		    	return true;
		   	return false;
		}

	  	@Override
	  	public String toString(){
	   		return "(" + row + "," + col + ")";
	  	}
	}

	
}
