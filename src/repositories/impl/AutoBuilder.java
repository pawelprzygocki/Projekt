package repositories.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Auto;

public class AutoBuilder implements IEntityBuilder<Auto> {
    @Override
    public Auto build(ResultSet rs) throws SQLException {
        Auto auto = new Auto();
        auto.setId(rs.getInt("id"));
        auto.setMarka(rs.getString("marka"));
        auto.setPrzebieg(rs.getInt("przebieg"));
        return auto;
    }
    
}
