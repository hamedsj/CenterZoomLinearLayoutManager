# CenterZoomLinearLayoutManager
[![](https://jitpack.io/v/hamedsj/CenterZoomLinearLayoutManager.svg)](https://jitpack.io/#hamedsj/CenterZoomLinearLayoutManager)

A LinearLayoutManager with ability to zoom center child

![](screencast.gif)

## Usage
1.Add CenterZoomLinearLayoutManager's dependency into your `build.gradle` file
```gradle
dependencies {
  implementation 'com.github.hamedsj:CenterZoomLinearLayoutManager:0.0.1'
}
```

2.Use CenterZoomLinearLayoutManager as LayoutManager of RecyclerView
```java
//Initialize instance of centerZoomLinearLayoutManager
CenterZoomLinearLayoutManager myLayoutManager = new CenterZoomLinearLayoutManager(getApplicationContext())

//Change maximum distance of item to return to (1 - MinScale)x of it's size by percentage of width/height of recyclerView
//Default PercentDiffFromCenter is 0.8
myLayoutManager.setPercentDiffFromCenter(0.4f);

//Change MinScale
//Default MinScale is 0.1
myLayoutManager.setMinScale(0.2f);

//Set layoutManager for recyclerView
yourRecyclerView.setLayoutManager(myLayoutManager);
```
