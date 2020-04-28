package com.example.vkontakte_recyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    var bottomNavigation: BottomNavigationView? = null
    var recView: RecyclerView? = null
    var feedModelArrayList = ArrayList<FeedModel>()
    var adapterFeed: RecyclerViewAdapterFeed<*>? = null
    private val TypefaceUtil: TypeFaceUtil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        TypeFaceUtil.overrideFont(applicationContext, "SANS_SERIF", "fonts/MontserratSemiBold.ttf")
        populaterecyclerview()
        recView = findViewById<View>(R.id.recy_feed) as RecyclerView
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recView!!.layoutManager = layoutManager
        adapterFeed = RecyclerViewAdapterFeed<Any?>(this, feedModelArrayList)
        recView!!.adapter = adapterFeed
    }

    private fun populaterecyclerview() {
        val fm1 = FeedModel("Good Life Inc", "два часа назад", "", "1K", R.drawable.profile11, R.drawable.post11, "34", "59", "30K")
        val fm2 = FeedModel("Astellia", "три часа назад", "⭐Доступ на серверы открыт! ⭐\n" +
                "\n" + "\n" +
                "Приглашаем всех желающих окунуться в волшебный мир Astellia! Доступ на серверы открыт для всех желающих, скачать клиент можно на странице: https://gamenet.ru/games/astellia/" + "\n" +
                "Благодарим всех за ожидание и желаем приятной игры!", "152", R.drawable.profile12, R.drawable.post12, "506", "10", "7K")
        val fm3 = FeedModel("Elation", "три часа назад", "-улыбочку!", "499", R.drawable.profile13, R.drawable.post13, "8", "5", "5K")
        val fm4 = FeedModel("E L E G A N T", "8 марта 21:05", "Криштиану Роналду вчера провёл свой 1000-й матч в карьере!\n" +
                "\n" +
                "За это время он забил 725 голов и завоевал 31 трофей. \uD83C\uDFC6\n" +
                "\n" +
                "Просто легенда \uD83D\uDC4F\uD83C\uDFFB", "2700", R.drawable.profile14, R.drawable.post14, "113", "56", "18K")
        val fm5 = FeedModel("ITProger", "5 марта 00:15", null, "763", R.drawable.profile5, R.drawable.post5, "160", "35", "14K")
        val fm6 = FeedModel("ЗЛОЙ НЕГР", "5 марта 04:59", "ПАКЕТ", "3K", R.drawable.profile15, R.drawable.post15, "216", "125", "44K")
        val fm7 = FeedModel("The Gentlemen", "3 марта 15:22", "Будтье смелее...", "132", R.drawable.profile16, R.drawable.post16, "2", "17", "1K")
        val fm8 = FeedModel("Дети Улиц", "3 марта 12:41", "Βepнocть - вoпpoc хapaктepa,\n" +
                "a нe oбcтoятeльcтв.\n" +
                "\n" +
                "—Дети Улиц.", "342", R.drawable.profile17, R.drawable.post17, "17", "104", "4К")
        val fm9 = FeedModel("UFC", "3 марта 00:56", "Макгрегор раскритиковал Махачева за высказывание о женщинах в ММА\n" +
                "\n" +
                "Экс-чемпион UFC Конор Макгрегор раскритиковал Ислама Махачева за его высказывание о женщинах в смешанных единоборствах.\n" +
                "\n" +
                "\uD83D\uDCAC«Полный кретин. Обвинённый за стероиды жулик, который сделает всё, чтобы избежать удара и затормозить ход поединка, обсуждает один из величайших боёв с разменом ударами, которые когда-либо проводили девушки-бойцы. Эти маленькие гремлины! Снова. Грязные крысы. Позор нашего спорта», – написал Макгрегор в своём «Твиттере».", "3K", R.drawable.profile19, R.drawable.post19, "677", "34", "60K")
        val fm10 = FeedModel("Строки пыльных книг", "1 марта 05:05", null, "4K", R.drawable.profilespk, R.drawable.postspg, "433", "72", "18K")
        feedModelArrayList.add(fm1)
        feedModelArrayList.add(fm2)
        feedModelArrayList.add(fm3)
        feedModelArrayList.add(fm4)
        feedModelArrayList.add(fm5)
        feedModelArrayList.add(fm6)
        feedModelArrayList.add(fm7)
        feedModelArrayList.add(fm8)
        feedModelArrayList.add(fm9)
        feedModelArrayList.add(fm10)
    }
}