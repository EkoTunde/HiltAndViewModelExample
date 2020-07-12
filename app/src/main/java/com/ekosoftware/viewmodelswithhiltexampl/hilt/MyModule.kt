package com.ekosoftware.viewmodelswithhiltexampl.hilt

import com.ekosoftware.viewmodelswithhiltexampl.data.SomeDataSource
import com.ekosoftware.viewmodelswithhiltexampl.domain.SomeRepoInterface
import com.ekosoftware.viewmodelswithhiltexampl.domain.SomeRepoInterfaceImpl
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
    fun provideSomeInterface(someDataSource: SomeDataSource) : SomeRepoInterface {
        return SomeRepoInterfaceImpl(
            someDataSource
        )
    }

}