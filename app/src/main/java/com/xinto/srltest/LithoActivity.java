package com.xinto.srltest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.yoga.YogaEdge;

public class LithoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentContext componentContext = new ComponentContext(this);

        RecyclerCollectionComponent recycler = RecyclerCollectionComponent
            .create(componentContext)
            .marginDip(YogaEdge.ALL, 16F)
            .section(CardGroup.create(new SectionContext(componentContext)).build())
            .build();

        setContentView(LithoView.create(this, recycler));
    }

}