package com.classgossip.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.classgossip.R;
import com.classgossip.navigationdrawer.NavigationDrawerActivity;
import com.classgossip.utilities.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setHeader(getString(R.string.app_name));
        setClick(R.id.button_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                openNavigationDrawerActivity();
                break;
        }
    }

    /**
     * this method opens NavigationDrawerActivity
     *
     * @see NavigationDrawerActivity
     */
    private void openNavigationDrawerActivity() {
        Intent drawerIntent = new Intent(this, NavigationDrawerActivity.class);
        startActivity(drawerIntent);
    }
}
