package com.olbati.mower.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.olbati.mower.domain.Orientation;
import com.olbati.mower.domain.Point;
import com.olbati.mower.domain.Position;
import com.olbati.mower.service.MowingService;

public class MowingServiceTestUnit {

	public final static String CONFIG_FILE_PATH = "filePath";

	MowingService mower;
	List<Position> expectedFinalPositions = new ArrayList<Position>();

	@Before
	public void init() {
		mower = new MowingService(CONFIG_FILE_PATH);
		Position expectedFinalPosition1 = new Position(new Point(3, 2),
				Orientation.WEST);
		Position expectedFinalPosition2 = new Position(new Point(7, 2),
				Orientation.NORTH);

		expectedFinalPositions.add(expectedFinalPosition1);
		expectedFinalPositions.add(expectedFinalPosition2);
	}

	@Test
	public void MowingSvcTest() {
		// arrange
		// act
		List<Position> testedFinalPositions = mower.go();
		// assert
		assertThat(testedFinalPositions.get(0)).isEqualTo(
				expectedFinalPositions.get(0));
		assertThat(testedFinalPositions.get(1)).isEqualTo(
				expectedFinalPositions.get(1));
	}
}
