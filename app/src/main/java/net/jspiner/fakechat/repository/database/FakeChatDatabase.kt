package net.jspiner.fakechat.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.jspiner.fakechat.repository.dao.MyProfileDao
import net.jspiner.fakechat.repository.dao.ProfileDao
import net.jspiner.fakechat.repository.entity.MyProfileEntity
import net.jspiner.fakechat.repository.entity.Profile

@Database(entities = [Profile::class, MyProfileEntity::class], version = 1)
abstract class FakeChatDatabase : RoomDatabase() {

    abstract fun myProfileDao(): MyProfileDao

    abstract fun profileDao(): ProfileDao

    companion object {

        @Volatile
        private var INSTANCE: FakeChatDatabase? = null

        fun getInstance(context: Context): FakeChatDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FakeChatDatabase::class.java, "Sample.db"
            ).build()
    }
}