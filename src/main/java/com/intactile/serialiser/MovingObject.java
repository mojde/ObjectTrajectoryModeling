package com.intactile.serialiser;

/**
 * 
 * @author Mojdeh
 */
public class MovingObject {

	public String mObjId;
	public String mObjName;
	public String mObjActivity;
	public String mObjDescription;
	public SpaceTimePoint lastPosition;
	public Trajectory objectTrajectory = new Trajectory(); // Il faut que j'initiale ici avec new??
										
	public SpaceTimePoint getLastPosition() {
		return lastPosition;
	}

	public Trajectory getObjectTrajectory() { // a completer avec les points de trajectoire
		return objectTrajectory;
	}

	public void setObjectTrajectory(Trajectory trajectoire) {
		this.objectTrajectory = trajectoire;
	}
}
