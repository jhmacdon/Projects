Template.home.helpers({
  'feature' : function () {
    return [
      { 'text' : 'Identity', 'icon' : 'ticket', 'path' : '#packages' },
      { 'text' : 'Ease of Use', 'icon' : 'compass', 'path' : '#console-tool' },
      { 'text' : 'Social Features', 'icon' : 'group', 'color' : 'hover-orange', 'path' : '#html5' },
    ];
  },
  'package' : function () {
    return [
      { 'name' : 'Reach and record milestones'},
      { 'name' : 'Keep a log of the games and important events you witnessed'},
      { 'name' : 'Earn rewards for fan loyalty'}

    ];
  },
  'package2' : function () {
    return [
      {'name': 'The new gateway to the park'},
      {'name': 'Preload money onto the wristband'},
      {'name': 'RFID chip replaces need for your ticket, phone, and credit card within the stadium'},
      {'name': 'Buy tickets and upgrade seats anywhere and anytime'},
      {'name': 'Location Services help you find events in the park, reduce wait times, and even guide you to your seat'}
    ];
  },
  'package3' : function () {
    return [
      {'name': 'Share milestones and events on social media'},
      {'name': 'Find your friends at the stadium'},
      {'name': 'Connect with others and buy tickets at group rates'},
    ];
  },
  'bootstrapCode' : function () {
    return '<div class="btn btn-primary btn-lg"></div>';
  },
  'folder' : function () {
    return [
      { 'root' : 'client', 'children' :
        ['compatibility', 'config', ' lib', ' startup', ' stylesheets',
          'modules', 'views']
      },
      { 'root' : 'model' },
      { 'root' : 'routes' },
      { 'root' : 'private' },
      { 'root' : 'server', 'children' : ['fixtures', 'lib', 'publications', 'startup'] },
      { 'root' : 'public' },
      { 'root' : 'meteor-boilerplate' }
    ];
  }
});

Template.home.events({
});


Template.home.rendered = function () {
  // @see: http://stackoverflow.com/questions/5284814/jquery-scroll-to-div
  $('a[href*=#]:not([href=#])').click(function () {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }

    return true;
  });
};
