package com.wednesday.template.interactor

import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.base.CoroutineContextControllerImpl
import com.wednesday.template.interactor.base.datetime.UIDateMapper
import com.wednesday.template.interactor.base.datetime.UIDateMapperImpl
import com.wednesday.template.interactor.localFm.FavouriteAlbumInteractor
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.interactor.localFm.favourite.FavouriteAlbumInteractorImpl
import com.wednesday.template.interactor.localFm.search.SearchAlbumInteractorImpl
import com.wednesday.template.interactor.localFm.search.UIAlbumMapper
import com.wednesday.template.interactor.localFm.search.UIAlbumMapperImpl
import com.wednesday.template.interactor.localFm.search.UIAlbumSearchMapper
import com.wednesday.template.interactor.localFm.search.UIAlbumSearchMapperImpl
import com.wednesday.template.interactor.weather.FavouriteWeatherInteractor
import com.wednesday.template.interactor.weather.SearchCityInteractor
import com.wednesday.template.interactor.weather.UICityMapper
import com.wednesday.template.interactor.weather.UICityMapperImpl
import com.wednesday.template.interactor.weather.favourite.FavouriteWeatherInteractorImpl
import com.wednesday.template.interactor.weather.favourite.UIWeatherListMapper
import com.wednesday.template.interactor.weather.favourite.UIWeatherListMapperImpl
import com.wednesday.template.interactor.weather.search.SearchCityInteractorImpl
import com.wednesday.template.interactor.weather.search.UICitySearchResultsMapper
import com.wednesday.template.interactor.weather.search.UICitySearchResultsMapperImpl
import org.koin.dsl.module

val interactorModule = module {

    // Date Time
    single<UIDateMapper> { UIDateMapperImpl(get()) }

    // Coroutine
    single<CoroutineContextController> { CoroutineContextControllerImpl() }

    // Weather
    single<UICityMapper> { UICityMapperImpl() }

    single<UICitySearchResultsMapper> { UICitySearchResultsMapperImpl(get()) }

    single<UIWeatherListMapper> { UIWeatherListMapperImpl() }

    factory<FavouriteWeatherInteractor> { FavouriteWeatherInteractorImpl(get(), get(), get(), get(), get(), get(), get(), get()) }

    factory<SearchCityInteractor> { SearchCityInteractorImpl(get(), get(), get(), get()) }

    // Last FM

    single<UIAlbumMapper> { UIAlbumMapperImpl() }

    single<UIAlbumSearchMapper> { UIAlbumSearchMapperImpl(get()) }

    factory<SearchAlbumInteractor> { SearchAlbumInteractorImpl(get(), get(), get(), get()) }

    factory<FavouriteAlbumInteractor> { FavouriteAlbumInteractorImpl(get(), get(), get(), get(), get(), get()) }
}
