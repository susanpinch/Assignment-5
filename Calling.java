import java.util.Random;
import javax.swing.JOptionPane;
public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//generate random numbers to use for information about each car. Variable is r. 
		Random r= new Random();
		
		
		//initialize three variables, these will be used as parameters for the setter methods. 
		int nForColor;
		int n;
		int nForYear;
		int minute; //minute will be used later. 
		boolean racing; // declare variable that keeps while loop going. 
		int placements; // declare placements as int. 
		
		
		
		//instantiate the class, store in array 
		Car[] c= new Car[10];
		//this for loop goes through the class array and instantiates different cars, or elements in the array. 
		//in doing so, we are creating new instances of the class in each element of the array. 
		for(int i =0; i<c.length;i++) {
			//randomly choose a color, 1-3 because there are only three colors we are using 
			nForColor = r.nextInt(3)+1;//set color
			//randomly pick a number 1-10 that will be used to determine the make of the car
			n = r.nextInt(10)+1;
			//then set up the years. half being >=2010 half less. We do this by separating it by the value of i
			
			if(i<5) {
				nForYear=r.nextInt((2009-2001)+1)+2001;
			}
			else {
				nForYear = r.nextInt((2019-2010)+1)+2010;
			}
			//now we are instantiating a new instance of the class inside the array at c[i]
			//then set up everything by sending in values. 
			c[i] = new Car();
			c[i].setColor(nForColor);
			c[i].setMake(n);
			c[i].setYear(nForYear);
			c[i].setSpeed(0);
		}
		
		
		//now we're setting up the race part of the program
		//the race is going to be done 100 times, so we need to set the speed of each of these instances to zero. 
		for(int times=0;times<100;times++) {//100 races
		setZero(c);
		minute=0;//initialize minutes to zero for every race. 
		racing=true;//reset racing to true. 
		placements=1; //set placements equal to one so that we can start off again. 
	
		//while loop where one race is going on
		while(racing) {
			//invoke the race. 
			invokeRace(c, r);//pick a random car and c
			//then set up a for loop that iterates through the length of Car array and sets the distance for each one,
			//while using minutes as parameters. 
			for(int i=0; i<c.length;i++) {
				c[i].setDistance(minute);
				
			}
			//then, set up a for loop that iterates through Car array and finds values that have a distance >= 100
			//and cars that are still racing. These cars we need to stop from racing and find their placement value. 
			for(int x=0; x<c.length;x++) {//check if greater than 100, and make sure that we have not stopped that car from racing yet
				if(c[x].getDistance()>=100 && c[x].isRacing()) {
					//accumulate member variable classPlacements with placements
					c[x].classPlacement+=placements;
					placements++; //accumulate variable in this main class so that the next car that reaches 100 knows its place
					c[x].race=false;//make is racing false so we don't check placements twice. 
				}
				
			}
			racing=checkAll(c); //check all cars to see if they reached 100, equal to racing so we can easily exit out. 
			//accumulates minutes. 
			minute+=1;
			
			
			
		}
		for(int t =0; t<c.length;t++) {
			c[t].totalPlacements+=c[t].classPlacement; //acumulate totalPlacements. 
		}
		
		
		}
		printOut(c);//print out cars, year, average place. 
		
	
		
	}
	public static void printOut(Car[] c) {
		int avg;
		for(int x=0; x<c.length;x++) {
			avg = c[x].totalPlacements/100;
			System.out.println("The car: " + c[x].getMake() + " " + c[x].getYear() + " With an average place of "+ avg);
			
		}
	}
	public static void setZero(Car[] c) {
		for(int x=0;x<c.length;x++) {
			c[x].setSpeed(0);
			c[x].distance=0;
		}
	}


	public static void invokeRace(Car[] c, Random r) {
		//this method is goin to take in the array for cars and the random variable and invoke the race on each car
		//first, make randCar and randCalling integer values. 
		int randCar;
		int randCalling;
		
		
		//pick a randomy car from 0-9
		randCar = r.nextInt(10);
		//pick a random thing to do to the car. 
		randCalling = r.nextInt(3)+1;
		//use switch statements to separate out each task. 
		switch(randCalling) {
		case 1: c[randCar].brake();break;
		case 2: c[randCar].accelerate();break;
		case 3: c[randCar].stop();break;
			
		}
	}
	public static boolean checkAll(Car[] c) {
		boolean flag=false;
		for(int x=0; x<c.length;x++) {
			if(c[x].getDistance()>=100) {
				continue;
			}
			else {
				flag=true;
			}
		}
		return flag;
	}


	
	
	

}
