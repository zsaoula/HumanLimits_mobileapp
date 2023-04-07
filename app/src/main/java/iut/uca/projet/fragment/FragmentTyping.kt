package iut.uca.projet.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import iut.uca.projet.R
import iut.uca.projet.model.ReactionGame
import iut.uca.projet.network.ApiWordService
import iut.uca.projet.network.WordApi
import iut.uca.projet.network.retrofit
import retrofit2.Retrofit

class FragmentTyping : Fragment(R.layout.fragment_typing_game)  {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Android dev //
        val listResult = WordApi.retrofitService.getWord()

        view.findViewById<TextView>(R.id.wordDisplay).setText(listResult)
    }
}