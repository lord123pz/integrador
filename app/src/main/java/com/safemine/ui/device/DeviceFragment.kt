package com.safemine.ui.device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.safemine.data.repository.FakeRepository
import com.safemine.databinding.FragmentDeviceBinding

class DeviceFragment : Fragment() {

    private var _binding: FragmentDeviceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DeviceViewModel by viewModels {
        DeviceViewModel.Factory(FakeRepository())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDeviceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = SensorAdapter()
        binding.rvSensores.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvSensores.adapter = adapter

        viewModel.device.observe(viewLifecycleOwner) { device ->
            binding.tvNombreOperador.text = viewModel.user.value?.let { "${it.nombre} ${it.apellido}" }
            binding.tvRol.text = viewModel.user.value?.cargo
            binding.tvUbicacionDispositivo.text = device.ubicacion
            binding.tvIdDispositivo.text = "Dispositivo: ${device.id}"
            binding.progressBateria.progress = device.bateria
        }

        viewModel.sensors.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
