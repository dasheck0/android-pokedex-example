package de.appcom.model.datasources.database;

import de.appcom.model.entities.database.PokemonDatabaseEntity;
import de.appcom.model.models.Pokemon;
import de.appcom.model.transformers.PokemonTransformer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

import static android.R.id.list;

/**
 * @author Stefan Neidig
 */

public class PokemonDatabaseDatasourceImpl implements PokemonDatabaseDatasource {

  @Inject PokemonTransformer pokemonTransformer;

  @Inject public PokemonDatabaseDatasourceImpl() {
  }

  @Override public Single<List<Pokemon>> getAllPokemon(int limit) {

    return Single.create(subscriber -> {
      List<Pokemon> result = new ArrayList<>();

      result.add(pokemonTransformer.toModel(new PokemonDatabaseEntity(0, "Duy")));
      result.add(pokemonTransformer.toModel(new PokemonDatabaseEntity(1, "Stefan")));
      result.add(pokemonTransformer.toModel(new PokemonDatabaseEntity(2, "Fabian from DB")));

      Timber.d("Loaded from database");
      subscriber.onSuccess(result);
    });
  }

  @Override public Single<Pokemon> getPokemon(int pokemonId) {
    return getAllPokemon(0).flatMapObservable(Observable::fromIterable)
        .filter(pokemon -> pokemon.id == pokemonId)
        .firstOrError();
  }
}
