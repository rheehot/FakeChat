package net.jspiner.fakechat.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import net.jspiner.fakechat.repository.entity.MyProfile
import net.jspiner.fakechat.repository.entity.MyProfileEntity

@Dao
interface MyProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMyProfile(myProfile: MyProfileEntity): Completable

    @Transaction
    @Query("SELECT * FROM my_profile_entity")
    fun getMyProfile(): Single<MyProfile>
}