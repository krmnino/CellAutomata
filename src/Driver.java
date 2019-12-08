import java.util.Random;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner enter = new Scanner(System.in);
		int gridSize = 30;
		Organism[][] grid = new Organism[gridSize][gridSize];
		int cycles = 0;		
		populateGrid(grid, gridSize);
		System.out.println("PRESS ENTER TO START SIMULATION");
		while(true)
		{
			enter.nextLine(); //comment this line if you don't want to press enter to execute a new time step
			printGrid(grid, cycles);
			for(int i = 0; i < gridSize; i++)
			{
				for(int j = 0; j < gridSize; j++)
				{
					if(grid[i][j] == null)
					{
						continue;
					}
					else if(grid[i][j].getActivity() == true)
					{
						grid[i][j].setActivity(false);
					}
				}
			}
			for(int i = 0; i < gridSize; i++)
			{
				for(int j = 0; j < gridSize; j++)
				{
					if(grid[i][j] == null)
					{
						continue;
					}
					else 
					{
						grid[i][j].breed(grid, i, j, gridSize);
						grid[i][j].move(grid, i, j, gridSize);
					}
				}
			}
			cycles++;
		}
	}
	public static void printGrid(Organism[][] g, int cycles)
	{
		System.out.println("\n\n\n");
		String pg = "";
		for(int i = 0; i < g.length; i++)
		{
			for(int j = 0; j < g[0].length; j++)
			{
				if(g[i][j] == null)
				{
					pg += " ";
				}
				else
				{
					pg += g[i][j]+ " ";
				}
			}
			pg += "\n";
		}
		pg += "=============\nCycles: " + cycles;
		System.out.println(pg);
	}
	public static void populateGrid(Organism[][] g, int gs)
	{
		Random rand = new Random(); 
		for(int i = 0; i < 150; i++)
		{
			while(true)
			{
				int x = rand.nextInt(gs);
				int y = rand.nextInt(gs);
				if(g[x][y] == null)
				{
					g[x][y] = new Prey(x, y);
					break;
				}
			}
		}
		for(int i = 0; i < 10; i++)
		{
			while(true)
			{
				int x = rand.nextInt(gs);
				int y = rand.nextInt(gs);
				if(g[x][y] == null)
				{
					g[x][y] = new Predator(x, y);
					break;
				}
			}
		}
	}
}