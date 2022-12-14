package com.code.musicsearch

import com.squareup.moshi.Json

data class SongData(

	@Json(name="resultCount")
	val resultCount: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@Json(name="artworkUrl100")
	val artworkUrl100: String? = null,

	@Json(name="trackHdRentalPrice")
	val trackHdRentalPrice: Double? = null,

	@Json(name="country")
	val country: String? = null,

	@Json(name="collectionHdPrice")
	val collectionHdPrice: Double? = null,

	@Json(name="trackName")
	val trackName: String? = null,

	@Json(name="artworkUrl600")
	val artworkUrl600: String? = null,

	@Json(name="collectionName")
	val collectionName: String? = null,

	@Json(name="trackCount")
	val trackCount: Int? = null,

	@Json(name="genres")
	val genres: List<String?>? = null,

	@Json(name="artworkUrl30")
	val artworkUrl30: String? = null,

	@Json(name="wrapperType")
	val wrapperType: String? = null,

	@Json(name="currency")
	val currency: String? = null,

	@Json(name="collectionId")
	val collectionId: Int? = null,

	@Json(name="trackExplicitness")
	val trackExplicitness: String? = null,

	@Json(name="feedUrl")
	val feedUrl: String? = null,

	@Json(name="collectionViewUrl")
	val collectionViewUrl: String? = null,

	@Json(name="trackHdPrice")
	val trackHdPrice: Double? = null,

	@Json(name="contentAdvisoryRating")
	val contentAdvisoryRating: String? = null,

	@Json(name="releaseDate")
	val releaseDate: String? = null,

	@Json(name="kind")
	val kind: String? = null,

	@Json(name="trackId")
	val trackId: Int? = null,

	@Json(name="trackRentalPrice")
	val trackRentalPrice: Double? = null,

	@Json(name="collectionPrice")
	val collectionPrice: Double? = null,

	@Json(name="genreIds")
	val genreIds: List<String?>? = null,

	@Json(name="primaryGenreName")
	val primaryGenreName: String? = null,

	@Json(name="trackPrice")
	val trackPrice: Double? = null,

	@Json(name="collectionExplicitness")
	val collectionExplicitness: String? = null,

	@Json(name="trackViewUrl")
	val trackViewUrl: String? = null,

	@Json(name="artworkUrl60")
	val artworkUrl60: String? = null,

	@Json(name="trackCensoredName")
	val trackCensoredName: String? = null,

	@Json(name="artistName")
	val artistName: String? = null,

	@Json(name="collectionCensoredName")
	val collectionCensoredName: String? = null,

	@Json(name="trackTimeMillis")
	val trackTimeMillis: Int? = null,

	@Json(name="previewUrl")
	val previewUrl: String? = null,

	@Json(name="artistId")
	val artistId: Int? = null,

	@Json(name="artistViewUrl")
	val artistViewUrl: String? = null,

	@Json(name="discNumber")
	val discNumber: Int? = null,

	@Json(name="isStreamable")
	val isStreamable: Boolean? = null,

	@Json(name="trackNumber")
	val trackNumber: Int? = null,

	@Json(name="discCount")
	val discCount: Int? = null,

	@Json(name="collectionArtistName")
	val collectionArtistName: String? = null,

	@Json(name="collectionArtistId")
	val collectionArtistId: Int? = null,

	@Json(name="longDescription")
	val longDescription: String? = null,

	@Json(name="shortDescription")
	val shortDescription: String? = null
)
