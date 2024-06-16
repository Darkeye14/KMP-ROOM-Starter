package database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

fun getCustomerDatabase() : CustomerDatabase{
    val dbFile = File(System.getProperty("java.io.tmpdir"),"customer.db")
    return Room.databaseBuilder<CustomerDatabase>(
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}