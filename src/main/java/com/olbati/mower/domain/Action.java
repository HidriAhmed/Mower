package com.olbati.mower.domain;

/*
 * Action Enum contains the possible actions
 * that a mower can perform
 */
public enum Action {
	LEFT("L"), RIGHT("R"), FORWARD("F");

	private String actionCode;

	private Action(String action) {
		this.actionCode = action;
	}

	public String getActionCode() {
		return actionCode;
	}

}
