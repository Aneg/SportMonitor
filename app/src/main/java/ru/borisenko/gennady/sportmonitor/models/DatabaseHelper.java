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

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try
        {
            TableUtils.createTable(connectionSource, Exercise.class);
//            TableUtils.createTable(connectionSource, Role.class);
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

    public ExerciseComplexDAO getExerciseComplexDAO() throws SQLException{
        if(exerciseComplexDao == null){
            exerciseComplexDao = new ExerciseComplexDAO(getConnectionSource(), Exercise.class);
        }
        return exerciseComplexDao;
    }


    //выполняется при закрытии приложения
    @Override
    public void close(){
        super.close();
        exerciseDao = null;
        exerciseComplexDao = null;
    }
}
