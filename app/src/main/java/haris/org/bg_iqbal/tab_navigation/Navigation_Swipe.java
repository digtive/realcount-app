package haris.org.bg_iqbal.tab_navigation;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import haris.org.bg_iqbal.R;

public class Navigation_Swipe extends AppCompatActivity implements Tab_1.OnFragmentInteractionListener, Tab_2.OnFragmentInteractionListener, Tab_3.OnFragmentInteractionListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_swipe);

        TabLayout tl = (TabLayout)findViewById(R.id.tablayout);
        tl.addTab(tl.newTab().setText("Tab 1"));
        tl.addTab(tl.newTab().setText("Tab 2"));
        tl.addTab(tl.newTab().setText("Tab 3"));
        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager vw = (ViewPager)findViewById(R.id.pager);
        final MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), tl.getTabCount());
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

