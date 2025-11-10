package com.safemine.ui.alerts

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * Lists ongoing alerts that require operator action.
 */
class AlertsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TextView(inflater.context).apply {
            text = "No alerts to display"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }
    }
}
