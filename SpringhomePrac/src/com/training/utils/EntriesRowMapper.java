package com.training.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.training.resources.Entries;

public class EntriesRowMapper implements RowMapper<Entries> {

	@Override
	public Entries mapRow(ResultSet rs, int rowCount) throws SQLException {
		
		Entries entry =new Entries();
		
		entry.setDate(rs.getString("submit_date"));
		entry.setSubject(rs.getString("subject"));
		entry.setEntry(rs.getString("entry"));
		entry.setUserName(rs.getString("username"));
        entry.setPk(rs.getString("ID"));

		return entry;
	}

}
