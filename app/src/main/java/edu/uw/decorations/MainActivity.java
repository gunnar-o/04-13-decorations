package edu.uw.decorations;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //show fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, WordListFragment.newInstance());
        ft.commit();
    }

    //toggles the action bar
    public void handleButton(View v) {
        ActionBar toolbar = getSupportActionBar();
        toolbar.hide();
        if (toolbar.isShowing()) {
            toolbar.hide();
        } else {
            toolbar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.helloMenuItem:
                // Clicked on first menu item

                new HelloDialogFragment().show(getSupportFragmentManager(), null);


                break;
            case R.id.helloMenuItem2:
                // Clicked on second
                Toast.makeText(this, "Ello I am long toast", Toast.LENGTH_LONG).show();
                break;
            case R.id.helloMenuItem3:
                // Clicked on third
                Toast.makeText(this, "Ello I am short toast", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    public static class HelloDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Hello!");
            builder.setMessage("Hello world! I am a dialog!");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.v(TAG, "You clicked Ok!");
                }
            });

            AlertDialog dialog = builder.create();
            return dialog;
        }
    }
}
