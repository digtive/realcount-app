package haris.org.bg_iqbal.tab_navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int noTabs;
    public MyPagerAdapter(FragmentManager fm, int NumberTabs) {
        super(fm);
        this.noTabs = NumberTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Tab_1();
            case 1 : return new Tab_2();
            case 2 : return new Tab_3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0 : return "Tab 1";
            case 1 : return "Tab 2";
            default: return null;
        }
    }
}
