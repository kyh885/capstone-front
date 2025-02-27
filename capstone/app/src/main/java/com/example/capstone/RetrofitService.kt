package com.example.capstone

import com.example.capstone.dataclass.PostList
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    // @Headers("content-type: application/json")
    // 게시글 목록 조회
    @GET("board/")
    fun getPostList(): Call<PostList>

    // 게시글 생성
    @POST("board/")
    fun createPost(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>

    // 게시글 자세히보기
    @GET("board/{boardid}/")
    fun getPostDetail(
        @Path("boardid") board_id: String
    ): Call<PostList>

    // 게시글 검색
    @GET("board/search")
    fun searchPostList(
        @Query("title") title: String
    ): Call<PostList>

    // 게시글 삭제
    @DELETE("board/{boardid}/")
    fun deletePostDetail(
        @Path("boardid") board_id: String
    ): Call<HashMap<String, String>>

    // 로그인
    @POST("user/login")
    fun login(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>

    // 회원가입
    @POST ("user/register")
    fun signUp(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>

    // 아이디 중복 확인
    @GET("user/confirm/name")
    fun confirmId(): Call<HashMap<String, String>>

    // 닉네임 중복 확인
    @GET("user/confirm/nickname")
    fun confirmNickname(): Call<HashMap<String, String>>
}