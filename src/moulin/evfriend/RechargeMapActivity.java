package moulin.evfriend;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;
import com.lemoulinstudio.evfriend.domain.Spot;
import java.util.ArrayList;
import java.util.List;

public class RechargeMapActivity extends MapActivity {

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recharge_map);

    MapView mapView = (MapView) findViewById(R.id.mapview);
    mapView.setBuiltInZoomControls(true);

    List<Overlay> mapOverlays = mapView.getOverlays();
    Drawable drawable = this.getResources().getDrawable(R.drawable.recharge24);
    BatteryOverlay batteryOverlay = new BatteryOverlay(drawable, this);

    List<OverlayItem> items = new ArrayList<OverlayItem>();
    for (Spot spot : InitialMapData.spots)
      if (spot.geoLocation != null)
        items.add(new OverlayItem(
                new GeoPoint((int) (spot.geoLocation.latitude * 1000000),
                             (int) (spot.geoLocation.longitude * 1000000)),
                spot.name, spot.address));
    batteryOverlay.addOverlays(items);
    mapOverlays.add(batteryOverlay);
  }

  @Override
  protected boolean isRouteDisplayed() {
    return false;
  }
  
}
