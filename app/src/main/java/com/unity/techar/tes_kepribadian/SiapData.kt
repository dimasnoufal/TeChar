package com.unity.techar.tes_kepribadian

import com.unity.techar.quiz_coding.QuestionData

object siapData {

    const val name: String = "name"
    const val score: String = "score"

    fun getSoal():ArrayList<SoalData>{
        var que: ArrayList<SoalData> = arrayListOf()
        var question1 = SoalData(
            "Anda rutin mendapatkan teman baru.",
            1,
            "Setuju",
            "Tidak Setuju",
            2
        )
        var question2 = SoalData(
            "Anda menghabiskan banyak waktu luang menjelajahi berbagai topik acak yang menarik minat Anda.",
            2,
            "Setuju",
            "Tidak Setuju",
            2
        )
        var question3 = SoalData(
            "Anda sering menyiapkan rencana cadangan untuk rencana cadangan Anda.",
            3,
            "Setuju",
            "Tidak Setuju",
            1
        )
        var question4 = SoalData(
            "Anda biasanya tetap tenang sekalipun sedang dalam banyak tekanan.",
            4,
            "Setuju",
            "Tidak Setuju",
            2
        )
        var question5 = SoalData(
            "Anda lebih cenderung mengikuti akal daripada perasaan.",
            5,
            "Setuju",
            "Tidak Setuju",
            1
        )
        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}