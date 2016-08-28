package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class ExerciseComplexDAO extends BaseDaoImpl<ExerciseComplex, Integer> {
    protected ExerciseComplexDAO(ConnectionSource connectionSource,
                          Class<ExerciseComplex> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<ExerciseComplex> getAllExerciseComplexes() throws SQLException{
        return this.queryForAll();
    }
}