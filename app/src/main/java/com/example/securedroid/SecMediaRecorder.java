package com.example.securedroid;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Build;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

//for Record_audio
public class SecMediaRecorder {

    DBHelper myDb;
    Context context;
    MediaRecorder mr;

    public SecMediaRecorder(Context context){
        mr = new MediaRecorder();
        this.context = context;
    }

    public void setAudioSource (int audioSource){
        mr.setAudioSource(audioSource);
    }

    public void setOutputFormat (int output_format){
        mr.setOutputFormat(output_format);
    }

    public void setAudioEncoder (int audio_encoder){
        mr.setAudioEncoder(audio_encoder);
    }

    public void setOutputFile (FileDescriptor fd){
        mr.setOutputFile(fd);
    }

    public void setOutputFile (String path){
        mr.setOutputFile(path);
    }

    public void setOutputFile (File file){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mr.setOutputFile(file);
        }
    }

    public void prepare (){
        try {
            mr.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start (){
        myDb = new DBHelper(context);
        myDb.insertPermission("RECORD_AUDIO");

        mr.start();
    }

    public void stop (){
        mr.stop();
    }

    public void reset (){
        mr.reset();
    }

    public void resume (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mr.resume();
        }
    }

    public void release (){
        mr.release();
    }
}
