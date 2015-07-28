package com.intactile.persistance;

import java.util.Map;

public abstract class IntDataBase {

	/** unique Instance non preinitialize */
	private static IntDataBase singlotonDB = null;
	


	/** Access Point for unique instance of singleton */
	public static void getDBInstance(IntDBKind dbKind) { 
		//IntDBKind.class... recuperer le singloton de DB choisi
	}

	/** Inserts a point for an object */
	abstract boolean insertElement(Map<Object, Object> element);

}
