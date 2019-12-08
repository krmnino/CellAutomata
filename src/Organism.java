public abstract class Organism 
{
	private int x;
	private int y;
	private int steps;
	private int eat;
	private boolean activity;
	
	public abstract void move(Organism[][] g, int x_, int y_, int gs);
	public abstract void breed(Organism[][] g, int x_, int y_, int gs);
	
	public Organism(int x_, int  y_, int steps_, boolean activity_)
	{
		this.x = x_;
		this.y = y_;
		this.steps = steps_;
		this.activity = true;
	}
	public Organism(int x_, int  y_, int steps_, boolean activity_, int eat_)
	{
		this.x = x_;
		this.y = y_;
		this.steps = steps_;
		this.activity = true;
		this.eat = eat_;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public int getSteps() 
	{
		return this.steps;
	}
	public int getEat()
	{
		return this.eat;
	}
	public boolean getActivity()
	{
		return this.activity;
	}
	public void setX(int x_)
	{
		this.x = x_;
	}
	public void setY(int y_)
	{
		this.y = y_;
	}
	public void setActivity(boolean activity_)
	{
		this.activity = activity_;
	}
	public void resetEat()
	{
		this.eat = 3;
	}
	public void addTimeStep()
	{
		this.steps++;
	}
	public void zeroSteps()
	{
		this.steps = 0;
	}
	public void substractEat() 
	{
		this.eat--;
	}
}