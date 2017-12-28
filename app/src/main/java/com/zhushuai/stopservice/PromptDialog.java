package com.zhushuai.stopservice;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.flurgle.blurkit.BlurKit;

/**
 * 业务名：
 * 功能说明：
 * 创建于：2017/8/18 下午4:43
 * 作者： zhushuai
 * <p/>
 * 历史记录
 * 1、修改日期：
 * 修改人：
 * 修改内容：
 */
public class PromptDialog extends Dialog {

    private Activity mContext;
    private View rootview;
    private boolean flag;

    public PromptDialog(@NonNull Activity context, @LayoutRes int layoutId) {
        super(context);
        mContext = context;
        Window window = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);//这句话，就是决定上面的那个黑框，也就是dialog的ti
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);

        rootview = getLayoutInflater().inflate(layoutId, null);
        rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) dismiss();
            }
        });
        ViewGroup vp = (ViewGroup) rootview;
        for (int i = 0; i < vp.getChildCount(); i++) {
            View childAt = vp.getChildAt(i);
            childAt.setOnClickListener(listener);
        }
        //获取屏幕的宽高
        Display display = mContext.getWindowManager().getDefaultDisplay();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(display.getWidth(), display.getHeight());
        layoutParams.gravity = Gravity.CENTER;
        super.setContentView(rootview, layoutParams);
    }

    @Override
    public void show() {
        super.show();
        Bitmap blurBackgroundDrawer = BlurKit.getInstance().blur(QMUIDrawableHelper.createBitmapFromView(mContext), 25);
        getWindow().setBackgroundDrawable(new BitmapDrawable(mContext.getResources(), blurBackgroundDrawer));
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
        this.flag = flag;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    public View getRootview() {
        return rootview;
    }
}
