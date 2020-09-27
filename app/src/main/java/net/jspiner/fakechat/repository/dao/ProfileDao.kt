package net.jspiner.fakechat.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import net.jspiner.fakechat.repository.entity.Profile

@Dao
interface ProfileDao {

    @Insert
    fun insertProfile(profile: Profile): Completable

    @Query("SELECT * FROM profile ORDER BY name")
    fun loadFriendProfiles(): Single<List<Profile>>
}