package de.appcom.pokedexapp4.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.appcom.pokedexapp4.annotations.Layout;
import java.lang.annotation.Annotation;

import static butterknife.ButterKnife.bind;

/**
 * @author Stefan Neidig
 */

public abstract class BaseActivity extends AppCompatActivity {

  Unbinder unbinder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());

    unbinder = ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
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
