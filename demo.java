class abc extends Thread
{
	public void run()
	{	
		synchronized(this)
 		{
			for(int i=0;i<10;i++)
			{
				System.out.println("Series one:"+i);
				if(i==2)
				{
					try
					{
						this.wait();
					}
					catch(Exception e)
					{}				
				}
			
			}
		this.notify();
		System.out.println("end");
		}
	}
}

class xyz extends Thread
{
	abc a;
	xyz(abc a)
	{
		this.a=a;
	}
	public void run()
	{	
		synchronized(this.a)
		{
			for(int j=0;j<5;j++)
			{
				System.out.println("Series:"+j);
				//this.a.notify();
				if(j==2)
				{
					try
					{
						this.a.wait();
					}
					catch(Exception e)
					{}				
				}
			}
		//this.a.notify();
		}
	}
}

class pqr extends Thread
{
	abc a;
	pqr(abc a)
	{
		this.a=a;
	}
	public void run()
	{
		synchronized(this.a)
		{
			for(int k=0;k<15;k++)
			{
				System.out.println("Series Is:"+k);
				this.a.notify();
			}
		}
	}
}

class demo
{
	public static void main(String args[])
	{
		abc a=new abc();
		xyz x=new xyz(a);
		pqr p=new pqr(a);		
		a.start();
		x.start();
		p.start();
					
	}
}
