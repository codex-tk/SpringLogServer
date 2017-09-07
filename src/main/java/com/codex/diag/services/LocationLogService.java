package com.codex.diag.services;

import java.util.List;

import com.codex.diag.model.LocationLogRecord;

public interface LocationLogService {
	void addLogs( List<LocationLogRecord> logs );
	List<String> findUUIDsByTimestamp(long begin , long end );
	List<LocationLogRecord> findLogsByTimestamp(long begin , long end );
	List<LocationLogRecord> findLogsByUUIDAndTimestamp(
			String uuid ,
			long begin , 
			long end );
}
