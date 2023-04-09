package iut.uca.projet.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iut.uca.projet.R
import iut.uca.projet.adapter.MiniJeuAdpater
import iut.uca.projet.application.MyApp
import iut.uca.projet.entity.MiniJeuEntity
import iut.uca.projet.viewmodel.MiniJeuVM
import iut.uca.projet.viewmodelfactory.ViewModelFactoryMiniJeux
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class FragmentMiniJeu(val model : List<String>) : Fragment(R.layout.fragment_container_minijeu){

    val viewModel : MiniJeuVM by viewModels<MiniJeuVM>
    { ViewModelFactoryMiniJeux((this.activity?.application as MyApp).db!!.MiniJeuDAO()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*var modelList = mutableListOf<MiniJeuEntity>()
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
             modelList = withContext(Dispatchers.IO) {
                viewModel.getMiniJeux()}.toMutableList()

             }
        Log.d("TEST",modelList.toString())
        var modelListFinal = mutableListOf<String>()
        modelList!!.forEach { modelListFinal.add(it.nom) }*/

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.minijeux_recyclerView).layoutManager = GridLayoutManager(this.context,2,GridLayoutManager.VERTICAL,false)
        view.findViewById<RecyclerView>(R.id.minijeux_recyclerView).adapter = MiniJeuAdpater(model)
    }
}