package com.example.ayursage.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayursage.utils.SharedPref
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AuthViewModel : ViewModel(){

    val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    val userRef = db.getReference("users")

    private val storageRef = Firebase.storage.reference

    private val _firebaseUser = MutableLiveData<FirebaseUser>()
    val firebaseUser: LiveData<FirebaseUser> = _firebaseUser

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        _firebaseUser.value = auth.currentUser
    }

    fun login(email: String, password: String, context: Context){

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    _firebaseUser.postValue(auth.currentUser)

                    getdata(auth.currentUser!!.uid,context)
                }else{
                    _error.postValue(it.exception!!.message)
                }
            }
    }

    private fun getdata(uid: String,context: Context) {
        userRef.child(uid).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userData = snapshot.getValue(UserModel::class.java)
                SharedPref.storeData(userData!!.name,userData!!.email,context)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun register(email:String, password:String,name:String,context: Context){

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    _firebaseUser.postValue(auth.currentUser)
                    saveData(email,password,name,auth.currentUser?.uid, context )
                }else{
                    _error.postValue("Something went wrong.")
                }
            }
    }

    private fun saveData(
        email: String,
        password: String,
        name: String,
        uid: String?,
        context: Context
    ){
        val userData =UserModel(email,password,name,uid!!)

        userRef.child(uid!!).setValue(userData)
            .addOnSuccessListener {
                SharedPref.storeData(name,email,context)
            }.addOnFailureListener{

            }
    }

    fun logout(){
        auth.signOut()
        _firebaseUser.postValue(null)
    }
}