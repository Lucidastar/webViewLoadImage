package com.lucidastar.demo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llContent = (LinearLayout) this.findViewById(R.id.ll_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) llContent.getLayoutParams();
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        llContent.setLayoutParams(layoutParams);

        for (int i = 0; i < 6; i++) {
            TextView textView = getTextView("张三"+i);
            llContent.addView(textView);
        }
    }




    public DrawableTextView getTextView(String name){
        DrawableTextView textView = new DrawableTextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setText(name);
        Drawable leftDrawable= this.getResources().getDrawable(R.mipmap.ic_launcher);
        leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
        textView.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,null,null,null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void openService(View view){
            startActivity(new Intent(this,ServiceStudyActivity.class));
    }

    public void openWebView(View view){
        startActivity(new Intent(this,WebViewActivity.class));
    }


}
