package de.appcom.pokedexapp4.fragments.dashboard.interactors;

import de.appcom.model.models.Pokemon;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * @author Stefan Neidig
 */

public interface LoadInitialDataInteractor {

  Flowable<Pokemon> execute(int pokemonId);
}
