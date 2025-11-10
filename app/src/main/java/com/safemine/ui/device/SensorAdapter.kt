package com.safemine.ui.device

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safemine.data.model.SensorReading
import com.safemine.databinding.ItemSensorBinding

class SensorAdapter : ListAdapter<SensorReading, SensorAdapter.SensorViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<SensorReading>() {
        override fun areItemsTheSame(oldItem: SensorReading, newItem: SensorReading): Boolean =
            oldItem.nombre == newItem.nombre

        override fun areContentsTheSame(oldItem: SensorReading, newItem: SensorReading): Boolean =
            oldItem == newItem
    }

    inner class SensorViewHolder(private val binding: ItemSensorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sensor: SensorReading) {
            binding.tvNombreSensor.text = sensor.nombre
            binding.tvValorActual.text = "${sensor.valorActual} ${sensor.unidad}"
            binding.tvLimite.text = "Límite: ${sensor.limiteSeguro} ${sensor.unidad}"
            binding.tvEstadoSensor.text = sensor.estado
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val binding = ItemSensorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SensorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
