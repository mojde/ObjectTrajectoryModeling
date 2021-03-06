package com.intactile.persistance;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.util.FileManager;
import com.intactile.tools.IntConfig;

/**
 * 
 * @author Mojdeh
 */
public class IntTDB extends IntPersistanceFactory {

	private static Dataset dataset = null;
	private static IntTDB singloton = null;

	public IntTDB() {
	}

	public static IntTDB getTDBInstance() {
		if (singloton == null) {
			singloton = new IntTDB();
		}
		return singloton;
	}

	/**
	 * Create a new model, Read existent Model at first load
	 * 
	 * @param directory
	 */
	@Override
	public void createDBModel() {
		if (dataset == null)
			System.out.println("Creating DataBase....");
		dataset = TDBFactory.createDataset(IntConfig.DIRECTORY);
		Model tdbModel = dataset.getDefaultModel();
		dataset.end();
	}

	/**
	 * Model recovery
	 */
	@Override
	public OntModel getDBModel() {
		if (dataset == null)
			dataset = TDBFactory.createDataset(IntConfig.DIRECTORY);
		dataset.begin(ReadWrite.WRITE);
		Model model = dataset.getDefaultModel();
		OntModel mTdb = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,
				model);
		return mTdb;
	}

	@Override
	public void emptyDBModel() {

		File fileToRemove = new File(IntConfig.DIRECTORY);
		if (fileToRemove.exists()) {
			System.out.println("Doing Empty DataBase....");
			try {
				FileUtils.deleteDirectory(fileToRemove);
			} catch (IOException ex) {
				Logger.getLogger(IntTDB.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	public static boolean commit() {
		dataset.commit();
		return true;
	}

	@Override
	public boolean insertElementIntoDB() {

		OntModel initModelTDB = getDBModel();
		/**
		 * Load Model from given file
		 * 
		 * @param filename
		 */
		Model modelFromFile = FileManager.get().readModel(initModelTDB,
				IntConfig.ONTOLOGY_FILE);
		List<Statement> stmts = modelFromFile.listStatements().toList();
		for (Statement stmt : stmts) {
			System.out.println(stmt.toString());
			// put the statement of model input in persistence model output
			initModelTDB.add(stmt);
		}
		System.err.println(initModelTDB.listClasses().toList().size());
		initModelTDB.close();

		return true;
	}
}