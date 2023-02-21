package com.example.dicesramdom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*****
 * Proyect: DicesRamdom
 * Package: com.example.dicesramdom
 *
 * Created by Rafael Barbeyto Torrellas on 21/02/2023 at 17:09
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/

class MainViewModel : ViewModel() {

    private var numberDice = MutableLiveData<Int>()

    fun launchDice(){
        val universe = 1..4
        numberDice.postValue(universe.random())
    }

    fun getNumberDice(): MutableLiveData<Int> = numberDice
}