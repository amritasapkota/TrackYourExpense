package com.example.trackyourexpense.ui

import androidx.navigation.NavBackStackEntry

const val BACK_DESTINATION = "backDestination"

/**
 * Defines all routes for the app with helpers for using the routes.
 */
@Suppress("MemberVisibilityCanBePrivate")
enum class RouteDef(vararg params: String, var title: String = "") {
    DashBoard(title = "IC location"),
    CarParkList;

    private val arguments = params

    private val queryArgs: String?
        get() = arguments
            .takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "&") { "$it={$it}" }
            ?.trim()

    private fun mapQueryArgs(args: Map<String, Any?>): String {
        return args
            .map { "${it.key}=${it.value}" }
            .joinToString("&")
    }

    /**
     * This returns the route def name that should be used to
     * when creating new composable routes
     *
     * Example:
     * ```kotlin
     * composable(RouteDef.SomeRoute.routeName) {
     *   RenderMyView()
     * }
     * ```
     */
    val routeName: String get() {
        return this.name.lowercase().let {
            if (!queryArgs.isNullOrBlank()) "$it?$queryArgs" else it
        }
    }

    /**
     * Concatenates the the route `name` with the value provided to
     * create a route path like `name/param`
     *
     * Example:
     * ```kotlin
     * // with no param argument
     * navController.navigate(RouteDef.SomeRoute.routePath())
     *
     * // with a param argument
     * navController.navigate(RouteDef.SomeRoute.routePath(someValue))
     * ```
     */
    fun routePath(paramValues: Map<String, Any?>? = null): String {
        return this.name.lowercase().let {
            if (!paramValues.isNullOrEmpty()) {
                "$it?${mapQueryArgs(paramValues)}"
            } else {
                it
            }
        }
    }

    /**
     * For routes with parameters the param can be retrieved from the route using
     *
     * Example:
     * ```
     * composable(RouteDef.SomeRoute.routeName) { navBackStack ->
     *   val myParam = RouteDef.SomeRoute.getRouteParamString(navBackStack)
     *   MyView(myParam)
     * }
     * ```
     */
    fun getRouteParamString(navBackStackEntry: NavBackStackEntry, name: String, defaultValue: String = ""): String {
        return navBackStackEntry.arguments?.getString(name) ?: defaultValue
    }
    fun getRouteParamLong(navBackStackEntry: NavBackStackEntry, name: String, defaultValue: Long = -1): Long {
        return getRouteParamString(navBackStackEntry, name, "").let { value ->
            value.takeIf { it.isNotEmpty() }
                ?.toLong(10)
                ?: defaultValue
        }
    }
    fun getRouteParamBool(navBackStackEntry: NavBackStackEntry, name: String, defaultValue: Boolean = false): Boolean {
        return getRouteParamString(navBackStackEntry, name, "").let { value ->
            value.takeIf { it.isNotEmpty() }
                ?.let { bool -> (bool == "true") }
                ?: defaultValue
        }
    }

    companion object {
        /**
         * Provides the start destination for
         * the Navigation Host
         */
        fun getStartDestination(): RouteDef {
            return DashBoard
        }

        /**
         * Reverse lookup for a route from a path
         *
         * Example
         * ```kotlin
         * val routeName: RouteDef? = RouteDef.route('route/{param}')
         * ```
         */
        fun route(name: String): RouteDef? {
            return values().find {
                it.routeName == name
            }
        }
    }
}
