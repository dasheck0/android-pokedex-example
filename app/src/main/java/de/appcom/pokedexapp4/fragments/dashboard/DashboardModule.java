package de.appcom.pokedexapp4.fragments.dashboard;

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
import de.appcom.pokedexapp4.annotations.PerFragment;
import de.appcom.pokedexapp4.fragments.dashboard.interactors.LoadInitialDataInteractor;
import de.appcom.pokedexapp4.fragments.dashboard.interactors.LoadInitialDataInteractorImpl;

/**
 * @author Stefan Neidig
 */

@Module public class DashboardModule {

  private DashboardView view;
  private DashboardPresenter presenter;

  public DashboardModule(DashboardView view, DashboardPresenter presenter) {
    this.view = view;
    this.presenter = presenter;
  }

  @PerFragment @Provides public DashboardView provideView() {
    return view;
  }

  @PerFragment @Provides public DashboardPresenter providePresenter() {
    return presenter;
  }

  @Provides @PerFragment public LoadInitialDataInteractor provideLoadInitialDataInteractor(
      LoadInitialDataInteractorImpl loadInitialDataInteractorImpl) {
    return loadInitialDataInteractorImpl;
  }

  @Provides @PerFragment public PokemonDatastore providePokemonDatastore(PokemonDatastoreImpl pokemonDatastoreImpl) {
    return pokemonDatastoreImpl;
  }

  @Provides @PerFragment
  public PokemonWebDatasource providePokemonWebDatasource(PokemonWebDatasourceImpl pokemonWebDatasourceImpl) {
    return pokemonWebDatasourceImpl;
  }

  @Provides @PerFragment public PokemonDatabaseDatasource providePokemonDatabaseDatasource(
      PokemonDatabaseDatasourceImpl pokemonDatabaseDatasourceImpl) {
    return pokemonDatabaseDatasourceImpl;
  }

  @Provides @PerFragment
  public PokemonTransformer providePokemonTransformer(PokemonTransformerImpl pokemonTransformerImpl) {
    return pokemonTransformerImpl;
  }
}
