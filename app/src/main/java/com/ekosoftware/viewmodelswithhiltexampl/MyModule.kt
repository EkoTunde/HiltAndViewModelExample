package com.ekosoftware.viewmodelswithhiltexampl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
class MyModule {

    @ActivityRetainedScoped
    @Provides
    fun provideSomeDataSource() : SomeDataSource {
        return SomeDataSource()
    }

    @ActivityRetainedScoped
    @Provides
    fun provideSomeInterface(someDataSource: SomeDataSource) : SomeInterface {
        return SomeInterfaceImpl(someDataSource)
    }

}