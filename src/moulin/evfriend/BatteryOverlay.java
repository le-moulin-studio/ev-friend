package moulin.evfriend;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BatteryOverlay extends ItemizedOverlay<OverlayItem> {

  private Context context;
  private List<OverlayItem> items = new ArrayList<OverlayItem>();

  public BatteryOverlay(Drawable defaultMarker) {
    super(boundCenter(defaultMarker));
  }

  public BatteryOverlay(Drawable defaultMarker, Context context) {
    this(defaultMarker);
    this.context = context;
  }

  public void addOverlays(Collection<OverlayItem> items) {
    this.items.addAll(items);
    populate();
  }

  @Override
  protected OverlayItem createItem(int i) {
    return items.get(i);
  }

  @Override
  public int size() {
    return items.size();
  }

  @Override
  protected boolean onTap(int index) {
    OverlayItem item = items.get(index);
    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
    dialog.setTitle(item.getTitle());
    dialog.setMessage(item.getSnippet());
    dialog.show();
    
    return true;
  }

  @Override
  public void draw(Canvas canvas, MapView mapView, boolean shadow) {
    if (!shadow) super.draw(canvas, mapView, shadow);
  }
  
}
