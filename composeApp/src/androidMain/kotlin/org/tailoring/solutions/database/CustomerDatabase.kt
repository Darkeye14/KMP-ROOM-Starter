package org.tailoring.solutions.database

import android.content.Context
import android.os.Bundle
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.CustomerDatabase

fun getCustomerDatabase(context : Context) : CustomerDatabase{
    val dbFile = context.getDatabasePath("customer.db")
    return Room.databaseBuilder<CustomerDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}