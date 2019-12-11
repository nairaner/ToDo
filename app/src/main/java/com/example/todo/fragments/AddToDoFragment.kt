package com.example.todo.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddToDoFragment : Fragment() {

    lateinit var button : FloatingActionButton
    private lateinit var listener: AddToDoListener

    interface AddToDoListener {
        fun onInputToDoSent() : Unit
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.add_todo_fragment, container, false)
        button = v.findViewById(R.id.floatingActionButton)
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View) {
                listener.onInputToDoSent()
            }
        })
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AddToDoListener)
        {
            listener = context as AddToDoListener
        }
        else
        {
            throw RuntimeException((context.toString() + " must implement AddToDoListener"))
        }
    }
    override fun onDetach() {
        super.onDetach()
    }
}