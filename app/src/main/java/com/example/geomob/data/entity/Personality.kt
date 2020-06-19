package com.example.geomob.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personality_table")
data class Personality(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "personality_id") val personalityId: Int,
    val country: Int,
    val personality: String, @ColumnInfo(name = "personality_description")
    val personalityDescription: String
)