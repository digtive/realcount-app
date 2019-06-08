package haris.org.bg_iqbal.rci;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class AdapterTab extends FragmentStatePagerAdapter {

    int noTabs;
    public AdapterTab(FragmentManager fm, int NumberTabs) {
        super(fm);
        this.noTabs = NumberTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new DataCenter();
            case 1 : return new Validasi();
            case 2 : return new DataCenter();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0 : return "Tab 21";
            case 1 : return "Tab 12";
            default: return null;
        }
    }
}