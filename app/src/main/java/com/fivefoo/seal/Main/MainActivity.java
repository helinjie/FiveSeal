package com.fivefoo.seal.Main;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fivefoo.seal.R;
import com.fivefoo.seal.Ui.Login.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private NavigationView mNavigation;

    private DrawerLayout mDrawerLayout;

    private ImageView ivBack;

    private TextView tvLoginOut;

    private LinearLayout llSign, llAfterSign, llWaitSign;

    private TextView tvAfterSign, tvWaitSign, tvGoCertification;

    private LinearLayout llSignature, llContract, llAccount, llPartners, llAlerts, llFeedback, llRegard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        mNavigation = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ivBack = (ImageView) findViewById(R.id.main_menu);
        tvLoginOut = (TextView) findViewById(R.id.tv_loginout);

        llSign = (LinearLayout) findViewById(R.id.ll_sign);
        llAfterSign = (LinearLayout) findViewById(R.id.ll_after_sign);
        llWaitSign = (LinearLayout) findViewById(R.id.ll_wait_sign);
        tvAfterSign = (TextView) findViewById(R.id.tv_after_sign_num);
        tvWaitSign = (TextView) findViewById(R.id.tv_wait_sign_num);
        tvGoCertification = (TextView) findViewById(R.id.tv_go_certification);
        llSignature = (LinearLayout) findViewById(R.id.ll_signature);
        llContract = (LinearLayout) findViewById(R.id.ll_contract);
        llAccount = (LinearLayout) findViewById(R.id.ll_account);
        llPartners = (LinearLayout) findViewById(R.id.ll_partners);
        llAlerts = (LinearLayout) findViewById(R.id.ll_alerts);
        llFeedback = (LinearLayout) findViewById(R.id.ll_feedback);
        llRegard = (LinearLayout) findViewById(R.id.ll_regard);

        /*设置下划线*/
        tvGoCertification.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvGoCertification.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        setListener();
    }

    private void setListener(){
        ivBack.setOnClickListener(this);
        tvLoginOut.setOnClickListener(this);
        llSign.setOnClickListener(this);
        llAfterSign.setOnClickListener(this);
        llWaitSign.setOnClickListener(this);
        tvGoCertification.setOnClickListener(this);
        llSignature.setOnClickListener(this);
        llContract.setOnClickListener(this);
        llAccount.setOnClickListener(this);
        llPartners.setOnClickListener(this);
        llAlerts.setOnClickListener(this);
        llFeedback.setOnClickListener(this);
        llRegard.setOnClickListener(this);
        mNavigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_login:
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signature:
                Toast.makeText(MainActivity.this, "我的签章", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_contract:
                Toast.makeText(MainActivity.this, "我的合同", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_partner:
                Toast.makeText(MainActivity.this, "我的合作伙伴", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_message:
                Toast.makeText(MainActivity.this, "消息通知", Toast.LENGTH_LONG).show();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_menu:
                Toast.makeText(MainActivity.this, "点击返回按钮", Toast.LENGTH_LONG).show();
                //监听返回键
                if (mDrawerLayout.isDrawerOpen(mNavigation)) {
                    //如果DrawerLayout 拦截点击 关闭Drawer
                    mDrawerLayout.closeDrawer(mNavigation);
                } else {
                    mDrawerLayout.openDrawer(mNavigation);
                }
                break;
            case R.id.tv_loginout:
                Toast.makeText(MainActivity.this, "点击退出登录", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_sign:
                Toast.makeText(MainActivity.this, "我要签约", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_after_sign:
                Toast.makeText(MainActivity.this, "待我签署", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_wait_sign:
                Toast.makeText(MainActivity.this, "等待他人签署", Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_go_certification:
                Toast.makeText(MainActivity.this, "去认证", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_signature:
                Toast.makeText(MainActivity.this, "我的签章", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_contract:
                Toast.makeText(MainActivity.this, "我的合同", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_account:
                Toast.makeText(MainActivity.this, "账户设置", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_partners:
                Toast.makeText(MainActivity.this, "我的合作伙伴", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_alerts:
                Toast.makeText(MainActivity.this, "消息通知", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_feedback:
                Toast.makeText(MainActivity.this, "意见反馈", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_regard:
                Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_LONG).show();
                break;

        }

    }

}
