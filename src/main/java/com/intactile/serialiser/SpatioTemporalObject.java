package com.intactile.serialiser;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntProperty;
import com.intactile.datamodel.IntModelConcepts;
import com.intactile.datamodel.IntSTModel;

public abstract class SpatioTemporalObject {

	public String stObjId;
	
	  public Individual saveSTObjectProperties() {

	        IntSTModel geomodel = IntSTModel.getInstance();
	        OntClass mySTObj = geomodel.getSTOntClass(IntModelConcepts.SpatioTemporalObject);

	        Individual stObjIndividual = mySTObj.createIndividual(geomodel.getNs_STModel()
	                + stObjId);

	        for (OntProperty pr : mySTObj.listDeclaredProperties().toList()) {
	            if (pr.getLocalName().equals("featureName")) {
	                
	            } else if (pr.getLocalName().equals("featureType")) {
	               
	            } else if (pr.getLocalName().equals("featureDescription")) {
	                
	            }
	        }

		this.saveSpecializedPropertiesToSubClasses(stObjIndividual);
	        
	        System.err.println("It's Save into TDB");
	        return stObjIndividual;
	    }

	  protected abstract Individual saveSpecializedPropertiesToSubClasses(Individual stObjIndividual);
	  
	  }
