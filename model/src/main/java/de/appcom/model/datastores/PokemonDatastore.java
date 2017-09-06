package de.appcom.model.datastores;

import de.appcom.model.models.Pokemon;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Single;
import java.util.List;

/**
 * @author Stefan Neidig
 */

public interface PokemonDatastore {

  Flowable<List<Pokemon>> getAllPokemon();

  Flowable<Pokemon> getPokemon(int pokemonId);
}
