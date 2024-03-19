package edu.temple.diceroll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

const val DIE_SIDES = "dIcE_SiDeS"

class DiceFragment : Fragment() {
    private var sides: Int? = null
    private var roll = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sides = it.getInt(DIE_SIDES)
        }

        savedInstanceState?.run{
            roll = getInt(DIE_SIDES, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dice, container, false).apply {

            val numberDisplayTextView = findViewById<TextView>(R.id.numberDisplay)
            findViewById<Button>(R.id.rollButton).setOnClickListener {
                roll = Random.nextInt(sides!!) + 1
                numberDisplayTextView.text = roll.toString()
            }

            numberDisplayTextView.text = ""
            numberDisplayTextView.text = roll.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)

        outState.putInt(DIE_SIDES, roll)

    }

    companion object {

        @JvmStatic
        fun newInstance(sides: Int) =
            DiceFragment().apply {
                arguments = Bundle().apply {
                    putInt(DIE_SIDES, sides)
                }
            }
    }
}