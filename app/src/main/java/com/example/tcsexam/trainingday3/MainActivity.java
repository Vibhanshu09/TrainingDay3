package com.example.tcsexam.trainingday3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button popupMenuButton, radioMenu, tabLayoutButton, navDrawerButton;
    int menu_state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupMenuButton = findViewById(R.id.popup_menu);
        radioMenu = findViewById(R.id.radio_menu);
        tabLayoutButton = findViewById(R.id.tablayout_button);
        navDrawerButton = findViewById(R.id.navdrawer_button);

        popupMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenuEventHandler(MainActivity.this));
                popupMenu.show();
            }
        });

        radioMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(view);
                openContextMenu(view);
            }
        });

        tabLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MyToolbarActivity.class));
            }
        });

        navDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MyToolbarActivity2.class));
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.radio_menu,menu);
        MenuItem share = menu.findItem(R.id.share_radio_menu);
        MenuItem call = menu.findItem(R.id.call_radio_menu);
        MenuItem message = menu.findItem(R.id.message_radio_menu);
        if (menu_state == 1)
            share.setChecked(true);
        else if (menu_state == 2)
            call.setChecked(true);
        else if (menu_state == 3)
            message.setChecked(true);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_radio_menu:
                showToast("Share");
                menu_state = 1;
                item.setChecked(true);
                return true;
            case R.id.call_radio_menu:
                showToast("Call");
                menu_state = 2;
                item.setChecked(true);
                return true;
            case R.id.message_radio_menu:
                showToast("Message");
                menu_state = 3;
                item.setChecked(true);
                return true;
        }
        return super.onContextItemSelected(item);
    }


    public void showToast(String textToDisplay){
        Toast.makeText(MainActivity.this, textToDisplay, Toast.LENGTH_SHORT).show();
    }
}
