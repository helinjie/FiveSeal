package com.fivefoo.seal.Base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.fivefoo.seal.R;
import com.fivefoo.seal.Widget.ToolBarX;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by 67423 on 2017/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected Context mContext;

    protected String TAG = getTAG();

    protected abstract String getTAG();

    public boolean statusVisible = true;  //状态栏背景布局是否显示,   true:显示,  false:不显示

    private Toolbar mToolbar;
    private LinearLayout ll_content;

    private ToolBarX toolBarX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mContext = this;

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            if(statusVisible){

                //
                LinearLayout linear_bar = (LinearLayout) super.findViewById(R.id.ll_bar);
                linear_bar.setVisibility(View.VISIBLE);
                //获取到状态栏的高度
                int statusHeight = getStatusBarHeight();
                //动态的设置隐藏布局的高度
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear_bar.getLayoutParams();
                params.height = statusHeight;
                linear_bar.setLayoutParams(params);

            }
        }

        mToolbar = (Toolbar) super.findViewById(R.id.toolbar);
        ll_content = (LinearLayout) super.findViewById(R.id.ll_content);

        setContentView(getLayoutId());

        initView();
        setListener();

    }


    /**
     * 抽象方法,子类实现, 返回资源ID
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化控件..
     */
    public void initView(){}


    /**
     * 设置监听器.
     */
    public void setListener(){}

    /**
     * 获取ToolBarX
     * @return
     */
    public ToolBarX getToolBarX(){

        if(toolBarX == null){
            toolBarX = new ToolBarX(this, mToolbar);
        }

        return toolBarX;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
//        super.setContentView(layoutResID);
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
//        super.setContentView(view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll_content.addView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    public View findViewById(@IdRes int id) {
        return ll_content.findViewById(id);
    }



//    //是否statusBar 状态栏为透明 的方法 默认为真
//    protected boolean isTranslucentStatusBar() {
//        return true;
//    }
//
    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



}
