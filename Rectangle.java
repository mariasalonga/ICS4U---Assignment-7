/*Maria Salonga
 * Friday, February 11, 2022
 * This class allows the user to create variables and use methods related to Cartesian rectangles.
 * */
public class Rectangle {

	int bottomleftx;
	int bottomlefty;
	int toprightx;
	int toprighty;
	int width;
	int height;
	
	/**
	 * This constructor assigns variables to an instance of a class if initialized with parameters.
	 * @param tempbottomleftx contains the x of the bottom left corner of the rectangle
	 * @param tempbottomlefty contains the y of the bottom left corner of the rectangle 
	 * @param tempWidth contains the width of the rectangle
	 * @param tempHeight contains the height of the rectangle
	 */
	public Rectangle(int tempbottomleftx, int tempbottomlefty, int tempWidth, int tempHeight) {

		if (tempbottomleftx < 0) {

			bottomleftx = 0;

		} else if (tempbottomlefty < 0) {

			bottomlefty = 0;

		} else if (tempWidth < 0) {

			width = 0;

		} else if (tempHeight < 0) {

			height = 0;

		} else {

			bottomleftx = tempbottomleftx;
			bottomlefty = tempbottomlefty;
			width = tempWidth;
			height = tempHeight;

		}

	}
	/**
	 * This constructor assigns variables to an instance of a class if initialized with parameters
	 * @param tempbottomleftx contains the x of the bottom left corner of the rectangle
	 * @param tempbottomlefty contains the y of the bottom left corner of the rectangle
	 * @param tempWidth contains the width of the rectangle
	 * @param tempHeight contains the height of the rectangle
	 * @param temptoprightx contains the x of the top right corner of the rectangle
	 * @param temptoprighty contains the y of the top right corner of the rectangle
	 */
	public Rectangle(int tempbottomleftx, int tempbottomlefty, int tempWidth, int tempHeight, int temptoprightx, int temptoprighty) {

		if (tempbottomleftx < 0) {

			bottomleftx = 0;

		} else if (tempbottomlefty < 0) {

			bottomlefty = 0;

		} else if (tempWidth < 0) {

			width = 0;

		} else if (tempHeight < 0) {

			height = 0;
			
		} else if (temptoprightx < 0) {
			
			toprightx = 0;
			
		} else if (temptoprighty < 0) {
			
			toprighty = 0;

		} else {

			bottomleftx = tempbottomleftx;
			bottomlefty = tempbottomlefty;
			width = tempWidth;
			height = tempHeight;
			toprightx = temptoprightx;
			toprighty = temptoprighty;

		}

	}
	
	/**
	 * This constructor initializes all the variables of the instance to 0.
	 */
	public Rectangle() {

		bottomleftx = 0;
		bottomlefty = 0;
		height = 0;
		width = 0;
		toprightx = 0;
		toprighty = 0;

	}
	
	/**
	 * This method prints out the base, width, and height of a rectangle.
	 */
	public String toString() {

		String rectangle = "";
		rectangle = "base: " + "(" + bottomleftx + "," + bottomlefty + ")" + "W:" + width + "H:" + height;
		return rectangle;
	}
	
	/**
	 * This method calculates the area of the rectangle
	 * @return the area
	 */
	public int calculateArea() {
		
		//System.out.println("width: " + width);
		//System.out.println("height: " + height);
		int area = width * height;
		return area;

	}

	/**
	 * This method calculates the perimeter of a rectangle
	 * @return the perimeter of the rectangle
	 */
	public int calculatePerimeter() {
		
		//System.out.println("width: " + width);
		//System.out.println("height: " + height);
		int perimeter = (2 * width) + (2 * height);

		return perimeter;

	}
	
