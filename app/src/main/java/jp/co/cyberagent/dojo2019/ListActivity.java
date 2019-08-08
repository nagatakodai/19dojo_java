package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabaseSingleton.getInstance(ListActivity.this);
                final TextView textView = findViewById(R.id.textView);
                final String a = db.userDao().toString();

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        // ui
                        textView.setText(a);
                    }
                });
            }
        }).start();
    }

    public void setScreenMain(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void setScreenQR(View v) {
        Intent intent = new Intent(ListActivity.this, QRCodeActivity.class);
        startActivity(intent);
    }
    public void setScreenQRRead(View v){
        Intent intent = new Intent(ListActivity.this, QRReadActivity.class);
        startActivity(intent);
    }

}
