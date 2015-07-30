package com.intactile.persistance;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * 
 * @author Mojdeh
 */
public interface IPersistance {

	/**
	 * Creation DataBase
	 */
	void createDBModel();

	/**
	 * Get DataBase Model
	 * 
	 * @return
	 */
	OntModel getDBModel();

	/**
	 * Delete tables
	 */
	void emptyDBModel();

	/**
	 * Insert Data to DataBase
	 */
	abstract boolean insertElementIntoDB();

}
