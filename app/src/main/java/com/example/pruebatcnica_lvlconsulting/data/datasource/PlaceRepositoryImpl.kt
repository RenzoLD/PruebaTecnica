package com.example.pruebatcnica_lvlconsulting.data.datasource


import com.example.pruebatcnica_lvlconsulting.data.ApiService
import com.example.pruebatcnica_lvlconsulting.data.model.Place
import com.example.pruebatcnica_lvlconsulting.domain.repository.PlaceRepository
import com.example.pruebatcnica_lvlconsulting.mapper.toPlacesConverter
import com.example.pruebatcnica_lvlconsulting.util.Constants
import javax.inject.Inject
import com.example.pruebatcnica_lvlconsulting.util.Result

class PlaceRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val apikey: String
) : PlaceRepository {

    override suspend fun getPlaces(): Result<List<Place>> {

        return try {
            val response = apiService.getNearbyPlaces(
                Constants.LOCATION_LIMA,
                Constants.RADIUS,
                Constants.TOURIST_PLACE,
                apikey
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.Success(it.results.toPlacesConverter(apikey))
                } ?: Result.Error(Exception("No data available"))
            } else {
                Result.Error(Exception("Error fetching nearby places: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
