package ru.borisenko.gennady.sportmonitor.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "training_complex")
public class TrainingComplex {
    public final static String TRAINING_ID_FIELD_NAME = "training_id";
    public final static String COMPLEX_ID_FIELD_NAME = "complex_id";

    /**
     * This id is generated by the database and set on the object when it is passed to the create method. An id is
     * needed in case we need to update or delete this object in the future.
     */
    @DatabaseField(generatedId = true)
    private int id;

    // This is a foreign object which just stores the id from the User object in this table.
    @DatabaseField(foreign = true, columnName = TRAINING_ID_FIELD_NAME)
    private Training training;

    // This is a foreign object which just stores the id from the Post object in this table.
    @DatabaseField(foreign = true, columnName = COMPLEX_ID_FIELD_NAME)
    private Complex complex;

    TrainingComplex() {
        // for ormlite
    }

    public TrainingComplex(Training training, Complex complex) {
        this.training = training;
        this.complex = complex;
    }

    public int getId() {
        return id;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Complex getComplex() {
        return complex;
    }

    public void setComplex(Complex complex) {
        this.complex = complex;
    }
}
