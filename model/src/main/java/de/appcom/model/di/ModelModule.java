package de.appcom.model.di;

import dagger.Module;
import dagger.Provides;
import de.appcom.model.datasources.database.PokemonDatabaseDatasource;
import de.appcom.model.datasources.database.PokemonDatabaseDatasourceImpl;
import de.appcom.model.datasources.web.PokemonWebDatasource;
import de.appcom.model.datasources.web.PokemonWebDatasourceImpl;
import de.appcom.model.datastores.PokemonDatastore;
import de.appcom.model.datastores.PokemonDatastoreImpl;
import de.appcom.model.transformers.PokemonTransformer;
import de.appcom.model.transformers.PokemonTransformerImpl;
import javax.inject.Singleton;

/**
 * @author Stefan Neidig
 */

@Module public class ModelModule {

  @Provides @Singleton PokemonTransformer providePokemonTransformer(PokemonTransformerImpl pokemonTransformerImpl) {
    return pokemonTransformerImpl;
  }

  @Provides @Singleton public PokemonDatabaseDatasource providePokemonDatabaseDatasource(
      PokemonDatabaseDatasourceImpl pokemonDatabaseDatasourceImpl) {
    return pokemonDatabaseDatasourceImpl;
  }

  @Provides @Singleton
  public PokemonWebDatasource providePokemonWebDatasource(PokemonWebDatasourceImpl pokemonWebDatasourceImpl) {
    return pokemonWebDatasourceImpl;
  }

  @Provides @Singleton public PokemonDatastore providePokemonDatastore(PokemonDatastoreImpl pokemonDatastoreImpl) {
    return pokemonDatastoreImpl;
  }
}
