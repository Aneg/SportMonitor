package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "complex")
public class Complex {

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.BOOLEAN, columnName = "is_round", defaultValue = "true")
    private int isRound;

    @DatabaseField(canBeNull = true, dataType = DataType.BOOLEAN, columnName = "is_round")
    private int countRound;

    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = "count_exercise")
    private String countExercise;

    public int getId() {
        return Id;
    }

    public int getIsRound() {
        return isRound;
    }

    public void setIsRound(int isRound) {
        this.isRound = isRound;
    }

    public int getCountRound() {
        return countRound;
    }

    public void setCountRound(int countRound) {
        this.countRound = countRound;
    }

    public String getCountExercise() {
        return countExercise;
    }

    public void setCountExercise(String countExercise) {
        this.countExercise = countExercise;
    }
}
