package com.xinto.srltest;

import com.facebook.litho.Component;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.widget.EmptyComponent;

@GroupSectionSpec
class CardGroupSpec {

    @OnCreateChildren
    static Children OnCreateChildren(SectionContext c) {
        Children.Builder builder = Children.create();

        for (int i = 0; i < 8; i++) {
            Component component = CardItem.create(c).build();;

            //Uncomment this line to reproduce the bug
            if (i == 0) {
                component = EmptyComponent.create(c).build(); //Also works with Text.create(c).heightDip(0f).build();
            }

            builder.child(
                SingleComponentSection
                    .create(c)
                    .component(component)
            );
        }
        return builder.build();
    }
}