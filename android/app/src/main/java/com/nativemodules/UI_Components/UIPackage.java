package com.nativemodules.UI_Components;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.image.ReactImageManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UIPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        //We import the module file here
        modules.add(new UIModule(reactContext));

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(
            ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new ReactImageManager()
        );
    }



}
