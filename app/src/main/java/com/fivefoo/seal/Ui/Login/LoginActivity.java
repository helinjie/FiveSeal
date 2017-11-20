package com.fivefoo.seal.Ui.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fivefoo.seal.Base.BaseActivity;
import com.fivefoo.seal.R;

/**
 * Created by 67423 on 2017/11/16.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected String getTAG() {
        return this.toString();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolBarX().hide();
    }
}
