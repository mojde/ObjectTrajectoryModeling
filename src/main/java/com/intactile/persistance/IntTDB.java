package com.intactile.persistance;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.TDBLoader;
import com.hp.hpl.jena.util.FileManager;
import com.intactile.tools.IntConfig;

public class IntTDB extends IntDataBase {

	private static Logger logger = Logger.getLogger(TDBLoader.class);

	private static IntTDB singloton = null;

	private IntTDB() {
	}

	public static IntTDB getTDBInstance() {
		if (singloton == null) {
			singloton = new IntTDB();
		}
		return singloton;
	}

	/**
	 * Load a Model in TDB TripleStore Read existent Model at first load
	 */
	public static void createTDBModel(String directory, List<String> files) {

		Dataset dataset = TDBFactory.createDataset(directory);
		Model tdbModel = dataset.getNamedModel("ST_Model");

		dataset.begin(ReadWrite.READ) ;
		 try {
			 System.out.println("Liste de l'ontologie de base :");
			 tdbModel.close();
		 } finally { dataset.end() ; }
		
		
		
//		dataset.begin(ReadWrite.READ);

//		try {
//			Model tdbModel = dataset.getNamedModel("ST_Model");
//
//			System.out.println("Liste de l'ontologie de base :");
//	
//			Resource o = tdbModel.createResource("object");
//			Property p1 = tdbModel.createProperty("has1");
//			Literal l1 = tdbModel.createLiteral("value1");
//			
//			Property p2 = tdbModel.createProperty("has2");
//			Literal l2 = tdbModel.createLiteral("value2");
//			
//			
//			
//			tdbModel.add( o , p1, l1);
//			tdbModel.add( o , p2, l2);
//			
//			tdbModel.close();
//		} finally {
//			dataset.end();
//		}
		
		dataset.end();
		
	}

	/**
	 * Model recovery
	 */
	public static OntModel getTDBModel(String directory) {
		Dataset dataset = TDBFactory.createDataset(directory);
		Model m2 = dataset.getDefaultModel();
		FileManager.get().readModel(m2, directory);
		/*
		 * System.out.println("Liste de l'ontologie :"); Iterator classIter =
		 * m2.listObjects(); while (classIter.hasNext()) { Object rdfn =
		 * (Object) classIter.next(); System.out.println(rdfn); }
		 */
		OntModel mTdb = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,
				m2);
		return mTdb;
	}

	@Override
	boolean insertElement(Map<Object, Object> element) {
		return false;
	}

}
