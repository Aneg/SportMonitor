package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "exercise_complex")
public class ExerciseComplex {

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.SHORT, columnName = "number_repetitions")
    private int number_repetitions;

    @DatabaseField(foreign = true, columnName = "exercise", foreignAutoRefresh = true)
    private Exercise exercise;

    public int getId() {
        return Id;
    }

    public int getNumber_repetitions() {
        return number_repetitions;
    }

    public void setNumber_repetitions(int number_repetitions) {
        this.number_repetitions = number_repetitions;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
