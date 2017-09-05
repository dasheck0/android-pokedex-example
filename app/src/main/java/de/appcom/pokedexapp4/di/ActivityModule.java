package de.appcom.pokedexapp4.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import de.appcom.pokedexapp4.activities.BaseActivity;
import de.appcom.pokedexapp4.annotations.PerActivity;

/**
 * @author Stefan Neidig
 */

@Module public class ActivityModule {

  private BaseActivity baseActivity;

  public ActivityModule(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @PerActivity @Provides BaseActivity provideActivity() {
    return baseActivity;
  }

  @PerActivity @Provides Context provideActivityContext() {
    return baseActivity;
  }
}
