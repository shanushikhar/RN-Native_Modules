package com.nativemodules.device;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class DeviceModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

   //constructor
   public DeviceModule(ReactApplicationContext reactContext) {
       super(reactContext);
       reactContext = reactContext;
   }
   //Mandatory function getName that specifies the module name
   @Override
   public String getName() {
       return "Device";
   }

   //Custom function that we are going to export to JS
   @ReactMethod
   public void getDeviceName(Callback cb) {
       try{
           cb.invoke(null, android.os.Build.MODEL);
       }catch (Exception e){
           cb.invoke(e.toString(), null);
       }
   }

   @ReactMethod
        public void createCalendarEvent(String name, String location , Callback cb) {
            cb.invoke(null,"CalendarModule Create event called with name: " + name
            + " and location: " + location);
        }

    @ReactMethod
        public void createCalendarEvent2(String name, String location, Promise promise) {
            try {
                // Integer eventId = new Integer(123);
                int eventId = 12;
                promise.resolve(eventId);
            } catch(Exception e) {
                promise.reject("Create Event Error", e);
          }
    }


    private void sendEvent(ReactContext reactContext,
                      String eventName,
                       WritableMap params) {

        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);

    }


    @ReactMethod
    public void ToastExample(){
            
     WritableMap  params = Arguments.createMap();
     params.putString("eventProperty", "someValue");

      sendEvent(reactContext, "EventReminder", params);

     }
}

