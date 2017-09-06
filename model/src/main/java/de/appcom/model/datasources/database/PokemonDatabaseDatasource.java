package de.appcom.model.datasources.database;

import de.appcom.model.models.Pokemon;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;

/**
 * @author Stefan Neidig
 */

public interface PokemonDatabaseDatasource {

  Single<List<Pokemon>> getAllPokemon(int limit);

  Single<Pokemon> getPokemon(int pokemonId);
}
