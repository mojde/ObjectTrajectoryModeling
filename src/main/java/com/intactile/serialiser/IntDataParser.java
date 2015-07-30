package com.intactile.serialiser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Mojdeh
 */
public class IntDataParser {

	String path;
	String deliminator = "\t";

	public IntDataParser() {
	}

	public IntDataParser(String filename, String deliminator) {
		path = filename;
		this.deliminator = deliminator;
	}

	public List<MovingObject> parse() {

		List<MovingObject> lst = new LinkedList<>();
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(path));
			String[] strs = null;
			MovingObject movingObject = new MovingObject();
			while ((sCurrentLine = br.readLine()) != null) {
				strs = sCurrentLine.split(deliminator);
				SpaceTimePoint point = new SpaceTimePoint();
				if (strs.length <= 4) {
					movingObject.mObjId = strs[0];
					movingObject.mObjName = strs[1];
					movingObject.mObjActivity = strs[2];
					movingObject.mObjDescription = strs[3];
					lst.add(movingObject);
				} else if (strs.length > 4) {
					point.stObjId = strs[0];
					point.pointLatitude = strs[1];
					point.pointLongitude = strs[2];
					point.pointAltitude = strs[3];
					point.pointDirection = strs[4];
					point.pointSpeed = strs[5];
					point.pointTime = strs[6];
					movingObject.objectTrajectory.trajectoryPoints.add(point);
				}
				for (int i = 0; i < strs.length; i++) {
					System.err.print(strs[i] + " - ");
				}
				System.err.println();
			}
			System.out.println("---------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("List of Objects:" + lst);
		return lst;
	}
}
