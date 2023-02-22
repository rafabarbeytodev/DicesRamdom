package com.example.dicesramdom

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.dicesramdom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val mViewModel: MainViewModel by viewModels()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnLaunchDice.setOnClickListener {
            mViewModel.launchDice()
        }

        mViewModel.getNumberDice().observe(this){
            mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.mov1))
            Handler(Looper.getMainLooper()).postDelayed({
                mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.mov2))
                Handler(Looper.getMainLooper()).postDelayed({
                    mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.mov3))
                    Handler(Looper.getMainLooper()).postDelayed({
                        mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.mov4))
                        Handler(Looper.getMainLooper()).postDelayed({
                            when(it){
                                1 -> mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.one))
                                2 -> mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.two))
                                3 -> mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.three))
                                4 -> mainBinding.ivDice.setImageDrawable(getDrawable(R.drawable.four))
                            }
                        }, timeSlot)
                    }, timeSlot)
                }, timeSlot)
            }, timeSlot)
        }
    }
}