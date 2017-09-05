package de.appcom.pokedexapp4.fragments.dashboard;

import dagger.Module;
import dagger.Provides;
import de.appcom.pokedexapp4.annotations.PerFragment;

/**
 * @author Stefan Neidig
 */

@Module public class DashboardModule {

  private DashboardView view;
  private DashboardPresenter presenter;

  public DashboardModule(DashboardView view, DashboardPresenter presenter) {
    this.view = view;
    this.presenter = presenter;
  }

  @PerFragment @Provides public DashboardView provideView() {
    return view;
  }

  @PerFragment @Provides public DashboardPresenter providePresenter() {
    return presenter;
  }
}
