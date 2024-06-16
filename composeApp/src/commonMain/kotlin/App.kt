import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import database.Customer
import database.CustomerDao
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(customerDao :CustomerDao) {
    MaterialTheme {
        val customer by customerDao.getAllPeople().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()
        LaunchedEffect(true){
            val list = listOf(
                Customer(
                    name = "Mike"
                ),
                Customer(
                    name = "hike"
                ),Customer(
                    name = "bike"
                ),Customer(
                    name = "sike"
                ),Customer(
                    name = "kite"
                )
            )
            list.forEach{
                customerDao.upsert(it)
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(12.dp)
        ) {
            items(customer){
                Text(text = it.name,
                    modifier = Modifier.fillMaxWidth()
                        .padding(12.dp)
                        .clickable {
                            scope.launch {
                               customerDao.delete(it)
                            }
                        })
            }
        }

    }
}