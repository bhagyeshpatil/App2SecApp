package com.example.securedroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

//For Camera
public class SecCamera {

    DBHelper myDb;
    Context context;
    CameraManager cm;
    CameraDevice cameraDevice;
    CameraCharacteristics cameraCharacteristics;
    StreamConfigurationMap map;
    CaptureRequest.Builder captureRequestBuilder;

    public SecCamera(Context context) {
        cm = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        this.context = context;
    }

    public String[] getCameraIdList() throws CameraAccessException {
        return cm.getCameraIdList();
    }

    public CameraCharacteristics getCameraCharacteristics(String cameraId) throws CameraAccessException {
        cameraCharacteristics = cm.getCameraCharacteristics(cameraId);
        return cameraCharacteristics;
    }

    public StreamConfigurationMap get(CameraCharacteristics.Key<StreamConfigurationMap> key) {
        map = cameraCharacteristics.get(key);
        return map;
    }

    @SuppressLint("MissingPermission")
    public void openCamera(String cameraId, CameraDevice.StateCallback callback, Handler handler) throws CameraAccessException {
        cm.openCamera(cameraId, callback, handler);
    }

    @SuppressLint("MissingPermission")
    public void openCamera(String cameraId, Executor executor, CameraDevice.StateCallback callback) throws CameraAccessException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            cm.openCamera(cameraId, executor, callback);
        }
    }

    public CaptureRequest.Builder createCaptureRequest (int templateType, Set<String> physicalCameraIdSet) throws CameraAccessException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            captureRequestBuilder = cameraDevice.createCaptureRequest(templateType, physicalCameraIdSet);
        }
        return captureRequestBuilder;
    }

    public CaptureRequest.Builder createCaptureRequest (int templateType) throws CameraAccessException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            captureRequestBuilder = cameraDevice.createCaptureRequest(templateType);
        }
        return captureRequestBuilder;
    }

    public void addTarget (Surface outputTarget) {
        captureRequestBuilder.addTarget(outputTarget);
    }

    public void createCaptureSession (SessionConfiguration config) throws CameraAccessException {

        myDb = new DBHelper(context);
        myDb.insertPermission("Camera");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            cameraDevice.createCaptureSession(config);
        }
    }

    public void createCaptureSession (List<Surface> outputs, CameraCaptureSession.StateCallback callback, Handler handler) throws CameraAccessException {

        myDb = new DBHelper(context);
        myDb.insertPermission("Camera");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            cameraDevice.createCaptureSession(outputs, callback, handler);
        }
    }

}
