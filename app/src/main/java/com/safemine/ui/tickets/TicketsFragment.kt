package com.safemine.ui.tickets

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * Provides visibility into open maintenance or incident tickets.
 */
class TicketsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TextView(inflater.context).apply {
            text = "Tickets will be managed here"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }
    }
}
