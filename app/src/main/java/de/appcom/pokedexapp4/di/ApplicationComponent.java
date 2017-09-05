package de.appcom.pokedexapp4.di;

import android.content.Context;
import dagger.Component;
import de.appcom.pokedexapp4.PokedexApplication;
import javax.inject.Singleton;

/**
 * @author Stefan Neidig
 */

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

  PokedexApplication pokedexApplication();
}
