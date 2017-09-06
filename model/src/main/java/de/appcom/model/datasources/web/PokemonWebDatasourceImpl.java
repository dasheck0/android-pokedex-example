package de.appcom.model.datasources.web;

import android.os.Handler;
import de.appcom.model.models.Pokemon;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * @author Stefan Neidig
 */

public class PokemonWebDatasourceImpl implements PokemonWebDatasource {

  @Inject public PokemonWebDatasourceImpl() {
  }

  @Override public Single<List<Pokemon>> getAllPokemon() {

    return Single.create(subscriber -> {
      List<Pokemon> result = new ArrayList<>();

      result.add(new Pokemon(0, "Duy"));
      result.add(new Pokemon(1, "Stefan"));
      result.add(new Pokemon(2, "Fabian from Web"));
      result.add(new Pokemon(3, "Gordon"));

      final Handler handler = new Handler();
      handler.postDelayed(() -> subscriber.onSuccess(result), 5000);
    });
  }

  @Override public Single<Pokemon> getPokemon(int pokemonId) {
    return getAllPokemon().flatMapObservable(Observable::fromIterable)
        .filter(pokemon -> pokemon.id == pokemonId)
        .firstOrError();
  }
}
