package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class TrainingDAO extends BaseDaoImpl<Training, Integer> {
    protected TrainingDAO(ConnectionSource connectionSource,
                                 Class<Training> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Training> getAllTrainings() throws SQLException{
        return this.queryForAll();
    }
}