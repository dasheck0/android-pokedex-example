package de.appcom.pokedexapp4;

import android.app.Application;
import de.appcom.model.di.ModelModule;
import de.appcom.pokedexapp4.di.ApplicationComponent;
import de.appcom.pokedexapp4.di.ApplicationModule;
import de.appcom.pokedexapp4.di.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * @author Stefan Neidig
 */

public class PokedexApplication extends Application {

  ApplicationComponent component;

  @Override public void onCreate() {
    super.onCreate();

    setupTimber();
    setupDependencyInjection();
  }

  private void setupDependencyInjection() {
    component = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .modelModule(new ModelModule())
        .build();
  }

  private void setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree() {
        @Override protected String createStackElementTag(StackTraceElement element) {
          return super.createStackElementTag(element) + "," + element.getFileName() + ", " + element.getMethodName()
              + ", " + element.getLineNumber();
        }
      });
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return component;
  }
}
