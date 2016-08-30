package mvrbancic.naughtynaughtytwo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;

    private ShakeDetector mSensorListener;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new ShakeDetector();

        mSensorListener.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            public void onShake() {
                Toast.makeText(getApplicationContext(), "Shake!", Toast.LENGTH_SHORT).show();

            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);

        Toast.makeText(getApplicationContext(), "Resume!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();

        Toast.makeText(getApplicationContext(), "Stop!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onStop();

        Toast.makeText(getApplicationContext(), "Stop!", Toast.LENGTH_SHORT).show();
    }


}
