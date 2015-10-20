(function() {
  var verticalshift = function(fromY, toY) { // 2
      return function(options) { // 3
          options = _.extend({ // 4
            duration: 500, // 5
            easing: 'ease-in-out' // 6
          }, options); // 7
          // 8
          return { // 9
            insertElement: function(node, next, done) { // 10
              var $node = $(node); // 11
              // 12
              $node // 13
                .css('transform', 'translateY(' + fromY + ')') // 14
                .insertBefore(next) // 15
                .velocity({ // 16
                  translateY: [0, fromY] // 17
                }, { // 18
                  easing: options.easing, // 19
                  duration: options.duration, // 20
                  queue: false, // 21
                  complete: function() { // 22
                      $node.css('transform', ''); // 23
                      done(); // 24
                    } // 25
                }); // 26
            }, // 27
            removeElement: function(node, next, done) { // 9
                $(node).velocity('fadeOut', function() { // 10
                  $(this).remove(); // 11
                }); // 12
              } // 42
          } // 43
        } // 44
    } // 45
    // 46
  Momentum.registerPlugin('bottom-to-top', verticalshift('500%', '-500%'));

}).call(this);
