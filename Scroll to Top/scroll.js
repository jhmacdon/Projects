$(window).scroll(function (e) {
  try{ //if run on a page without a fixed element, no error will be thrown
    e.preventDefault();
    var d2t = 50; //distance from top at which element should stick
    var distance = d2t + $('.fixed').offset().top; //original distance from top
    if ($(window).scrollTop() >= distance-(d2t*2)) {
      if($('.fixed').css('position') != 'fixed'){//don't waste cpu if already stuck
      $('.fixed').css('position', 'fixed');
      $('.fixed').css('top', d2t)
    }
  } else {
    $('.fixed').css('position', 'relative');
    $('.fixed').css('top', 0);
  }
} catch(e) {/*element not on page*/}
});
