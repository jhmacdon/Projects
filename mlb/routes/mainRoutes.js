// Home Route
Router.route('/', {
  name:'home',
  action: function () {
    if(!Session.get('in')){
      this.render('home');
      SEO.set({ title: 'Home - ' + Meteor.App.NAME });
    } else {
      this.render('dashboard')
      SEO.set({title: 'Dashboard - ' + Meteor.App.NAME})
    }

  }
});

Router.route('/user', {
  name:'user'
})

Router.route('/seat', {
  name:'seat'
})

Router.route('/money', {
  name:'money'
})

Router.route('/deals', {
  name:'deals'
})

Router.route('/help', {
  name:"help"
})

Router.route('/account', {
  name:"account"
})

Router.route('/present', {
  name:"present",
  setLayout:null
})
