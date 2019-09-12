package com.example.transitionsanddynamicui.ui.secondActivity.fragments

import android.content.Context
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.createNavigateOnClickListener
import com.example.transitionsanddynamicui.R
import kotlinx.android.synthetic.main.fragment_basic_transition.*
import kotlinx.android.synthetic.main.fragment_basic_transition.view.*
import kotlinx.android.synthetic.main.scene3.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BasicTransition.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BasicTransition.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasicTransition : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private var scene1: Scene? = null
    private var scene2: Scene? = null
    private var scene3: Scene? = null

    private var scene3CustomTransition: TransitionManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_transition, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, activity)
        scene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, activity)
        scene3 = Scene.getSceneForLayout(scene_root, R.layout.scene3, activity)

        scene3CustomTransition = TransitionInflater.from(activity).inflateTransitionManager(R.transition.scene_transition, scene_root)

        toggle_positions?.setOnClickListener {onToggleClick()}

        view.next_fragment.setOnClickListener(createNavigateOnClickListener(R.id.next_action))

        /*next_fragment?.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.next_action)
        }
*/

    }


    var currentPosition = 0
    fun onToggleClick(){


        when(currentPosition){

            0 -> {TransitionManager.go(scene2)
                currentPosition+=1}

            1 -> {scene3CustomTransition!!.transitionTo(scene3)
                currentPosition+=1}

            2 -> {// Alternatively, transition can be invoked dynamically without a Scene.
                // For this, we first call TransitionManager.beginDelayedTransition().
                TransitionManager.beginDelayedTransition(scene_root)
                // Then, we can just change view properties as usual.

                val params = transition_square.layoutParams
                val newSize = resources.getDimensionPixelSize(R.dimen.square_size_expanded)
                params.width = newSize
                params.height = newSize
                transition_square.layoutParams = params
                // END_INCLUDE(transition_dynamic)
                currentPosition+=1
            }

            3 -> { TransitionManager.go(scene1)
                    currentPosition = 0
               }
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onViewReady(view: View) {
        listener?.onFragmentInteraction(view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener") as Throwable
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(view: View)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BasicTransition.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BasicTransition().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
