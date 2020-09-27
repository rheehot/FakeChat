package net.jspiner.fakechat.repository.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "my_profile_entity")
data class MyProfileEntity(
    @PrimaryKey val id: Int = 1,
    val profileId: Int
)

data class MyProfile(
    @Embedded val myProfile: MyProfileEntity,
    @Relation(
        parentColumn = "profileId",
        entityColumn = "id"
    )
    val profile: Profile
)