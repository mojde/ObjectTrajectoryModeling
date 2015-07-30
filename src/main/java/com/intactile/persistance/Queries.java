package com.intactile.persistance;

/**
 * 
 * @author Mojdeh
 */
public class Queries {

	public static String prefix = "PREFIX afn: <http://jena.hpl.hp.com/ARQ/function#>"
			+ "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
			+ "PREFIX geo: <http://www.opengis.net/ont/geosparql#>"
			+ "PREFIX geof: <http://www.opengis.net/def/function/geosparql/>"
			+ "PREFIX gml: <http://www.opengis.net/ont/gml#>"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
			+ "PREFIX par: <http://parliament.semwebcentral.org/parliament#>"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
			+ "PREFIX sf: <http://www.opengis.net/ont/sf#>"
			+ "PREFIX time: <http://www.w3.org/2006/time#>"
			+ "PREFIX units: <http://www.opengis.net/def/uom/OGC/1.0/>"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
			+ ""
			+ "PREFIX myST:<http://www.intactile.com/ontologies/2015/7/myST_Ontology#>"
			+ "PREFIX myS:<http://www.intactile.com/ontologies/2015/7/myS_Ontology#>"
			+ "PREFIX myT:<http://www.intactile.com/ontologies/2015/7/myT_Ontology#>"
			+ "PREFIX mySx:<http://www.IntactileDESGN.com/ontologies/2014/Example#> "
			+ "" + "PREFIX spatial: <http://jena.apache.org/spatial#>";

	public static String req = prefix
			+ " SELECT ?port ?ship ?when ?position WHERE  " + "{"
			+ "?ship rdfs:label \"Alpha\" ." + "?ship rdf:type myS:Ship ."
			+ "?ship myST:isTimeSliceOf ?timeslice ." + ""
			+ "?timeslice geo:hasGeometry  ?gposition ."
			+ "?timeslice myST:atTime  ?tposition ."
			+ "?tposition myT:timeValue  ?when ."
			+ "?gposition geo:asWKT ?position ."
			+ "?gposition myS:pointSpeed ?speed ." + ""
			+ "?port rdfs:label \"Port bastia\" ."
			+ "?port rdf:type myS:Port ." + "?port geo:hasGeometry ?geoPort ."
			+ "?geoPort geo:asWKT ?wktPort ." + ""
			+ "?position spatial:withinCircle(42.689615 9.469331 10 'km')"
			+ "}";

	public static String req2 = prefix
			+ " SELECT ?ship ?position ?when ?speed WHERE  " + "{"
			+ "?ship rdfs:label \"Alpha\" ." + "?ship rdf:type myS:Ship ."
			+ "?ship myST:isTimeSliceOf ?timeslice ." + ""
			+ "?timeslice geo:hasGeometry  ?gposition ."
			+ "?timeslice myST:atTime  ?tposition ."
			+ "?tposition myT:timeValue  ?when ."
			+ "?gposition geo:asWKT ?position ."
			+ "?gposition myS:pointSpeed ?speed ." + "}";

	static String req3 = prefix + " SELECT ?position ?when WHERE  " + "  { "
			+ "?ship rdfs:label \"Alpha\" ." + "?ship rdf:type myS:Ship ."
			+ "?ship myST:isTimeSliceOf ?timeslice ." + ""
			+ "?timeslice geo:hasGeometry  ?gposition ."
			+ "?timeslice myST:atTime  ?tposition ."
			+ "?tposition myT:timeValue  ?when ."
			+ "?gposition geo:asWKT ?position ."
			+ "?gposition myS:pointSpeed ?speed ." + ""
			+ "FILTER ( ?when > \"2014-06-28T11:00:00\"^^xsd:dateTime) ."
			+ "FILTER ( ?when < \"2014-06-28T13:30:00\"^^xsd:dateTime)." + "}";

}
