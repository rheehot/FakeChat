package net.jspiner.fakechat.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val profileImage: String,
    val statusMessage: String
)