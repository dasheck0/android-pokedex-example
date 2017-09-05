package de.appcom.pokedexapp4.di;

import android.content.Context;
import dagger.Component;
import de.appcom.pokedexapp4.activities.BaseActivity;
import de.appcom.pokedexapp4.annotations.PerActivity;

/**
 * @author Stefan Neidig
 */

@PerActivity @Component(modules = { ActivityModule.class }, dependencies = { ApplicationComponent.class })
public interface ActivityComponent {

  BaseActivity baseActivity();

  Context context();
}
