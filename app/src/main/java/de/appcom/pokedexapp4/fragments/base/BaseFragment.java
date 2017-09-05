package de.appcom.pokedexapp4.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.appcom.pokedexapp4.activities.BaseActivity;
import de.appcom.pokedexapp4.annotations.Layout;
import de.appcom.pokedexapp4.annotations.Title;
import java.lang.annotation.Annotation;

/**
 * @author Stefan Neidig
 */
public abstract class BaseFragment extends Fragment {

  Unbinder unbinder;
  BasePresenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.presenter = providePresenter();

    if (presenter != null) {
      presenter.onCreate();
    }
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(getLayoutResId(), null);
    unbinder = ButterKnife.bind(this, rootView);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    initializeViews();
    ((BaseActivity) getActivity()).setTitle(getTitleFromAnnotation());

    if (presenter != null) {
      presenter.onResume();
    }
  }

  @Override public void onPause() {
    super.onPause();
    if (presenter != null) {
      presenter.onPause();
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }

  abstract protected void initializeViews();

  abstract protected BasePresenter providePresenter(); // TODO kill me

  private String getTitleFromAnnotation() {
    Annotation annotation = getClass().getAnnotation(Title.class);
    if (annotation != null) {
      int stringResId = ((Title) annotation).value();
      return getString(stringResId);
    }

    return "";
  }

  private int getLayoutResId() {
    Annotation annotation = getClass().getAnnotation(Layout.class);
    if (annotation != null) {
      return ((Layout) annotation).value();
    } else {
      throw new IllegalStateException("You must provide a layout annotation");
    }
  }
}