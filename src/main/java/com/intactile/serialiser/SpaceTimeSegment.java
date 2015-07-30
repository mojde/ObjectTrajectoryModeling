package com.intactile.serialiser;

import com.hp.hpl.jena.ontology.Individual;

/**
 * 
 * @author Mojdeh
 */
public class SpaceTimeSegment extends SpatioTemporalObject{

	public String getSegmentId() { //Il faut generer un id automatic different
		return super.stObjId;
	}

	@Override
	protected Individual saveSpecializedPropertiesToSubClasses(
			Individual stObjIndividual) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
