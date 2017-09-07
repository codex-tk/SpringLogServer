package com.codex.diag.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codex.diag.model.LocationLogRecord;
import com.codex.diag.repositories.LocationLogRepository;

@Service("LocationLogService")
public class LocationLogServiceImpl implements LocationLogService {
	
	final int MAX_UUID_TS_RANGE = 60 * 60 * 24;
	final int MAX_LOG_TS_RANGE =  60 * 10;
	
	@Autowired
	LocationLogRepository repository;

	@Override
	public void addLogs(List<LocationLogRecord> logs) {
		for (LocationLogRecord r : logs ) {
			repository.save(r);
		}
	}

	@Override
	public List<String> findUUIDsByTimestamp(long begin, long end) {
		if ( end < begin ) {
			end = begin + MAX_UUID_TS_RANGE;
		}
		if ( end == 0 || begin == 0 ) {
			end = System.currentTimeMillis() / 1000;
			begin = end - MAX_UUID_TS_RANGE;
		}
		if ( end - begin > MAX_UUID_TS_RANGE ) {
			end = begin + MAX_UUID_TS_RANGE;
		}
		return repository.findUUIDsByTimestamp (begin, end);
	}

	@Override
	public List<LocationLogRecord> findLogsByTimestamp(long begin, long end) {
		if ( end < begin ) {
			end = begin + MAX_LOG_TS_RANGE;
		}
		if ( end == 0 || begin == 0 ) {
			end = System.currentTimeMillis() / 1000;
			begin = end - MAX_LOG_TS_RANGE;
		}
		if ( end - begin > MAX_LOG_TS_RANGE ) {
			end = begin + MAX_LOG_TS_RANGE;
		}
		return repository.findLogsByTimestamp(begin, end);
	}
	
	@Override
	public List<LocationLogRecord> findLogsByUUIDAndTimestamp(
			String uuid ,
			long begin , 
			long end ) {
		if ( end < begin ) {
			end = begin + MAX_LOG_TS_RANGE;
		}
		if ( end == 0 || begin == 0 ) {
			end = System.currentTimeMillis() / 1000;
			begin = end - MAX_LOG_TS_RANGE;
		}
		if ( end - begin > MAX_LOG_TS_RANGE ) {
			end = begin + MAX_LOG_TS_RANGE;
		}
		return repository.findLogsByUUIDAndTimestamp(uuid , begin, end);
	}


}
