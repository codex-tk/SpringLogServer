package com.codex.diag.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.diag.model.LocationLogRecord;
import com.codex.diag.model.LocationLogRepository;
import com.codex.diag.model.LogRecord;
import com.codex.diag.model.LogRepository;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class LoggingController {
	@Autowired
	LogRepository logRepository;
	@Autowired
	LocationLogRepository locationLogRepository;

	@RequestMapping(value = "/add_log", method = RequestMethod.POST)
	public String addLog(@RequestBody HashMap<String, ArrayList<LogRecord>> logs) {
		for (LogRecord r : logs.get("logs")) {
			logRepository.save(r);
		}
		return logs.toString();
	}

	@RequestMapping(value = "/get_logs", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, ArrayList<LogRecord>> getLogs(
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "end") int end) 
	{
		HashMap<String, ArrayList<LogRecord>> logs = new HashMap<String, ArrayList<LogRecord>>();

		logs.put("logs", logRepository.findByTimestamp(begin, end));
		//
		return logs;
	}
	
	@RequestMapping(value = "/add_location_log", method = RequestMethod.POST)
	public String addLocationLog(@RequestBody HashMap<String, ArrayList<LocationLogRecord>> logs) {
		for (LocationLogRecord r : logs.get("logs")) {
			locationLogRepository.save(r);
		}
		return logs.toString();
	}
	
	@RequestMapping( value = "/get_location_log_devices" , method = RequestMethod.GET )
	public @ResponseBody HashMap<String, ArrayList<String>> getLocationLogDevices(
			@RequestParam(value = "begin", required = false ) long begin,
			@RequestParam(value = "end", required = false) long end) 
	{
		if ( begin == 0 || end == 0 ) {
			begin = 0;
			end = System.currentTimeMillis();
			/*
			end = System.currentTimeMillis();
			begin = end - 6000;
			end += 10000;
			*/
		}
		HashMap<String, ArrayList<String>> ans = new HashMap<String, ArrayList<String>>();
		ArrayList<String> uuids = locationLogRepository.findUUIDSbyTimestamp(begin, end);
		ans.put("uuids", uuids );
		return ans;
	}
	
	@RequestMapping(value = "/get_location_logs", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, ArrayList<LocationLogRecord>> getLocationLogs(
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "end") int end) 
	{
		HashMap<String, ArrayList<LocationLogRecord>> logs = new HashMap<String, ArrayList<LocationLogRecord>>();

		logs.put("logs", locationLogRepository.findByTimestamp(begin, end));
		//
		return logs;
	}
}
