package de.appcom.pokedexapp4.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import de.appcom.pokedexapp4.PokedexApplication;
import javax.inject.Singleton;

/**
 * @author Stefan Neidig
 */

@Module public class ApplicationModule {

  private PokedexApplication pokedexApplication;

  public ApplicationModule(PokedexApplication pokedexApplication) {
    this.pokedexApplication = pokedexApplication;
  }

  @Singleton @Provides PokedexApplication providePokedexApplication() {
    return pokedexApplication;
  }
}
