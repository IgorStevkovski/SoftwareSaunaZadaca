package solution.igor;

import java.util.ArrayList;

public class SoftwareSaunaTest {

	public static void main(String[] args) {
		
		
		
		
		//Initialize the two dimensional array 
//		String[][] matrix = { {"",  "",  "",  "",  "+", "-", "O",  "-", "N", "-",  "+", "",  ""}, 
//				              {"",  "",  "",  "",  "|", "",  "",   "",  "",  "",   "|", "",  ""},
//				              {"",  "",  "",  "",  "|", "",  "",   "",  "+", "-",  "I", "-", "+"},
//				              {"@", "-", "G", "-", "O", "-", "+",  "",  "|", "",   "|", "",  "|"},
//				              {"",  "",  "",  "",  "|", "",  "|",  "",  "+", "-",  "+", "",  "E"},
//				              {"",  "",  "",  "",  "+", "-", "+",  "",  "",  "",   "",  "",  "S"},
//				              {"",  "",  "",  "",  "",  "",  "",   "",  "",  "",   "",  "",  "|"},
//				              {"",  "",  "",  "",  "",  "",  "",   "",  "",  "",   "",  "",  "x"}
//				            };
		
		String[][] matrix = { {"@",  "",  "",   "",   "",  "",   "",    "",   "",  ""}, 
	              			  {"|",  "",  "+",  "-",  "C", "-",  "-",   "+",  "",  ""},
	              			  {"A",  "",  "|",  "",   "",  "",   "",    "|",  "",  ""},
	              			  {"+",  "-", "-",  "-",  "B", "-",  "-",   "+",  "",  ""},
	              			  {"",   "",  "|",  "",   "",  "",   "",    "",   "",  "x"},
	              			  {"",   "",  "|",  "",   "",  "",   "",    "",   "",  "|"},
	              			  {"",   "",  "+",  "-",  "-", "-",  "D",   "-",  "-", "+"}
	            			};
		
//		String[][] matrix = { {"",  "+",  "-",   "L",   "-",  "+",   "",    ""}, 
//    			  			  {"",  "|",  "",    "",    "+",  "A",   "-",   "+"},
//    			  			  {"@", "B",  "+",   "",    "+",  "+",   "",    "H"},
//    			  			  {"",  "+",  "+",   "",    "",   "",    "",    "x"}  			  			  
//  							};

//		String[][] matrix = { {"@",  "-",  "A",   "-",   "-",  "+",   "",   "",  "",  "",  "",   "",   "",  "",   "",    ""}, 
//							  {"",   "",   "",    "",    "",   "|",   "",   "",  "",  "",  "",   "",   "",  "",   "",    ""},
//							  {"",   "",   "",    "",    "",   "+",   "-",  "B", "-", "-", "x",  "-",  "C", "-",  "-",   "D"}							   			  			  
//							};
		

//		String[][] matrix = { {"@",  "-",  "-",   "-",   "A",  "-",   "-",    "-",   "+"}, 
//							  {"",   "",   "",    "",    "",   "",    "",     "",    "|"},
//							  {"x",   "-",   "B",    "-",    "+",   "",    "",     "",    "|"},
//							  {"",   "",   "",    "",    "|",   "",    "",     "",    "|"},
//							  {"",   "",   "",    "",    "+",  "-",   "-",    "-",   "C"}
//							};
		
//		String[][] matrix = { {"@",  "-",  "-",   "-",   "A",  "-",   "-",    "-",   "+"}, 
//				  			  {"",   "",   "",    "",    "",   "",    "",     "",    "|"},
//				  			  {"x",  "-",  "B",   "-",   "+",  "",    "",     "",    "C"},
//				  			  {"",   "",   "",    "",    "|",  "",    "",     "",    "|"},
//				  			  {"",   "",   "",    "",    "+",  "-",   "-",    "-",   "+"}
//							};
		
		//dodadi static metodi za loadanje na matricata, i go staj gi promenlivite da se vo samata klasa za da se koristat po metodite!
		
		
		//Check multiple starting paths
		//Check multiple end of path
		int numberOfStartPaths = 0;
		int numberOfEndPaths = 0;
		Point startPoint = null;
		Point[][] pointMatrix = new Point[matrix.length][matrix[1].length];
		Point previousPoint = null;
		Point currentPoint = null;
		
		ArrayList<String> letters = new ArrayList();
		ArrayList<String> path = new ArrayList();
		
		for(int i=0 ; i<matrix.length; i++ ) 
		{
			for(int j=0; j<matrix[i].length; j++) 
			{
				if(!matrix[i][j].equals("")) {
					pointMatrix[i][j] = new Point(i,j,matrix[i][j]);
				}else {
					pointMatrix[i][j] = null;
				}
				
				if(matrix[i][j].equals("@")) {
					startPoint = pointMatrix[i][j];
					previousPoint = startPoint;
					currentPoint = startPoint;
					numberOfStartPaths ++;
				}
				if(matrix[i][j].equals("x")) {
					numberOfEndPaths ++;
				}
			}
		}
		
		if(numberOfStartPaths != 1) {
			System.out.println("Invalid number of Start paths: @ characters.");
			return;
		}
		
		if(numberOfEndPaths != 1) {
			System.out.println("Invalid number of End paths: x characters.");
			return;
		}
		
		
		//Iterate through matrix starting from found startPoint
		while(true) {
			previousPoint = currentPoint;
			
			if(previousPoint.isVisited()==false && Character.isLetter(previousPoint.getValue().charAt(0)) && !previousPoint.getValue().equals("x")) {
				letters.add(previousPoint.getValue());
			}
			path.add(previousPoint.getValue());
			previousPoint.setVisited(true);
			
			
			System.out.println(previousPoint.getValue());
			
			if(previousPoint.getValue().equals("x")) {
				System.out.println("Kraj");
				break;
			}
			
			Point[] neighbours = ErrorChecking.returnNeibours(previousPoint, pointMatrix);
			//Fist Point - @ ; Left neighbour
			if(previousPoint.getValue().equals("@") && neighbours[0]!=null && !neighbours[0].getValue().equals("")) {
				currentPoint = neighbours[0];
				currentPoint.setDirection(0);
				continue;
			}
			
			//Fist Point - @ ; Up neighbour
			if(previousPoint.getValue().equals("@") && neighbours[1]!=null && !neighbours[1].getValue().equals("")) {
				currentPoint = neighbours[1];
				currentPoint.setDirection(1);
				continue;
			}
			
			//Fist Point - @ ; Right neighbour
			if(previousPoint.getValue().equals("@") && neighbours[2]!=null && !neighbours[2].getValue().equals("")) {
				currentPoint = neighbours[2];
				currentPoint.setDirection(2);
				continue;
			}
			
			//Fist Point - @ ; Down neighbour
			if(previousPoint.getValue().equals("@") && neighbours[3]!=null && !neighbours[3].getValue().equals("")) {
				currentPoint = neighbours[3];
				currentPoint.setDirection(3);
				continue;
			}
			
			
			boolean found = false;
			
			//direction 0
			if(previousPoint.getDirection()==0) {
				if( (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==false ) ||
					(neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && Character.isLetter(neighbours[0].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix)) ||
					(neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[0].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix))  ) {					
						
						currentPoint = neighbours[0];
						currentPoint.setDirection(0);
						found = true;
										
				}else if( (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==false) || 
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && Character.isLetter(neighbours[1].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix)) ||
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[1].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix))) {
					
						currentPoint = neighbours[1];
						currentPoint.setDirection(1);
						found = true;
										
				}else if((neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==false) ||
						 (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && Character.isLetter(neighbours[2].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix)) ||
						 (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[2].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix))) {
					
						currentPoint = neighbours[2];
						currentPoint.setDirection(2);
						found = true;
										
				}else if((neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==false) ||
						 (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && Character.isLetter(neighbours[3].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix)) ||
						 (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[0].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix))) {
					
						currentPoint = neighbours[3];
						currentPoint.setDirection(3);
						found = true;
										
				}
			}
			
			//direction 1
			if(previousPoint.getDirection()==1) {
				if( (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==false) ||
					(neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && Character.isLetter(neighbours[1].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix)) ||
					(neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[1].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix)) ) {
					
						currentPoint = neighbours[1];
						currentPoint.setDirection(1);
						found = true;
									
				}else if( (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==false) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && Character.isLetter(neighbours[0].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix)) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[0].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix))) {
									
						currentPoint = neighbours[0];
						currentPoint.setDirection(0);
						found = true;
					
				}else if((neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==false) ||
						 (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && Character.isLetter(neighbours[2].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix)) ||
						 (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[2].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix))) {
					
						currentPoint = neighbours[2];
						currentPoint.setDirection(2);
						found = true;
										
				}else if((neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==false) || 
					     (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && Character.isLetter(neighbours[3].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix)) ||
					     (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[3].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix))) {
						currentPoint = neighbours[3];
						currentPoint.setDirection(3);
						found = true;
										
				}
			}
			
			//direction 2
			if(previousPoint.getDirection()==2) {
				if( (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==false) ||
					(neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && Character.isLetter(neighbours[2].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix)) ||
					(neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[2].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix))) {
					
						currentPoint = neighbours[2];
						currentPoint.setDirection(2);
						found = true;
										
				}else if( (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==false) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && Character.isLetter(neighbours[0].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix)) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[0].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix))) {
					
						currentPoint = neighbours[0];
						currentPoint.setDirection(0);
						found = true;
										
				}else if( (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==false) ||
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && Character.isLetter(neighbours[1].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix)) ||
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[1].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix))) {
					
						currentPoint = neighbours[1];
						currentPoint.setDirection(1);
						found = true;
										
				}else if( (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==false) || 
						  (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && Character.isLetter(neighbours[3].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix)) ||
						  (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[3].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix))) {
					
						currentPoint = neighbours[3];
						currentPoint.setDirection(3);
						found = true;
										
				}
			}
			
			//direction 3
			if(previousPoint.getDirection()==3) {
				if( (neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==false) ||
					(neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && Character.isLetter(neighbours[3].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix)) ||	
					(neighbours[3]!=null && !neighbours[3].getValue().equals("") && neighbours[3].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[3].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[3],pointMatrix))) {
					
						currentPoint = neighbours[3];
						currentPoint.setDirection(3);
						found = true;
										
				}else if( (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==false) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && Character.isLetter(neighbours[0].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix)) ||
						  (neighbours[0]!=null && !neighbours[0].getValue().equals("") && neighbours[0].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[0].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[0],pointMatrix))){
					
						currentPoint = neighbours[0];
						currentPoint.setDirection(0);
						found = true;
										
				}else if( (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==false) ||
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && Character.isLetter(neighbours[1].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix)) ||
						  (neighbours[1]!=null && !neighbours[1].getValue().equals("") && neighbours[1].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[1].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[1],pointMatrix))) {
					    
						currentPoint = neighbours[1];
						currentPoint.setDirection(1);
						found = true;
									
				}else if( (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==false) ||
						  (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && Character.isLetter(neighbours[2].getValue().charAt(0)) && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix)) ||
						  (neighbours[2]!=null && !neighbours[2].getValue().equals("") && neighbours[2].isVisited()==true && previousPoint.getValue().equals("|") && neighbours[2].getValue().equals("-") && ErrorChecking.doesLetterPointHasUnvisitedNeighbours(neighbours[2],pointMatrix))){
					
						currentPoint = neighbours[2];
						currentPoint.setDirection(2);
						found = true;
										
				}
			}
			
			if(found==false) {
				System.out.println("Error, matrix is invalid!");
				return;
			}
		}
		
		
		System.out.println("Path = " + path);
		System.out.println("Letters = " + letters);
	}
}
