package haris.org.bg_iqbal.core;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class Ubah_Status extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = managedQuery(uri, null, null, null, null);

        for (int i = 0; i < cursor.getColumnCount(); i++) {
            Log.i("vipul", cursor.getColumnName(i));
        }


        Cursor c= getContentResolver().query(uri, null, null ,null,null);
        startManagingCursor(c);

        // Read the sms data and store it in the list
        if(c.moveToFirst()) {
            for(int i=0; i < c.getCount(); i++) {
                markMessageRead(this, c.getString(c.getColumnIndexOrThrow("address")).toString(), c.getString(c.getColumnIndexOrThrow("body")).toString());
//                Toast.makeText(Ubah_Status.this, c.getString(c.getColumnIndexOrThrow("read")), Toast.LENGTH_SHORT).show();
                c.moveToNext();
            }
        }
        c.close();


//        if (cursor.moveToFirst()) {
//            do {
//
//                String id = cursor.getString(0);
//
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("read", false);
//                getContentResolver().update(uri, contentValues, "_id=?",
//                        new String[] { id });
//                contentValues.clear();
//            } while (cursor.moveToNext());
//
//        }
    }

    private void markMessageRead(Context context, String number, String body) {

        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        try{

            while (cursor.moveToNext()) {
                if ((cursor.getString(cursor.getColumnIndex("address")).equals(number)) && (cursor.getInt(cursor.getColumnIndex("read")) == 0)) {
                    if (cursor.getString(cursor.getColumnIndex("body")).startsWith(body)) {
                        String SmsMessageId = cursor.getString(cursor.getColumnIndex("_id"));
                        ContentValues values = new ContentValues();
                        values.put("read", true);
                        context.getContentResolver().update(Uri.parse("content://sms/inbox"), values, "_id=" + SmsMessageId, null);
                        Toast.makeText(Ubah_Status.this, cursor.getString(cursor.getColumnIndex("read")), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        }catch(Exception e)
        {
            Log.e("Mark Read", "Error in Read: "+e.toString());
        }
    }
}
