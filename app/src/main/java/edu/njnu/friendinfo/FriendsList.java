package edu.njnu.friendinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sawatari on 2017/1/26.
 */

public class FriendsList extends AppCompatActivity {
    private ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.listToolbar);
        toolbar.setTitle("好友列表");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView  = (ListView)findViewById(R.id.friendListView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(FriendsList.this, InfoOfFriend.class);
                intent.putExtra("name", getData().get(position));
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getData(){
        ArrayList<String> myData = new ArrayList<String>();
        myData.add("何韬");
        myData.add("江亚玉");
        myData.add("李罚");
        myData.add("韩勇");
        return myData;
    }
}