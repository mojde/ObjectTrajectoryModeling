package com.intactile.persistance;

import com.hp.hpl.jena.ontology.OntModel;

public interface IDataBase {
	
    /**
     * Creation tables
     */
	void createDBModel();
	
	
	/**
     * Get Model
     * @return 
     */
	OntModel getDBModel();

	
    /**
     * Delete tables
     */
    void emptyDBModel();
    
    /**
     * Insert Data
     */
    abstract boolean insertElement();

}
