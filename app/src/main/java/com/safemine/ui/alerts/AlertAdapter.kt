package com.safemine.ui.alerts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safemine.data.model.Alert
import com.safemine.data.model.AlertSeverity
import com.safemine.databinding.ItemAlertBinding

class AlertAdapter :
    ListAdapter<Alert, AlertAdapter.AlertViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Alert>() {
        override fun areItemsTheSame(oldItem: Alert, newItem: Alert) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Alert, newItem: Alert) = oldItem == newItem
    }

    inner class AlertViewHolder(private val binding: ItemAlertBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(alert: Alert) {
            binding.tvTitulo.text = alert.titulo
            binding.tvMensaje.text = alert.mensaje
            binding.tvTiempo.text = alert.tiempo
            binding.tvUbicacion.text = alert.ubicacion
            binding.tvEstado.text = alert.estado

            binding.chipSeveridad.text = when (alert.severidad) {
                AlertSeverity.CRITICA -> "CRÍTICA"
                AlertSeverity.ALTA -> "ALTA"
                AlertSeverity.MEDIA -> "MEDIA"
                AlertSeverity.BAJA -> "BAJA"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val binding = ItemAlertBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AlertViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
