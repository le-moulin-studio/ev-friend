package moulin.evfriend;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BatteryOverlay extends ItemizedOverlay<BatteryOverlayItem> {

  private Context context;
  private List<BatteryOverlayItem> items = new ArrayList<BatteryOverlayItem>();

  public BatteryOverlay(Drawable defaultMarker) {
    super(boundCenterBottom(defaultMarker));
  }

  public BatteryOverlay(Drawable defaultMarker, Context context) {
    this(defaultMarker);
    this.context = context;
  }

  public void addOverlay(BatteryOverlayItem batteryItem) {
    items.add(batteryItem);
    populate();
  }

  public void addOverlays(Collection<BatteryOverlayItem> batteryItems) {
    items.addAll(batteryItems);
    populate();
  }

  @Override
  protected BatteryOverlayItem createItem(int i) {
    return items.get(i);
  }

  @Override
  public int size() {
    return items.size();
  }

  @Override
  protected boolean onTap(int index) {
    BatteryOverlayItem item = items.get(index);
    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
    dialog.setTitle(item.getTitle());
    dialog.setMessage(item.getSnippet());
    dialog.show();
    
    return true;
  }
}
