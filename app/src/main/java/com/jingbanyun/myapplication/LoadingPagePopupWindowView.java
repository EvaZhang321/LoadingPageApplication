package com.jingbanyun.myapplication;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;

public class LoadingPagePopupWindowView extends PopupWindow {

    private static LoadingPagePopupWindowView loadingView;

    public static LoadingPagePopupWindowView getLoadingView(Context context) {
        if (loadingView==null){
            synchronized (LoadingPagePopupWindowView.class){
                if (loadingView==null){
                    loadingView = new LoadingPagePopupWindowView(context.getApplicationContext());
                }
            }
        }

        return loadingView;
    }

    private LoadingPagePopupWindowView(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Glide.with(context).load(R.drawable.timg).into(imageView);
        setContentView(imageView);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.white)));
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void  show(View parent){
        if (isShowing()) dismiss();
        showAtLocation(parent, Gravity.CENTER,0,0);
    }
}
