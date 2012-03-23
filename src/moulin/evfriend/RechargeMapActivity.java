package moulin.evfriend;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.lemoulinstudio.evfriend.domain.Spot;
import java.util.ArrayList;
import java.util.List;

public class RechargeMapActivity extends MapActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recharge_map);

    MapView mapView = (MapView) findViewById(R.id.mapview);
    mapView.setBuiltInZoomControls(true);

    List<Overlay> mapOverlays = mapView.getOverlays();
    Drawable drawable = this.getResources().getDrawable(R.drawable.parking24);
    BatteryOverlay batteryOverlay = new BatteryOverlay(drawable, this);

    List<OverlayItem> items = new ArrayList<OverlayItem>();
    for (Spot spot : InitialMapData.spots)
      if (spot.geoLocation != null)
        items.add(new OverlayItem(
                new GeoPoint((int) (spot.geoLocation.latitude * 1000000),
                             (int) (spot.geoLocation.longitude * 1000000)),
                spot.name,
                spot.address + "\n" + spot.nbPlaces + "個位子"));
    batteryOverlay.addOverlays(items);
    mapOverlays.add(batteryOverlay);
    
    // Center the view on the DaAn park on the first run.
    GeoPoint daAnSpot = new GeoPoint(25029781, 121536247);
    mapView.getController().setCenter(daAnSpot);
    mapView.getController().setZoom(12);
  }

  @Override
  protected boolean isRouteDisplayed() {
    return false;
  }
  
}
