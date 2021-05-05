package com.xinto.srltest;

import com.facebook.litho.Component;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.widget.EmptyComponent;
import com.facebook.litho.widget.Text;

@GroupSectionSpec
class CardGroupSpec {

    @OnCreateChildren
    static Children OnCreateChildren(SectionContext c) {
        Children.Builder builder = Children.create();
        EmptyComponent.Builder emptyComponent = EmptyComponent.create(c); // Causes bug even without specifying height attribute
        CardItem.Builder cardComponent = CardItem.create(c);
        Text.Builder text = Text.create(c)
            .text("")
            .heightDip(1f);

        Component currentComponent;

        for (int i = 0; i < 8; i++) {
            currentComponent = cardComponent.build();

            //The problematic place
            if (i == 0) {
                currentComponent = text.build();
            }

            builder.child(
                SingleComponentSection
                    .create(c)
                    .component(currentComponent)
            );


        }
        return builder.build();
    }


}

