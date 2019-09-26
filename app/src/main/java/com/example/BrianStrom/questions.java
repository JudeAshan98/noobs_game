package com.example.BrianStrom;

public class questions {

    public String mQuestions[]={
            "which is the first planent in the Solar system?",
            "which is the second planent in the Solar system?",
            "which is the Third planent in the Solar system?",
            "which is the Fourth planent in the Solar system?",
            "which is the Fifth planent in the Solar system?",
            "which is the Sixth planent in the Solar system?",
            "which is the Seventh planent in the Solar system?",
            "which is the Eight planent in the Solar system?",
            "which is the Nineth planent in the Solar system?"
    };


    public String answers[][]={
            {"Mercury","Venus","Mars","Saturn"},
            {"Mercury","Venus","Mars","Saturn"},
            {"Mercury","Earth","Mars","Saturn"},
            {"Mercury","Venus","Mars","Saturn"},
            {"Jupiter","Venus","Mars","Saturn"},
            {"Mercury","Venus","Saturn","Saturn"},
            {"Mercury","Venus","Mars","Uranus"},
            {"Mercury","Neptune","Mars","Saturn"},
            {"Mercury","Venus","Pluto","Saturn"}

    };

    private String correctAnswer []={"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = answers[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = answers[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = answers[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = answers[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String Canswer = correctAnswer[a];
        return Canswer;
    }

}
