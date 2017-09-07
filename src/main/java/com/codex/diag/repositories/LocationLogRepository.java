package com.codex.diag.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codex.diag.model.LocationLogRecord;

public interface LocationLogRepository extends CrudRepository<LocationLogRecord, Long>{
	
	ArrayList<LocationLogRecord> findLogsByuuid(String uuid);
	
	@Query("select r from LocationLogRecord as r where r.timestamp >= :begin and r.timestamp <= :end")
	public ArrayList<LocationLogRecord> findLogsByTimestamp(@Param("begin") long begin , @Param("end") long end );

	@Query("select distinct r.uuid from LocationLogRecord as r where r.timestamp >= :begin and r.timestamp <= :end order by r.uuid desc")
	public ArrayList<String> findUUIDsByTimestamp(@Param("begin") long begin , @Param("end") long end );
	
	@Query("select r "
			+ "from LocationLogRecord as r "
			+ "where "
			+ "r.uuid = :uuid "
			+ "and r.timestamp >= :begin "
			+ "and r.timestamp <= :end "
			+ "order by r.timestamp desc")
	public ArrayList<LocationLogRecord> findLogsByUUIDAndTimestamp(@Param("uuid") String uuid 
			, @Param("begin") long begin 
			, @Param("end") long end );


	

}
