package com.olbati.mower.domain;

import java.util.List;

/*
 * A mower is represented by its initial position
 * and the sequence of actions that he will perform
 */
public class Mower {

	private Position initialPosition;
	private List<Action> actions;

	public Mower(Position initialPosition, List<Action> actions) {
		super();
		this.initialPosition = initialPosition;
		this.actions = actions;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return String.format("Mower [initialPosition=%s, actions=%s]",
				initialPosition, actions);
	}

}
