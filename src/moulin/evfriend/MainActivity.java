package moulin.evfriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new OnClickListener() {
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, RechargeMapActivity.class));
      }
    });
  }

}
