public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {
	    boolean aOverlapsXY1 = (plot.x >= x && plot.x < (x + width)) &&  (plot.y >= y && plot.y < (y + depth));
	    boolean aOverlapsXY2 = (x >= plot.x && x < (plot.x + width)) &&  (y >= plot.y && y < (plot.y + plot.depth));
	    boolean bOverlapsXY1 = (plot.x + plot.width) > x && (plot.x + plot.width) < (x + width) && plot.y >= y && plot.y <= (y + depth); 
	    boolean bOverlapsXY2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && y >= plot.y && y <= (plot.y + plot.depth); 
	    boolean cOverlapsXY1 = plot.x >= x && plot.x < (x +  width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
	    boolean cOverlapsXY2 = x >= plot.x && x < (plot.x +  plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);
	    boolean dOverlapsXY1 = (plot.x + plot.width) > x && (plot.x +plot.width) <= (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
	    boolean dOverlapsXY2 = (x + width) > plot.x && (x + width) <= (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);
	    
	    return aOverlapsXY1 || aOverlapsXY2 || bOverlapsXY1 || bOverlapsXY2 || cOverlapsXY1 || cOverlapsXY2 || dOverlapsXY1 || dOverlapsXY2;
	  }

	public boolean encompasses(Plot plot) {
		boolean inX = plot.x >= x;
		boolean inY = plot.y >= y;
    	boolean inWidth = plot.x + plot.width <= x + width;
    	boolean inDepth = plot.y + plot.depth <= y + depth;
    
    return inX && inY && inWidth && inDepth;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	public int getX() {
		return x;
	}  
	public int getY() {
		return y;
	}	

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}


	@Override
  	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth:" + depth;
	}
}