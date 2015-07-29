package com.intactile.mainLuncher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.intactile.datamodel.CreateSTOntologyFromFile;
import com.intactile.persistance.IntDataBase;
import com.intactile.persistance.IntDataBase.PersistanceType;
import com.intactile.serialiser.IntDataParser;
import com.intactile.serialiser.ObjectMobile;

public class TrajectoryModelingMain {

	public static void main(String args[]) throws IOException {
		CreateOntologyFromOntologyFile();
		//Interogation();
	}

	public static void CreateOntologyFromOntologyFile() {
		String[] files = { "./resources/STOntologie.owl",
				"./resources/TOntologie.owl", "./resources/SOntologie.owl" };
		CreateSTOntologyFromFile
				.CreateOntologyFromFile("ressources/STOntologie.owl");
		// CreateOntologyModel.CreateMemOntologyFromFiles(files, "RDF/XML");
	}

	public static void Interogation(){
		Model model = null; //createOntologyModel

		Query query = QueryFactory.create();
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect();
			ResultSetFormatter.out(System.out, results);
		} finally {
			qexec.close();
		}
	}

	private static void readFiles(List<String> fileNames) {
		Iterator<String> itr = fileNames.iterator();
		IntDataParser pars;
		List<ObjectMobile> lst = null;
		while (itr.hasNext()) {
			System.out
					.println("****************Nouveau Item******************");
			String fileName = itr.next();
			pars = new IntDataParser(fileName, ",");
			lst = pars.parse();
			for (ObjectMobile obj : lst) {
				System.out.println(obj);
			}
		}
	}
}