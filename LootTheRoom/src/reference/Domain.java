package reference;

public final class Domain< T extends Compare2D<? super T> >
{
	Coordinate<T> topL;
	Coordinate<T> topR;
	Coordinate<T> botL;
	Coordinate<T> botR;
	
	private Coordinate<T> core;
	
	public Domain(long xMin, long xMax, long yMin, long yMax)
	{
		this.topL = new Coordinate<T>(xMin, yMax);
		this.topR = new Coordinate<T>(xMax, yMax);
		this.botL = new Coordinate<T>(xMin, yMin);
		this.botR = new Coordinate<T>(xMax, yMin);
		
		this.core = new Coordinate<T>( ((xMin + xMax) / (long)2.0),
																	 ((yMin + yMax) / (long)2.0) );
	}
	
	public Domain<T> getNE()
	{
		long xMin = this.core.getX();
		long xMax = this.topR.getX();
		long yMin = this.core.getY();
		long yMax = this.topR.getY();
		
		return new Domain<T>(xMin, xMax, yMin, yMax);
	}
	
	public Domain<T> getNW()
	{
		long xMax = this.core.getX();
		long xMin = this.topL.getX();
		long yMin = this.core.getY();
		long yMax = this.topR.getY();
		
		return new Domain<T>(xMin, xMax, yMin, yMax);
	}
	
	public Domain<T> getSE()
	{
		long xMin = this.core.getX();
		long xMax = this.topR.getX();
		long yMax = this.core.getY();
		long yMin = this.botR.getY();
		
		return new Domain<T>(xMin, xMax, yMin, yMax);
	}
	
	public Domain<T> getSW()
	{
		long xMax = this.core.getX();
		long xMin = this.botL.getX();
		long yMax = this.core.getY();
		long yMin = this.botR.getY();
		
		return new Domain<T>(xMin, xMax, yMin, yMax);
	}
	
	public Coordinate<T> getCore()
	{
		return this.core;
	}
	
	public String toString()
	{
		return ('{' + botL.toString() + "-" + topR.toString() + '}');
	}

}
