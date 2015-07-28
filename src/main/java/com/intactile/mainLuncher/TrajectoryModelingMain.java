package com.intactile.mainLuncher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.intactile.dataParser.IntDataParser;
import com.intactile.dataParser.ObjectMobile;
import com.intactile.persistance.IntTDB;
import com.intactile.tools.IntConfig;

public class TrajectoryModelingMain {
	public static void main(String args[]) throws IOException {

		List<String> list = Arrays.asList("Travail_maison.csv");
		// readFiles(list);
		// IntTDB.createTDBModel(IntConfig.DIRECTORY, list);

		OntModel model = IntTDB.getTDBModel(IntConfig.DIRECTORY);

		System.out.println("Liste de l'ontologie de base :");

		Resource o = model.createResource("object");
		Property p1 = model.createProperty("has1");
		Literal l1 = model.createLiteral("value1");

		Property p2 = model.createProperty("has7");
		Literal l2 = model.createLiteral("value7");

		model.add(o, p1, l1);
		model.add(o, p2, l2);

		System.err.println(model.size());
		
		model.close();
		
		IntTDB.commit();

		// IntConfig.listProperties();

		// List<String> list = Arrays.asList("Travail_maison.csv", "Burger.csv",
		// "Christophe.csv", "Carré du Roi.csv", "Olivier.csv");

		// parseTest();
		// CreateJenaModel();

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
