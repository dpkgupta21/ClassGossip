package com.classgossip.navigationdrawer;

import android.os.Bundle;
import android.view.View;

import com.classgossip.R;
import com.classgossip.navigationresidemenu.ResideMenuItem;
import com.classgossip.navigationresidemenu.ResideMenuSecond;
import com.classgossip.utilities.BaseActivity;

public class NavigationDrawerActivity extends BaseActivity {

    private ResideMenuSecond resideMenu;
    private ResideMenuItem[] menuItemArray;

    private ResideMenuSecond.OnMenuListener menuListener = new ResideMenuSecond.OnMenuListener() {
        @Override
        public void openMenu() {
        }

        @Override
        public void closeMenu() {
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        setUpMenu();
        setViewVisibility(R.id.hamburgur_img_icon, View.VISIBLE);
        setClick(R.id.hamburgur_img_icon);
    }


    /**
     * this method sets up navigation drawer menu
     */
    private void setUpMenu() {
        resideMenu = new ResideMenuSecond(this);
        resideMenu.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        String[] menuItems = getResources().getStringArray(R.array.menu_item_string_array);
        int[] drawables = getResources().getIntArray(R.array.menu_item_drawable_array);
        menuItemArray = new ResideMenuItem[menuItems.length];

        for (int i = 0; i < menuItems.length; i++) {
            menuItemArray[i] = new ResideMenuItem(this, drawables[i], menuItems[i]);
            resideMenu.addMenuItem(menuItemArray[i], ResideMenuSecond.DIRECTION_LEFT);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hamburgur_img_icon:
                if (resideMenu.isOpened()) {
                    resideMenu.closeMenu();
                    resideMenu.setOpened(false);
                } else {
                    resideMenu.openMenu(ResideMenuSecond.DIRECTION_LEFT);
                    resideMenu.setOpened(true);
                }
        }
    }
}
