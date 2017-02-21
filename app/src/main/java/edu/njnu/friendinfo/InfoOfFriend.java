package edu.njnu.friendinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Sawatari on 2017/1/26.
 */

public class InfoOfFriend extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toolbar toolbar = (Toolbar) findViewById(R.id.friToolbar);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}