package com.sunlife.clienttactics.util

import android.content.Context
import com.google.gson.Gson
import com.sunlife.clienttactics.data.RejectionCategory
import com.sunlife.clienttactics.data.CategorySuggestion
import com.sunlife.clienttactics.data.SuggestionRoot

object RejectionDataLoader {
    private var suggestionData: SuggestionRoot? = null

    fun loadSuggestionData(context: Context): SuggestionRoot {
        return suggestionData ?: run {
            val jsonString = context.assets.open("suggestions_data.json").bufferedReader().use { it.readText() }
            suggestionData = Gson().fromJson(jsonString, SuggestionRoot::class.java)
            suggestionData!!
        }
    }

    fun getCategories(): List<String> {
        return suggestionData?.rejectionReasons?.map { it.category } ?: emptyList()
    }

    fun getReasonsForCategory(category: String): List<String> {
        return suggestionData?.rejectionReasons
            ?.find { it.category == category }
            ?.items
            ?.map { it.reason } ?: emptyList()
    }

    fun getSuggestionsForReason(category: String, reason: String): List<String> {
        return suggestionData?.rejectionReasons
            ?.find { it.category == category }
            ?.items
            ?.find { it.reason == reason }
            ?.suggestions ?: emptyList()
    }

    fun getAllCategories(): List<CategorySuggestion> {
        return suggestionData?.rejectionReasons ?: emptyList()
    }
}