	/**
	 * This method calculates if two rectangles overlap and saves the overlapping area as a new rectangle
	 * @param one contains one rectangle
	 * @param two contains one rectangle
	 * @return the rectangle formed by the overlapping area
	 */
	public static Rectangle intersection(Rectangle one, Rectangle two) {

		Rectangle intersection;
		intersection = new Rectangle();
		
		if(two.contains(one)) {
			
			intersection = one;
			
		} else if(one.contains(two)) {
		
			intersection = two;
			
		} else if((one.bottomleftx <= two.toprightx) && (two.toprightx <= one.toprightx)) {
			
			if((two.bottomlefty <= one.toprighty) && (two.bottomlefty >= one.bottomlefty)) {
				
				intersection = new Rectangle(one.bottomleftx, two.bottomlefty, (two.toprightx - one.bottomleftx), (one.toprighty - two.bottomlefty), two.toprightx, one.toprighty);
			
				
			} else if((two.toprighty <= one.toprighty) && (two.toprighty >= one.bottomlefty)) {
				
				intersection = new Rectangle(one.bottomleftx, one.bottomlefty, (two.toprightx - one.bottomleftx),(two.toprighty - one.bottomlefty), two.toprightx, two.toprighty);
				
			} 
			
		} else if((two.bottomleftx >= one.bottomleftx) && (two.bottomleftx <= one.toprightx )) {
			
			if((two.bottomlefty <=one.toprighty) && (two.bottomlefty >= one.bottomlefty)) {
				
				intersection = new Rectangle(two.bottomleftx, two.bottomlefty,(one.toprightx - two.bottomleftx),(one.toprighty - two.bottomlefty), one.toprightx, one.toprighty);
				
			} else if((two.toprighty <= one.toprighty) && (two.toprighty >= one.bottomlefty)) {
				
				intersection = new Rectangle(two.bottomleftx,one.bottomlefty,(one.toprightx - two.bottomleftx),(two.toprighty - one.bottomlefty),one.toprightx,two.toprighty);
				
			}
				
		}
		
		if ((one.bottomleftx > two.bottomleftx) && (one.toprightx < two.toprightx) && (one.toprighty > two.toprighty) && (one.bottomlefty < two.bottomlefty)) {
			
			intersection = new Rectangle(one.bottomleftx, two.bottomlefty,one.width,two.height, one.toprightx, two.toprighty);
			
		} else if ((two.bottomleftx > one.bottomleftx) && (two.toprightx < one.toprightx) && (two.toprighty > one.toprighty) && (two.bottomlefty < one.bottomlefty)) {
			
			intersection = new Rectangle(two.bottomleftx, one.bottomlefty,two.width,one.height, two.toprightx, one.toprighty);
			
		}
		
		if ((one.bottomleftx > two.bottomleftx) && (one.toprightx < two.toprightx) && (one.bottomlefty < two.toprighty) && (one.bottomlefty > two.bottomlefty)) {
				
				intersection = new Rectangle(one.bottomleftx, one.bottomlefty, one.width, (two.toprighty - one.bottomlefty), one.toprightx, two.toprighty);
				
		} else if((one.bottomleftx > two.bottomleftx) && (one.toprightx < two.toprightx) && (one.toprighty > two.bottomlefty) && (one.toprighty < two.toprighty)) {
				
				intersection = new Rectangle(one.bottomleftx,(one.toprighty - (one.toprighty - two.bottomlefty)), one.width, (one.toprighty - two.bottomlefty), one.toprightx, one.toprighty);
				
		}
		
		if ((two.bottomleftx > one.bottomleftx) && (two.toprightx < one.toprightx) && (two.bottomlefty < one.toprighty) && (two.bottomlefty > one.bottomlefty)) {
				
				intersection = new Rectangle(two.bottomleftx, two.bottomlefty, two.width, (one.toprighty - two.bottomlefty), two.toprightx, one.toprighty);
				
		} else if((two.bottomleftx > one.bottomleftx) && (two.toprightx < one.toprightx) && (two.toprighty > one.bottomlefty) && (two.toprighty < one.toprighty)) {
				
				intersection = new Rectangle(two.bottomleftx,(two.toprighty - (two.toprighty - one.bottomlefty)), two.width, (two.toprighty - one.bottomlefty), two.toprightx, two.toprighty);
				
		}
			
		
		if((two.bottomlefty > one.bottomlefty) && (two.toprighty < one.toprighty)) {
			
			if((two.toprightx > one.bottomleftx) && (two.toprightx < one.toprightx)) {
				
				intersection = new Rectangle(one.bottomleftx, two.bottomlefty, (two.toprightx - one.bottomleftx), two.height, two.toprightx, two.toprighty);
				
			} else if((two.bottomleftx > one.bottomleftx) && (two.bottomleftx < one.toprightx)) {
				
				intersection = new Rectangle(two.bottomleftx, two.bottomlefty,(one.toprightx - two.bottomleftx), two.height, one.toprightx, two.toprighty);
				
			}
			
		} else if((one.bottomlefty > two.bottomlefty) && (one.toprighty < two.toprighty)) {
			
			if((one.toprightx > two.bottomleftx) && (one.toprightx < two.toprightx)) {
				
				intersection = new Rectangle(two.bottomleftx, one.bottomlefty, (one.toprightx - two.bottomleftx), one.height, one.toprightx, one.toprighty);
				
			} else if((one.bottomleftx > two.bottomleftx) && (one.bottomleftx < two.toprightx)) {
				
				intersection = new Rectangle(one.bottomleftx, one.bottomlefty,(two.toprightx - one.bottomleftx), one.height, two.toprightx, one.toprighty);
				
			}
		}
		System.out.println("The area is: " + intersection.calculateArea());
		
		return intersection;

	}
	
	/**
	 * Calculates the perimeter of two rectangles.
	 * @param one contains one rectangle
	 * @param two contains one rectangle
	 * @return the perimeter of the rectangles
	 */
	public static int totalPerimeter(Rectangle one, Rectangle two) {
		
		int perimeter = 0;
		Rectangle intersection = intersection(one, two);
		
		if(two.contains(one)) {
			
			perimeter = two.calculatePerimeter();
					
		} else if(one.contains(two)) {
			
			perimeter = one.calculatePerimeter();
			
		} else if(intersection.calculateArea() == 0) {
			
			perimeter = two.calculatePerimeter() + one.calculatePerimeter();
			
		} else {
				
			perimeter = one.width + one.height + two.width + two.height + (one.height - intersection.height) + (two.height - intersection.height) + (one.width - intersection.width) + (two.width - intersection.width);
			
		}
		System.out.println("The perimeter is: " + perimeter);
		
		return perimeter;
		
	}
	
	/**
	 * Checks if a rectangle is contained by another
	 * @param one contains one rectangle
	 * @return a boolean that describes if the rectangle is contained by the object calling the method
	 */
	public boolean contains(Rectangle one) {
		
		boolean inside = false;
		
		if((one.bottomleftx > bottomleftx) && (one.bottomlefty > bottomlefty) && (one.toprightx < toprightx) && (one.toprighty < toprighty)) {
			
			inside = true;
			
		} 
		return inside;
		
	}
	
	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Rectangle thisOne = new Rectangle(2,2,6,4,8,6);
		Rectangle thatOne = new Rectangle(1,3,5,2,6,5);
		intersection(thisOne, thatOne);
		totalPerimeter(thisOne, thatOne);
		thisOne.contains(thatOne);
		

	}

}
