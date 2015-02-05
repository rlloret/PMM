package com.example.mati.examen;

/**
 * Created by mati on 29/01/15.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLitehelper extends SQLiteOpenHelper {

    String cadSQL = "CREATE TABLE DatosEnvio (zona TEXT, tarifa TEXT, peso TEXT, decoracion TEXT, coste TEXT)";

    public SQLitehelper(Context contexto, String nombre, CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        bd.execSQL("DROP TABLE IF EXISTS DatosEnvio");

        bd.execSQL(cadSQL);
    }
}

