(function() {
  var verticalshift = function(fromY, toY) {
      return function(options) {
          options = _.extend({
            duration: 500,
            easing: 'ease-in-out'
          }, options);
          return {
            insertElement: function(node, next, done) {
              var $node = $(node);
              $node
                .css('transform', 'translateY(' + fromY + ')')
                .insertBefore(next)
                .velocity({
                  translateY: [0, fromY]
                }, {
                  easing: options.easing,
                  duration: options.duration,
                  queue: false,
                  complete: function() {
                      $node.css('transform', '');
                      done();
                    }
                });
            },
            removeElement: function(node, next, done) {
                $(node).velocity('fadeOut', function() {
                  $(this).remove();
                });
              }
          }
        }
    }
  Momentum.registerPlugin('bottom-to-top', verticalshift('500%', '-500%'));
}).call(this);
