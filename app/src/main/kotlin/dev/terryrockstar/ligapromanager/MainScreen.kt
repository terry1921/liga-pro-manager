package dev.terryrockstar.ligapromanager

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.terryrockstar.core.database.entity.toCard
import dev.terryrockstar.ligapromanager.calendar.CalendarContent
import dev.terryrockstar.ligapromanager.calendar.CalendarScreen
import dev.terryrockstar.ligapromanager.calendar.MatchDetailScreen
import dev.terryrockstar.ligapromanager.standing.StandingsContent
import dev.terryrockstar.ligapromanager.standing.StandingsScreen
import dev.terryrockstar.ligapromanager.teams.TeamDetailScreen
import dev.terryrockstar.ligapromanager.teams.TeamsContent
import dev.terryrockstar.ligapromanager.teams.TeamsScreen
import dev.terryrockstar.ligapromanager.ui.theme.LigaProTheme
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens
import dev.terryrockstar.ligapromanager.utils.DataMock

object NavRoutes {
    const val STANDINGS = "standings"
    const val CALENDAR = "calendar"
    const val TEAMS = "teams"
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    Scaffold(
        topBar = {
            TopAppBarWithNavigation(
                currentRoute = currentRoute ?: NavRoutes.STANDINGS,
                showBack = currentRoute != NavRoutes.STANDINGS,
                onBack = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            BottomNavBar(navController, currentRoute)
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = NavRoutes.STANDINGS,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } },
            popEnterTransition = { slideInHorizontally { it } },
            popExitTransition = { slideOutHorizontally { it } }
        ) {
            composable(NavRoutes.STANDINGS) {
                StandingsScreen(paddingValues)
            }
            composable(NavRoutes.CALENDAR) {
                CalendarScreen(paddingValues, navigateToMatchDetail = { matchId ->
                    navController.navigate("matchDetail/${matchId}")
                })
            }
            composable(NavRoutes.TEAMS) {
                TeamsScreen(paddingValues, navigateToTeamDetail = { teamId ->
                    navController.navigate("teamDetail/${teamId}")
                })
            }
            composable(
                "matchDetail/{matchId}", arguments = listOf(
                    navArgument("matchId") { type = NavType.IntType }
                )) { backStackEntry ->
                val matchId = backStackEntry.arguments?.getInt("matchId") ?: return@composable
                MatchDetailScreen(matchId = matchId)
            }

            composable(
                "teamDetail/{teamId}", arguments = listOf(
                navArgument("teamId") { type = NavType.IntType }
            )) { backStack ->
                val teamId = backStack.arguments?.getInt("teamId") ?: return@composable
                TeamDetailScreen(teamId = teamId)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithNavigation(
    currentRoute: String,
    showBack: Boolean,
    onBack: () -> Unit
) {
    val title = when (currentRoute) {
        NavRoutes.CALENDAR -> "Calendario"
        NavRoutes.TEAMS -> "Equipos"
        else -> "Liga Pro-Manager"
    }
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.EmojiEvents, contentDescription = null)
                Spacer(modifier = Modifier.width(Dimens.size2))
                Text(
                    title,
                    lineHeight = 20.sp,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                }
            }
        }
    )
}

@Composable
fun BottomNavBar(navController: NavHostController, currentRoute: String?) {
    val items = listOf(
        NavItem("Calendario", Icons.Default.DateRange, NavRoutes.CALENDAR),
        NavItem("Equipos", Icons.Default.Groups, NavRoutes.TEAMS),
        NavItem("Estadísticas", Icons.Default.BarChart, NavRoutes.STANDINGS)
    )

    NavigationBar(containerColor = colorScheme.secondary) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(NavRoutes.STANDINGS) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.outlineVariant,
                    unselectedIconColor = colorScheme.outline,
                    selectedTextColor = colorScheme.outlineVariant,
                    unselectedTextColor = colorScheme.outline,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun PreviewScreenForRoute(currentRoute: String) {
    LigaProTheme(useDarkTheme = true) {
        Scaffold(
            topBar = {
                TopAppBarWithNavigation(
                    currentRoute = currentRoute,
                    showBack = currentRoute != NavRoutes.STANDINGS,
                    onBack = {}
                )
            },
            bottomBar = {
                BottomNavBar(
                    navController = rememberNavController(),
                    currentRoute = currentRoute
                )
            }
        ) { _ ->
            when (currentRoute) {
                NavRoutes.STANDINGS -> StandingsContent(teams = DataMock.TEAMS_STANDINGS)

                NavRoutes.CALENDAR -> CalendarContent(
                    matches = DataMock.MATCHES.toCard(),
                    navigateToMatchDetail = {}
                )

                NavRoutes.TEAMS -> TeamsContent(
                    teams = DataMock.TEAMS.toCard(),
                    navigateToTeamDetail = {})
            }
        }
    }
}

@Preview(name = "Preview Estadísticas", showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreenStandings() {
    PreviewScreenForRoute(currentRoute = NavRoutes.STANDINGS)
}

@Preview(name = "Preview Calendario", showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreenCalendar() {
    PreviewScreenForRoute(currentRoute = NavRoutes.CALENDAR)
}

@Preview(name = "Preview Equipos", showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreenTeams() {
    PreviewScreenForRoute(currentRoute = NavRoutes.TEAMS)
}
