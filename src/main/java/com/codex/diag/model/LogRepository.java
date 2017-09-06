package com.codex.diag.model;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LogRepository extends CrudRepository<LogRecord, Long>{
	ArrayList<LogRecord> findByuuid(String uuid);
	
	@Query("select r from LogRecord as r where r.timestamp > :begin and r.timestamp < :end")
	public ArrayList<LogRecord> findByTimestamp(@Param("begin") long begin , @Param("end") long end );
}