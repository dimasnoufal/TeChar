package com.unity.techar.quiz_coding

object setData {

    const val name: String = "name"
    const val score: String = "score"

    fun getQuestion():ArrayList<QuestionData>{
        var que: ArrayList<QuestionData> = arrayListOf()
        var question1 = QuestionData(
            "Sebelum mulai melakukan kode program, sebaiknya diingat bahwa C++ bersifat Case Sensitive yang artinya adalah....",
            1,
            "Huruf besar dan kecil dibedakan",
            "Spasi dan jarak",
            "Compiler Program",
            "Angka besar dan kecil dibedakan",
            1
        )
        var question2 = QuestionData(
            "Suatu tipe data yang nilainya tidak dapat diubah-ubah adalah....",
            2,
            "Variabel",
            "Real",
            "Operator",
            "Konstanta",
            4
        )
        var question3 = QuestionData(
            "Suatu tipe data yang nilainya dapat diubah-ubah adalah....",
            3,
            "Variabel",
            "Real",
            "Operator",
            "Konstanta",
            1
        )
        var question4 = QuestionData(
            "Bilangan komputer berbasis 16 yang terdiri dari angka 0 sampai 9, A, B, C, D, E, F disebut dengan....",
            4,
            "Bilangan decimal",
            "Bilangan biner",
            "Bilangan hexa decimal",
            "Bilangan octal",
            3
        )
        var question5 = QuestionData(
            "Manakah yang tidak termasuk Operator Logika !",
            5,
            "!",
            "| |",
            "And",
            "Me",
            4
        )
        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}