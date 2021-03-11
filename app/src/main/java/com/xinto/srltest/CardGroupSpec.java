package com.xinto.srltest;

import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

@GroupSectionSpec
class CardGroupSpec {

    @OnCreateChildren
    static Children OnCreateChildren(SectionContext c) {
        Children.Builder builder = Children.create();

        for (int i = 0; i < 8; i++) {
            CardItem.Builder cardItem = CardItem.create(c);

            //The problematic place
            if (i == 0) {
                cardItem.heightDip(1f); //Changing this to 0f completely breaks pull-down-to-refresh feature
            }

            builder.child(
                SingleComponentSection
                    .create(c)
                    .component(cardItem.build())
            );
        }
        return builder.build();
    }


}

