package com.example.tvmazeproject.api.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseShow(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("image")
	val image: Image,

	@field:SerializedName("averageRuntime")
	val averageRuntime: Int,

	@field:SerializedName("dvdCountry")
	val dvdCountry: String,

	@field:SerializedName("_links")
	val links: Links,

	@field:SerializedName("premiered")
	val premiered: String,

	@field:SerializedName("rating")
	val rating: Rating,

	@field:SerializedName("runtime")
	val runtime: Int,

	@field:SerializedName("weight")
	val weight: Int,

	@field:SerializedName("language")
	val language: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("officialSite")
	val officialSite: String,

	@field:SerializedName("network")
	val network: Network,

	@field:SerializedName("schedule")
	val schedule: Schedule,

	@field:SerializedName("webChannel")
	val webChannel: String,

	@field:SerializedName("genres")
	val genres: List<String>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("ended")
	val ended: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("externals")
	val externals: Externals,

	@field:SerializedName("updated")
	val updated: Int,

	@field:SerializedName("status")
	val status: String
) : Parcelable

@Parcelize
data class Schedule(

	@field:SerializedName("days")
	val days: List<String>,

	@field:SerializedName("time")
	val time: String
) : Parcelable

@Parcelize
data class Image(

	@field:SerializedName("original")
	val original: String,

	@field:SerializedName("medium")
	val medium: String
) : Parcelable

@Parcelize
data class Rating(

	@field:SerializedName("average")
	val average: String
) : Parcelable

@Parcelize
data class Network(

	@field:SerializedName("country")
	val country: Country,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("officialSite")
	val officialSite: String
) : Parcelable

@Parcelize
data class Country(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("timezone")
	val timezone: String,

	@field:SerializedName("name")
	val name: String
) : Parcelable

@Parcelize
data class Links(

	@field:SerializedName("self")
	val self: Self,

	@field:SerializedName("previousepisode")
	val previousepisode: Previousepisode
) : Parcelable

@Parcelize
data class Externals(

	@field:SerializedName("thetvdb")
	val thetvdb: Int,

	@field:SerializedName("imdb")
	val imdb: String,

	@field:SerializedName("tvrage")
	val tvrage: Int
) : Parcelable

@Parcelize
data class Previousepisode(

	@field:SerializedName("href")
	val href: String
) : Parcelable

@Parcelize
data class Self(

	@field:SerializedName("href")
	val href: String
) : Parcelable
