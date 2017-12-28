package com.zhushuai.stopservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flurgle.blurkit.BlurLayout;


/**
 * 作者 by ZhuShuai on 2017/12/25 13:48.
 */

public class MainActivity extends AppCompatActivity {

    private PromptDialog promptDialog;
    private BlurLayout blurLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blurLayout = (BlurLayout) findViewById(R.id.blur_layout);
    }

    public void absbdajsdasfaf(View v) {
        if (promptDialog == null) {
            promptDialog = new PromptDialog(this, R.layout.dialog_layout);
            promptDialog.setCancelable(false);
            promptDialog.getRootview().findViewById(R.id.ok_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    promptDialog.dismiss();
                }
            });
        }
        promptDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        blurLayout.startBlur();
        blurLayout.lockView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        blurLayout.pauseBlur();
    }
}
