package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.frgments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.activities.DetailActivity
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.adapter.CountryListAdapter
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.adapter.TourListAdapter
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ToursAndCountriesVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.HomePresenter
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter.HomePresenterImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.HomeView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewpods.EmptyViewPod
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(),HomeView {


    private var param1: String? = null
    private var param2: String? = null

    private var compositeDisposable : CompositeDisposable= CompositeDisposable()
    lateinit var mTourListAdapter : TourListAdapter
    lateinit var mPopularListAdapter: CountryListAdapter
    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mPresenter : HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpSwipeRefresh()
        setUpTourRecyclerView()
        setUpCountryRecyclerView()
        setUpViewPod()

        mPresenter.onUiReady()


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

//    private fun testRxOperator(){
//        getOneToTenNumber().toObservable()
//            .filter { it%2==0 }
//            .subscribe {
//               Log.d("Filter",it.toString())
//            }
//
//        Observable.fromIterable(getOneToTenNumber())
//            .firstElement()
//            .subscribe {
//                Log.d("FirstElement",it.toString())
//            }
//        getOneToTenNumber().toObservable()
//            .lastElement()
//            .subscribe{
//                Log.d("LastElement",it.toString())
//            }
//        getOneToTenNumber().toObservable()
//            .skip(4)
//            .subscribe {
//                Log.d("skip",it.toString())
//            }
//        Observable.fromIterable(getOneToTenNumber())
//            .take(2)
//            .subscribe {
//                Log.d("take",it.toString())
//            }
//
//        //Transforming operator
//        Observable.fromIterable(getOneToTenNumber())
//            .map { it*10 }
//            .subscribe {
//                Log.d("Map",it.toString())
//            }
//
//        Observable.fromIterable(getOneToTenNumber())
//            .buffer(3)
//            .subscribe {
//                Log.d("buffer",it.toString())
//            }
//
//        getOneToTenNumber().toObservable()
//            .scan {a,b -> a+b}
//            .subscribe {
//                Log.d("scan",it.toString())
//            }
//
//        (1..100).toList().toObservable()
//            .skip(50)
//            .filter { it % 2 != 0 }
//            .map { it*20 }
//            .subscribe {
//                Log.d("Hello",it.toString())
//            }
//
//
//        //Conditional operator
//
//        getOneToTenNumber().toObservable()
//            .all { it != 101 }
//            .subscribe { result ->
//                Log.d("All",result.toString())
//            }
//
//        Observable.fromIterable(getOneToTenNumber())
//            .skipWhile { it != 56 }
//            .subscribe {
//                Log.d("SkipWhile",it.toString())
//            }
//
//        Observable.fromIterable(getOneToTenNumber())
//            .takeWhile { it != 12 }
//            .subscribe {
//                Log.d("TakeWhile",it.toString())
//            }
//
//        Observable.fromIterable(getOneToTenNumber())
//            .reduce { t1: Int, t2: Int -> t1+t2 }
//            .subscribe {
//                Log.d("Reduce",it.toString())
//            }
//    }


    private fun setUpTourRecyclerView(){
        mTourListAdapter= TourListAdapter(mPresenter)
        val linearLayoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recycler_popular.layoutManager=linearLayoutManager
        recycler_popular.adapter= mTourListAdapter
    }

    private fun setUpCountryRecyclerView(){
        mPopularListAdapter = CountryListAdapter(mPresenter)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recycler_country.layoutManager = layoutManager
        recycler_country.adapter = mPopularListAdapter
    }

    private fun setUpSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh()
        }

    }

    private fun setUpPresenter(){
      mPresenter=ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(
            "There are no news available",
            "https://point-broadband.com/wp-content/uploads/2017/06/No-data-caps-graphic-e1497904686711.png"
        )
    }

    override fun displayToursList(toursList: ToursAndCountriesVO) {

      mTourListAdapter.setNewData(toursList.tours.toMutableList())
        mPopularListAdapter.setNewData(toursList.country.toMutableList())
    }

    override fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    override fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing=true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing=false
    }

    override fun nagvigateToDetail(name: String) {
      startActivity(context?.let { DetailActivity.newIntent(it,name) })
    }

    override fun showErrorMessage(message: String) {
      showErrorMessage(message)
    }

//    private fun getOneToTenNumber() : List<Int>{
//        return (1..100).toList()
//    }
}
