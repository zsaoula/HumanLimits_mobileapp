package iut.uca.projet.viewmodel

import android.content.Context
import androidx.lifecycle.*
import iut.uca.projet.dao.DAOMiniJeu
import iut.uca.projet.entity.MiniJeuEntity
import kotlinx.coroutines.flow.collect

class MiniJeuVM(val DAO : DAOMiniJeu) : ViewModel() {
    fun getMiniJeux() : LiveData<List<MiniJeuEntity>> = DAO.getMiniJeux().asLiveData()

}