package iut.uca.projet.model

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.findViewTreeLifecycleOwner
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import iut.uca.projet.R


class MemoryGame(var view: View) : MiniJeu {
    var sequence = mutableListOf<Int>()
    var currentStep = MutableLiveData<Int>(0)
    var boolResponseGlobal = true
    var selectionButtons = mutableListOf<Button?>()
    val buttons : Array<Button?> = arrayOfNulls<Button>(9)

    override fun start(): Int {

        var scoreView = view.findViewById<TextView>(R.id.scoreViewMemory)
        buttons[0] = view.findViewById(R.id.button1)
        buttons[1] = view.findViewById(R.id.button2)
        buttons[2] = view.findViewById(R.id.button3)
        buttons[3] = view.findViewById(R.id.button4)
        buttons[4] = view.findViewById(R.id.button5)
        buttons[5] = view.findViewById(R.id.button6)
        buttons[6] = view.findViewById(R.id.button7)
        buttons[7] = view.findViewById(R.id.button8)
        buttons[8] = view.findViewById(R.id.button9)

        view.findViewTreeLifecycleOwner()?.let { currentStep.observe(it, Observer<Int> {
            newValue -> scoreView.text = newValue.toString()}) }
        game()
        return currentStep.value!!.minus(1)
    }

    private fun game(){
        GlobalScope.launch {
            var listButtons = mutableListOf<Button?>()
            while (boolResponseGlobal){
                currentStep.postValue(currentStep.value!!.plus(1))
                generateSequence()
                displaySequence()
                listButtons = buttons.filterIndexed { index, button -> sequence.contains(index)}.toMutableList()
                waitForButtonGroup(listButtons)
                buttons.forEach { it!!.setOnClickListener{} }
                selectionButtons.removeAll(selectionButtons)
            }
        }
    }

    suspend fun waitForButtonGroup(buttonsList : List<Button?>): Unit = suspendCoroutine { continuation ->
        for (button in buttons) {
            button?.setOnClickListener {
                if (button in buttonsList) {
                    selectionButtons.add(button)
                    if(selectionButtons.size == buttonsList.size){
                        boolResponseGlobal=true
                        continuation.resume(Unit)
                    }
                }
                else {
                    boolResponseGlobal=false
                    continuation.resume(Unit)
                }
            }
        }
    }

    override fun stop() {

    }

    private fun generateSequence() {
        sequence.add((0..8).random())
    }

    private suspend fun displaySequence() {
        delay(9000)
        for (i in sequence){
            val buttonBackground = buttons[i]?.background!!.mutate()
            DrawableCompat.setTint(buttonBackground, ContextCompat.getColor(view.context, R.color.blueBackground))
            buttons[i]?.background = buttonBackground
            delay(500)
            DrawableCompat.setTint(buttonBackground, ContextCompat.getColor(view.context, R.color.greyButton))
            buttons[i]?.background = buttonBackground
            delay(400)
        }
    }
}