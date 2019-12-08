import java.util.Random;

public class Prey extends Organism 
{
	Random rand = new Random();
	
	public Prey(int x_, int y_)
	{
		super(x_, y_, 0, true);
	}
	public void move(Organism[][] g, int x_, int y_, int gs) 
	{	
		if(g[x_][y_].getActivity() == false)
		{
			int range = gs - 1;
			int direction = 0;
			if(x_ == 0 && y_ == 0)
			{
				if(g[x_ + 1][y_] == null || g[x_][y_ + 1] == null || g[g[0].length - 1][y_] == null || g[x_][g.length - 1] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[x_][g.length - 1] == null)
						{
							teleportLeft(g, x_, y_);
							break;
						}
						else if(direction == 3 && g[g[0].length - 1][y_] == null)
						{
							teleportUp(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}	
			}
			else if(x_ == gs - 1 && y_ == 0)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null || g[0][y_] == null || g[x_][g.length - 1] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[0][y_] == null)
						{
							teleportRight(g, x_, y_);
							break;
						}
						else if(direction == 3 && g[x_][g.length - 1] == null)
						{
							teleportUp(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(x_ == 0 && y_ == gs - 1)
			{
				if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null || g[g[0].length - 1][y_] == null || g[x_][0] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[g[0].length - 1][y_] == null)
						{
							teleportLeft(g, x_, y_);
							break;
						}
						else if(direction == 3 && g[x_][0] == null)
						{
							teleportDown(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(x_ == gs - 1 && y_ == gs - 1)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null || g[0][y_] == null || g[x_][0] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[0][y_] == null)
						{
							teleportRight(g, x_, y_);
							break;
						}
						else if(direction == 3 && g[x_][0] == null)
						{
							teleportDown(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(x_ == 0)
			{
				if(g[x_][y_ - 1] == null || g[x_ + 1][y_] == null || g[x_][y_ + 1] == null || g[g[0].length - 1][y_] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							break;
						}		
						else if(direction == 3 && g[g[0].length - 1][y_] == null)
						{
							teleportLeft(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(x_ == gs - 1)
			{
				if(g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null || g[0][y_] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							break;
						}			
						else if(direction == 3 && g[0][y_] == null)
						{
							teleportRight(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(y_ == 0)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null || g[x_ + 1][y_] == null || g[x_][g.length - 1] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							break;
						}			
						else if(direction == 3 && g[x_][g.length - 1] == null)
						{
							teleportUp(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(y_ == gs - 1)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null || g[x_ + 1][y_] == null || g[x_][0] == null)
				{
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							break;
						}						
						else if(direction == 3 && g[x_][0] == null)
						{
							teleportDown(g, x_, y_);
							break;
						}
					}
				}
				else
				{
					g[x_][y_].addTimeStep();
				}
			}
			else if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
			{
				while(true)
				{
					direction = rand.nextInt(range);
					if(direction == 0 && g[x_ + 1][y_] == null)
					{
						moveRight(g, x_, y_);
						break;
					}
					else if(direction == 1 && g[x_][y_ - 1] == null)
					{
						moveUp(g, x_, y_);
						break;
					}
					else if(direction == 2 && g[x_ - 1][y_] == null)
					{
						moveLeft(g, x_, y_);
						break;
					}	
					else if(direction == 3 && g[x_][y_ + 1] == null)
					{
						moveDown(g, x_, y_);
						break;
					}
				}
			}
		}	
	}
	public void breed(Organism[][] g, int x_, int  y_, int gs) 
	{
		if(g[x_][y_].getSteps() >= 3)
		{
			int range = 0;
			int direction = 0;
			if(x_ == 0 && y_ == 0)
			{
				if(g[x_ + 1][y_] == null || g[x_][y_ + 1] == null)
				{
					range = 2;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Prey(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Prey(x_, y_ + 1);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
					}
				}
					
			}
			else if(x_ == gs - 1 && y_ == 0)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
				{
					range = 2;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Prey(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Prey(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
					}
				}
			}
			else if(x_ == 0 && y_ == gs - 1)
			{
				if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null)
				{
					range = 2;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Prey(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Prey(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
					}
				}
			}
			else if(x_ == gs - 1 && y_ == gs - 1)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null)
				{
					range = 2;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Prey(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Prey(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
					}
				}
			}
			else if(x_ == 0)
			{
				if(g[x_][y_ - 1] == null || g[x_ + 1][y_] == null || g[x_][y_ + 1] == null)
				{
					range = 3;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Prey(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Prey(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Prey(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}						
					}
				}
			}
			else if(x_ == gs - 1)
			{
				if(g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
				{
					range = 3;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Prey(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Prey(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Prey(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}						
					}
				}
			}
			else if(y_ == 0)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null || g[x_ + 1][y_] == null)
				{
					range = 3;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Prey(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Prey(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Prey(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}						
					}
				}
			}
			else if(y_ == gs - 1)
			{
				if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null || g[x_ + 1][y_] == null)
				{
					range = 3;
					while(true)
					{
						direction = rand.nextInt(range);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Prey(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Prey(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Prey(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}						
					}
				}
			}
			else if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
			{
				range = gs - 1;
				while(true)
				{
					direction = rand.nextInt(range);
					if(direction == 0 && g[x_ + 1][y_] == null)
					{
						g[x_ + 1][y_] = new Prey(x_ + 1, y_);
						g[x_ + 1][y_].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
					else if(direction == 1 && g[x_][y_ - 1] == null)
					{
						g[x_][y_ - 1] = new Prey(x_, y_ - 1);
						g[x_][y_ - 1].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
					else if(direction == 2 && g[x_ - 1][y_] == null)
					{
						g[x_ - 1][y_] = new Prey(x_ - 1, y_);
						g[x_ - 1][y_].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}	
					else if(direction == 3 && g[x_][y_ + 1] == null)
					{
						g[x_][y_ + 1] = new Prey(x_, y_ + 1);
						g[x_][y_ + 1].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
				}
			}
		}
	}
	public void moveRight(Organism[][] g, int x_, int y_)
	{
		g[x_ + 1][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[x_ + 1][y_].setX(x_ + 1);
		g[x_ + 1][y_].addTimeStep();
		g[x_ + 1][y_].setActivity(true);
	}
	public void moveLeft(Organism[][] g, int x_, int y_)
	{
		g[x_ - 1][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[x_ - 1][y_].setX(x_ - 1);
		g[x_ - 1][y_].addTimeStep();
		g[x_ - 1][y_].setActivity(true);
	}
	public void moveUp(Organism[][] g, int x_, int y_)
	{
		g[x_][y_ - 1] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][y_ - 1].setY(y_ - 1);
		g[x_][y_ - 1].addTimeStep();
		g[x_][y_ - 1].setActivity(true);
	}
	public void moveDown(Organism[][] g, int x_, int y_)
	{
		g[x_][y_ + 1] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][y_ + 1].setY(y_ + 1);
		g[x_][y_ + 1].addTimeStep();
		g[x_][y_ + 1].setActivity(true);
	}
	public void teleportRight(Organism[][] g, int x_, int y_)
	{
		g[0][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[0][y_].setX(0);
		g[0][y_].addTimeStep();
		g[0][y_].setActivity(true);
	}
	public void teleportLeft(Organism[][] g, int x_, int y_)
	{
		g[g[0].length - 1][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[g[0].length - 1][y_].setX(g.length - 1);
		g[g[0].length - 1][y_].addTimeStep();
		g[g[0].length - 1][y_].setActivity(true);
	}
	public void teleportUp(Organism[][] g, int x_, int y_)
	{
		g[x_][g.length - 1] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][g.length - 1].setY(g.length - 1);
		g[x_][g.length - 1].addTimeStep();
		g[x_][g.length - 1].setActivity(true);
	}
	public void teleportDown(Organism[][] g, int x_, int y_)
	{
		g[x_][0] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][0].setY(0);
		g[x_][0].addTimeStep();
		g[x_][0].setActivity(true);
	}
	public String toString()
	{
		return "o";
	}
}