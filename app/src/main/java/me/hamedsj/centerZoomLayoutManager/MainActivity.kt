package me.hamedsj.centerZoomLayoutManager

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import me.hamedsj.centerzoomlayoutmanager.CenterZoomLinearLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mList = listOf(
            RecyclerViewItem(ContextCompat.getDrawable(applicationContext,R.drawable.rect1)),
            RecyclerViewItem(ContextCompat.getDrawable(applicationContext,R.drawable.rect2)),
            RecyclerViewItem(ContextCompat.getDrawable(applicationContext,R.drawable.rect3)),
            RecyclerViewItem(ContextCompat.getDrawable(applicationContext,R.drawable.rect4)),
            RecyclerViewItem(ContextCompat.getDrawable(applicationContext,R.drawable.rect5))
        )
        val adapter = TestAdapter(mList)
        val centerZoomLinearLayoutManager = CenterZoomLinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        centerZoomLinearLayoutManager.minScale = 0.2f
        recycler.layoutManager = centerZoomLinearLayoutManager
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler)
        recycler.adapter = adapter
    }
}
data class RecyclerViewItem(val bg: Drawable?)