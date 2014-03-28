package com.olbati.mower.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.olbati.mower.domain.Ground;
import com.olbati.mower.domain.Mower;

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
			Ground aGround) {
		List<Mower> mowers = new ArrayList<Mower>();

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\testing.txt"));
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {

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
