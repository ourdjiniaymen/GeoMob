package com.example.geomob.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resource_table")
data class Resource(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "resource_id") val resourceId: Int,
    val country: Int,
    val resource: String,
    @ColumnInfo(name = "resource_description") val resourceDescription: String
)