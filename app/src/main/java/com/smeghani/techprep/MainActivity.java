package com.smeghani.techprep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smeghani.techprep.algorithm.search.BinarySearch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BinarySearch.binarySearch(null,null,0,0);
    }
}
