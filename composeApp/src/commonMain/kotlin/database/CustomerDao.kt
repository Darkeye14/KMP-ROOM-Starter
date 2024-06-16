package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Upsert
    suspend fun upsert(person: Customer)

    @Delete
    suspend fun delete(person: Customer)

    @Query("SELECT * FROM customer")
    fun getAllPeople(): Flow<List<Customer>>
}