package com.Yi.videoplayer.di.AppModule

import android.app.Application
import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import com.Yi.videoplayer.network.UserService
import com.Yi.videoplayer.network.VideoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val OFFICIAL_URL:String = "http://123.56.73.64:8888/"
    /**
     *提供OkHttpClient对象,在其中添加拦截器，给header添加cookie，为未来需要cookie的接口做准备 */
    @Singleton
    @Provides
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(3000L,TimeUnit.MILLISECONDS)
            .writeTimeout(3000L,TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    /**
     * 在目录中使用Hilt提供多个相对类型的实例对象，通过"@Named"注解进行区分
     * 也可以通过"@Qualifier"限定符定义新的注解进行区分*/

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(OFFICIAL_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserService(retrofit:Retrofit): UserService{
        return retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun provideVideoService(retrofit:Retrofit): VideoService{
        return retrofit.create(VideoService::class.java)
    }




}