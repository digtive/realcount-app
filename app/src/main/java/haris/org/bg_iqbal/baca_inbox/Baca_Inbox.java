package haris.org.bg_iqbal.baca_inbox;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Baca_Inbox extends ListActivity {

    Button btn_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<SMSData> smsList = new ArrayList<SMSData>();


        final int REQUEST_CODE_ASK_PERMISSIONS = 123;
        ActivityCompat.requestPermissions(Baca_Inbox.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);

        Uri uri = Uri.parse("content://sms/inbox");
        Cursor c= getContentResolver().query(uri, null, null ,null,null);
        startManagingCursor(c);


        // Read the sms data and store it in the list
        if(c.moveToFirst()) {
            for(int i=0; i < c.getCount(); i++) {
                SMSData sms = new SMSData();
                sms.setBody(c.getString(c.getColumnIndexOrThrow("body")).toString());
                sms.setNumber(c.getString(c.getColumnIndexOrThrow("address")).toString());
                sms.setStatus(Integer.parseInt(c.getString(c.getColumnIndexOrThrow("read")).toString()));
                smsList.add(sms);
                c.moveToNext();
            }
        }
        c.close();
        String mm = smsList.get(0).getBody();
        String xx = String.valueOf(mm.charAt(0));
        if (xx.equals("#")){

            Toast.makeText(this, "Format sms terdeteksi", Toast.LENGTH_SHORT).show();
        }
        setListAdapter(new ListAdapter(this, smsList));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        SMSData sms = (SMSData)getListAdapter().getItem(position);

        Toast.makeText(getApplicationContext(), String.valueOf(sms.getBody())+"\n"+String.valueOf(sms.getStatus()), Toast.LENGTH_LONG).show();
    }
}
