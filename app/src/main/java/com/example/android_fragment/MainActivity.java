package com.example.android_fragment;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {


    private Fragment fragment;
    Button replaceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          fragment = new FirstFragment();
          loadFragment(fragment);
          replaceButton = findViewById(R.id.replace_button);
             replaceButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(fragment instanceof SecondFragment){
                         fragment =new SecondFragment();
                         loadFragment(fragment);
                     }else if(fragment instanceof SecondFragment){
                         fragment = new FirstFragment();
                         loadFragment(fragment);
                     }
                 }
             });
    }
private void loadFragment(Fragment fragment){



    FragmentManager fm =getSupportFragmentManager();



    fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();

}
}
