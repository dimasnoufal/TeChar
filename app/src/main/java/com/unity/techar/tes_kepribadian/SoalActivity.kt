package com.unity.techar.tes_kepribadian

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.unity.techar.R
import com.unity.techar.quiz_coding.QuestionData
import com.unity.techar.quiz_coding.ResultActivity
import com.unity.techar.quiz_coding.setData

class SoalActivity : AppCompatActivity() {

    private var Name: String?=null
    private var score: Int = 0

    private var currentPosition: Int = 1
    private var questionList: ArrayList<SoalData>?=null
    private var selectedOption: Int = 0

    private lateinit var opt_1: TextView
    private lateinit var opt_2: TextView
    private lateinit var submit: Button
    private lateinit var progress_bar: ProgressBar
    private lateinit var progress_text: TextView
    private lateinit var question_text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        opt_1 = findViewById(R.id.opt_1s)
        opt_2 = findViewById(R.id.opt_2s)
        submit = findViewById(R.id.submits)
        progress_bar = findViewById(R.id.progress_bars)
        progress_text = findViewById(R.id.progress_texts)
        question_text = findViewById(R.id.question_texts)

        questionList = siapData.getSoal()

        setQuestion()

        opt_1.setOnClickListener{
            selectedOptionStyle(opt_1, 1)
        }

        opt_2.setOnClickListener{
            selectedOptionStyle(opt_2, 2)
        }


        submit.setOnClickListener{
            if (selectedOption != 0)
            {
                val question = questionList!![currentPosition - 1]

                if (selectedOption != question.correct_ans)
                {
                    setColor(selectedOption, R.drawable.ques_option)
                }else{
                    score++
                }
                setColor(question.correct_ans, R.drawable.ques_option)

                if (currentPosition == questionList!!.size)
                    submit.text = "FINISH"
                else
                    submit.text = "Go To Next"
            }else{
                currentPosition++
                when{
                    currentPosition <= questionList!!.size->{
                        setQuestion()
                    }
                    else->
                    {
                        var intent = Intent(this, HasilActivity::class.java)

//                        intent.putExtra(setData.name, Name.toString())
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total size", questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt: Int, color: Int)
    {
        when(opt){
            1->{
                opt_1.background = ContextCompat.getDrawable(this, color)
            }
            2->{
                opt_2.background = ContextCompat.getDrawable(this, color)
            }

        }
    }

    fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        setOptionStyle()

        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_text.text = "${currentPosition}" + "/" + "${questionList!!.size}"
        question_text.text = question.question

        opt_1.text = question.option_one
        opt_2.text = question.option_two
    }

    fun setOptionStyle()
    {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(0, opt_2)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#747377"))
            op.background = ContextCompat.getDrawable(this, R.drawable.ques_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int)
    {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}