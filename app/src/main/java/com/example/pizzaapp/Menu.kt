package com.example.pizzaapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.pizzaapp.adapter.CategoriesAdapter
import com.example.pizzaapp.adapter.ThemealdbAdapter
import com.example.pizzaapp.model.responce.CategoriesResponce
import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.example.pizzaapp.viewmodel.CategoriesViewModel
import com.example.pizzaapp.viewmodel.ThemealdbViewModel

class Menu : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var rvThemealdbList: RecyclerView
    private lateinit var rvList_btn_category: RecyclerView
    private lateinit var vi: View
    private lateinit var themealdbViewModel: ThemealdbViewModel
    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vi = inflater.inflate(R.layout.fragment_menu, container, false)
        return vi
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initThemealdbApi("Beef")
        initCategoriesApi()
    }

    override fun onStart() {
        super.onStart()
        init_slider()
    }

    private fun init_slider(){
        viewPager2 = vi.findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.avd1)
        imageList.add(R.drawable.avd2)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 2
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        setUpTransformer()
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer{ page, position ->
            if(position == 1F || position == -1F ) {
                page.alpha = 0.6F
            } else if (position == 0F){
                page.alpha = 1F
            }
        }
        viewPager2.setPageTransformer(transformer)
    }

    fun initThemealdbApi(querry: String){
        themealdbViewModel = ViewModelProvider(this).get(ThemealdbViewModel::class.java)

        themealdbViewModel.getApiData(querry)

        themealdbViewModel.themealDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initCategoriesApi(){
        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

        categoriesViewModel.getApiData()

        categoriesViewModel.categoriesDataList.observe(this, Observer {
            initAdapterCat(it)
        })
    }

    private fun initAdapter(data: ThemealdbResponce){
        rvThemealdbList = vi.findViewById(R.id.rvThemealdbList)
        rvThemealdbList.layoutManager = LinearLayoutManager(activity)
        val adapter = ThemealdbAdapter(data)
        rvThemealdbList.adapter = adapter
    }

    private fun initAdapterCat(data: CategoriesResponce){
        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)

        rvList_btn_category = vi.findViewById(R.id.rvList_btn_category)
        rvList_btn_category.layoutManager = layoutManager

        val adapter = CategoriesAdapter(data, this::initThemealdbApi)

        rvList_btn_category.adapter = adapter
    }
}