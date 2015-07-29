package com.intactile.datamodel;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.intactile.persistance.IDataBase;
import com.intactile.persistance.IntDataBase;

/** 
 * @author Mojdeh
 * @see Must be called one time in programme
 */
public class CreateSTOntologyFromFile {
	
	/**
	 * Load Model from given file
	 * 
	 * @param filename
	 */
	public static void CreateOntologyFromFile(String filename) {

		// model input
		Model modelOrigin = FileManager.get().loadModel(filename);

		// get persistence model
		IDataBase persistance = IntDataBase
				.getDBInstance(IntDataBase.PersistanceType.TDB);
		persistance.emptyDBModel();
		persistance.createDBModel();

		// model output
		OntModel modelClone = persistance.getDBModel();

		// put the statement of model input in persistence model output
		StmtIterator stmts = modelOrigin.listStatements();
		while (stmts.hasNext()) {
			Statement stmt = stmts.next();
			System.out.println(stmt.toString());
			modelClone.add(stmt);
		}
		// System.err.println(modelClone.listClasses().toList().size());
		modelClone.close();
	}

}
