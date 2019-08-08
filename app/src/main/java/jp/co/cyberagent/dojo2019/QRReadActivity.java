package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrread);
        new IntentIntegrator(QRReadActivity.this).initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            Log.d("readQR", result.getContents());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    public void setScreenMain(View v) {
        Intent intent = new Intent(QRReadActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void setScreenQR(View v) {
        Intent intent = new Intent(QRReadActivity.this, QRCodeActivity.class);
        startActivity(intent);
    }
    public void setScreenList(View v){
        Intent intent = new Intent(QRReadActivity.this, ListActivity.class);
        startActivity(intent);
    }
}
