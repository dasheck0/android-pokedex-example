package de.appcom.pokedexapp4.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.appcom.pokedexapp4.PokedexApplication;
import de.appcom.pokedexapp4.annotations.Layout;
import de.appcom.pokedexapp4.di.ActivityComponent;
import de.appcom.pokedexapp4.di.ActivityModule;
import de.appcom.pokedexapp4.di.DaggerActivityComponent;
import java.lang.annotation.Annotation;

import static butterknife.ButterKnife.bind;

/**
 * @author Stefan Neidig
 */

public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder unbinder;
  private ActivityComponent component;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());

    unbinder = ButterKnife.bind(this);
    setupDependencyInjection();
  }

  private void setupDependencyInjection() {
    component = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .applicationComponent(((PokedexApplication) getApplication()).getApplicationComponent())
        .build();
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
