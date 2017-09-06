package de.appcom.pokedexapp4.fragments.dashboard;

import android.widget.TextView;
import butterknife.BindView;
import de.appcom.model.models.Pokemon;
import de.appcom.pokedexapp4.R;
import de.appcom.pokedexapp4.annotations.Layout;
import de.appcom.pokedexapp4.annotations.Title;
import de.appcom.pokedexapp4.fragments.base.BaseFragment;
import de.appcom.pokedexapp4.fragments.base.BasePresenter;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * @author Stefan Neidig
 */

@Layout(R.layout.fragment_dashboard) @Title(R.string.app_name) public class DashboardFragment extends BaseFragment
    implements DashboardView {

  @Inject DashboardPresenter presenter;

  @BindView(R.id.textView2) TextView textview2;

  @Override protected void initializeViews() {
  }

  @Override protected BasePresenter providePresenter() {
    return presenter;
  }

  @Override public void showPokemonData(Pokemon pokemon) {
    getActivity().runOnUiThread(() -> textview2.setText(pokemon.name));
  }
}
