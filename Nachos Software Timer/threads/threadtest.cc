// threadtest.cc
//  Tests for project 1.
//
// Notes:
//  1. Your global SWTimer object should be named 'mytimer'. Declare
//     and initialze 'mytimer' in system.h and system.cc. (Refer to the
//     declaration and initialization of hardware Timer in those two
//     files, don't forget system.h!)
//  2. In you SWTimer::GoToSleepFor() implementation, print the *actual*
//     duration the calling thread is sleeping for or the reason it is
//     terminated.

#include "copyright.h"
#include "system.h"

//----------------------------------------------------------------------
// IdleThread
// Doesn't do anything.
//----------------------------------------------------------------------

void
IdleThread(int dummy)
{
  while (1) {
    currentThread->Yield();
  }
}

//----------------------------------------------------------------------
// WorkingThread
// Advances Nachos time by calling interrupt->OneTick().
//----------------------------------------------------------------------

void
WorkingThread(int dummy)
{
  while (1) {
    interrupt->OneTick();
    currentThread->Yield();
  }
}

//----------------------------------------------------------------------
// NappingThread
// Goes to sleep for 'count' times, 2 msec each time.
//----------------------------------------------------------------------

void
NappingThread(int count)
{
  int i;
  for (i = 0; i < count; ++i) {
    if (mytimer->GoToSleepFor(2) < 0) {
      printf("*** %s didn't sleep.\n", currentThread->getName());
    }
    else {
      printf("*** %s just woke up.\n", currentThread->getName());
    }
  }
}

//----------------------------------------------------------------------
// SleepingThread
// Goes to sleep for 3 times, 'duration' msec each time.
//----------------------------------------------------------------------

void
SleepingThread(int duration)
{
  int i;
  for (i = 0; i < 3; ++i) {
    if (mytimer->GoToSleepFor(duration) < 0) {
      printf("*** %s didn't sleep.\n", currentThread->getName());
    }
    else {
      printf("*** %s just woke up.\n", currentThread->getName());
    }
  }
}

//----------------------------------------------------------------------
// ThreadTest
// Set up threads for testing.
//----------------------------------------------------------------------

void
ThreadTest()
{
  Thread *idle = new Thread("Idle thread");
  idle->Fork(IdleThread, 0);
    
  Thread *work = new Thread("Working thread");
  work->Fork(WorkingThread, 0);
    
  Thread *napA = new Thread("Napping thread A");
  napA->Fork(NappingThread, 3);
    
  Thread *napB = new Thread("Napping thread B");
  napB->Fork(NappingThread, 4);
    
  Thread *sleepA = new Thread("Sleeping thread A");
  sleepA->Fork(SleepingThread, 20);
    
  Thread *sleepB = new Thread("Sleeping thread B");
  sleepB->Fork(SleepingThread, 15);
}
