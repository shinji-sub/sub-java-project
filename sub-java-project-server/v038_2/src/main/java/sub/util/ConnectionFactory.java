package sub.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
  String jdbcUrl;
  String username;
  String password;

  public ConnectionFactory(String jdncUrl, String username, String password) {
    this.jdbcUrl = jdncUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    return DriverManager.getConnection(jdbcUrl, username, password);
  }
}
