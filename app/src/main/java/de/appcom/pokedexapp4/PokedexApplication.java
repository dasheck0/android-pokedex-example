package de.appcom.pokedexapp4;

import android.app.Application;
import timber.log.Timber;

/**
 * @author Stefan Neidig
 */

public class PokedexApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();

    setupTimber();
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
}
