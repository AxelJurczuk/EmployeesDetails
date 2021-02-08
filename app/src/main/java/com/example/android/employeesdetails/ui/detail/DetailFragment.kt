package com.example.android.employeesdetails.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.employeesdetails.R
import com.example.android.employeesdetails.databinding.FragmentDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetailFragment : Fragment(), OnMapReadyCallback {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var map:GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val employee = args.employee
        binding.tvWebsite.text = employee.website
        createMap()
    }

    private fun createMap (){
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(p0: GoogleMap?) {
            if (p0 != null) {
                map = p0
                createMarker()
            }
    }

    private fun createMarker() {

        val lat = args.employee.address.geo.lat
        val long = args.employee.address.geo.long
        val name = args.employee.name
        val marker = LatLng(lat, long)
        map.addMarker(MarkerOptions().position(marker).title(name))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(marker, 10f),
            400,
            null
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}