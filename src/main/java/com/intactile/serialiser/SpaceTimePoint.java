package com.intactile.serialiser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.hp.hpl.jena.ontology.Individual;

/**
 * 
 * @author Mojdeh
 */
public class SpaceTimePoint extends SpatioTemporalObject implements Comparable<SpaceTimePoint> {

	public String pointLatitude;
	public String pointLongitude;
	public String pointAltitude;
	public String pointDirection;
	public String pointSpeed;
	public String pointTime;

	public String getPointId() {
		return super.stObjId;
	}

	public String getPointLat() {
		return pointLatitude;
	}

	public String getPointLong() {
		return pointLongitude;
	}

	public String getPointAlt() {
		return pointAltitude;
	}

	public String getPointDirection() {
		return pointDirection;
	}

	public String getPointSpeed() {
		return pointSpeed;
	}

	public String getPointSaveTime() {
		return pointTime;
	}

	@Override
	public String toString() {
		return "It's a point with Id:" + getPointId() + ", Latitude:" + pointLatitude + ", Longitude:"
				+ pointLongitude + ", Altitude:" + pointAltitude
				+ ", Direction:" + pointDirection + ", Speed:" + pointSpeed
				+ ", Time:" + pointTime;
	}

	@Override
	public int compareTo(SpaceTimePoint myPoint) {
		SimpleDateFormat inputFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS-Z", Locale.ENGLISH);
		SimpleDateFormat outputFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		int dif = 0;
		try {
			Date dt1 = inputFormat.parse(pointTime);
			Date dt2 = inputFormat.parse(myPoint.pointTime);
			 System.out.println("Date:" + dt1);
			String dtOut1 = outputFormat.format(dt1);
			String dtOut2 = outputFormat.format(dt2);
			int dat1Int = Integer.valueOf(dtOut1);
			int dat2Int = Integer.valueOf(dtOut2);
			dif = dat1Int - dat2Int;
		} catch (ParseException e) {
			e.printStackTrace();
			e.getErrorOffset();
		}	
		return dif;
	}

	@Override
	protected Individual saveSpecializedPropertiesToSubClasses(
			Individual stObjIndividual) {
		// TODO Auto-generated method stub
		return null;
	}

}
