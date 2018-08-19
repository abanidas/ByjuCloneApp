package com.abani.exercise.android.byjuclone.utils;

import com.abani.exercise.android.byjuclone.R;

import java.util.Random;

public class CommonUtils {

    public static int getRandomDrawable(){
        Random random = new Random();
        int randomInt = random.nextInt(5);
        switch (randomInt){
            case 1: return R.drawable.ic_card_gradient_1;
            case 2: return R.drawable.ic_card_gradient_2;
            case 3: return R.drawable.ic_card_gradient_3;
            case 4: return R.drawable.ic_card_gradient_4;
        }
        return R.drawable.ic_card_gradient_1;
    }
}
