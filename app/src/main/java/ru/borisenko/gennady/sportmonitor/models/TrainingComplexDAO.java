package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class TrainingComplexDAO extends BaseDaoImpl<TrainingComplex, Integer> {
    protected TrainingComplexDAO(ConnectionSource connectionSource,
                         Class<TrainingComplex> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<TrainingComplex> getAllTrainingComplexes() throws SQLException{
        return this.queryForAll();
    }
}