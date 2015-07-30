package com.intactile.persistance;


/**
*
* @author Mojdeh
*/
public abstract class IntPersistanceFactory implements IPersistance {

	/** unique Instance non preinitialize */
	private static IntPersistanceFactory singlotonDB = null;
	public enum PersistanceType{
        TDB,
        SDB,
    }

	/** Access Point for unique DBinstance of singleton */
	public static IPersistance getDBInstance(PersistanceType persistance) { 
		  switch(persistance){
          case TDB:
              return new IntTDB();
          case SDB:
              /* action */;
      }
      return null;           
	}

	/** Inserts the Elements into DB */
	public abstract boolean insertElementIntoDB();

}
