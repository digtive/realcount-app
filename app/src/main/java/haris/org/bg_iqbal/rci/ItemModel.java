package haris.org.bg_iqbal.rci;

import android.animation.TimeInterpolator;

public class ItemModel {
    public final String description;
    public final String rincian;
    public final int colorId1;
    public final int colorId2;
    public final TimeInterpolator interpolator;

    public ItemModel(String description, String rincian, int colorId1, int colorId2, TimeInterpolator interpolator) {
        this.description = description;
        this.rincian = rincian;
        this.colorId1 = colorId1;
        this.colorId2 = colorId2;
        this.interpolator = interpolator;
    }
}