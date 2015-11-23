Template.basicLayout.helpers({
  'in':function(){
    return Session.get('in')
  },
  'pre':function(){
    return Router.current().route.getName() == 'present'
  }
})
