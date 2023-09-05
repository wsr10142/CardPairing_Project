package myfinal;

public class timer
{
	private long start=0;
	private long end=0;
	
	public void setStartTime()
	{
		start=System.currentTimeMillis();
	}
	
	public void setEndTime()
	{
		end = System.currentTimeMillis();
	}
	
	public long getStartTime()
	{
		return start;
	}
	
	public long getEndTime()
	{
		return end;
	}
	
}
