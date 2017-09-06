package de.appcom.model.datasources.web;

import de.appcom.model.models.Pokemon;
import io.reactivex.Single;
import java.util.List;

/**
 * @author Stefan Neidig
 */

public interface PokemonWebDatasource {

  Single<List<Pokemon>> getAllPokemon();

  Single<Pokemon> getPokemon(int pokemonId);
}
