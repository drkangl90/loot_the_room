package reference;

import java.util.Vector;

public class prQuadtree< T extends Compare2D<? super T> >
{
//~ PRIVATE CLASS HIERARCHY =================================== ~\\

	/**
	 * Minor.P3.DS.prQuadtree.java
	 * Domain
	 * 
	 * @author Dirk N. Hortensius
	 * @version Oct 17, 2012
	 *
	 */
	final class Domain
	{
		Coordinate topL;
		Coordinate topR;
		Coordinate botL;
		Coordinate botR;
		
		private Coordinate core;
		
		public Domain(long xMin, long xMax, long yMin, long yMax)
		{
			this.topL = new Coordinate(xMin, yMax);
			this.topR = new Coordinate(xMax, yMax);
			this.botL = new Coordinate(xMin, yMin);
			this.botR = new Coordinate(xMax, yMin);
			
			this.core = new Coordinate( ((xMin + xMax) / (long)2.0),
																		 ((yMin + yMax) / (long)2.0) );
		}
		
		public Domain getNE()
		{
			long xMin = this.core.getX();
			long xMax = this.topR.getX();
			long yMin = this.core.getY();
			long yMax = this.topR.getY();
			
			return new Domain(xMin, xMax, yMin, yMax);
		}
		
		public Domain getNW()
		{
			long xMax = this.core.getX();
			long xMin = this.topL.getX();
			long yMin = this.core.getY();
			long yMax = this.topR.getY();
			
			return new Domain(xMin, xMax, yMin, yMax);
		}
		
		public Domain getSE()
		{
			long xMin = this.core.getX();
			long xMax = this.topR.getX();
			long yMax = this.core.getY();
			long yMin = this.botR.getY();
			
			return new Domain(xMin, xMax, yMin, yMax);
		}
		
		public Domain getSW()
		{
			long xMax = this.core.getX();
			long xMin = this.botL.getX();
			long yMax = this.core.getY();
			long yMin = this.botR.getY();
			
			return new Domain(xMin, xMax, yMin, yMax);
		}
		
		public boolean overlap(Domain other)
		{
			/*long xMax = this.topR.getX();
			long xMin = this.botL.getX();
			long yMax = this.topL.getY();
			long yMin = this.botR.getY();*/
			/*double xMax = other.topR.getX();
			double xMin = other.botL.getX();
			double yMax = other.topL.getY();
			double yMin = other.botR.getY();
			
			return ( this.topR.inBox(xMin, xMax, yMin, yMax) 
						|| this.topL.inBox(xMin, xMax, yMin, yMax) 
						|| this.botR.inBox(xMin, xMax, yMin, yMax) 
						|| this.botL.inBox(xMin, xMax, yMin, yMax) );*/
			return true;
		}
		
		public String toString()
		{
			return ('{' + botL.toString() + "-" + topR.toString() + '}');
		}

	}
	
	/**
	 * Minor.P3.DS.Coordinate.java
	 * Coordinate
	 * 
	 * @author Dirk N. Hortensius
	 * @version Oct 16, 2012
	 *
	 */
	final class Coordinate implements Compare2D<T>
	{
		Long x;
		Long y;
		
		public Coordinate(long x, long y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public long getX()
		{
			return this.x;
		}

		@Override
		public long getY()
		{
			return this.y;
		}

		@Override
		public Direction directionFrom(long X, long Y)
		{
			int i = this.x.compareTo(X);
			int j = this.y.compareTo(Y);
			
			// x > X
			if ( i > 0 )
			{
				if ( j >= 0 )
				{
					return Direction.NE;
				}
				return Direction.SE;
			}
			
			// x <= X
			if ( j > 0 )
			{
				return Direction.NW;
			} 
			else
			{
				return Direction.SW;
			}
		}

		@Override
		public Direction inQuadrant(double xLo, double xHi, double yLo, double yHi)
		{
			if ( this.inBox(xLo, xHi, yLo, yHi) )
			{
				long X = (long)((xLo + xHi) / 2.0);
				long Y = (long)((yLo + yHi) / 2.0);
				
				return this.directionFrom(X, Y);
			}
			
			return Direction.NOQUADRANT;
		}

		@Override
		public boolean inBox(double xLo, double xHi, double yLo, double yHi)
		{
			/*if (   (this.x >= xLo) 
			&& (this.x <= xHi) 
			&& (this.y >= yLo)
			&& (this.y <= yHi) )*/
			if (   (this.x.compareTo( (long)xLo ) > 0) 
					&& (this.x.compareTo( (long)xHi ) < 0) 
					&& (this.y.compareTo( (long)yLo ) > 0)
					&& (this.y.compareTo( (long)yHi ) < 0 ) )
			{
				return true;
			}
			return false;
		}
		
		public String toString()
		{
			return ("(" + this.getX() + ", " + this.getY() + ")") ;
		}

	}	
	
