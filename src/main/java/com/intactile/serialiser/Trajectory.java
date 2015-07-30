package com.intactile.serialiser;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.ontology.Individual;

/**
 * 
 * @author Mojdeh
 */
public class Trajectory extends SpatioTemporalObject{

	List<SpaceTimePoint> trajectoryPoints = new ArrayList<SpaceTimePoint>();

	public String getTajectoryId() { //Il faut generer un id automatic different
		return super.stObjId;
	}
	
	public List<SpaceTimePoint> getTrajectoryPoints() {
		return this.trajectoryPoints;
	}

	public void addPointsToTrajectory(SpaceTimePoint point) {
		trajectoryPoints.add(point);
	}

	@Override
	public String toString() {
		String line = " Trajectory has the following points :\n";
		for (SpaceTimePoint p : trajectoryPoints) {
			line += "\t " + p.toString() + " \n";
		}
		return line;
	}

	@Override
	protected Individual saveSpecializedPropertiesToSubClasses(
			Individual stObjIndividual) {
		// TODO Auto-generated method stub
		return null;
	}

}
