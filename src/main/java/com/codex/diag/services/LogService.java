package com.codex.diag.services;

import java.util.List;

import com.codex.diag.model.LogRecord;

public interface LogService {
	void addLogs( List<LogRecord> logs );
	List<String> findUUIDsByTimestamp( long begin , long end );
	List<LogRecord> findLogsByTimestamp( long begin , long end ); 
	List<LogRecord> findLogsByUUIDAndTimestamp(
			String uuid ,
			long begin , 
			long end );
}
