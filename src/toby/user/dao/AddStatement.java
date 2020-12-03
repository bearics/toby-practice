/**
 * @(#)AddStatement.java 2020. 12. 04
 *
 * Copyright 2020 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package toby.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import toby.user.domain.User;

/**
 * @author Hyounglin Jun (KR19849)
 */
public class AddStatement implements StatementStrategy {
	User user;

	public AddStatement(User user) {
		this.user = user;
	}

	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		return ps;
	}
}