package com.olbati.mower.service;

import java.util.ArrayList;
import java.util.List;

import com.olbati.mower.domain.Action;
import com.olbati.mower.domain.Mower;
import com.olbati.mower.domain.Orientation;
import com.olbati.mower.domain.Point;
import com.olbati.mower.domain.Position;
import com.olbati.mower.utils.MowingFileReader;

public class MowingService {

	private String configFilePath;

	public MowingService(String configFilePath) {
		this.configFilePath = configFilePath;
	}

	public List<Position> go() {
		List<Position> finalPositions = new ArrayList<Position>();
		Point highestLeftPoint = null;

		// read the file
		List<Mower> Mowers = MowingFileReader.readMowingConfigFile(
				configFilePath, highestLeftPoint);
		for (Mower mower : Mowers) {
			Position finalPosition = mower.getInitialPosition();
			for (Action action : mower.getActions()) {
				calculateNextPosition(finalPosition, action);
			}
			finalPositions.add(finalPosition);
		}

		return finalPositions;
	}

	public void calculateNextPosition(Position position, Action action) {
		if ("L".equals(action.getActionCode())) {
			position.setOrientation(moveNinetyDegree(position.getOrientation(),
					Action.LEFT));
		} else if ("R".equals(action.getActionCode())) {
			position.setOrientation(moveNinetyDegree(position.getOrientation(),
					Action.RIGHT));
		} else if ("F".equals(action.getActionCode())) {
			moveForward(position);
		}
	}

	public Orientation moveNinetyDegree(Orientation orientation, Action action) {
		Orientation newOrientation = orientation;
		if ("L".equals(action.getActionCode())) {
			if ("N".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.WEST;
			}
			if ("E".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.NORTH;
			}
			if ("S".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.EAST;
			}
			if ("W".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.SOUTH;
			}
		}
		if ("R".equals(action.getActionCode())) {
			if ("N".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.EAST;
			}
			if ("E".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.SOUTH;
			}
			if ("S".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.WEST;
			}
			if ("W".equals(orientation.getOrientationCode())) {
				newOrientation = Orientation.NORTH;
			}
		}
		return newOrientation;
	}

	public void moveForward(Position position) {

		Point point = position.getPoint();
		if ("N".equals(position.getOrientation().getOrientationCode())) {
			point.setPosY(point.getPosY() + 1);
		}
		if ("E".equals(position.getOrientation().getOrientationCode())) {
			point.setPosX(point.getPosX() + 1);
		}
		if ("S".equals(position.getOrientation().getOrientationCode())) {
			point.setPosY(point.getPosY() - 1);
		}
		if ("W".equals(position.getOrientation().getOrientationCode())) {
			point.setPosX(point.getPosX() - 1);
		}
		position.setPoint(point);
	}
}
