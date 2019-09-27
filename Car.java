
public class Car {
	//properties:
	private String make;
	private int year;
	private String color;
	private int speed;
	public int distance=0;;
	public int classPlacement=0;
	public int totalPlacements=0;
	public boolean race=true;
	
public boolean isRacing() {//isracing method tells us the value of race. 
	return this.race;
}

		
	public void setDistance(int minute) {//set distance
		int speed = getSpeed();
		this.distance += speed/(minute=60);
		
	}
	public int getDistance() {//return distance
		return distance;
	}
		
	public String getMake() {//get make of car
		return this.make;
	}
	public int getYear() {//get year of car
		return this.year;
	}
	public String getColor() {//get color
		return this.color;
		
	}
	public int getSpeed() {//get speed
		return this.speed;
	}
	public void setMake(int taker) {//take in random number and assign the make a value from that number
		
		switch (taker) {
		case 1: this.make= "Toyota";break;
		case 2: this.make= "Honda"; break;
		case 3: this.make="Mercedes";break;
		case 4: this.make= "Ford";break;
		case 5: this.make= "Dodge";break;
		case 6: this.make= "Bentley";break;
		case 7: this.make= "Range rover";break;
		case 8: this.make = "Chevy";break;
		case 9: this.make = "Infinity";break;
		case 10:this.make= "Audi";break;
		}
		
		

	}
	public void setYear(int yearChoice) {//set year
		this.year=yearChoice;
	}
	public void setColor(int col) {//set color
		if(col==1) {
			this.color="blue";
		}
		if(col==2) {
			this.color="green";
		}
		if(col==3) {
			this.color="red";
			
		}
		
	}
	public void setSpeed(int sped) {//set speed
		this.speed=sped;
	}
	public void accelerate() {
		if(year<2010) {
			this.speed+=15;
		}
		else {
			this.speed+=30;
		}
		
	}
	//need to make sure speed is greater than zero at all times. 
	public void brake() {
		int theSpeed = getSpeed();
		
	
		
		if(year<2010) {
			if((theSpeed-5)>=0) {//braking
				this.speed-=5;
			}
		}
		else {
			if(theSpeed-10>=0) {
			this.speed-=10;}
		}
	}
	public void stop() {//stopping, set speed to zero. 
		setSpeed(0);	}
	
	
		
			
			
		}



