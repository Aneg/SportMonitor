package ru.borisenko.gennady.sportmonitor.models;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "training")
public class Training {

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.BOOLEAN, columnName = "is_round")
    private int isRound;

    @DatabaseField(canBeNull = true, dataType = DataType.BOOLEAN, columnName = "is_round")
    private int countRound;

    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = "count_exercise")
    private String countExercise;
}
