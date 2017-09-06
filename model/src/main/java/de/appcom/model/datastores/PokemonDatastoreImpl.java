package de.appcom.model.datastores;

import de.appcom.model.datasources.database.PokemonDatabaseDatasource;
import de.appcom.model.datasources.web.PokemonWebDatasource;
import de.appcom.model.models.Pokemon;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Stefan Neidig
 */

public class PokemonDatastoreImpl implements PokemonDatastore {

  @Inject PokemonWebDatasource webDatasource;
  @Inject PokemonDatabaseDatasource databaseDatasource;

  @Inject public PokemonDatastoreImpl() {
  }

  @Override public Flowable<List<Pokemon>> getAllPokemon() {
    //List<Pokemon> databaseList = databaseDatasource.getAllPokemon(10);
    //List<Pokemon> webList = webDatasource.getAllPokemon();
    //
    //return databaseList;
    return databaseDatasource.getAllPokemon(10).concatWith(webDatasource.getAllPokemon());
  }

  @Override public Flowable<Pokemon> getPokemon(int pokemonId) {
    //Pokemon databasePokemon = databaseDatasource.getPokemon(pokemonId);
    //Pokemon webPokemon = webDatasource.getPokemon(pokemonId);
    //
    //return databasePokemon;
    return databaseDatasource.getPokemon(pokemonId).concatWith(webDatasource.getPokemon(pokemonId));
  }
}
