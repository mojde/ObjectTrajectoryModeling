package com.intactile.serialiser;

import java.util.ArrayList;
import java.util.List;

public class ObjectMobile {

	public String objectId;
	public String objectName;
	public String activity;
	public String description;
	public List<ObjectPoints> points = new ArrayList<ObjectPoints>();

	public ObjectMobile() {

	}

	public int getPointSize() {
		return points.size();
	}
}
