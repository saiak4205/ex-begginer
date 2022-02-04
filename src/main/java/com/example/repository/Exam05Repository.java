package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class Exam05Repository {
	

		@Autowired
		private NamedParameterJdbcTemplate template;
		
		private static final RowMapper<Member>MEMBER_ROW_MAPPER = new BeanPropertyRowMapper<>(Member.class);
		
		public List<Member> findByName(String word) {
			String sql = "SELECT name FROM members WHERE name LIKE :word;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("word","%" + word + "%");
			List<Member> member = template.query(sql,param, MEMBER_ROW_MAPPER); // ←ここに実行処理を書く

			return member;
		}


}
