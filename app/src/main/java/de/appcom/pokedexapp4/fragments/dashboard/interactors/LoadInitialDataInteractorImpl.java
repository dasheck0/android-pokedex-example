package de.appcom.pokedexapp4.fragments.dashboard.interactors;

import de.appcom.model.datastores.PokemonDatastore;
import de.appcom.model.models.Pokemon;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import javax.inject.Inject;

/**
 * @author Stefan Neidig
 */

public class LoadInitialDataInteractorImpl implements LoadInitialDataInteractor {

  @Inject PokemonDatastore pokemonDatastore;

  @Inject public LoadInitialDataInteractorImpl() {
  }

  @Override public Flowable<Pokemon> execute(int pokemonId) {
    return pokemonDatastore.getPokemon(pokemonId)
        .observeOn(new ComputationScheduler())
        .subscribeOn(AndroidSchedulers.mainThread());
  }
}
