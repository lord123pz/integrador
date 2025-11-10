package com.safemine.ui.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

/**
 * Hosts the primary navigation graph for the SafeMine application.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FrameLayout(this).apply {
            id = ViewCompat.generateViewId()
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            contentDescription = "SafeMine navigation host"
        }

        setContentView(container)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(container.id, PlaceholderFragment())
                .commitNow()
        }
    }

    /**
     * Placeholder fragment until the navigation graph wiring is completed.
     */
    class PlaceholderFragment : androidx.fragment.app.Fragment() {
        override fun onCreateView(
            inflater: android.view.LayoutInflater,
            container: android.view.ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return FrameLayout(inflater.context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                setBackgroundResource(android.R.color.white)
            }
        }
    }
}
