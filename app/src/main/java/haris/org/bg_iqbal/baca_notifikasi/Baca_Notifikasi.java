package haris.org.bg_iqbal.baca_notifikasi;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import haris.org.bg_iqbal.R;

public class Baca_Notifikasi extends AppCompatActivity {
    EditText txt_no, txt_isi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_notif);
        txt_no = (EditText)findViewById(R.id.et_nomor);
        txt_isi = (EditText)findViewById(R.id.et_pesan);
        cekPermission();
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String nomor, String messagetext) {
                Log.d("Isi Pesan", messagetext);
                Toast.makeText(Baca_Notifikasi.this, "Isi pesan = "+messagetext, Toast.LENGTH_SHORT).show();
                updateUI(nomor, messagetext);
            }
        });

    }

    private void updateUI(final String no, final String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txt_no.setText(no);
                txt_isi.setText(message);
            }
        });
    }

    private void cekPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(Baca_Notifikasi.this, Manifest.permission.READ_SMS)){
            Log.d("SMS PERMISSION", "Harus menunjukkan permission");
        }
        ActivityCompat.requestPermissions(Baca_Notifikasi.this, new String[]{Manifest.permission.READ_SMS}, 0);
    }
}
