package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.impls

import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.MockToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModel
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.DetailPresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.HomePresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.DetailView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)



class DetailPresenterImplsTest {

    private lateinit var mPresenter : DetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView : DetailView

    private lateinit var mToursModel: ToursModel

    @Before
    fun setUpPresenter(){

        MockKAnnotations.init(this)

        ToursModelImpl.initModel(ApplicationProvider.getApplicationContext())

        mToursModel=MockToursModelImpl

        mPresenter= DetailPresenterImpl()

        mPresenter.initPresenter(mView)

        mPresenter.mTourModel=this.mToursModel

    }

    @Test
    fun onDetailUiReady() {

        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        val countryone = CountryVO()
        countryone.name="sea"
        countryone.averagerating=4.0
        countryone.description=""
        countryone.location="Yangon"

        Thread.sleep(2000)
        mPresenter.getTourByName(lifeCycleOwner,"sea")

        Thread.sleep(2000)
        verify {
            mView?.DisplayToursDetail(countryone)
        }
    }


}