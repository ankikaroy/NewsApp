package com.app.newsapplication.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.app.newsapplication.dashboard.model.Article

@Database(entities = arrayOf(Article::class), version = 1)
@TypeConverters(Article.SourceTypeConverter::class)
abstract class AppDatabse : RoomDatabase() {
    
    abstract fun newsDataDao(): NewsDao

    companion object {
        private var INSTANCE: AppDatabse? = null

        fun getInstance(context: Context): AppDatabse? {
            if (INSTANCE == null) {
                synchronized(AppDatabse::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabse::class.java, "news.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}