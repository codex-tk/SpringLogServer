package com.codex.diag.model;

public enum LogLevel {
	TRACE(0) , DEBUG(1) , INFO(2), WARN(3) , ERROR(4) , FATAL(5) ;
	
	private final int id;
	LogLevel(int id) { this.id = id; }
	public int getValue() {
		return this.id;
	}
}
