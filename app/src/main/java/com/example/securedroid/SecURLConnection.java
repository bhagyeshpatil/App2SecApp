package com.example.securedroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

//For Server connectivity
public class SecURLConnection {
    DBHelper myDb;
    URLConnection conn;
    OutputStream outputStream;
    InputStream inputStream;
    URL url;
    Context context;
    String allPermissions;

    public SecURLConnection(URL url, Context context){

        try {
            conn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.url=url;
        this.context = context;
    }

    public OutputStream getOutputStream () throws IOException {

        outputStream = null;

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
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to write some data to a server.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                try {
                    outputStream = conn.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context, "Output Stream Established", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Output Stream Not Established", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return outputStream;
    }

    public InputStream getInputStream () throws IOException {

        inputStream = null;

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
        alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to read some data from a server.");
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                try {
                    inputStream = conn.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context, "Input Stream Established", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "Input Stream Not Established", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}

        return inputStream;
    }

    public void setDoOutput (boolean dooutput){
        conn.setDoOutput(dooutput);
    }

    public void setRequestProperty (String key, String value){
        conn.setRequestProperty(key,value);
    }

}
