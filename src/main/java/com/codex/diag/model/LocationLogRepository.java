package com.codex.diag.model;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LocationLogRepository extends CrudRepository<LocationLogRecord, Long>{
	ArrayList<LocationLogRecord> findByuuid(String uuid);
	
	@Query("select r from LocationLogRecord as r where r.timestamp > :begin and r.timestamp < :end")
	public ArrayList<LocationLogRecord> findByTimestamp(@Param("begin") long begin , @Param("end") long end );

	@Query("select distinct r.uuid from LocationLogRecord as r where r.timestamp > :begin and r.timestamp < :end")
	public ArrayList<String> findUUIDSbyTimestamp(@Param("begin") long begin , @Param("end") long end );

}
