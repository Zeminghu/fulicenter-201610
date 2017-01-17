package cn.ucai.fulicenter.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cn.ucai.fulicenter.model.utils.L;

/**
 * Created by Administrator on 2017/1/17.
 */

public class DBManager {
    private static final String TAG=DBManager.class.getSimpleName();
    private static DBOpenHelper dbHelper;
    DBManager dbMgr=new DBManager();

    public DBManager(){

    }
    public static void onInit(Context context){
        dbHelper=new DBOpenHelper(context);
    }

    public synchronized static DBManager getInstance(){
        if (dbHelper==null){
            L.e(TAG,"没有调用onInit()");
        }
        return null;
    }

   /* public void saveUser(User user){
        SQLiteDatabase values=new ContentValues();
    }*/
}
