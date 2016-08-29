package ru.borisenko.gennady.sportmonitor.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "training")
public class Training {

    @DatabaseField(generatedId = true)
    private int Id;
}
