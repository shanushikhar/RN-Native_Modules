package com.nativemodules.UI_Components;

import android.graphics.Color;
import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.NonNull;

public class UIModule extends SimpleViewManager<View> {

    public static final String REACT_CLASS = "HelloWorldSquare";
    private ReactApplicationContext mContext;
    private ThemedReactContext themdReact;
    private View view;

    public UIModule(ReactApplicationContext reactContext) {
        mContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected View createViewInstance( ThemedReactContext context) {
        themdReact = context;
       view = new View(mContext);
       view.setBackgroundColor(Color.BLUE);
        return view;
    }

    @ReactProp(name="exampleProp")
    public void setUiProps(View view, String prop){

    }
}
