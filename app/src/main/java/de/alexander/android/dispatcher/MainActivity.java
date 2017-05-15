package de.alexander.android.dispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Bundle extras = getIntent().getExtras();
//        String params = "";
//
//        if (extras != null) {
//            for (String key : extras.keySet()) {
//                Object value = extras.get(key);
//                Log.d("", String.format("%s %s (%s)", key,
//                        value.toString(), value.getClass().getName()));
//                params += key + ", ";
//            }
//        }

        Context context = MainActivity.this;

        String number = getIntent().getDataString();

//        Toast.makeText(context, "Data: " + number, Toast.LENGTH_SHORT).show();

        if (number != null) {
            number = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        finish();
        System.exit(0);
    }
}
