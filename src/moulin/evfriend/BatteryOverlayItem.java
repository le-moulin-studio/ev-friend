package moulin.evfriend;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class BatteryOverlayItem extends OverlayItem {

  public BatteryOverlayItem(GeoPoint geoPoint, String title, String snippet) {
    super(geoPoint, title, snippet);
  }
  
}
