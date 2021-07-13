package learn.dio.project.businesscard

import android.app.Application
import learn.dio.project.businesscard.data.AppDatabase
import learn.dio.project.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository (database.businessDao()) }
}