package com.example.whereis.model

import com.google.gson.annotations.SerializedName

data class CompanyList(
    @SerializedName("Company")
    val companies: List<Company>
)

data class Company(
    val Code: String,
    val Name: String
)