package com.sajibthedev.sajibsquiz

object setData {

    const val score:String = "score"
    fun getQuestion(): ArrayList<QuestionData> {

        var que: ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            1,
            "What is Sajib's age?",
            "20",
            "21",
            "22",
            "23",
            2
        )

        que.add(q1)

        var q2 = QuestionData(
            2,
            "What is Sajib's favorite food?",
            "Biri",
            "Vat",
            "Biriany",
            "None",
            3
        )

        que.add(q2)

        var q3 = QuestionData(
            3,
            "What animal does Sajib hate?",
            "Cat",
            "Dog",
            "Spider",
            "Snake",
            4
        )

        que.add(q3)

        var q4 = QuestionData(
            4,
            "What animal does Sajib loves?",
            "Cat",
            "Dog",
            "Panda",
            "Elephant",
            2

            )
        que.add(q4)

        var q5 = QuestionData(
            5,
            "Who is Sajib's favorite footballer?",
            "Messi",
            "CR7",
            "Ronaldo",
            "Neymar jr",
            2
        )

        que.add(q5)

        var q6 = QuestionData(
            6,
            "Who is Sajib's favourite movie actor? ",
            "Shahrukh Khan",
            "Ryan Reynolds",
            "Sakib Khan",
            "Dwayne Johnson",
            1
        )

        que.add(q6)

        var q7 = QuestionData(
            7,
            "Who is Sajib's favorite movie actor?",
            "Priyanka Chopra",
            "Sunny Leone",
            "Deepika Padukone",
            "Apu Biswas",
            3
        )

        que.add(q7)

        var q8 = QuestionData(
            8,
            "Who is Sajib's favorite singer?",
            "Arijit Singh",
            "Justin Bieber",
            "Eminem",
            "Selena Gomez",
            2
        )

        que.add(q8)

        var q9 = QuestionData(
            9,
            "Whom does Sajib's love the most?",
            "Mother",
            "Father",
            "Himself",
            "His Best friend",
            3
        )

        que.add(q9)

        var q10 = QuestionData(
            10,
            "What is Sajib's Dream",
            "Software Engineer",
            "Teacher",
            "Hawker",
            "Father",
            4
        )

        que.add(q10)

        return que
    }
}