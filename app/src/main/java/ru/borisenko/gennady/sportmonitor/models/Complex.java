package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "complex")
public class Complex {

    @DatabaseField(generatedId = true)
    private int Id;

    private Exercise exercise;
    public void setExercise(Exercise value){
        this.exercise = value;
    }

    public Exercise getExercise(){
        return exercise;
    }
}
