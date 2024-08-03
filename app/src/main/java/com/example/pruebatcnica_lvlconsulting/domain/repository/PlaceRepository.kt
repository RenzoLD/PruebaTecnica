package com.example.pruebatcnica_lvlconsulting.domain.repository

import com.example.pruebatcnica_lvlconsulting.data.model.Place
import com.example.pruebatcnica_lvlconsulting.util.Result

interface PlaceRepository {
    suspend fun getPlaces(): Result<List<Place>>
}
