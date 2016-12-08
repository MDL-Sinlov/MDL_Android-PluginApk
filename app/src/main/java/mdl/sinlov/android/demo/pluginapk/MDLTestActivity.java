package mdl.sinlov.android.demo.pluginapk;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by "sinlov" on 16/6/30.
 */
public abstract class MDLTestActivity extends AppCompatActivity {

    private long testTimeUse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bindView(savedInstanceState);
    }
    protected abstract void bindView(Bundle savedInstanceState);

    protected abstract void bindListener();

    /**
     * @param id   widget id
     * @param <VT> View
     * @return extends {@link View}
     */
    @SuppressWarnings("unchecked")
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }

    protected void showToast(String text) {
        Toast.makeText(this.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int id) {
        Toast.makeText(this.getApplicationContext(), id, Toast.LENGTH_SHORT).show();
    }

    protected void skip2Activity(Class<?> cls) {
        startActivity(new Intent(MDLTestActivity.this, cls));
    }

    protected void testTimeUseStart() {
        testTimeUse = System.currentTimeMillis();
    }

    protected long testTimeUseEnd() {
        long useTime = System.currentTimeMillis() - testTimeUse;
        Log.d("MDLTestActivity", "testTimeUse: " + useTime);
        return useTime;
    }
}
