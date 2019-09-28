package com.example.BrianStrom;

public class questions {

    public String mQuestions[]={
            "who won the cricket world cup 2019?",
            "According to IEEE,which is the top top Programming Language in 2019 ?",
            "which is the Fourth planent in the Solar system?",
            "The World Largest desert is ?",
            "Mount Everest is located in ?",
            "Who is  the founder of the Linux open-source operating system?",
            "In which year was google founded",
            "Who is  the author of the harry potter books",
            "In which year world fastest man Usain bolt retired",
            "what is the happiest country in the world?"

    };


    public String answers[][]={
            {"Australia","England","Newzeland","SriLanka"},
            {"Python","SQL","C","Java"},
            {"Mercury","Earth","Mars","Saturn"},
            {"Sonoran","Thar","Kalahari","Sahara"},
            {"China","India","Nepal","Japan"},
            {"Richard Stallman","Dennis Ritchie","Linus Torvalds","Nils Torvalds"},
            {"1997","2001","1998","1999"},
            {"Stephen King","Emma Watson","J.K.Rowling","Neil Murray"},
            {"2017","2018","2015","2016"},
            {"Finland","Australia","France","Norway"}

    };

    private String correctAnswer []={"England","Python","Mars","Sahara","Nepal","Linus Torvalds","1998","J.K.Rowling","2017","Finland"};

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
