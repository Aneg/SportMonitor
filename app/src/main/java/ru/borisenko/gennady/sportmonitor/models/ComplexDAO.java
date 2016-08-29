package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


public class ComplexDAO extends BaseDaoImpl<Complex, Integer> {
    protected ComplexDAO(ConnectionSource connectionSource,
                          Class<Complex> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Complex> getAllComplexes() throws SQLException{
        return this.queryForAll();
    }
}
