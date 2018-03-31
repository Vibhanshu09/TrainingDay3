package com.example.tcsexam.trainingday3;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by Vibhanshu on 3/31/2018.
 */

public class PopupMenuEventHandler implements PopupMenu.OnMenuItemClickListener {
    Context context;
    public PopupMenuEventHandler(Context context){
        this.context = context;
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.share_menu:
                showToast("Share");
                return true;
            case R.id.call_menu:
                showToast("Call");
                return true;
            case R.id.message_menu:
                showToast("Message");
                return true;
        }
        return false;
    }

    public void showToast(String textToDisplay){
        Toast.makeText(context, textToDisplay, Toast.LENGTH_SHORT).show();
    }
}
