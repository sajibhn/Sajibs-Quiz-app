package com.sajibthedev.sajibsquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.sajibthedev.sajibsquiz.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private var score:Int = 0

    private lateinit var binding: ActivityQuizBinding
    private var currentPosition:Int = 1
    private var questionList:ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        questionList = setData.getQuestion()
        setQuestion()
        binding.tvOptionOne.setOnClickListener {
            selectedOptionStyle(binding.tvOptionOne, 1)
        }

        binding.tvOptionTwo.setOnClickListener {
            selectedOptionStyle(binding.tvOptionTwo, 2)
        }

        binding.tvOptionThree.setOnClickListener {
            selectedOptionStyle(binding.tvOptionThree, 3)
        }

        binding.tvOptionFour.setOnClickListener {
            selectedOptionStyle(binding.tvOptionFour, 4)
        }

        binding.submitBtn.setOnClickListener {
            if(selectedOption!=0){
                val question = questionList!![currentPosition -1]
                if (selectedOption!= question.correct_ans){

                    setColor(selectedOption, R.drawable.wrong_text_bg)
                }else{
                    score++
                }
                setColor(question.correct_ans, R.drawable.correct_text_bg)

                // if it is last question then show "finish" otherwise "go to next"
                if (currentPosition==questionList!!.size)
                binding.submitBtn.text = "FINISH"
                else
                    binding.submitBtn.text = "Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }



    }

    // set color of wrong ro right ans
    private fun setColor(opt:Int, color:Int){
        when(opt){
            1 ->{
                binding.tvOptionOne.background = ContextCompat.getDrawable(this, color)
            }

            2 ->{
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this, color)
            }

            3 ->{
                binding.tvOptionThree.background = ContextCompat.getDrawable(this, color)
            }

            4 ->{
                binding.tvOptionFour.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    //setting question
    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        setOptionStyle()

        binding.progressBar.progress = currentPosition
        binding.progressBar.max = questionList!!.size

        binding.tvProgress.text = "$currentPosition" + "/" + "${questionList!!.size}"
        binding.tvQuestion.text = question.question
        binding.tvOptionOne.text = question.option_one
        binding.tvOptionTwo.text = question.option_two
        binding.tvOptionThree.text = question.option_three
        binding.tvOptionFour.text =   question.option_four

    }

    //styling question
    private fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0, binding.tvOptionOne)
        optionList.add(1, binding.tvOptionTwo)
        optionList.add(2, binding.tvOptionThree)
        optionList.add(3, binding.tvOptionFour)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#252527"))
            op.background = ContextCompat.getDrawable(this, R.drawable.option_text_bg)
            op.typeface = Typeface.DEFAULT
        }
    }

    // setting selected option background

    private fun selectedOptionStyle(view:TextView, opt:Int){
        setOptionStyle()
        selectedOption = opt

        view.background = ContextCompat.getDrawable(this, R.drawable.selected_text_bg)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#252527"))
    }
}