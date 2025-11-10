package com.safemine.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.safemine.data.repository.FakeRepository
import com.safemine.databinding.FragmentDashboardBinding
import com.safemine.ui.alerts.AlertAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by viewModels {
        DashboardViewModel.Factory(FakeRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AlertAdapter()
        binding.rvActiveAlerts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActiveAlerts.adapter = adapter

        viewModel.activeAlerts.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        // Zona actual mockeada por ahora
        binding.tvZonaActual.text = "Túnel 7 - Zona B"
        binding.tvConexionEstado.text = "Conexión en tiempo real"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
