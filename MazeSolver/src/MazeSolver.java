import java.util.ArrayList;
import java.util.LinkedList;

public class MazeSolver {
	
	public static void main(String[] args) {
		
		ArrayList<Maze> mazes= new ArrayList<>();
		
		Maze m = new Maze();
		
		int[][] mMaze = {
			{2, 1, 1, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 0, 0, 1}
		};
		m.maze = mMaze;
		m.start = new Position(0,7);
		m.path = new LinkedList<Position>();
		
		Maze n = new Maze();
		
		int[][] nMaze = {
			{2, 0, 1, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 0, 0, 1}
		};
		n.maze = nMaze;
		n.start = new Position(0,7);
		n.path = new LinkedList<Position>();
		
		mazes.add(m);
		mazes.add(n);
		
		for(Maze maze : mazes)
		{
			if(solveMaze(maze)) {
				System.out.println("Destination Found");
			}
			else {
				System.out.println("No path");
			}
		}

	}
	
	private static boolean solveMaze(Maze m) {
		
		Position p = m.start;
		m.path.push(p);
		
		while(true)
		{
			int y = m.path.peek().y;
			int x = m.path.peek().x;
			m.maze[y][x] = 0;
			
			//down
			if(isValid(y + 1, x, m)) {
				if(m.maze[y + 1][x] == 2) {
					System.out.println("Moved down");
					return true;
					
				}
				else{
					if(m.maze[y + 1][x] == 1) {
						System.out.println("Moved down");
						m.path.push(new Position(y+1, x));
						continue;
					}
		
				}
			}
			
			//left
			if(isValid(y, x - 1, m)) {
				if(m.maze[y][x - 1] == 2) {
					System.out.println("Moved left.");
					return true;
					
				}
				else{
					if(m.maze[y][x - 1] == 1) {
						System.out.println("Moved left");
						m.path.push(new Position(y, x - 1));
						continue;
					}
		
				}
			}
			
			//up
			if(isValid(y - 1, x, m)) {
				if(m.maze[y - 1][x] == 2) {
					System.out.println("Moved up");
					return true;
					
				}
				else{
					if(m.maze[y - 1][x] == 1) {
						System.out.println("Moved up");
						m.path.push(new Position(y - 1, x));
						continue;
					}
		
				}
			}
			
			//right
			if(isValid(y, x + 1, m)) {
				if(m.maze[y][x + 1] == 2) {
					System.out.println("Moved right");
					return true;
					
				}
				else{
					if(m.maze[y][x + 1] == 1) {
						System.out.println("Moved right");
						m.path.push(new Position(y, x + 1));
						continue;
					}
		
				}
			}
			
			
			m.path.pop();
			System.out.println("Moved back");
			if(m.path.size() <= 0)
			{
				return false;
			}
		}
		
	}

	public static boolean isValid(int y, int x, Maze m)
	{
		if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
			return false;
		}
		return true;
	}

}
