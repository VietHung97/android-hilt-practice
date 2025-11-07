package com.frank.practicehilt.di

import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StackOverFlowSite() //pham vi dung stackover


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonPlaceHolderFlowSite() //pham vi dung json place holder