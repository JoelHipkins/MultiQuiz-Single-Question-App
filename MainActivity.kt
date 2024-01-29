package edu.vt.cs5254.multiquiz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.vt.cs5254.multiquiz.databinding.ActivityMainBinding
import edu.vt.cs5254.multiquiz.*





class MainActivity : AppCompatActivity() {

    // Name: Joel Hipkins
    // PID: joel5


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val answers = listOf("Brisbane", "Canberra", "Melbourne", "Sydney")


        val answerButtons = listOf(
            binding.answerButton1,
            binding.answerButton2,
            binding.answerButton3,
            binding.answerButton4
        )

        answerButtons.forEachIndexed { index, button ->
            button.text = answers[index]
            button.setOnClickListener {
                onAnswerButtonClicked(it as Button, answerButtons)
            }
        }

        binding.fiftyFiftyButton.setOnClickListener {
            applyFiftyFifty(answerButtons)
        }

        binding.resetButton.setOnClickListener {
            resetQuiz(answerButtons)
        }
    }

    private fun onAnswerButtonClicked(selectedButton: Button, answerButtons: List<Button>) {

        answerButtons.forEach { button ->
            button.isSelected = button == selectedButton
            button.updateColor()
        }
    }

    private fun applyFiftyFifty(answerButtons: List<Button>) {

        val buttonsToDisable = listOf(binding.answerButton1, binding.answerButton3)


        buttonsToDisable.forEach { button ->
            button.isEnabled = false


        }

        binding.fiftyFiftyButton.isEnabled = false

    }

    private fun resetQuiz(answerButtons: List<Button>) {
        answerButtons.forEach { button ->
            button.isEnabled = true
            button.isSelected = false

        }
        binding.fiftyFiftyButton.isEnabled = true

    }

}