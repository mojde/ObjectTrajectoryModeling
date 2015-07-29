package com.intactile.persistance;

import java.util.Map;

/**
*
* @author Mojdeh
*/
public abstract class IntDataBase {

	/** unique Instance non preinitialize */
	private static IntDataBase singlotonDB = null;
	public enum PersistanceType{
        TDB,
        SDB,
    }

	/** Access Point for unique instance of singleton */
	public static IDataBase getDBInstance(PersistanceType persistance) { 
		  switch(persistance){
          case TDB:
              return new IntTDB();
          case SDB:
              /* action */;
      }
      return null;           
	}

	/** Inserts a point for an object */
	abstract boolean insertElement(Map<Object, Object> element);

}
