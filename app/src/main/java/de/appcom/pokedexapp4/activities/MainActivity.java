package de.appcom.pokedexapp4.activities;

import android.app.Application;
import android.os.Bundle;
import android.widget.TextView;
import de.appcom.pokedexapp4.R;
import de.appcom.pokedexapp4.annotations.Layout;
import timber.log.Timber;

@Layout(R.layout.activity_main) public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Timber.d("Hey this is a log message");
  }
}
