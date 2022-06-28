package com.wednesday.template.service

import com.wednesday.template.service.base.getRoomDatabase
import com.wednesday.template.service.base.lastFm.getLastFMRetrofit
import com.wednesday.template.service.base.lastFm.getLastFmRoomDatabase
import com.wednesday.template.service.base.lastFm.interceptors.LastFMApiKeyInterceptor
import com.wednesday.template.service.base.retrofit.getOpenWeatherRetrofit
import com.wednesday.template.service.base.retrofit.interceptors.OpenWeatherApiKeyInterceptor
import com.wednesday.template.service.lastFm.LastFmLocalService
import com.wednesday.template.service.lastFm.LastFmLocalServiceImpl
import com.wednesday.template.service.lastFm.LastFmRemoteService
import com.wednesday.template.service.openWeather.OpenWeatherLocalServiceImpl
import com.wednesday.template.service.room.AndroidTemplateDatabase
import com.wednesday.template.service.room.LastFmDatabase
import com.wednesday.template.service.weather.OpenWeatherLocalService
import com.wednesday.template.service.weather.OpenWeatherRemoteService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {

    // Retrofit
    factory { OpenWeatherApiKeyInterceptor() }

    single { getOpenWeatherRetrofit(get(), get<OpenWeatherApiKeyInterceptor>()) }

    // Room
    single { getRoomDatabase(get()) }

    // OpenWeather
    single { getWeatherRemoteService(get()) }

    single<OpenWeatherLocalService> { getWeatherLocalService(get()) }

    // Retrofit lastFm
    factory { LastFMApiKeyInterceptor() }

    single(named("LastFmRetrofit")) { getLastFMRetrofit(get(), get<LastFMApiKeyInterceptor>()) }

    // lastFm retrofit object
    single { getLastFmRemoteService(get(named("LastFmRetrofit"))) }

    // lastFm room
    single { getLastFmRoomDatabase(get())}

    single<LastFmLocalService> { getLastFmLocalService(get())}
}

fun getWeatherLocalService(database: AndroidTemplateDatabase): OpenWeatherLocalServiceImpl {
    return database.databaseDao()
}

fun getWeatherRemoteService(retrofit: Retrofit): OpenWeatherRemoteService {
    return retrofit.create(OpenWeatherRemoteService::class.java)
}

fun getLastFmRemoteService(retrofit: Retrofit): LastFmRemoteService {
    return retrofit.create(LastFmRemoteService::class.java)
}

fun getLastFmLocalService(database : LastFmDatabase) : LastFmLocalServiceImpl{
    return database.databaseDao()
}