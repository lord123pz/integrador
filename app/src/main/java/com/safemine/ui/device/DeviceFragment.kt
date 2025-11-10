package com.safemine.ui.device

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * Shows the status of connected safety devices.
 */
class DeviceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TextView(inflater.context).apply {
            text = "Device list will appear here"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }
    }
}
