package meqdad.darweesh.homy;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManageActivity extends MainActivity {

    private static final String CHANNEL_ID = "1";
    //    public static Intent i;
    public static int CONTROLHOME = 5;

    public static TextView gasSensor;
    public static Button sensorOff;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        gasSensor = findViewById(R.id.gasSensor);
        sensorOff = findViewById(R.id.sensorOff);
        String number = gasSensor.getText().toString();
        sensorOff.setVisibility(View.INVISIBLE);


        if (Integer.parseInt(number) > 300) {
            sensorOff.setVisibility(View.VISIBLE);
            notificationCall();
        }
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
