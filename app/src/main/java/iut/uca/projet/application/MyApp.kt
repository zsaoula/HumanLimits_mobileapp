package iut.uca.projet.application

import android.app.Application
import iut.uca.projet.data.Database

class MyApp : Application() {
    val db by lazy { Database.getInstance(this); }
}