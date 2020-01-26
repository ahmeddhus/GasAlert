package meqdad.darweesh.homy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManageActivity extends MainActivity {

    private static final String CHANNEL_ID = "1";
    public static int CONTROLHOME = 5;

    public static TextView gasSensor;
    public static Button sensorOff;
    private String number;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        init();

        if (Integer.parseInt(number) > 300) {
            sensorOff.setVisibility(View.VISIBLE);

            Intent ring = new Intent(ManageActivity.this, RingingActivity.class);
            startActivity(ring);
        }
    }

    private void init() {

        gasSensor = findViewById(R.id.gasSensor);
        sensorOff = findViewById(R.id.sensorOff);
        number = gasSensor.getText().toString();
        sensorOff.setVisibility(View.INVISIBLE);
    }
}
