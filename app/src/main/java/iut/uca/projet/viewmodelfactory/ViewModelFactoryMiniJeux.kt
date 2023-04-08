package iut.uca.projet.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import iut.uca.projet.dao.DAOMiniJeu
import iut.uca.projet.viewmodel.MiniJeuVM
import java.security.InvalidParameterException

class ViewModelFactoryMiniJeux(val DAO : DAOMiniJeu ) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MiniJeuVM(DAO)::class.java)){
            return MiniJeuVM(DAO) as T
        }
        else throw InvalidParameterException("ViewModelFactoryMiniJeux invlaide parameters")
    }
}