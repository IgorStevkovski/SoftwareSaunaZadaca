package solution.igor;

public class Point implements Comparable<Point>{

	private int x;
	private int y;
	private String value;
	
	private boolean visited = false;
	private int direction = 0;
	
	public Point() {
		
	}
	
	public Point(int x, int y, String value) {
		this.x = x;
		this.y = y;
		this.value = value;

	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	@Override
	public int compareTo(Point other) {
		if(this.getX() == other.getX() && this.getY() == other.getY() && this.getValue() == other.getValue()) {
			return 0;
		}
		return -1;
	}
	
}
