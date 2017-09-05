package de.appcom.pokedexapp4.fragments.base;

import timber.log.Timber;

/**
 * @author Stefan Neidig
 */

public class BasePresenterImpl implements BasePresenter {

  @Override public void onCreate() {
    Timber.d("You called onCreate");
  }

  @Override public void onResume() {
    Timber.d("You called onResume");
  }

  @Override public void onPause() {
    Timber.d("You called onPause");
  }
}
