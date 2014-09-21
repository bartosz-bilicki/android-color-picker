package com.bb.android.example.activities;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import com.bb.android.example.R;

import java.lang.ref.WeakReference;

public class PopupOnClickListener implements Button.OnClickListener {
    private final WeakReference<PopupWindow> popupWindowRef;
    private final WeakReference<ColorChangedCallback> callbackRef;

    public PopupOnClickListener(PopupWindow popupWindow, ColorChangedCallback callback) {
        this.popupWindowRef = new WeakReference(popupWindow);
        this.callbackRef = new WeakReference(callback);
    }

    @Override
    public void onClick(View view) {
        /**
         * nasty. use eveloper.android.com/reference/android/widget/ImageButton.html
         * style it to remove margin, paddings, background
         * use selector for pressed state.
         * http://developer.android.com/guide/topics/resources/drawable-resource.html#StateList
         *
         * generic button tutorial
         * http://developer.android.com/guide/topics/ui/controls/button.html
         *
         * check
         * http://developer.android.com/guide/topics/resources/drawable-resource.html#Shape
         * how to create border
         * use background and padding
         *
         */


        Log.d(PopupOnClickListener.class.toString(), "PopupOnClickListener.onClick");
        PopupWindow popupWindow = popupWindowRef.get();
        if (popupWindow != null) {
            View v = popupWindow.getContentView();
            v.findViewById(R.id.imageView1).setPadding(0, 0, 0, 0);
            v.findViewById(R.id.imageView2).setPadding(0, 0, 0, 0);
            v.findViewById(R.id.imageView3).setPadding(0, 0, 0, 0);
            v.findViewById(R.id.imageView4).setPadding(0, 0, 0, 0);
            view.setPadding(1, 1, 1, 1);
            popupWindow.dismiss();
        }

        ColorChangedCallback callback = callbackRef.get();
        if (callback != null) {
            callback.onColorChanged(Color.parseColor((String) view.getTag()));
        }
    }
}
