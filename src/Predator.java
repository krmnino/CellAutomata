import java.util.Random;

public class Predator extends Organism 
{
	Random rand = new Random();
	
	public Predator(int x_, int y_)
	{
		super(x_, y_, 0, true, 3);
	}
	public void move(Organism[][] g, int x_, int y_, int gs) 
	{
		if(g[x_][y_].getActivity() == false)
		{
			int val = 0;
			int direction = 0;
			if(x_ == 0 && y_ == 0)
			{
				if(g[x_ + 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ + 1][y_]instanceof Prey)
						{
							moveRight(g, x_, y_);
							g[x_ + 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1]instanceof Prey)
						{
							moveDown(g, x_, y_);
							g[x_][y_ + 1].resetEat();
							break;
						}
					}
				}
				else if(g[x_ + 1][y_] == null || g[x_][y_ + 1] == null)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							starve(g, x_ + 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							starve(g, x_, y_ + 1);
							break;
						}
					}
				}
					
			}
			else if(x_ == gs - 1 && y_ == 0)
			{
				if(g[x_ - 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_]instanceof Prey)
						{
							moveLeft(g, x_, y_);
							g[x_ - 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1]instanceof Prey)
						{
							moveDown(g, x_, y_);
							g[x_][y_ + 1].resetEat();
							break;
						}
					}
				}
				else if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							starve(g, x_ - 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							starve(g, x_, y_ + 1);
							break;
						}
					}
				}
			}
			else if(x_ == 0 && y_ == gs - 1)
			{
				if(g[x_ + 1][y_]instanceof Prey || g[x_][y_ - 1]instanceof Prey)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ + 1][y_]instanceof Prey)
						{
							moveRight(g, x_, y_);
							g[x_ + 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1]instanceof Prey)
						{
							moveUp(g, x_, y_);
							g[x_][y_ - 1].resetEat();
							break;
						}
					}
				}
				else if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							starve(g, x_ + 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							starve(g, x_, y_ - 1);
							break;
						}
					}
				}
			}
			else if(x_ == gs - 1 && y_ == gs - 1)
			{
				if(g[x_ - 1][y_]instanceof Prey || g[x_][y_ - 1]instanceof Prey)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_]instanceof Prey)
						{
							moveLeft(g, x_, y_);
							g[x_ - 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1]instanceof Prey)
						{
							moveUp(g, x_, y_);
							g[x_][y_ - 1].resetEat();
							break;
						}
					}
				}
				else if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null)
				{
					val = 2;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							starve(g, x_ - 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							starve(g, x_, y_ - 1);
							break;
						}
					}
				}
			}
			else if(x_ == 0)
			{
				if(g[x_][y_ - 1]instanceof Prey || g[x_ + 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_][y_ - 1]instanceof Prey)
						{
							moveUp(g, x_, y_);
							g[x_][y_ - 1].resetEat();
							break;
						}
						else if(direction == 1 && g[x_ + 1][y_]instanceof Prey)
						{
							moveRight(g, x_, y_);
							g[x_ + 1][y_].resetEat();
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1]instanceof Prey)
						{
							moveDown(g, x_, y_);
							g[x_][y_ + 1].resetEat();
							break;
						}						
					}
				}
				else if(g[x_][y_ - 1] == null || g[x_ + 1][y_] == null || g[x_][y_ + 1] == null)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							starve(g, x_, y_ - 1);
							break;
						}
						else if(direction == 1 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							starve(g, x_ + 1, y_);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							starve(g, x_, y_ + 1);
							break;
						}						
					}
				}
			}
			else if(x_ == gs - 1)
			{
				if(g[x_][y_ - 1]instanceof Prey || g[x_ - 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_][y_ - 1]instanceof Prey)
						{
							moveUp(g, x_, y_);
							g[x_][y_ - 1].resetEat();
							break;
						}
						else if(direction == 1 && g[x_ - 1][y_]instanceof Prey)
						{
							moveLeft(g, x_, y_);
							g[x_ - 1][y_].resetEat();
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1]instanceof Prey)
						{
							moveDown(g, x_, y_);
							g[x_][y_ + 1].resetEat();
							break;
						}						
					}
	
				}
				else if(g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							starve(g, x_, y_ - 1);
							break;
						}
						else if(direction == 1 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							starve(g, x_ - 1, y_);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							starve(g, x_, y_ + 1);
							break;
						}						
					}
				}
			}
			else if(y_ == 0)
			{
				if(g[x_ - 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey || g[x_ + 1][y_]instanceof Prey)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_]instanceof Prey)
						{
							moveLeft(g, x_, y_);
							g[x_ - 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1]instanceof Prey)
						{
							moveDown(g, x_, y_);
							g[x_][y_ + 1].resetEat();
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_]instanceof Prey)
						{
							moveRight(g, x_, y_);
							g[x_ + 1][y_].resetEat();
							break;
						}						
					}
				}
				else if(g[x_ - 1][y_] == null || g[x_][y_ + 1] == null || g[x_ + 1][y_] == null)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							starve(g, x_ - 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							moveDown(g, x_, y_);
							starve(g, x_, y_ + 1);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							starve(g, x_ + 1, y_);
							break;
						}						
					}
				}
			}
			else if(y_ == gs - 1)
			{
				if(g[x_ - 1][y_]instanceof Prey || g[x_][y_ - 1]instanceof Prey || g[x_ + 1][y_]instanceof Prey)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_]instanceof Prey)
						{
							moveLeft(g, x_, y_);
							g[x_ - 1][y_].resetEat();
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1]instanceof Prey)
						{
							moveUp(g, x_, y_);
							g[x_][y_ - 1].resetEat();
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_]instanceof Prey)
						{
							moveRight(g, x_, y_);
							g[x_ + 1][y_].resetEat();
							break;
						}						
					}
				}
				else if(g[x_ - 1][y_] == null || g[x_][y_ - 1] == null || g[x_ + 1][y_] == null)
				{
					val = 3;
					while(true)
					{
						direction = rand.nextInt(val);
						if(direction == 0 && g[x_ - 1][y_] == null)
						{
							moveLeft(g, x_, y_);
							starve(g, x_ - 1, y_);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							moveUp(g, x_, y_);
							starve(g, x_, y_ - 1);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							moveRight(g, x_, y_);
							starve(g, x_ + 1, y_);
							break;
						}						
					}
				}
			}
			else if(g[x_ + 1][y_]instanceof Prey || g[x_][y_ - 1]instanceof Prey || g[x_ - 1][y_]instanceof Prey || g[x_][y_ + 1]instanceof Prey)
			{
				val = 4;
				while(true)
				{
					direction = rand.nextInt(val);
					if(direction == 0 && g[x_ + 1][y_]instanceof Prey)
					{
						moveRight(g, x_, y_);
						g[x_ + 1][y_].resetEat();
						break;
					}
					else if(direction == 1 && g[x_][y_ - 1]instanceof Prey)
					{
						moveUp(g, x_, y_);
						g[x_][y_ - 1].resetEat();
						break;
					}
					else if(direction == 2 && g[x_ - 1][y_]instanceof Prey)
					{
						moveLeft(g, x_, y_);
						g[x_ - 1][y_].resetEat();
						break;
					}	
					else if(direction == 3 && g[x_][y_ + 1]instanceof Prey)
					{
						moveDown(g, x_, y_);
						g[x_][y_ + 1].resetEat();
						break;
					}
				}
			}
			else if(g[x_ + 1][y_] == null || g[x_][y_ - 1] == null || g[x_ - 1][y_] == null || g[x_][y_ + 1] == null)
			{
				val = 4;
				while(true)
				{
					direction = rand.nextInt(val);
					if(direction == 0 && g[x_ + 1][y_] == null)
					{
						moveRight(g, x_, y_);
						starve(g, x_ + 1, y_);
						break;
					}
					else if(direction == 1 && g[x_][y_ - 1] == null)
					{
						moveUp(g, x_, y_);
						starve(g, x_, y_ - 1);
						break;
					}
					else if(direction == 2 && g[x_ - 1][y_] == null)
					{
						moveLeft(g, x_, y_);
						starve(g, x_ - 1, y_);
						break;
					}	
					else if(direction == 3 && g[x_][y_ + 1] == null)
					{
						moveDown(g, x_, y_);
						starve(g, x_, y_ + 1);
						break;
					}
				}
			}
			else
			{
				g[x_][y_].addTimeStep();
				g[x_][y_].substractEat();
				starve(g, x_, y_);
			}
		}
	}
	public void breed(Organism[][] g, int x_, int y_, int gs) 
	{
		if(g[x_][y_].getSteps() == 8)
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
							g[x_ + 1][y_] = new Predator(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Predator(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
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
							g[x_ - 1][y_] = new Predator(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Predator(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
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
							g[x_ + 1][y_] = new Predator(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Predator(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
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
							g[x_ - 1][y_] = new Predator(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Predator(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
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
							g[x_][y_ - 1] = new Predator(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 1 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Predator(x_ + 1, y_);
							g[x_ + 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Predator(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
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
							g[x_][y_ - 1] = new Predator(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_ - 1][y_] == null)
						{
							g[x_ - 1][y_] = new Predator(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Predator(x_, y_ + 1);
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
							g[x_ - 1][y_] = new Predator(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ + 1] == null)
						{
							g[x_][y_ + 1] = new Predator(x_, y_ + 1);
							g[x_][y_ + 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Predator(x_ + 1, y_);
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
							g[x_ - 1][y_] = new Predator(x_ - 1, y_);
							g[x_ - 1][y_].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 1 && g[x_][y_ - 1] == null)
						{
							g[x_][y_ - 1] = new Predator(x_, y_ - 1);
							g[x_][y_ - 1].setActivity(true);
							g[x_][y_].zeroSteps();
							g[x_][y_].setActivity(true);
							break;
						}
						else if(direction == 2 && g[x_ + 1][y_] == null)
						{
							g[x_ + 1][y_] = new Predator(x_ + 1, y_);
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
						g[x_ + 1][y_] = new Predator(x_ + 1, y_);
						g[x_ + 1][y_].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
					else if(direction == 1 && g[x_][y_ - 1] == null)
					{
						g[x_][y_ - 1] = new Predator(x_, y_ - 1);
						g[x_][y_ - 1].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
					else if(direction == 2 && g[x_ - 1][y_] == null)
					{
						g[x_ - 1][y_] = new Predator(x_ - 1, y_);
						g[x_ - 1][y_].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}	
					else if(direction == 3 && g[x_][y_ + 1] == null)
					{
						g[x_][y_ + 1] = new Predator(x_, y_ + 1);
						g[x_][y_ + 1].setActivity(true);
						g[x_][y_].zeroSteps();
						g[x_][y_].setActivity(true);
						break;
					}
				}
			}
		}
	}
	public void starve(Organism[][] g, int x_, int y_)
	{
		if(g[x_][y_].getEat() == 0)
		{
			g[x_][y_] = null;
		}
	}
	public void moveRight(Organism[][] g, int x_, int y_)
	{
		g[x_ + 1][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[x_ + 1][y_].setX(x_ + 1);
		g[x_ + 1][y_].addTimeStep();
		g[x_ + 1][y_].substractEat();
		g[x_ + 1][y_].setActivity(true);
	}
	public void moveLeft(Organism[][] g, int x_, int y_)
	{
		g[x_ - 1][y_] = g[x_][y_];
		g[x_][y_] = null;
		g[x_ - 1][y_].setX(x_ - 1);
		g[x_ - 1][y_].addTimeStep();
		g[x_ - 1][y_].substractEat();
		g[x_ - 1][y_].setActivity(true);
	}
	public void moveUp(Organism[][] g, int x_, int y_)
	{
		g[x_][y_ - 1] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][y_ - 1].setY(y_ - 1);
		g[x_][y_ - 1].addTimeStep();
		g[x_][y_ - 1].substractEat();
		g[x_][y_ - 1].setActivity(true);
	}
	public void moveDown(Organism[][] g, int x_, int y_)
	{
		g[x_][y_ + 1] = g[x_][y_];
		g[x_][y_] = null;
		g[x_][y_ + 1].setY(y_ + 1);
		g[x_][y_ + 1].addTimeStep();
		g[x_][y_ + 1].substractEat();
		g[x_][y_ + 1].setActivity(true);
	}
	public String toString()
	{
		return "X";
	}
}