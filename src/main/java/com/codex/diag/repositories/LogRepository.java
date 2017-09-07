package com.codex.diag.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codex.diag.model.LogRecord;

public interface LogRepository extends CrudRepository<LogRecord, Long>{
	ArrayList<LogRecord> findByuuid(String uuid);
	
	@Query("select r from LogRecord as r where r.timestamp >= :begin and r.timestamp <= :end")
	public ArrayList<LogRecord> findLogsByTimestamp(@Param("begin") long begin , @Param("end") long end );
	
	@Query("select distinct r.uuid from LogRecord as r where r.timestamp >= :begin and r.timestamp <= :end")
	public ArrayList<String> findUUIDsByTimestamp(@Param("begin") long begin , @Param("end") long end );
	
	@Query("select r "
			+ "from LogRecord as r "
			+ "where "
			+ "r.uuid = :uuid "
			+ "and r.timestamp >= :begin "
			+ "and r.timestamp <= :end")
	public ArrayList<LogRecord> findLogsByUUIDAndTimestamp(@Param("uuid") String uuid 
			, @Param("begin") long begin 
			, @Param("end") long end );
}