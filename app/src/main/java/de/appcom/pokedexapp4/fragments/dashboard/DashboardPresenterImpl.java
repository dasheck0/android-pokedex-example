package de.appcom.pokedexapp4.fragments.dashboard;

import de.appcom.model.models.Pokemon;
import de.appcom.pokedexapp4.fragments.base.BasePresenterImpl;
import de.appcom.pokedexapp4.fragments.dashboard.interactors.LoadInitialDataInteractor;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * @author Stefan Neidig
 */

public class DashboardPresenterImpl extends BasePresenterImpl implements DashboardPresenter {

  @Inject DashboardView view;

  @Inject LoadInitialDataInteractor loadInitialDataInteractor;

  @Override public void onResume() {
    super.onResume();
    loadInitialData();
  }

  @Override public void onPause() {
    super.onPause();
  }

  private void loadInitialData() {
    loadInitialDataInteractor.execute(2).subscribe(pokemon -> view.showPokemonData(pokemon));
  }
}
