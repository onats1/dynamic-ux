package com.example.transitionsanddynamicui.utils.uiElements

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionValues
import com.example.transitionsanddynamicui.ConstantTags.TRANS_VAL

class ChangeColor : Transition() {

    fun captureValues(value: TransitionValues){
        value.values.put(TRANS_VAL, value.view.background)
    }


    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {

        // Store the object containing the background property for both the starting and ending
        // layouts.
        val startBackground = startValues!!.values[TRANS_VAL] as Drawable
        val endBackground = endValues!!.values[TRANS_VAL] as Drawable
        // This transition changes background colors for a target. It doesn't animate any other
        // background changes. If the property isn't a ColorDrawable, ignore the target.
        if (startBackground is ColorDrawable && endBackground is ColorDrawable) {
            // If the background color for the target in the starting and ending layouts is
            // different, create an animation.
            if (startBackground.color != endBackground.color) {
                // Create a new Animator object to apply to the targets as the transitions framework
                // changes from the starting to the ending layout. Use the class ValueAnimator,
                // which provides a timing pulse to change property values provided to it. The
                // animation runs on the UI thread. The Evaluator controls what type of
                // interpolation is done. In this case, an ArgbEvaluator interpolates between two
                // #argb values, which are specified as the 2nd and 3rd input arguments.
                val animator = ValueAnimator.ofObject(
                    ArgbEvaluator(),
                    startBackground.color, endBackground.color
                )

                animator.duration = 2000

                // Add an update listener to the Animator object.
                animator.addUpdateListener { animation ->
                    val value = animation.animatedValue
                    // Each time the ValueAnimator produces a new frame in the animation, change
                    // the background color of the target. Ensure that the value isn't null.
                    if (null != value) {
                        endValues.view.setBackgroundColor(value as Int)
                    }
                }
                // Return the Animator object to the transitions framework. As the framework changes
                // between the starting and ending layouts, it applies the animation you've created.
                return animator
            }

        }

        return null
    }
}