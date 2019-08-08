package jp.co.cyberagent.dojo2019;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class QRCodeActivity extends AppCompatActivity {
    private String[] str = new String[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        str[0] = data.getString("name", "none");
        str[1] = data.getString("github", "none");
        str[2] = data.getString("twitter", "none");
        String qrData = "ca-tech://dojo/share?iam="+str[0]+"&tw="+str[1]+"&gh="+str[2]+"";
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            //QRコードをBitmapで作成
            Bitmap bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 500, 500);

            //作成したQRコードを画面上に配置
            ImageView imageViewQrCode = findViewById(R.id.imageView);
            imageViewQrCode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            throw new AndroidRuntimeException("Barcode Error.", e);
        }
    }
    public void setScreenMain(View v) {
        Intent intent = new Intent(QRCodeActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void setScreenQRRead(View v){
        Intent intent = new Intent(QRCodeActivity.this, QRReadActivity.class);
        startActivity(intent);
    }
    public void setScreenList(View v){
        Intent intent = new Intent(QRCodeActivity.this, ListActivity.class);
        startActivity(intent);
    }
}
