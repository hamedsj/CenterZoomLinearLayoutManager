package me.hamedsj.centerzoomlayoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.math.abs
import kotlin.math.min

class CenterZoomLinearLayoutManager : LinearLayoutManager {
    var percentDiffFromCenter : Float = 0.8f
    var minScale : Float = 0.1f
    constructor(context: Context?) : super(context) {}
    constructor(
        context: Context?,
        orientation: Int,
        reverseLayout: Boolean
    ) : super(context, orientation, reverseLayout) {

    }

    override fun scrollHorizontallyBy(dx: Int, recycler: Recycler, state: RecyclerView.State): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        val mid = width / 2f
        val d1 = percentDiffFromCenter * mid
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val left = getDecoratedLeft(child!!).toFloat()
            val right = getDecoratedRight(child).toFloat()
            val cMid = (left + right) / 2f
            val diffMid = abs(mid - cMid)
            val d = min(d1, diffMid)
            val finalScale = 1f + -1 * minScale * d / d1
            child.scaleX = finalScale
            child.scaleY = finalScale
        }
        return scrolled
    }

    override fun scrollVerticallyBy(dy: Int, recycler: Recycler?, state: RecyclerView.State?): Int {
        val scrolled = super.scrollHorizontallyBy(dy, recycler, state)
        val mid = width / 2f
        val d1 = percentDiffFromCenter * mid
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val top = getDecoratedTop(child!!).toFloat()
            val bottom = getDecoratedBottom(child).toFloat()
            val cMid = (top + bottom) / 2f
            val diffMid = abs(mid - cMid)
            val d = min(d1, diffMid)
            val finalScale = 1f + -1 * minScale * d / d1
            child.scaleX = finalScale
            child.scaleY = finalScale
        }
        return scrolled
    }

    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        if (orientation==HORIZONTAL) {
            scrollHorizontallyBy(0, recycler, state)
        }else{
            scrollVerticallyBy(0, recycler, state)
        }
    }
}