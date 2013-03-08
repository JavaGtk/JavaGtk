package org.java_gtk.gtk;

public enum SelectionMode {
	NONE(0),
	SINGLE(1),
	BROWSE(2),
	MULTIPLE(3);
	
	private SelectionMode(int value) {
		this.value = value;
	}
	
	private int value;
	
	public int getValue() {
		return value;
	}

}
