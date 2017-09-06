package com.codex.diag.model;

import javax.persistence.*;

@Entity
@Table(name="tbl_log_records")
public class LogRecord {
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE) @Column(name = "id")
	long id;
	@Column(name = "uuid") 
	String uuid;	
	@Column(name = "level")
	LogLevel level;
	@Column(name = "timestamp")
	long timestamp; 
	@Column(name = "message")
	String message;
	
	public long getId() {
		return id;
	}
	public LogRecord setId(long id) {
		this.id = id;
		return this;
	}
	@Override
	public String toString() {
		return uuid + " " + level.toString() +  " "  + Long.toString(timestamp)  +  " " + message;
	}
	public String getUuid() {
		return uuid;
	}

	public LogRecord setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public LogRecord setMessage(String message) {
		this.message = message;
		return this;
	}

	public LogLevel getLevel() {
		return level;
	}

	public LogRecord setLevel(LogLevel level) {
		this.level = level;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public LogRecord setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}
}
