package com.intactile.datamodel;

import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.intactile.persistance.IntDataBase;

public class IntSTModel {

	static IntSTModel singleton = null;
	private OntModel model;

	// name space
	private String ns_STmodel = "http://www.intactile.com/ontologies/2015/7/myST_Ontology.owl#";
	private String ns_Geosparl = "https://www.opengis.net/ont/geosparql#";
	private String ns_temporal = "http://www.w3.org/2006/time#";

	// myclasses
	private OntClass spaceTimePoint;
	private OntClass spaceTimeSegment;
	private OntClass trajectory;
	private OntClass movingObject;
	private OntClass port;
	private OntClass way;

	// geosparql class
	private OntClass feature;
	private OntClass geometry;

	// temporal classes
	private OntClass instant;
	private OntClass interval;

	public OntModel getModel() {
		return model;
	}

	private IntSTModel() {
		initSTModel();
	}

	public static IntSTModel getInstance() {
		if (singleton == null) {
			singleton = new IntSTModel();
		}
		return singleton;
	}

	/**
	 * Init Model
	 */
	private void initSTModel() {
		System.out.println("Model init ...");
		model = IntDataBase.getDBInstance(IntDataBase.PersistanceType.TDB)
				.getDBModel();

		System.out.println("Model Parse Classes");
		Iterator<OntClass> modelClasses = model.listClasses();
		try {
			// if base is created
			if (modelClasses.hasNext()) {
				System.out.println("Getting existing ");
				do {
					OntClass c = modelClasses.next();
					IntModelConcepts type = IntModelConcepts.Unknown;
					try {
						type = IntModelConcepts.valueOf(c.getLocalName());
					} catch (Exception e) {
						// System.err.println("unkown :" + c.getLocalName());
						type = IntModelConcepts.Unknown;
					}

					switch (type) {
					case SpaceTimePoint:
						spaceTimePoint = c;
						break;
					case SpaceTimeSegment:
						spaceTimeSegment = c;
						break;
					case Trajectory:
						trajectory = c;
						break;
					case Port:
						port = c;
						break;
					case Way:
						way = c;
						break;
					case MovingObject:
						movingObject = c;
						break;

					// LOAD GEO SPARQL CLASS
					case Feature:
						feature = c;
						break;
					case Geometry:
						geometry = c;
						break;
					case Instant:
						instant = c;
						break;
					case Interval:
						interval = c;
						break;
					default:
						break;
					}
					// System.err.println(c.getLocalName());
					// Iterator<OntProperty> pso = c.listDeclaredProperties();
					// while (pso.hasNext()) {
					// OntProperty p = pso.next();
					// System.out.println(p.getLocalName());
					// }
				} while (modelClasses.hasNext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public OntClass getSTOntClass(IntModelConcepts type) {
		switch (type) {
		case SpaceTimePoint:
			return spaceTimePoint;

		case SpaceTimeSegment:
			return spaceTimeSegment;

		case Trajectory:
			return trajectory;

		case Port:
			return port;

		case Way:
			return way;

		case MovingObject:
			return movingObject;

		case Feature:
			return feature;

		case Geometry:
			return geometry;

		case Instant:
			return instant;

		case Interval:
			return interval;
		default:
			break;
		}
		return null;
	}

	public String getNs_STModel() {
		return ns_STmodel;
	}

	public String getNs_GeoSparql() {
		return ns_Geosparl;
	}

	public String getNs_Temporal() {
		return ns_temporal;
	}

	public void toConsole() {
		try {
			model.write(new OutputStreamWriter(System.out, "UTF8"),
					"RDF/XML-ABBREV");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
