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

import com.codex.diag.model.LocationLogRecord;
import com.codex.diag.services.LocationLogService;

@RestController
public class LocationLogController {
	
	@Autowired
	LocationLogService locationLogService;
	
	@RequestMapping( "/location_log/add" )
	public void add(@RequestBody HashMap<String, ArrayList<LocationLogRecord>> logs ) {
		locationLogService.addLogs(logs.get("logs"));
	}
	
	@RequestMapping( value = "/location_log/get_logs_by_timestamp" , method = RequestMethod.GET )
	public @ResponseBody HashMap<String,List<LocationLogRecord>> getLogsByTimestamp(
			@RequestParam(value = "begin", required = false ) long begin,
			@RequestParam(value = "end", required = false) long end) 
	{
		HashMap<String,List<LocationLogRecord>> ans = new HashMap<String,List<LocationLogRecord>>();
		ans.put("logs", locationLogService.findLogsByTimestamp(begin, end));
		return ans;
	}
	
	@RequestMapping( value = "/location_log/get_uuids_by_timestamp" , method = RequestMethod.GET )
	public @ResponseBody HashMap<String,List<String>> getUUIDsByTimestamp( 
			@RequestParam( value = "begin" ) long begin ,
			@RequestParam( value = "end" ) long end )
	{
		HashMap<String, List<String>> ans = new HashMap<String, List<String>>();
		List<String> uuids = locationLogService.findUUIDsByTimestamp(begin, end);
		ans.put("uuids", uuids );
		return ans;
	}
	
	@RequestMapping( value = "/location_log/get_logs_by_uuid_and_timestamp" , method = RequestMethod.GET )
	public @ResponseBody HashMap<String,List<LocationLogRecord>> getLogsByUUIDAndTimestamp(
			@RequestParam( value = "uuid" ) String uuid ,
			@RequestParam( value = "begin" ) long begin ,
			@RequestParam( value = "end" ) long end ){
		HashMap<String,List<LocationLogRecord>> ans = new HashMap<String,List<LocationLogRecord>>();
		ans.put("logs", locationLogService.findLogsByUUIDAndTimestamp(uuid, begin, end));
		return ans;
	}
	
	
}
