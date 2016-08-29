package ru.borisenko.gennady.sportmonitor.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private String TAG = "Model.error";

    //имя файла базы данных который будет храниться в /data/data/APPNAME/DATABASE_NAME.db
    private static final String DATABASE_NAME ="sportmonitor.db";

    //с каждым увеличением версии, при нахождении в устройстве БД с предыдущей версией будет выполнен метод onUpgrade();
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private ExerciseDAO exerciseDao = null;
    private ExerciseComplexDAO exerciseComplexDao = null;
    private ComplexDAO complexDao = null;
    private ComplexExerciseComplexDAO complexExerciseComplexDao = null;
    private TrainingDAO trainingDao = null;
    private TrainingComplexDAO trainingComplexDao = null;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try
        {
            TableUtils.createTable(connectionSource, Exercise.class);
            TableUtils.createTable(connectionSource, ExerciseComplex.class);
            TableUtils.createTable(connectionSource, Complex.class);
            TableUtils.createTable(connectionSource, ComplexExerciseComplex.class);
            TableUtils.createTable(connectionSource, ComplexExerciseComplex.class);
            TableUtils.createTable(connectionSource, ComplexExerciseComplex.class);
        }
        catch (SQLException e){
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    //Выполняется, когда БД имеет версию отличную от текущей
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer,
                          int newVer){
        try{
            //Так делают ленивые, гораздо предпочтительнее не удаляя БД аккуратно вносить изменения
            TableUtils.dropTable(connectionSource, ExerciseComplex.class, true);
            TableUtils.dropTable(connectionSource, Exercise.class, true);
            TableUtils.dropTable(connectionSource, Complex.class, true);
            TableUtils.dropTable(connectionSource, ComplexExerciseComplex.class, true);
            TableUtils.dropTable(connectionSource, TrainingComplex.class, true);
            TableUtils.dropTable(connectionSource, Training.class, true);
            onCreate(db, connectionSource);
        }
        catch (SQLException e){
            Log.e(TAG,"error upgrading db "+DATABASE_NAME+"from ver "+oldVer);
            throw new RuntimeException(e);
        }
    }

    public ExerciseDAO getExerciseDAO() throws SQLException{
        if(exerciseDao == null){
            exerciseDao = new ExerciseDAO(getConnectionSource(), Exercise.class);
        }
        return exerciseDao;
    }

    public TrainingDAO getTrainingDAO() throws SQLException{
        if(trainingDao == null){
            trainingDao = new TrainingDAO(getConnectionSource(), Training.class);
        }
        return trainingDao;
    }

    public TrainingComplexDAO getTrainingComplexDAO() throws SQLException{
        if(trainingComplexDao == null){
            trainingComplexDao = new TrainingComplexDAO(getConnectionSource(), TrainingComplex.class);
        }
        return trainingComplexDao;
    }

    public ExerciseComplexDAO getExerciseComplexDAO() throws SQLException{
        if(exerciseComplexDao == null){
            exerciseComplexDao = new ExerciseComplexDAO(getConnectionSource(), ExerciseComplex.class);
        }
        return exerciseComplexDao;
    }

    public ComplexDAO getComplexDAO() throws SQLException{
        if(complexDao == null){
            complexDao = new ComplexDAO(getConnectionSource(), Complex.class);
        }
        return complexDao;
    }

    public ComplexExerciseComplexDAO getComplexExerciseComplexDao() throws SQLException{
        if(complexExerciseComplexDao == null){
            complexExerciseComplexDao = new ComplexExerciseComplexDAO(getConnectionSource(), ComplexExerciseComplex.class);
        }
        return complexExerciseComplexDao;
    }

    //выполняется при закрытии приложения
    @Override
    public void close(){
        super.close();
        exerciseDao = null;
        exerciseComplexDao = null;
        complexExerciseComplexDao = null;
        complexDao = null;
        trainingDao = null;
        trainingComplexDao = null;
    }
}
