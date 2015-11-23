Template.topbar.events({
  'click .log-out':function(){
    Session.set('in', false)
  },
  'click .go-back':function(){
    Router.go('/')
  }
})

Template.topbar.helpers({
  notHome:function(){
    console.log(Router.current().route.getName())
    return Router.current().route.getName() != 'home';
  }
})
