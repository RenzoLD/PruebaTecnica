package com.example.pruebatcnica_lvlconsulting.mapper

import com.example.pruebatcnica_lvlconsulting.data.model.Place
import com.example.pruebatcnica_lvlconsulting.data.model.PlaceResult

//con esta funcion obtengo la url de la imagen de la api de google
fun getPhotoUrl(photoReference: String, apiKey: String, maxWidth: Int = 400): String {
    return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=$maxWidth&photoreference=$photoReference&key=$apiKey"
}

fun PlaceResult.toPlace(apiKey: String): Place {
    val fotoReference = this.photos?.firstOrNull()?.photo_reference ?: ""
    return Place(
        id = this.place_id,
        title = this.name,
        description = this.vicinity ?: "No description available",
        imageUrl = getPhotoUrl(fotoReference, apiKey)
    )
}

fun List<PlaceResult>.toPlacesConverter(apiKey: String): List<Place> {
    return this.map { it.toPlace(apiKey) }
}