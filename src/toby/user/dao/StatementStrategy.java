package toby.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Hyounglin Jun (KR19849)
 */
public interface StatementStrategy {
	PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
