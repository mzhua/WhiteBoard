package im.hua.whiteboard;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import im.hua.whiteboard.beautifulofbezier.BezierEvaluatorActivity;
import im.hua.whiteboard.beautifulofbezier.BezierViewActivity;
import im.hua.whiteboard.beautifulofbezier.DropPagerIndicatorActivity;
import im.hua.whiteboard.databinding.ActivityMainBinding;
import im.hua.whiteboard.library.WhiteBoardActivity;

public class MainActivity extends AppCompatActivity {

    @butterknife.Bind(R.id.fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);

        butterknife.ButterKnife.bind(this);

    }

    public void clickBezierIndicator(View view) {
        startActivity(new Intent(this, DropPagerIndicatorActivity.class));
    }

    public void clickBezierView(View view) {
        startActivity(new Intent(this, BezierViewActivity.class));
    }

    public void clickBezierAnimation(View view) {
        startActivity(new Intent(this, BezierEvaluatorActivity.class));
    }

    public void clickWhiteBoard(View view) {
        startActivity(new Intent(this, WhiteBoardActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