  abstract class prQuadNode 
  {
  	Domain area;
  	String type;
  	
  	public abstract boolean    isEmpty();
  	public abstract T 				 find(T elem);
  	public abstract Vector<T>  find(long xMin, long xMax, long yMin, long yMax);
  	public abstract prQuadNode insert(T elem);
  	public abstract prQuadNode delete(T elem);
  	public abstract String     toString();
  }  // </prQuadNode>
  //
  final class prQuadLeaf extends prQuadNode
  {
  	final static int DEFAULT_BUCKET_SIZE = 1;
  	
  	private int bucketSize;
  	Vector<T> Elements;
    
  	public prQuadLeaf(Domain area)
  	{
  		this.area 			= area;
  		this.type       = "leaf";
  		this.bucketSize = DEFAULT_BUCKET_SIZE;
  		this.Elements   = new Vector<T>(bucketSize);
  	}
  	
  	public boolean isEmpty()
  	{
  		return (this.Elements.size() == 0);
  	}
  	
  	public T find(T elem)
  	{
  		for (T i : this.Elements)
  		{
  			if ( (i.getX() == elem.getX()) && (i.getY() == elem.getY()) )
  			{
  				return i;
  			}
  		}
  		return null;
  	}
  	
  	public Vector<T> find(long xMin, long xMax, long yMin, long yMax)
  	{
  		Vector<T> vec = new Vector<T>();
  		for (T e : this.Elements)
  		{
  			Coordinate c = new Coordinate(e.getX(), e.getY());
  			if (c.inBox(xMin, xMax, yMin, yMax))
  			{
  				vec.add(e);
  			}
  		}
  		return vec;
  	}
  	
  	public prQuadNode insert(T elem)
  	{
  		if (this.Elements.size() == this.bucketSize)
  		{
  			prQuadInternal branch = new prQuadInternal(this.area);
  			
  			for (T i : this.Elements)
  			{
  				branch.insert(i);
  			}
  			branch.insert(elem);
  			return branch;
  		}
  		this.Elements.add(elem);
  		return this;
  	}
  	
  	public prQuadNode delete(T elem)
  	{
  		int i = 0;
  		for (T e : this.Elements)
  		{
  			if ( (e.getX() == elem.getX()) && (e.getY() == elem.getY()) )
  			{
  				this.Elements.remove(i);
  				break;
  			}
  			i++;
  		}
  		return this;
  	}
  	
  	public String toString()
  	{
  		return this.area.toString() + '\t' + this.Elements.toString();
  	}
  	
  }  // </prQuadLeaf>
  //
  final class prQuadInternal extends prQuadNode
  {
  	prQuadNode NW, NE, SE, SW;
  	
  	int filled;
     
  	public prQuadInternal(Domain area)
  	{
  		this.area = area;
  		this.type = "branch";
  		this.NW = null;
  		this.NE = null;
  		this.SE = null;
  		this.SW = null;
  		
  		filled = 0;
  	}
  	
  	public boolean isEmpty()
  	{
  		boolean b = true;
  		if (this.NW != null)
  		{
  			b = (b && this.NW.isEmpty());
  		}
  		if (this.NE != null)
  		{
  			b = (b && this.NE.isEmpty());
  		}
  		if (this.SW != null)
  		{
  			b = (b && this.SW.isEmpty());
  		}
  		if (this.SE != null)
  		{
  			b = (b && this.SE.isEmpty());
  		}
  		return b;
  	}
  	
