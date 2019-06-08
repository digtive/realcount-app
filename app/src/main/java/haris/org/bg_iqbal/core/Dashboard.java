package haris.org.bg_iqbal.core;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import haris.org.bg_iqbal.chart.ChartActivity;
import haris.org.bg_iqbal.chart.PieChart;
import haris.org.bg_iqbal.expandable.RecyclerViewActivity;
import haris.org.bg_iqbal.pop_up.PopUpTest;
import haris.org.bg_iqbal.rci.RCI_Induk;
import haris.org.bg_iqbal.tab_navigation.Navigation_Swipe;
import haris.org.bg_iqbal.R;
import haris.org.bg_iqbal.baca_inbox.Baca_Inbox;
import haris.org.bg_iqbal.baca_notifikasi.Baca_Notifikasi;

public class Dashboard extends AppCompatActivity {
    Button inbox, notif, kirim, bar, pie, expand, tab, pop, pizza;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        inbox = (Button)findViewById(R.id.btn_sms_masuk);
        notif = (Button)findViewById(R.id.btn_sms_notif);
        kirim = (Button)findViewById(R.id.btn_sms_send);
        bar = (Button)findViewById(R.id.btn_bar_chart);
        pie = (Button)findViewById(R.id.btn_pie_chart);
        expand = (Button)findViewById(R.id.btn_expand);
        tab = (Button)findViewById(R.id.btn_tab);
        pop = (Button)findViewById(R.id.btn_pop_up);
        pizza = (Button)findViewById(R.id.btn_pizza_chart);

        ActivityCompat.requestPermissions(Dashboard.this, new String[]{Manifest.permission.READ_SMS}, 1);

        if (ContextCompat.checkSelfPermission(Dashboard.this,
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Dashboard.this,
                    Manifest.permission.READ_SMS) || ActivityCompat.shouldShowRequestPermissionRationale(Dashboard.this,
                    Manifest.permission.SEND_SMS) || ActivityCompat.shouldShowRequestPermissionRationale(Dashboard.this,
                    Manifest.permission.RECEIVE_SMS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(Dashboard.this,
                        new String[]{Manifest.permission.READ_SMS},
                        0);
                ActivityCompat.requestPermissions(Dashboard.this,
                        new String[]{Manifest.permission.SEND_SMS},
                        0);
                ActivityCompat.requestPermissions(Dashboard.this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        0);

            }
        }


        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inbox = new Intent(Dashboard.this, Baca_Inbox.class);
                startActivity(inbox);
            }
        });

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(Dashboard.this, Baca_Notifikasi.class);
                startActivity(notif);
            }
        });

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(Dashboard.this, SendSms.class);
                startActivity(notif);
            }
        });

        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Dashboard.this, ChartActivity.class);
                in.putExtra("tipe", "bar");
                startActivity(in);
            }
        });

        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Dashboard.this, ChartActivity.class);
                in.putExtra("tipe", "pie");
                startActivity(in);
            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inbox = new Intent(Dashboard.this, RecyclerViewActivity.class);
                startActivity(inbox);
            }
        });

        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inbox = new Intent(Dashboard.this, Navigation_Swipe.class);
                startActivity(inbox);
            }
        });

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inbox = new Intent(Dashboard.this, PopUpTest.class);
                startActivity(inbox);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inbox = new Intent(Dashboard.this, RCI_Induk.class);
                startActivity(inbox);
            }
        });
    }

}
