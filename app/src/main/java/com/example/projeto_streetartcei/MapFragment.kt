// MapFragment.kt

package com.example.projeto_streetartcei

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projeto_streetartcei.R
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapFragment : Fragment() {

    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_map, container, false)

        Configuration.getInstance().load(context,
            context?.let { androidx.preference.PreferenceManager.getDefaultSharedPreferences(it) })

        mapView = rootView.findViewById(R.id.mapView)
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)

        // Define as coordenadas do ponto inicial
        val initialPosition = GeoPoint(41.19043110854155, -8.598065374103918)

        // Adiciona um marcador nas coordenadas especificadas
        val marker = Marker(mapView)
        marker.position = initialPosition
        marker.title = "ISCAP"
        marker.snippet = "Instituto Superior de Contabilidade e Administração do Porto"
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(marker)

        // Move a câmera para as coordenadas iniciais
        mapView.controller.setCenter(initialPosition)
        mapView.controller.setZoom(16.0)

        return rootView
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}
