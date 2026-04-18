package com.sunlife.clienttactics.data

import com.google.gson.annotations.SerializedName

data class RejectionRoot(
    @SerializedName("rejection_reasons")
    val rejectionReasons: List<RejectionCategory>
)

data class RejectionCategory(
    @SerializedName("category")
    val category: String,
    @SerializedName("reasons")
    val reasons: List<String>? = null,
    @SerializedName("items")
    val items: List<RejectionItem>? = null
)

data class RejectionItem(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("suggestions")
    val suggestions: List<String>? = null
)

data class SuggestionRoot(
    @SerializedName("rejection_reasons")
    val rejectionReasons: List<CategorySuggestion>,
    @SerializedName("core_root_causes")
    val coreRootCauses: List<CauseSuggestion>? = null
)

data class CategorySuggestion(
    @SerializedName("category")
    val category: String,
    @SerializedName("items")
    val items: List<ReasonSuggestion>
)

data class ReasonSuggestion(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("suggestions")
    val suggestions: List<String>
)

data class CauseSuggestion(
    val cause: String,
    val suggestions: List<String>
)