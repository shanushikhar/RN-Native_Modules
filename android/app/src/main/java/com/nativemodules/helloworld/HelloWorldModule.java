package com.nativemodules.helloworld;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class HelloWorldModule extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "helloworld";
    private static ReactApplicationContext reactContext = null;

    public HelloWorldModule(ReactApplicationContext context){
        super(context);
        reactContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public Map<String,Object> getConstants(){
        final Map<String,Object> constants = new HashMap<>();
        constants.put("EXAMPLE_CONSTANT","example");
        return constants;
    }

    @ReactMethod
    public void exampleMethod(){
        final WritableMap event = Arguments.createMap();
        event.putString("greeting","Whats up ");
        emitDeviceEvent("EXAMPLE_EVENT", event);
    }

    private static void emitDeviceEvent(String eventName, WritableMap eventData){
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName,eventData);
    }
}
