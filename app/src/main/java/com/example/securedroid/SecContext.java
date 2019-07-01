package com.example.securedroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//For External Storage
public class SecContext {

    Context context;
    File file;
    File[] files;
    String str;
    DBHelper myDb;
    String allPermissions;
    FileOutputStream fileOutputStream;
    FileInputStream fileInputStream;

    public SecContext(Context context){
        this.context = context;
    }

    public File getDataDir (){
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    file = context.getDataDir();
                }
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

    public File getDir (final String name, final int mode){
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
                file = context.getDir(name, mode);
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

    public File getExternalCacheDir (){
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
                file = context.getExternalCacheDir();
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

    public File[] getExternalCacheDirs (){
        files = null;

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
                files = context.getExternalCacheDirs();
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

        return files;
    }

    public File getExternalFilesDir (final String type){
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
                file = context.getExternalFilesDir(type);
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

    public File[] getExternalFilesDirs (final String type){
        files = null;

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
                files = context.getExternalFilesDirs(type);
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

        return files;
    }


    public File[] getExternalMediaDirs (){
        files = null;

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
                files = context.getExternalMediaDirs();
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

        return files;
    }

    public File getFileStreamPath (final String name){
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
                file = context.getFileStreamPath(name);
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

    public File getFilesDir (){
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
                file = context.getFilesDir();
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

    public File getNoBackupFilesDir (){
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
                file = context.getNoBackupFilesDir();
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

    public File getObbDir (){
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
                file = context.getObbDir();
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

    public File[] getObbDirs (){
        files = null;

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
                files = context.getObbDirs();
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

        return files;
    }

    public FileOutputStream openFileOutput (final String name, final int mode){
        fileOutputStream = null;

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
                try {
                    fileOutputStream = context.openFileOutput(name,mode);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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

        return fileOutputStream;
    }

    public FileInputStream openFileInput (final String name) {
        fileInputStream = null;

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
                try {
                    fileInputStream = context.openFileInput(name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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

        return fileInputStream;
    }

    public String getPackageCodePath (){
        str = context.getPackageCodePath();
        return str;
    }

    public String getPackageName (){
        str = context.getPackageName();
        return str;
    }

    public String getPackageResourcePath (){
        str = context.getPackageResourcePath();
        return str;
    }
}
