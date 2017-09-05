package de.appcom.pokedexapp4.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import de.appcom.pokedexapp4.annotations.Layout;
import java.lang.annotation.Annotation;

/**
 * @author Stefan Neidig
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());
  }

  private int getLayoutResId() {
    Annotation annotation = getClass().getAnnotation(Layout.class);
    if (annotation != null) {
      return ((Layout) annotation).value();
    } else {
      throw new IllegalStateException("You must provide a layout annotation");
    }
  }
}
