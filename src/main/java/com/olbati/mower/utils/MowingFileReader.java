package com.olbati.mower.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.olbati.mower.domain.Action;
import com.olbati.mower.domain.Mower;
import com.olbati.mower.domain.Orientation;
import com.olbati.mower.domain.Point;
import com.olbati.mower.domain.Position;

public class MowingFileReader {

	// FIXME method not implemented
	/**
	 * this read from a config file the initial positions and the actions for a
	 * mower
	 * 
	 * @param aFilePath
	 * @return
	 */
	public static List<Mower> readMowingConfigFile(String aFilePath,
			Point highestLowerPoint) {
		List<Mower> mowers = new ArrayList<Mower>();

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(
					"/Users/ahidri/Documents/mowers.txt"));
			int lineIndex = 0;
			int mowerIndex = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				// For the first line
				// extract
				if (lineIndex == 0) {
					String[] lineKeys = sCurrentLine.split(" ");
					int posX = Integer.parseInt(lineKeys[0]);
					int posY = Integer.parseInt(lineKeys[1]);
					highestLowerPoint = new Point(posX, posY);
				} else if (lineIndex % 2 == 1) {
					String[] lineKeys = sCurrentLine.split(" ");

					int posX = Integer.parseInt(lineKeys[0]);
					int posY = Integer.parseInt(lineKeys[1]);
					String orientationString = lineKeys[2];

					Orientation orientation = null;
					if ("E".equals(orientationString)) {
						orientation = Orientation.EAST;
					} else if ("N".equals(orientationString)) {
						orientation = Orientation.NORTH;
					} else if ("S".equals(orientationString)) {
						orientation = Orientation.SOUTH;
					} else if ("W".equals(orientationString)) {
						orientation = Orientation.WEST;
					}
					Point initialPoint = new Point(posX, posY);
					Position initialPosition = new Position(initialPoint,
							orientation);
					Mower newMower = new Mower(initialPosition, null);
					mowers.add(newMower);

				} else if (lineIndex % 2 == 0) {
					Mower mower = mowers.get(mowerIndex);
					List<Action> actions = new ArrayList<Action>();
					for (int i = 0; i < sCurrentLine.length(); i++) {
						char currentChar = sCurrentLine.charAt(i);
						if (currentChar == 'G') {
							actions.add(Action.LEFT);
						} else if (currentChar == 'D') {
							actions.add(Action.RIGHT);
						} else if (currentChar == 'A') {
							actions.add(Action.FORWARD);
						}

					}
					mower.setActions(actions);
					mowerIndex++;
				}
				lineIndex++;
			}

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

		return mowers;
	}
}
