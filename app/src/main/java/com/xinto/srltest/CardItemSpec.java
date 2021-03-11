package com.xinto.srltest;

import android.graphics.Color;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Card;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
class CardItemSpec {

    @OnCreateLayout
    static Component OnCreateLayout(ComponentContext c) {
        return Card
            .create(c)
            .marginDip(YogaEdge.ALL, 16F)
            .cardBackgroundColor(Color.GRAY)
            .cornerRadiusDip(16F)
            .content(
                Column
                    .create(c)
                    .heightDip(160f)
                    .build()
            )
            .build();
    }

}

