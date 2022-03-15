package com.example.demo.login.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;

@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl {
	
	@Autowired
	private JdbcTemplate jdbc;
	
//	1件取得用SQL
	public User delectOne(String userId) {
		
		String sql = "SELECT * FROM m_user WHERE user_id = ?";
//		RowMappweの生成
		UserRowMapper rowMapper = new UserRowMapper();
//		SQL実行
		return jdbc.queryForObject(sql, rowMapper, userId);
	}
	
//	ユーザー全件取得
	@Override
	public List<User> selectMany() {
//		m_userテーブルのデータを全件取得するSQL
		String sql = "SELECT * FROM m_user";
//		RowMapperの生成
		RowMapper<User> rowMapper = new UserRowMapper();
//		SQL実行
		return jdbc.query(sql, rowMapper);
	}
}
