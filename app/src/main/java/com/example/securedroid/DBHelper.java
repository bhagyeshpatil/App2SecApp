package com.example.securedroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Maintains the database of permissions influencing the application.
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Permissions.db";
    public static final String TABLE_NAME = "permissions_table";
    public static final String COL_1 = "Permissions";
    String allPermissions;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuffer createDbBuf = new StringBuffer();
        createDbBuf.append("create table ");
        createDbBuf.append(TABLE_NAME);
        createDbBuf.append("( " + COL_1 + " text UNIQUE)");

        sqLiteDatabase.execSQL(createDbBuf.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    public boolean insertPermission(String permission) {
        if(alreadyExist(permission)){
            return false;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,permission);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public String getAllPermissions() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        if(res.getCount() != 0) {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                if(!res.isLast())
                    buffer.append(res.getString(0)+", ");
                else
                    buffer.append(res.getString(0)+".");
            }
            allPermissions = buffer.toString();
        }
        else{
            allPermissions = "None.";
        }
        return allPermissions;
    }

    public Integer deletePermission (String permission) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1 + " = ?",new String[] {permission});
    }

    public boolean alreadyExist (String permission) {
        boolean exist = false;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        if(res.getCount() != 0) {
            while (res.moveToNext()) {
                if(res.getString(0).equals(permission)) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

}
