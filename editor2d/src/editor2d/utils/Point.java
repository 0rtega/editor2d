package editor2d.utils;


public class Point {

	private double x,y,z;
	public Point(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Point rotateZ(double angle) {
		return new Point( this.x * Math.cos( angle ) + this.y * Math.sin( angle ), - this.x * Math.sin( angle ) + this.y * Math.cos ( angle ), 0 );
	}
	
	public double headingZTo(Point p){
		return Math.atan2( p.x - this.x, p.y - this.y );
	}
	
    public Point plus(Point point) {
    	return new Point( x + point.x, y + point.y , z + point.z);
    }
    
    @Override
    public String toString() {
    	return x +" " + y + " " + z + " ";
    }
}
