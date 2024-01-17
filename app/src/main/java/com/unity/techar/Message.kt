package com.unity.techar
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Message(
    val text : String? = null,
    val name : String? = null,
    val timestamp : Long? = null,
){

}
