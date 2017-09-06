package com.codex.diag.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.diag.model.LogRecord;
import com.codex.diag.model.LogRepository;

@RestController
public class LSDKController {
	@Autowired
	LogRepository logRepository;
	
	@RequestMapping( value="/lsdk/addlocations", method=RequestMethod.POST )
    public String addLog( @RequestBody HashMap<String,ArrayList<LogRecord>> logs ) {
		for ( LogRecord r : logs.get("logs")) {
			logRepository.save( r );
		}
        return logs.toString();
    }
	/*
	@RequestMapping( value = "/lsdk/getlocatoins" , method=RequestMethod.GET )
	public @ResponseBody HashMap<String,ArrayList<LogRecord>> getLogs(  
			@RequestParam(value = "begin") int begin ,
			@RequestParam(value = "end") int end
			)
	{
		HashMap<String,ArrayList<LogRecord>> logs = new HashMap<String, ArrayList<LogRecord>>();

		logs.put("logs",  logRepository.findByTimestamp(begin, end));
		//
		return logs;
	}*/
}

