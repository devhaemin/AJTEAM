package com.ajstudy.nbrg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class AreaSelectionActivity extends AppCompatActivity {

    String[] areas = {"서대문구", "동작구", "노원구", "중구", "난방", "정해민", "송하예", "니 소식"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_selection);
        LinearLayout tableLayout = findViewById(R.id.selection_area_table);
        LinearLayout row1 = findViewById(R.id.tab1);
        LinearLayout row2 = findViewById(R.id.tab2);
        LinearLayout row3 = findViewById(R.id.tab3);

        for (int i = 0; i < areas.length; i++) {

            LayoutInflater li = getLayoutInflater();
            ToggleButton button = (ToggleButton) li.inflate(R.layout.btn_selection, tableLayout, false);
            button.setText(areas[i]);
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        buttonView.setTextColor(getColor(getApplicationContext(),R.color.colorAccent));
                    }else{
                        buttonView.setTextColor(getColor(getApplicationContext(),R.color.black));
                    }
                }
            });

            switch (i % 3) {
                case 0:
                    row1.addView(button);
                    break;
                case 1:
                    row2.addView(button);
                    break;
                case 2:
                    row3.addView(button);
                    break;
            }
        }

    }
    public static final int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return context.getResources().getColor(id,null);
        } else {
            return context.getResources().getColor(id);
        }
    }
}
