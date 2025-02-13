package com.tattoshaman.catalog_api

import kotlinx.serialization.Serializable

@Serializable
data object CatalogDestination

@Serializable
data class CategoryDestination(val id: Int)