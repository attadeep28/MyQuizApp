package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{
    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAns:Int=0
    private var mUserName:String?=null
    private var progressBar:ProgressBar? =null
    private var tvprogress:TextView?=null
    private var tvQue:TextView?=null
    private var ivImage:ImageView?=null

    private var tvOpt1:TextView?=null
    private var tvOpt2:TextView?=null
    private var tvOpt3:TextView?=null
    private var tvOpt4:TextView?=null
    private var btn_submit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions2)
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progrss_bar)
        tvprogress=findViewById(R.id.tv_progress)
        tvQue=findViewById(R.id.tvQue)
        ivImage=findViewById(R.id.iv_image)

        tvOpt1=findViewById(R.id.tv_opt1)
        tvOpt2=findViewById(R.id.tv_opt2)
        tvOpt3=findViewById(R.id.tv_opt3)
        tvOpt4=findViewById(R.id.tv_opt4)
        btn_submit=findViewById(R.id.btn_submit)

        tvOpt1?.setOnClickListener(this)
        tvOpt2?.setOnClickListener(this)
        tvOpt3?.setOnClickListener(this)
        tvOpt4?.setOnClickListener(this)

        btn_submit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestion()
        setQuestion()


    }

    private fun setQuestion() {

        defaultOptionView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQue?.text = question.question
        tvOpt1?.text = question.optionOne
        tvOpt2?.text = question.optionTwo
        tvOpt3?.text = question.optionThree
        tvOpt4?.text = question.optionFour

        if(mCurrentPosition==mQuestionsList!!.size){
            btn_submit?.text="Finish"
        }else{
            btn_submit?.text="Submit"
        }
    }



    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOption

        tv.setTextColor(
            Color.parseColor("#363a43")
        )
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border
        )
    }
    private fun defaultOptionView(){
        val option=ArrayList<TextView>()
        tvOpt1?.let{
            option.add(0,it)
        }
        tvOpt2?.let{
            option.add(1,it)
        }
        tvOpt3?.let{
            option.add(2,it)
        }
        tvOpt4?.let{
            option.add(3,it)
        }

        for(opt in option){
            opt.setTextColor(Color.parseColor("#7a8089"))
            opt.typeface= Typeface.DEFAULT
            opt.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_opt1->{
                tvOpt1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_opt2->{
                tvOpt2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_opt3->{
                tvOpt3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_opt4->{
                tvOpt4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                //TODO
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else->{
//                            Toast.makeText(this,"You made to the end",Toast.LENGTH_SHORT).show()
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANS,mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUE,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAns!=mSelectedOptionPosition){
                        ansView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAns++
                    }

                    ansView(question.correctAns,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionsList!!.size){
                        btn_submit?.text="FINISH"
                    }else{
                        btn_submit?.text="next"
                    }
                    mSelectedOptionPosition=0
                }

            }
        }
    }

    private fun ansView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvOpt1?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOpt2?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                tvOpt3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvOpt4?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}