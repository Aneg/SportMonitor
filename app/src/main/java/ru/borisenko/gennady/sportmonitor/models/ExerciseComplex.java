package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "exercise_complex")
public class ExerciseComplex {

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.SHORT, columnName = "number_repetitions")
    private String number_repetitions;

    private Exercise exercise;
    public void setExercise(Exercise value){
        this.exercise = value;
    }

    public Exercise getExercise(){
        return exercise;
    }
}
