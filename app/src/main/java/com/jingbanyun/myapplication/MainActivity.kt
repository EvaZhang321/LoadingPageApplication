package com.jingbanyun.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showFullPop(view:View){
        LoadingPagePopupWindowView.getLoadingView(this).show(findViewById(R.id.ll_content))
    }
    fun showPop(view:View){
        LoadingPagePopupWindowView.getLoadingView(this).showAsDropDown(findViewById(R.id.action_bar))
    }

    override fun onDestroy() {
        super.onDestroy()
        LoadingPagePopupWindowView.getLoadingView(this).dismiss()
    }
}
