ScrollToTop
========

I noticed there is no clear solution posted anywhere online for this, so I made one. Current methods seem to constantly recalculate the top using absolute positioning, but this wastes a ton of CPU. This simply switches positioning to fixed once the 'fixed' element in at the top, which is similar to what sites such as facebook do. 
