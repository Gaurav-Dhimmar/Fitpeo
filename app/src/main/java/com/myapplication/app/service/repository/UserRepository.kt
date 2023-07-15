package com.myapplication.app.service.repository

import android.content.Context
import com.myapplication.app.service.main.ServerApi

class UserRepository(val context: Context, private val serverApi: ServerApi) {
//    fun getProfileAPI(): Observable<GetProfileResponseModel?>? {
//        return serverApi.getProfilesAPI()
//    }
//
//    fun checkUserEmailAPI(params: Map<String, String>): Observable<CheckUserEmailResponseModel> {
//        return serverApi.checkUserEmailAPI(params)
//    }
//
//    fun loginAPI(params: HashMap<String, Any>): Observable<LoginResponseModel> {
//        return serverApi.loginAPI(params)
//    }
//
//    fun login(
//        email: String?,
//        password: String?,
//        mfaCode: String?
//    ): Flow<CheckUserEmailResponseModel> {
//        return flow {
//            val r = serverApi.login(
//                SendCheckUserEmailRequestModel().apply {
//                    this.email = email
//                })
//            emit(r)
//        }.flowOn(Dispatchers.IO) // Use the IO thread for this Flow
//    }
}