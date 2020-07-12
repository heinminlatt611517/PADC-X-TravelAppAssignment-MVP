package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.DetailPresenter
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.DetailPresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.HomePresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.DetailView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.root.TourApp.Companion.context
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_middle_layout.*

class DetailActivity : BaseActivity(),DetailView {


    private lateinit var mPresenter : DetailPresenter


    companion object{
        const val TOURS_NAME_EXTRA="Tours Name Extra"

        fun newIntent(context: Context, tourName : String) : Intent {
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra(TOURS_NAME_EXTRA,tourName)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        setUpPresenter()
        intent.getStringExtra(TOURS_NAME_EXTRA)?.let { mPresenter.getTourByName(this, it) }
    }

    private fun setUpPresenter(){
      mPresenter=ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun bindData(it : CountryVO){


        Glide.with(context!!)
            .load(it.photos[0])
            .into(iv_detail)
        tv_detail_dec.text=it.description
        tv_country_title.text=it.name
        tv_country_location.text=it.location
        tv_booking.text= it.scoresandreviews?.get(0)?.name
        tv_hotel.text= it.scoresandreviews?.get(1)?.name

        tv_booking_dec.text="Base on "+it.scoresandreviews?.get(0)?.total_reviews+" reviews"
        tv_booking_date.text= it.scoresandreviews?.get(0)?.score.toString()+"/"+it.scoresandreviews?.get(0)?.max_score.toString()

        tv_hotel_dec.text="Base on "+it.scoresandreviews?.get(1)?.total_reviews+" reviews"
        tv_hotel_date.text= it.scoresandreviews?.get(1)?.score.toString()+"/"+it.scoresandreviews?.get(1)?.max_score.toString()

        tv_ratingNo.text=it.averagerating.toString()
        rating.rating= it.averagerating.toFloat()
    }

    override fun DisplayToursDetail(country: CountryVO) {
        bindData(country)
    }

    override fun showErrorMessage(message: String) {
        showErrorMessage(message)
    }

}
