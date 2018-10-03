package com.example.student.android3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.action2:
                Toast.makeText(this, "Action 2 click", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.action3:
                Toast.makeText(this, "Action 3 click", Toast.LENGTH_LONG).show();
                return  true;
        }
        return false;
    }

    public void OnClick(View v) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(this, "Hello toast!", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2: {
                Toast toast = Toast.makeText(this, "Hello toast!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 100, 100);
                toast.show();
            }
            break;
            case R.id.button3: {
                Toast toast = Toast.makeText(this, "Hello toast!", Toast.LENGTH_LONG);

                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);

                LinearLayout layout = (LinearLayout) toast.getView();
                layout.addView(imageView, 0);
                layout.removeViewAt(1);

                toast.show();
            }
            break;
            case R.id.button4: {
                View view = getLayoutInflater().inflate(R.layout.toast, null);
                TextView textView = view.findViewById(R.id.textView);
                textView.setText("Custom toast");

                view.findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                Toast toast = new Toast(this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view);
                toast.show();
            }
            break;
            case R.id.button5: {
                Intent intent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(this, 0, intent, 0);

                Notification notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Ticker")
                        .setContentTitle("Title")
                        .setContentText("Text")
                        .setWhen(System.currentTimeMillis())
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentIntent(pendingIntent)
                        .build();

                notificationManager.notify(1, notification);
            }
            break;
            case R.id.button6:
                ProgressDialog dialog = new ProgressDialog(this);
                dialog.setMessage("Wait...");
                dialog.setCancelable(false);
                dialog.show();
                break;
            case R.id.button7:
                PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.imageView));
                popupMenu.inflate(R.menu.main);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.action2:
                Toast.makeText(this, "Action 2 click", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.action3:
                Toast.makeText(this, "Action 3 click", Toast.LENGTH_LONG).show();
                return  true;
        }
        return false;
    }
}
