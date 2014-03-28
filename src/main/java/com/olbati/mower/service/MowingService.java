package com.olbati.mower.service;

import java.util.ArrayList;
import java.util.List;

import com.olbati.mower.domain.Position;

public class MowingService {

	private String configFilePath;

	public MowingService(String configFilePath) {
		this.configFilePath = configFilePath;
	}

	public List<Position> go() {
		List<Position> finalPositions = new ArrayList<Position>();

		return finalPositions;
	}

}
