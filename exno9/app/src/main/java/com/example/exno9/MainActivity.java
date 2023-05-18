package com.example.exno9;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    NotificationChannel channel;
    CharSequence charSequence = "";
    EditText e;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSimpleNotification = findViewById(R.id.Button);

        e= (EditText) findViewById(R.id.editText);
        String msg = e.toString();
        btnSimpleNotification.setOnClickListener(this);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence name = "My Notification";
        String description = "welcome seenuvasan";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);
        builder = new NotificationCompat.Builder(MainActivity.this, channel.getId())
                .setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.createNotificationChannel(channel);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button:
                simpleNotification();
                break;

        }
    }
    private void simpleNotification() {

        Person jd = new Person.Builder().setName("allert") .setImportant(true) .build();
        new NotificationCompat.MessagingStyle(jd)
                .addMessage(e.getText(), new Date().getTime(), jd) .setBuilder(builder);
        notificationManager.notify(1, builder.build());
    }

}
