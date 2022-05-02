package com.example.quizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWER:String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        questionsList.add(que1)
        val que2 = Question(
            2, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )
        questionsList.add(que2)
        val que3 = Question(
            3, "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_brazil,
            "Bielorrusia", "Belice",
            "Brunei", "Brasil", 4
        )
        questionsList.add(que3)
        val que4 = Question(
            4, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgica",
            "Barbados", "Belice", 2
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "Francia",
            "Fiji", "Finlandia", 3
        )
        questionsList.add(que5)
        val que6 = Question(
            6, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_germany,
            "Alemania", "Georgia",
            "Grecia", "Ninguna de las anteriores", 1
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egipto",
            "Dinamarca", "Etiopia", 3
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_india,
            "irlanda", "Iran",
            "Hungria", "India", 4
        )
        questionsList.add(que8)

        val que9 = Question(
            9, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "Nueva zelanda",
            "Tuvalu", "Estados Unidos", 2
        )
        questionsList.add(que9)

        val que10 = Question(
            10, "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordania",
            "Sudan", "Palestina", 1
        )
        questionsList.add(que10)

        return questionsList
    }
}