  	public T find(T elem)
  	{
  		Coordinate core = this.area.core;
  		Coordinate c    = new Coordinate(elem.getX(), elem.getY());
  		Direction d     = c.directionFrom(core.getX(), core.getY());
  		
  		if (d == Direction.NW && (this.NW != null) )
  		{
  			return this.NW.find(elem);
  		}
  		else if (d == Direction.NE && (this.NE != null) )
  		{
  			return this.NE.find(elem);
  		}
  		else if (d == Direction.SW && (this.SW != null) )
  		{
  			return this.SW.find(elem);
  		}
  		else if (d == Direction.SE && (this.SE != null) )
  		{
  			return this.SE.find(elem);
  		}
  		
  		return null;
  	}
  	
  	public Vector<T> find(long xMin, long xMax, long yMin, long yMax)
  	{
  		Vector<T> vec = new Vector<T>();
  		Domain region = new Domain(xMin, xMax, yMin, yMax);
  		
  		if ( (this.NW != null) && (this.NW.area.overlap(region)) )
  		{
  			vec.addAll(this.NW.find(xMin, xMax, yMin, yMax));
  		}
  		if ( (this.NE != null) && (this.NE.area.overlap(region)) )
  		{
  			vec.addAll(this.NE.find(xMin, xMax, yMin, yMax));
  		}
  		if ( (this.SW != null) && (this.SW.area.overlap(region)) )
  		{
  			vec.addAll(this.SW.find(xMin, xMax, yMin, yMax));
  		}
  		if ( (this.SE != null) && (this.SE.area.overlap(region)) )
  		{
  			vec.addAll(this.SE.find(xMin, xMax, yMin, yMax));
  		}
  		
  		return vec;
  	}
  	
  	public prQuadNode insert(T elem)
  	{
  		Coordinate core = this.area.core;
  		Coordinate c    = new Coordinate(elem.getX(), elem.getY());
  		Direction d     = c.directionFrom(core.getX(), core.getY());
  		
  		if (d == Direction.NW)
  		{
  			if (this.NW == null)
  			{
  				this.NW = new prQuadLeaf(this.area.getNW());
  				this.filled++;
  			}
  			this.NW = this.NW.insert(elem);
  		}
  		else if (d == Direction.NE)
  		{
  			if (this.NE == null)
  			{
  				this.NE = new prQuadLeaf(this.area.getNE());
  				this.filled++;
  			}
  			this.NE = this.NE.insert(elem);
  		}
  		else if (d == Direction.SW)
  		{
  			if (this.SW == null)
  			{
  				this.SW = new prQuadLeaf(this.area.getSW());
  				this.filled++;
  			}
  			this.SW = this.SW.insert(elem);
  		}
  		else if (d == Direction.SE)
  		{
  			if (this.SE == null)
  			{
  				this.SE = new prQuadLeaf(this.area.getSE());
  				this.filled++;
  			}
  			this.SE = this.SE.insert(elem);
  		}
  		
  		return this;
  	}
  	
  	public prQuadNode delete(T elem)
  	{
  		Coordinate core = this.area.core;
  		Coordinate c    = new Coordinate(elem.getX(), elem.getY());
  		Direction d     = c.directionFrom(core.getX(), core.getY());
  		
  		if (d == Direction.NW)
  		{
  			this.NW = this.NW.delete(elem);
  			if (this.NW.isEmpty())
  			{
  				this.NW = null;
  				this.filled--;
  			}
  		}
  		else if (d == Direction.NE)
  		{
  			this.NE = this.NE.delete(elem);
  			if (this.NE.isEmpty())
  			{
  				this.NE = null;
  				this.filled--;
  			}
  		}
  		else if (d == Direction.SW)
  		{
  			this.SW = this.SW.delete(elem);
  			if (this.SW.isEmpty())
  			{
  				this.SW = null;
  				this.filled--;
  			}
  		}
  		else if (d == Direction.SE)
  		{
  			this.SE = this.SE.delete(elem);
  			if (this.SE.isEmpty())
  			{
  				this.SE = null;
  				this.filled--;
  			}
  		}
  		
  		if (this.filled <= 1)
  		{
  			return this.trim();
  		}
  		
  		return this;
  	}
  	
