package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


public class ComplexExerciseComplexDAO extends BaseDaoImpl<ComplexExerciseComplex, Integer> {
    protected ComplexExerciseComplexDAO(ConnectionSource connectionSource,
                                 Class<ComplexExerciseComplex> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<ComplexExerciseComplex> getAllComplexExerciseComplexes() throws SQLException{
        return this.queryForAll();
    }
}