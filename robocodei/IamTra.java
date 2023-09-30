package sample;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;



public class IamTra extends Robot {
	int turnDirection = 1; // Clockwise or counterclockwise

	
	public void run() {
		
		setBodyColor(Color.lightGray);
		setGunColor(Color.gray);
		setRadarColor(Color.darkGray);

		while (true) {
			turnRight(5 * turnDirection);
		}
	}

	
	public void onScannedRobot(ScannedRobotEvent e) {

		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan(); 
	}

	
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		
		if (e.getEnergy() > 16) {
			fire(3);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40); 
	}
}