package de.appcom.pokedexapp4.fragments.dashboard;

import android.widget.TextView;
import butterknife.BindView;
import de.appcom.pokedexapp4.R;
import de.appcom.pokedexapp4.annotations.Layout;
import de.appcom.pokedexapp4.annotations.Title;
import de.appcom.pokedexapp4.fragments.base.BaseFragment;
import de.appcom.pokedexapp4.fragments.base.BasePresenter;
import javax.inject.Inject;

/**
 * @author Stefan Neidig
 */

@Layout(R.layout.fragment_dashboard) @Title(R.string.app_name) public class DashboardFragment extends BaseFragment
    implements DashboardView {

  @Inject DashboardPresenter presenter;

  @BindView(R.id.textView2) TextView textview2;

  @Override protected void initializeViews() {
    textview2.setText("x is the dashboar but changed");
  }

  @Override protected BasePresenter providePresenter() {
    return null;
  }
}
