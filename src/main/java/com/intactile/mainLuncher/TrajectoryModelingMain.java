package com.intactile.mainLuncher;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.intactile.datamodel.IntModelConcepts;
import com.intactile.datamodel.IntSTModel;
import com.intactile.persistance.IPersistance;
import com.intactile.persistance.IntPersistanceFactory;

/**
 * 
 * @author Mojdeh
 */
public class TrajectoryModelingMain {

	public static void main(String args[]) throws Exception {

		// CreateOntologyFromOntologyFile();
		 TdbTest();
		// CreateJenaModel();
		// Interogation();
	}

	public static void CreateOntologyFromOntologyFile() {

		IPersistance persistance = IntPersistanceFactory
				.getDBInstance(IntPersistanceFactory.PersistanceType.TDB);
		persistance.insertElementIntoDB();
	}

	public static void Interogation() {
		Model model = null; // createOntologyModel

		Query query = QueryFactory.create();
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect();
			ResultSetFormatter.out(System.out, results);
		} finally {
			qexec.close();
		}
	}

	public static void TdbTest() {
		IntSTModel modelFactory = IntSTModel.getInstance();
		OntClass cl = modelFactory.getSTOntClass(IntModelConcepts.MovingObject);

		// System.err.println(cl.listDeclaredProperties().toList().size());
		for (OntProperty p : cl.listDeclaredProperties().toList()) {
			System.err.println("Class MovingObject:" + p.getRange() + " "
					+ p.getDomain() + " " + p.getLocalName());
		}
	}

	public static void CreateJenaModel() throws Exception {
		IntSTModel modelFactory = IntSTModel.getInstance();
		modelFactory.toConsole();
	}
}