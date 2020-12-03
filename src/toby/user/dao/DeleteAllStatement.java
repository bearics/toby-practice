/**
 * @(#)DeleteAllStatement.java 2020. 12. 04
 *
 * Copyright 2020 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package toby.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Hyounglin Jun (KR19849)
 */
public class DeleteAllStatement implements StatementStrategy {
	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from users");
		return ps;
	}
}