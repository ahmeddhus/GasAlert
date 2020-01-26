package meqdad.darweesh.homy;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RingingActivity extends AppCompatActivity {

    private Button close_alarm;
    private MediaPlayer mp;
    private static final String CHANNEL_ID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringing);

        init();
        actions();
    }

    private void init() {
        close_alarm = findViewById(R.id.close_ringing);
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        mp = MediaPlayer.create(getApplicationContext(), notification);
    }

    private void actions() {
        mp.start();
        notificationCall();

        close_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp.release();
                finish();

                Intent goToMain = new Intent(RingingActivity.this, MainActivity.class);
                startActivity(goToMain);
            }
        });
    }

    public void notificationCall() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Gas alarm")
                .setContentText("Gas infiltration")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(NotificationCompat.DEFAULT_ALL);


        NotificationManager notificationManger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManger != null) {
            notificationManger.notify(1, builder.build());
        }
    }
}
