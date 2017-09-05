package de.appcom.pokedexapp4.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.appcom.pokedexapp4.PokedexApplication;
import de.appcom.pokedexapp4.annotations.Layout;
import de.appcom.pokedexapp4.di.ActivityComponent;
import de.appcom.pokedexapp4.di.ActivityModule;
import de.appcom.pokedexapp4.di.DaggerActivityComponent;
import de.appcom.pokedexapp4.fragments.dashboard.DaggerDashboardComponent;
import de.appcom.pokedexapp4.fragments.dashboard.DashboardComponent;
import de.appcom.pokedexapp4.fragments.dashboard.DashboardFragment;
import de.appcom.pokedexapp4.fragments.dashboard.DashboardModule;
import de.appcom.pokedexapp4.fragments.dashboard.DashboardPresenterImpl;
import java.lang.annotation.Annotation;
import java.util.prefs.PreferenceChangeEvent;

/**
 * @author Stefan Neidig
 */

public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder unbinder;
  protected ActivityComponent component;

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

  public void loadDashboard() {
    DashboardFragment fragment = new DashboardFragment();
    DashboardPresenterImpl presenter = new DashboardPresenterImpl();

    DashboardComponent dashboardComponent = DaggerDashboardComponent.builder()
        .dashboardModule(new DashboardModule(fragment, presenter))
        .activityComponent(component)
        .build();

    dashboardComponent.inject(fragment);
    dashboardComponent.inject(presenter);

    getSupportFragmentManager().beginTransaction()
        .replace(getContainerResId(), fragment)
        .addToBackStack(fragment.getClass().getSimpleName())
        .commit();
  }

  private int getLayoutResId() {
    Annotation annotation = getClass().getAnnotation(Layout.class);
    if (annotation != null) {
      return ((Layout) annotation).value();
    } else {
      throw new IllegalStateException("You must provide a layout annotation");
    }
  }

  protected abstract int getContainerResId();
}


