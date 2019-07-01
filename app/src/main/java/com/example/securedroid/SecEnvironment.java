package com.example.securedroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.io.File;

//For External Storage
public class SecEnvironment {

    static Context context;
    static File file;
    static String str;
    static DBHelper myDb;
    static String allPermissions;

    public SecEnvironment(){}

    public SecEnvironment(Context context){
        this.context = context;
    }

    public static File getDataDirectory (){
        file = null;

        myDb = new DBHelper(context);
        allPermissions = myDb.getAllPermissions();

        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Are you sure?");
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to access the external storage.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                file = Environment.getDataDirectory();
                Toast.makeText(context, "Access Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Access not Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return file;
    }

    public static File getDownloadCacheDirectory (){
        file = null;

        myDb = new DBHelper(context);
        allPermissions = myDb.getAllPermissions();

        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Are you sure?");
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to access the external storage.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                file = Environment.getDownloadCacheDirectory();
                Toast.makeText(context, "Access Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Access not Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return file;
    }

    public static File getExternalStorageDirectory (){
        file = null;

        myDb = new DBHelper(context);
        allPermissions = myDb.getAllPermissions();

        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Are you sure?");
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to access the external storage.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                file = Environment.getExternalStorageDirectory();
                Toast.makeText(context, "Access Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Access not Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return file;
    }

    public static File getExternalStoragePublicDirectory (final String type){
        file = null;

        myDb = new DBHelper(context);
        allPermissions = myDb.getAllPermissions();

        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Are you sure?");
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to access the external storage.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                file = Environment.getExternalStoragePublicDirectory(type);
                Toast.makeText(context, "Access Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Access not Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return file;
    }

    public static String getExternalStorageState (){
        str = Environment.getExternalStorageState();
        return str;
    }

    public static String getExternalStorageState (File path){
        str = Environment.getExternalStorageState(path);
        return str;
    }

    public static File getRootDirectory (){
        file = null;

        myDb = new DBHelper(context);
        allPermissions = myDb.getAllPermissions();

        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Are you sure?");
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to access the external storage.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                file = Environment.getRootDirectory();
                Toast.makeText(context, "Access Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Access not Granted", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return file;
    }
}
