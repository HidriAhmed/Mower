package com.olbati.mower.domain;

/*
 * This class represents the position of the Mower
 * A Position contains a Point and an 
 * orientation (North, East, South, West)
 */
public class Position {

	private Point point;
	private Orientation orientation;

	public Position(Point point, Orientation orientation) {
		super();
		this.point = point;
		this.orientation = orientation;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return String.format("Position [point=%s, orientation=%s]", point,
				orientation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (orientation != other.orientation)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

}
