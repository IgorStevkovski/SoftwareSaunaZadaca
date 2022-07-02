package tests.igor;

public class ErrorChecking {

//	public Point[] returnNeibours(Point point, String[][]matrix) {
//		Point currentPoint = point;
//		int currentPointX = point.getX();
//		int currentPointY = point.getY();
//		String currentPointValue = point.getValue();
//		
//		Point leftPoint = null;
//		Point upPoint = null;
//		Point rightPoint = null;
//		Point downPoint = null;
//		
//		//left point
//		if(currentPointY - 1 >= 0 && !matrix[currentPointX][currentPointY-1].equals("")) {
//			leftPoint = new Point(currentPointX, currentPointY-1, matrix[currentPointX][currentPointY-1]);
//		}
//		
//		//up point
//		if(currentPointX - 1 >= 0 && !matrix[currentPointX-1][currentPointY].equals("")) {
//			upPoint = new Point(currentPointX-1, currentPointY, matrix[currentPointX-1][currentPointY]);
//		}
//		
//		//right point
//		if(currentPointY + 1 < matrix[currentPointX].length && !matrix[currentPointX][currentPointY+1].equals("")) {
//			rightPoint = new Point(currentPointX, currentPointY+1, matrix[currentPointX][currentPointY+1]);
//		}
//		
//		//down point
//		if(currentPointX + 1 < matrix.length && !matrix[currentPointX+1][currentPointY].equals("")) {
//			downPoint = new Point(currentPointX+1, currentPointY, matrix[currentPointX+1][currentPointY]);
//		}	
//		
//		Point[] neighbours = new Point[4];
//		neighbours[0] = leftPoint;
//		neighbours[1] = upPoint;
//		neighbours[2] = rightPoint;
//		neighbours[3] = downPoint;
//		
//		return neighbours;
//	}
	
	public static Point[] returnNeibours(Point point, Point[][]pointMatrix) {
		Point currentPoint = point;
		int currentPointX = point.getX();
		int currentPointY = point.getY();
		String currentPointValue = point.getValue();
		
		Point leftPoint = null;
		Point upPoint = null;
		Point rightPoint = null;
		Point downPoint = null;
		
		//left point
		if(currentPointY - 1 >= 0) {
			leftPoint = pointMatrix[currentPointX][currentPointY-1];
		}
		
		//up point
		if(currentPointX - 1 >= 0) {
			upPoint = pointMatrix[currentPointX-1][currentPointY];
		}
		
		//right point
		if(currentPointY + 1 < pointMatrix[currentPointX].length) {
			rightPoint = pointMatrix[currentPointX][currentPointY+1];
		}
		
		//down point
		if(currentPointX + 1 < pointMatrix.length ) {
			downPoint = pointMatrix[currentPointX+1][currentPointY];
		}	
		
		Point[] neighbours = new Point[4];
		neighbours[0] = leftPoint;
		neighbours[1] = upPoint;
		neighbours[2] = rightPoint;
		neighbours[3] = downPoint;
		
		return neighbours;
	}
	
	public static boolean doesLetterPointHasUnvisitedNeighbours(Point neighbour, Point[][]pointMatrix) {
		
		Point[] neighbours = ErrorChecking.returnNeibours(neighbour, pointMatrix);
		
		for(int i=0; i<neighbours.length; i++) {
			if(neighbours[i]!=null && neighbours[i].isVisited()==false) {
				return true;
			}
		}
		return false;
	}
}
