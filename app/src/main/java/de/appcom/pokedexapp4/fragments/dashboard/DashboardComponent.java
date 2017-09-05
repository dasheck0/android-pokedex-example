package de.appcom.pokedexapp4.fragments.dashboard;

import dagger.Component;
import de.appcom.pokedexapp4.annotations.PerFragment;
import de.appcom.pokedexapp4.di.ActivityComponent;
import de.appcom.pokedexapp4.di.ActivityModule;

/**
 * @author Stefan Neidig
 */

@PerFragment @Component(modules = { DashboardModule.class }, dependencies = { ActivityComponent.class })
public interface DashboardComponent {

  void inject(DashboardFragment fragment);

  void inject(DashboardPresenterImpl presenter);
}
