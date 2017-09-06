package de.appcom.pokedexapp4.di;

import android.content.Context;
import dagger.Component;
import de.appcom.model.datasources.database.PokemonDatabaseDatasource;
import de.appcom.model.datasources.web.PokemonWebDatasource;
import de.appcom.model.datastores.PokemonDatastore;
import de.appcom.model.di.ModelModule;
import de.appcom.model.transformers.PokemonTransformer;
import de.appcom.pokedexapp4.PokedexApplication;
import javax.inject.Singleton;

/**
 * @author Stefan Neidig
 */

@Singleton @Component(modules = { ApplicationModule.class, ModelModule.class }) public interface ApplicationComponent {

  /* Common */

  PokedexApplication pokedexApplication();

  /* Transformers */

  PokemonTransformer pokemonTransformer();

  /* Datastores */

  PokemonDatastore pokemonDatastore();

  /* Datasources */

  PokemonDatabaseDatasource pokemonDatabaseDatasource();

  PokemonWebDatasource pokemonWebDatasource();
}
