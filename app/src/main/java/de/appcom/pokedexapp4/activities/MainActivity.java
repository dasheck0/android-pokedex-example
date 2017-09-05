package de.appcom.pokedexapp4.activities;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import de.appcom.pokedexapp4.R;
import de.appcom.pokedexapp4.annotations.Layout;
import org.w3c.dom.Text;
import timber.log.Timber;

@Layout(R.layout.activity_main) public class MainActivity extends BaseActivity {

  @BindView(R.id.textView) TextView textview;

  @OnClick(R.id.textView) public void onTextViewClicked(View view) {
    ((TextView) view).setText("Oy you clicked me");
  }
}
