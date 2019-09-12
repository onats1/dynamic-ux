package com.example.transitionsanddynamicui.ui.secondActivity.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.app.SharedElementCallback
import androidx.core.util.Pair
import androidx.navigation.Navigation
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.example.transitionsanddynamicui.ConstantTags.IMAGE_TAG
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.thirdActivity.GridToPager
import com.example.transitionsanddynamicui.utils.uiElements.ChangeColor
import kotlinx.android.synthetic.main.custom_scene1.*
import kotlinx.android.synthetic.main.fragment_custom_transition.*
import kotlinx.android.synthetic.main.fragment_custom_transition.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CustomTransition.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CustomTransition.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomTransition : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var colorTransition: Transition? = null
    private var scenes: MutableList<Scene>? = null

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
        return inflater.inflate(R.layout.fragment_custom_transition, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(view: View) {
        listener?.onFragmentInteraction(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorTransition = ChangeColor()

        scenes = mutableListOf(Scene.getSceneForLayout(scene_root, R.layout.custom_scene1, view.context),
                                Scene.getSceneForLayout(scene_root, R.layout.custom_scene2, view.context),
                                Scene.getSceneForLayout(scene_root, R.layout.custom_scene3, view.context))

        toggle_positions.setOnClickListener{onClick()}

        previous_fragment.setOnClickListener{Navigation.createNavigateOnClickListener(R.id.next_action)}

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next_fragment.setOnClickListener{
            activity?.let {
                val intent = Intent(activity, GridToPager::class.java)
                startActivity(intent)
            }

        }
    }
    var position = 0

    fun onClick(){

        position++
        if(position < scenes!!.size){

            TransitionManager.go(scenes!![position], colorTransition)

        }else{
            position = 0
            TransitionManager.go(scenes!![position], colorTransition)
        }


    }
    var superContext: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/


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
         * @return A new instance of fragment CustomTransition.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomTransition().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
