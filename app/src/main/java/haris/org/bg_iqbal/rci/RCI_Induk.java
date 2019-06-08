package haris.org.bg_iqbal.rci;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import haris.org.bg_iqbal.R;

public class RCI_Induk extends AppCompatActivity implements DataCenter.OnFragmentInteractionListener, Validasi.OnFragmentInteractionListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rci_dashboard);

        TabLayout tl = (TabLayout)findViewById(R.id.tab_utama);
        tl.addTab(tl.newTab().setText("Data Center"));
        tl.addTab(tl.newTab().setText("Validasi"));
        tl.addTab(tl.newTab().setText("Pendaftaran"));
        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager vw = (ViewPager)findViewById(R.id.pager);
        final AdapterTab adapter = new AdapterTab(getSupportFragmentManager(), tl.getTabCount());
        vw.setAdapter(adapter);
        vw.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));

        tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vw.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}