  	private prQuadNode trim()
  	{
  		if ( (this.NW != null) && (this.NW.type.equals("leaf")) )
  		{
  			this.NW.area = this.area;
  			return this.NW;
  		}
  		else if ( (this.NE != null) && (this.NE.type.equals("leaf")) )
  		{
  			this.NE.area = this.area;
  			return this.NE;
  		}
  		else if ( (this.SW != null) && (this.SW.type.equals("leaf")) )
  		{
  			this.SW.area = this.area;
  			return this.SW;
  		}
  		if ( (this.SE != null) && (this.SE.type.equals("leaf")) )
  		{
  			this.SE.area = this.area;
  			return this.SE;
  		}
  		return this;
  	}
  	
  	public String toString()
  	{
  		String ret = this.area.toString();
  		if (this.NW != null)
  		{
  			ret += "\nNW: " + NW.toString();
  		}
  		if (this.NE != null)
  		{
  			ret += "\nNE: " + NE.toString();
  		}
  		if (this.SW != null)
  		{
  			ret += "\nSW: " + SW.toString();
  		}
  		if (this.SE != null)
  		{
  			ret += "\nSE: " + SE.toString();
  		}
  		return ret;
  	}
  }  // </prQuadInternal>
  
  //~ FIELD DECLARATIONS ======================================== ~\\
  //
  prQuadNode root;
  
  long xMin; 
  long xMax;
  long yMin;
  long yMax;
   
  //~ INITIALIZATION ============================================ ~\\
  //
  /**
   * CONSTRUCTOR
   * 
   * Initialize quadtree to empty state, representing the specified region.
   *
   * @param xMin - x-axis lower bound
   * @param xMax - x-axis upper bound
   * @param yMin - y axis lower bound
   * @param yMax - y axis upper bound
   */
  public prQuadtree(long xMin, long xMax, long yMin, long yMax) 
  {
  	// Set Tree Empty
  	this.root = null;
     
  	// Set Bounds
    this.xMin = xMin;
    this.xMax = xMax;
    this.yMin = yMin;
    this.yMax = yMax;
  }
  
  //~ PUBLIC ACCESS FUNCIONS ==================================== ~\\
  //
  /** 
   * Pre:   elem != null
   * Post:  If elem lies within the tree's region, and elem is not already 
   *        present in the tree, elem has been inserted into the tree.
   * 
   * Return true iff elem is inserted into the tree. 
   */
  public boolean insert(T elem)
  {
  	if ( (elem.getX() <= this.xMax) && (elem.getX() >= this.xMin)
  			&& (elem.getY() <= this.yMax) && (elem.getY() >= this.yMin)
  			&& (this.find(elem) == null) )
  	{
  		if (root == null)
    	{
    		this.root = new prQuadLeaf(new Domain(this.xMin, this.xMax, 
    											     								this.yMin, this.yMax));
    	}
  		this.root = this.root.insert(elem);
  		return true;
  	}
  	return false;
  }
    
  /**
   * Pre:  elem != null
   * Post: If elem lies in the tree's region, and a matching element occurs
   *       in the tree, then that element has been removed.
   *
   * Returns true iff a matching element has been removed from the tree.
   */
  public boolean delete(T elem)
  {
  	if ( (elem.getX() <= this.xMax) && (elem.getX() >= this.xMin)
  			&& (elem.getY() <= this.yMax) && (elem.getY() >= this.yMin)
  			&& (this.find(elem) != null) )
  	{
  		this.root   = this.root.delete(elem);
  		
  		if (this.root.isEmpty())
  		{
  			this.root = null;
  		}
  		return true;
  	}
  	return false;
  }

  /**
   * Pre:  elem != null
   * 
   * Returns reference to an element x within the tree such that 
   * elem.equals(x)is true, provided such a matching element occurs within
   * the tree; returns null otherwise.
   */
  public T find(T elem)
  {
  	if (this.root == null)
  	{
  		return null;
  	}
  	return this.root.find(elem);
  }
 
  /**
   * Pre:  xLo, xHi, yLo and yHi define a rectangular region
   *  
   * Returns a collection of (references to) all elements x such that x is 
   * in the tree and x lies at coordinates within the defined rectangular 
   * region, including the boundary of the region.
   * 
   * @param xLo, xHi, yLo, yHi - region bounds
   */
  public Vector<T> find(long xLo, long xHi, long yLo, long yHi)
  {
     return this.root.find(xLo, xHi, yLo, yMax);      
  }
  
  
  public String toString()
  {
  	return this.root.toString();
  }
 
}
