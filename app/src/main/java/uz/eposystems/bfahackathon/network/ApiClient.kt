package uz.eposystems.bfahackathon.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
class ApiClient(context: Context) {

    private var baseUrl = "https://mobile.turbosoft.uz"

    private val loggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val baseInterceptor: Interceptor = Interceptor.invoke { chain ->
        val newUrl = chain
            .request()
            .url
            .newBuilder()
            .build()
        val request = chain
            .request()
            .newBuilder()
            .url(newUrl)
            .build()
        return@invoke chain.proceed(request)
    }
    private val client: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(Interceptor {
            val request: Request = it.request().newBuilder().build()
            return@Interceptor it.proceed(request)
        })
        .addInterceptor(
            ChuckerInterceptor.Builder(context)
                .collector(ChuckerCollector(context))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )
        .addInterceptor(loggingInterceptor)
        .addInterceptor(baseInterceptor)
        .build()

    fun retrofitService(): ApiInterface = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(ApiInterface::class.java)
}