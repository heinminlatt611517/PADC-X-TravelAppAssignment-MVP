package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.impls

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.MockToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModel
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.dummy.getDummyTours
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.HomePresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.android.schedulers.AndroidSchedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class HomePresenterImplTest {

    private lateinit var mpresenter : HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView : HomeView

    private lateinit var mToursModel: ToursModel

    @Before
    fun setUpPresenter(){


        MockKAnnotations.init(this)

       ToursModelImpl.initModel(ApplicationProvider.getApplicationContext())

        mToursModel=MockToursModelImpl

        mpresenter= HomePresenterImpl()

        mpresenter.initPresenter(mView)

    }

    @Test
    fun NavigateToDetail(){
        val countryOne = CountryVO()
        countryOne.scoresandreviews= listOf()
        countryOne.location=""
        countryOne.id=1
        countryOne.description=""
        countryOne.averagerating=0.0
        countryOne.photos= listOf()
        countryOne.name="Test"


       mpresenter.onTapToursItem("")

        verify {
           mView.nagvigateToDetail("")
        }
    }

    @Test
    fun onUIReady_showTourList(){

        mpresenter.onUiReady()


           mToursModel.getAllTours()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    verify {
                        mView.displayToursList(it)
                    }
           
        }

    }




}