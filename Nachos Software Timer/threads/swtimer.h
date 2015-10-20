
#ifndef SWTIMER_H
#define SWTIMER_H

#include "list.h"

class SWTimer {
 public:
  SWTimer();
 int GoToSleepFor(int howLong); // this signature is required, because it is used in the
  // test file
  void WakeUp(); // this function optional
  // other functions as you need
  //void Check(int *pointer);
 private:
  List *sleepList; // this is optional
  // other variables as you need
  int done;
  //Thread *w;
};

#endif
