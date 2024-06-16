import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import database.getCustomerDatabase

fun main() = application {
    val dao = remember {
        getCustomerDatabase().customerDao()
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "TailoringSolutions",
    ) {
        App(dao)
    }
}