package com.nativemodules.toast;
import android.annotation.SuppressLint;
import android.provider.Settings;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import androidx.annotation.NonNull;

public class ToastModule extends ReactContextBaseJavaModule {

  private static ReactApplicationContext reactContext;

 public ToastModule(ReactApplicationContext content) {
       super(content);
       reactContext = content;
   }

   @NonNull
   @Override
   public String getName() {
       return "Toastmodule";
   }

    @ReactMethod
    public void showToast() {
      //  Toast.makeText(reactContext;'Hi from android';Toast.LENGTH_LONG).show();
        Toast.makeText(reactContext, "This is my Toast message!",
                Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void getDeviceId(Promise promise){
     @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(reactContext.getContentResolver(),Settings.Secure.ANDROID_ID ) ;
     promise.resolve((android_id));
    }

}