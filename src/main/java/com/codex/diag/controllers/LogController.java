package com.codex.diag.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.diag.model.LogRecord;
import com.codex.diag.services.LogService;

@RestController
public class LogController {
	
	@Autowired 
	LogService logService;

	@RequestMapping(value = "/log/add", method = RequestMethod.POST)
	public void add(@RequestBody HashMap<String, ArrayList<LogRecord>> logs) {
		logService.addLogs(logs.get("logs"));
	}
	
	@RequestMapping(value= "/log/get_uuids_by_timestamp" , method = RequestMethod.GET )
	public @ResponseBody HashMap<String,List<String>> getUUIDSByTimestamp(
			@RequestParam(value="begin") long begin ,
			@RequestParam(value="end") long end )
	{
		HashMap<String,List<String>> ans = new HashMap<String,List<String>>();
		ans.put("uuids",  logService.findUUIDsByTimestamp(begin, end));
		return ans;
	}
		

	@RequestMapping(value = "/log/get_logs_by_timestamp", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<LogRecord>> getLogsByTimestamp(
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "end") int end) 
	{
		HashMap<String, List<LogRecord>> logs = new HashMap<String, List<LogRecord>>();
		logs.put("logs", logService.findLogsByTimestamp(begin, end));
		return logs;
	}
	
	@RequestMapping(value = "/log/get_logs_by_uuid_and_timestamp", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<LogRecord>> getLogsByUUIDAndTimestamp(
			@RequestParam(value = "uuid" ) String uuid ,
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "end") int end) 
	{
		HashMap<String, List<LogRecord>> logs = new HashMap<String, List<LogRecord>>();
		logs.put("logs", logService.findLogsByUUIDAndTimestamp( uuid , begin, end));
		return logs;
	}
}
