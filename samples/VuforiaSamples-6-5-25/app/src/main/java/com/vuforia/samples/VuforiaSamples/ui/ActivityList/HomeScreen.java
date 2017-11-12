package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.UserDefinedTargets.UserDefinedTargets;

/**
 * Created by sameer on 12/11/2017.
 */

public class HomeScreen extends Activity {

Button viewButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewButton = (Button)findViewById(R.id.viewPostButton);
        viewButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                startActivity(new Intent(v.getContext(),UserDefinedTargets.class));
            }
        });


    }




}
