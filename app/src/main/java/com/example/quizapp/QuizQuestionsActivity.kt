package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var currentPosition: Int = 1
    private var questionList: ArrayList<Question>? = null
    private var selectedPosition: Int = 0
    private var userName:String?=null
    private var correctAnswers:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userName = intent.getStringExtra(Constants.USER_NAME)

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        questionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = questionList!![currentPosition - 1]
        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
        if (currentPosition == questionList!!.size) {
            binding.btnSubmit.text = "Finalizar"
        } else {
            binding.btnSubmit.text = "siguiente pregunta"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        binding.tvOptionOne.let {
            options.add(0, it)
        }
        binding.tvOptionTwo.let {
            options.add(1, it)
        }
        binding.tvOptionThree.let {
            options.add(2, it)
        }
        binding.tvOptionFour.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_option_one -> {
                binding.tvOptionOne.let { selectedOptionView(it, 1) }
            }
            R.id.tv_option_two -> {
                binding.tvOptionTwo.let { selectedOptionView(it, 2) }
            }
            R.id.tv_option_three -> {
                binding.tvOptionThree.let { selectedOptionView(it, 3) }
            }
            R.id.tv_option_four -> {
                binding.tvOptionFour.let { selectedOptionView(it, 4) }
            }
            R.id.btn_submit -> {
                if (selectedPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,userName)
                            intent.putExtra(Constants.CORRECT_ANSWER,correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,questionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionList!!.get(currentPosition - 1)
                    if (question!!.correctAnswer != selectedPosition) {
                        answerView(selectedPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    selectedPosition=0
                }
            }
        }
    }
}