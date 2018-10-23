package com.login_page.hp.message;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Integer date_index;
    String id,address,body,date;
    public static final String TAG="messages";

    Message message;
    ArrayList<Message> arrayList = new ArrayList();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = managedQuery(Uri.parse("content://sms/inbox"),null,null,
                null,null);

        while (cursor.moveToNext()){

//            id = cursor.getString(cursor.getColumnIndex("id"));
            address = cursor.getString(cursor.getColumnIndex("address"));
            body = cursor.getString(cursor.getColumnIndex("body"));
            date_index = cursor.getColumnIndex("date");
            String dateString = cursor.getString(date_index);
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd-MMM-yyyy HH:mm");
            date = formatter.format(new Date(Long
                    .parseLong(dateString)));
//            Log.e(TAG,""+date);

            message = new Message(address,body,date);
            arrayList.add(message);
        }

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(arrayList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
