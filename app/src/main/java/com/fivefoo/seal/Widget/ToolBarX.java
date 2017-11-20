package com.fivefoo.seal.Widget;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.fivefoo.seal.R;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class ToolBarX {

    private AppCompatActivity mActivity;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private RelativeLayout rl_custom;

    public ToolBarX(AppCompatActivity mActivity, Toolbar mToolbar) {
        this.mActivity = mActivity;
        this.mToolbar = mToolbar;

        rl_custom = (RelativeLayout) mToolbar.findViewById(R.id.rl_custom);

        mActivity.setSupportActionBar(mToolbar);

        mActionBar = mActivity.getSupportActionBar();
    }


    /**
     * 添加自定义标题栏view
     * @param view
     * @return
     */
    public ToolBarX setCustomView(View view){
        rl_custom.removeAllViews();
        rl_custom.addView(view);
        return this;
    }

    /**
     * 标题...资源Id
     * @param resId
     * @return
     */
    public ToolBarX setTitle(int resId){
        mActionBar.setTitle(resId);
        return this;
    }

    /**
     * 标题....文字
     * @param title
     * @return
     */
    public ToolBarX setTitle(String title){
//        mToolbar.setTitle(title);
        mActionBar.setTitle(title);
        return this;
    }

    /**
     * 副标题...资源Id
     * @param resId
     * @return
     */
    public ToolBarX setSubtitle(int resId){
        mActionBar.setSubtitle(resId);
        return this;
    }

    /**
     * 副标题...文字
     * @param subTitle
     * @return
     */
    public ToolBarX setSubtitle(String subTitle){
        mActionBar.setSubtitle(subTitle);
//        mToolbar.setNavigationIcon();
        return this;
    }

    public ToolBarX setNavigationIcon(int resId){
        mToolbar.setNavigationIcon(resId);
        return this;
    }

    /**
     * 是否显示返回按钮...
     * @param showHomeAsUp
     * @return
     */
    public ToolBarX setDisplayHomeAsUpEnabled(boolean showHomeAsUp){
        mActionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        return this;
    }

    public ToolBarX setDisplayShowTitleEnabled(boolean showTitle){
        mActionBar.setDisplayShowTitleEnabled(showTitle);
        return this;
    }

    public ToolBarX setNavigationOnClickListener(View.OnClickListener listener){
        mToolbar.setNavigationOnClickListener(listener);
        return this;
    }

    public ToolBarX inflateMenu(int resId){
        mToolbar.inflateMenu(resId);
        return this;
    }

    /**
     * 隐藏Toolbar
     * @return
     */
    public ToolBarX hide(){
        mActionBar.hide();
        return this;
    }

    /**
     * 获取View状态
     * @return
     */
    public int getVisibility(){
        return mToolbar.getVisibility();
    }

    /**
     * 显示隐藏.
     * @param visibility
     */
    public void setVisibility(int visibility){
        mToolbar.setVisibility(visibility);
    }

}
