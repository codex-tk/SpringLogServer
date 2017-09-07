package com.codex.diag.model;

public enum LocationLogType {
	BLE(0) , USER(1);
	
	private final int id;
	LocationLogType(int id) { this.id = id; }
	public int getValue() {
		return this.id;
	}
}
