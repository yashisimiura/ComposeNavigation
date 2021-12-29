package com.github.janespooky.matchingforfirebase.ui.main

import com.github.janespooky.matchingforfirebase.R

sealed class MainNavigationItem(var route: String, var icon: Int, var title: String) {
    object List: MainNavigationItem("list", R.drawable.ic_baseline_article_24, "早見表")
    object Card: MainNavigationItem("card", R.drawable.ic_baseline_credit_card_24, "カード")
    object Square: MainNavigationItem("square", R.drawable.ic_baseline_family_restroom_24, "広場")
    object Talk: MainNavigationItem("talk", R.drawable.ic_baseline_message_24, "トーク")
    object Narrative: MainNavigationItem("narrative", R.drawable.ic_baseline_masks_24, "語り")
}
