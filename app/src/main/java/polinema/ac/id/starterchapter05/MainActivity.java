package polinema.ac.id.starterchapter05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.fragments.dipsFragment;
import polinema.ac.id.starterchapter05.fragments.handstandFragment;
import polinema.ac.id.starterchapter05.fragments.pushupFragment;

public class MainActivity extends AppCompatActivity {
    Integer active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        active = 1;
        fragmentChange(new pushupFragment(),4);
    }

    public void pushupButton(View view) {
        fragmentChange(new pushupFragment(),1);
    }

    public  void fragmentChange(Fragment fragment, int status){
        if(active != status) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.frameChange, fragment, status+"");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            active = status;
        }
    }

    public void pushupsButton(View view) {
        fragmentChange(new pushupFragment(),1);
    }

    public void dipsButton(View view) {
        fragmentChange(new dipsFragment(),2);
    }

    public void handButton(View view) {
        fragmentChange(new handstandFragment(),3);
    }
}