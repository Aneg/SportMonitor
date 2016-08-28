package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class ExerciseDAO extends BaseDaoImpl<Exercise, Integer> {
    protected ExerciseDAO(ConnectionSource connectionSource,
                      Class<Exercise> dataClass) throws SQLException{
        super(connectionSource, dataClass);
    }

    public List<Exercise> getAllExercises() throws SQLException{
        return this.queryForAll();
    }
}
