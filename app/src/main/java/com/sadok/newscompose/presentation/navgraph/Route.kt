package com.sadok.newscompose.presentation.navgraph

sealed class Route (
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object BookmarkScreen : Route(route = "bookmarkScreen")
    object DetailScreen : Route(route = "detailScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "NewsNavigation")
    object NewsNavigatorScreen : Route(route = "NewsNavigatorScreen")

}