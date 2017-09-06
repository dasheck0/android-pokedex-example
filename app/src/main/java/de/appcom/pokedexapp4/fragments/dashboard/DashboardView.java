package de.appcom.pokedexapp4.fragments.dashboard;

import de.appcom.model.models.Pokemon;
import de.appcom.pokedexapp4.fragments.base.BaseView;

/**
 * @author Stefan Neidig
 */

public interface DashboardView extends BaseView {

  void showPokemonData(Pokemon pokemon);
}
