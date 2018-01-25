package com.example.hdahagam.app10;

import android.os.Build;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;

/**
 * Created by hdahagam on 11/16/2017.
 */

public class DetailsTransition extends android.transition.TransitionSet {
    public DetailsTransition() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new android.transition.ChangeBounds())
                .addTransition(new ChangeTransform())
                .addTransition(new ChangeImageTransform());
    }
}
