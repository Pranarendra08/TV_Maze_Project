package com.example.tvmazeproject.api.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseCast(

	@field:SerializedName("ResponseCast")
	val responseCast: List<ResponseCastItem>
) : Parcelable


@Parcelize
data class Character(

	@field:SerializedName("image")
	val image: Image,

	@field:SerializedName("_links")
	val links: Links,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("url")
	val url: String
) : Parcelable

@Parcelize
data class ResponseCastItem(

	@field:SerializedName("voice")
	val voice: Boolean,

	@field:SerializedName("character")
	val character: Character,

	@field:SerializedName("person")
	val person: Person,

	@field:SerializedName("self")
	val self: Boolean
) : Parcelable

@Parcelize
data class Person(

	@field:SerializedName("birthday")
	val birthday: String,

	@field:SerializedName("country")
	val country: Country,

	@field:SerializedName("image")
	val image: Image,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("_links")
	val links: Links,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deathday")
	val deathday: String,

	@field:SerializedName("updated")
	val updated: Int,

	@field:SerializedName("url")
	val url: String
) : Parcelable

