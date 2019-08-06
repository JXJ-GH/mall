package Utils;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MVCTest {
    @Test
    public void connect() throws SQLException {
        System.out.println(JdbcUtils.getConnection());
    }
}
