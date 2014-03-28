package com.olbati.mower.domain;

/*
 * Orientation Enum contains the possible orientations
 * to which a mower can be directed
 */
public enum Orientation {

	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	private String orientationCode;

	private Orientation(String orientation) {
		this.orientationCode = orientation;
	}

	public String getOrientationCode() {
		return orientationCode;
	}

}
