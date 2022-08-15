package com.example.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUE:String="total_que"
    const val CORRECT_ANS:String="corret_ans"
    fun getQuestion():ArrayList<Question>{
        val questionsList= ArrayList<Question>()

        val que1 = Question(
            1, "What is this anime called?",
            R.drawable.que1,
            "One Piece", "Naruto",
            "Fairy Tail", "Samarai Champloo", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What is this anime called?",
            R.drawable.que2,
            "Overlord", "Shingeki No kyojin",
            "Demon Slayer", "Attack on Tiatan", 4
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What is this anime called?",
            R.drawable.que3,
            "The Rising of the Shield Hero", "Swart Art Online",
            "No Game No life", "Death Note", 2
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What is this anime called?",
            R.drawable.que4,
            "Boku No Hero Academia", "Prison School",
            "Fairy Tail", "Jujutsu Kaisen", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What is this anime called?",
            R.drawable.que5,
            "The Devil is a Part Timer", "My Hero Academia",
            "Naruto", "March Comes in Like a Lion", 2
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What is this anime called?",
            R.drawable.que6,
            "Death Note", "Soul Eater",
            "Higurashi When They Cry", "Parasyte", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What is this anime called?",
            R.drawable.que7,
            "Dragon Ball", "Dragon Ball Z",
            "Dragon Ball Super", "One Piece", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What is this anime called?",
            R.drawable.que8,
            "Little Witch Academia", "Sailer Moon",
            "Sailer Moon Crystal", "Madoka Magica", 2
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What is this anime called??",
            R.drawable.que9,
            "Charlotte", "Orange",
            "Your Lie in April", "Carole and Tuesday", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What is this anime called?",
            R.drawable.que10
            ,
            "High School DxD", "The Devil is a Part-Timer",
            "Prison School", "High School of the Dead", 1
        )

        questionsList.add(que10)
        return questionsList
    }
}