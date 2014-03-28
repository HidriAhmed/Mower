package com.olbati.mower.domain;

import java.util.Arrays;

/*
 * Ground class represents the surface that will be mowed
 * it's represented by the higher left point and a grid
 */
public class Ground {

	private Point higherLeftPoint;

	private int[][] grid;

	public Ground(Point higherLeftPoint) {
		super();
		this.higherLeftPoint = higherLeftPoint;
		this.grid = new int[higherLeftPoint.getPosY()][higherLeftPoint
				.getPosX()];
	}

	public Point getHigherLeftPoint() {
		return higherLeftPoint;
	}

	public void setHigherLeftPoint(Point higherLeftPoint) {
		this.higherLeftPoint = higherLeftPoint;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return String.format("Ground [higherLeftPoint=%s, grid=%s]",
				higherLeftPoint, Arrays.toString(grid));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(grid);
		result = prime * result
				+ ((higherLeftPoint == null) ? 0 : higherLeftPoint.hashCode());
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
		Ground other = (Ground) obj;
		if (!Arrays.deepEquals(grid, other.grid))
			return false;
		if (higherLeftPoint == null) {
			if (other.higherLeftPoint != null)
				return false;
		} else if (!higherLeftPoint.equals(other.higherLeftPoint))
			return false;
		return true;
	}

}
