Template.user.helpers({
  'items':function(){
    return [
      {'icon':'trophy', 'title':'Attend 50 Games', 'text':'You have attended 45/50 games', 'status':'not'},
      {'icontext':'3-2', 'title':'Attended NYY @ SEA, Mariners win!', 'text':'Highlight: Cano 450 foot HR', 'status':'done'},
      {'icon':'shopping cart', 'title':'Visited 9/10 Concession Stands', 'text':'Visit 1 more concession stand!', 'status':'not'},
      {'icon':'trophy', 'title':'Out on the Road', 'text':'You attended a Mariners game on the road!', 'status':'trophybg'},
      {'icontext':'4-1', 'title':'Attended SEA @ HOU, Mariners fall to Astros', 'text':'Highlight: Mariners pull 5-4-3 triple play', 'status':'done'},
      {'icon':'shopping cart', 'title':'Visited 8/10 Concession Stands', 'text':'Visit 2 more concession stand!', 'status':'not'},
      {'icontext':'2-1', 'title':'Attended HOU @ SEA, Mariners win!', 'text':'Highlight: Cruz hits 2 HR', 'status':'done'},
    ]
  }
})

Template.money.rendered = function(){
  Session.set('con',25)
  Session.set('tic',150)
}

Template.money.helpers({
  con:function(){
    return Session.get('con')
  },
  tic:function(){
    return Session.get('tic')
  }
})

Template.money.events({
  'click #conclick':function(){
    amount = Session.get('con')
    console.log($('#conmon').val())
    amount += parseInt($('#conmon').val())
    Session.set('con', amount)
    $('#conmon').val("")
  },
  'click #ticclick':function(){
    amount = Session.get('tic')
    amount += parseInt($('#ticmon').val())
    Session.set('tic', amount)
    $('#ticmon').val("")
  }
})
