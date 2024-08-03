package com.example.pruebatcnica_lvlconsulting.domain.usecase

import com.example.pruebatcnica_lvlconsulting.data.model.Place
import com.example.pruebatcnica_lvlconsulting.domain.repository.PlaceRepository
import javax.inject.Inject
import com.example.pruebatcnica_lvlconsulting.util.Result

class GetPlacesUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
){
    suspend operator fun invoke(): Result<List<Place>> {
        return placeRepository.getPlaces()
    }
}
