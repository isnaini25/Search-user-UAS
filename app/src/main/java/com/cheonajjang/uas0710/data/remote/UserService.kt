package com.cheonajjang.uas0710.data.remote

import com.cheonajjang.uas0710.data.model.DetailUser
import com.cheonajjang.uas0710.data.model.User
import com.cheonajjang.uas0710.data.model.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("search/users")
    @Headers("Authorization: token 3922fb5b5624b4e45a0107cd637ac35b998441b1")
    fun searchUser(@Query("q") query: String) : Call<UserList>

    @GET("users/{username}")
    @Headers("Authorization: token 3922fb5b5624b4e45a0107cd637ac35b998441b1")
    fun detailUser(@Path("username") username: String) : Call<DetailUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 3922fb5b5624b4e45a0107cd637ac35b998441b1")
    fun getFollowers(@Path("username") username: String) : Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 3922fb5b5624b4e45a0107cd637ac35b998441b1")
    fun getFollowing(@Path("username") username: String) : Call<ArrayList<User>>

}