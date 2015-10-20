// NOTE: pseudocode provided is just an option, feel free to implement in different ways

#include "swtimer.h"
#include "system.h"
#include "scheduler.h"
//void
//SWTimer(){
//  List *sleepList = new List();
//*}
List *sleepList;
int done = 0;

SWTimer::SWTimer(){
  sleepList = new List();
}
int
SWTimer::GoToSleepFor(int howLong) {
  if(howLong % 2 == 0){
    currentThread->sleep_count++;
    //printf("%d", currentThread->sleep_count);
    if(currentThread->sleep_count < 4){
      //printf("%d\n", currentThread->sleep_time);
      if(currentThread->sleep_time < 30){
	if(currentThread->sleep_time + howLong >= 30){
	  printf("%s wanted to sleep for %d, put to sleep for %d instead\n", currentThread->getName(), howLong, 30-currentThread->sleep_time);
	  howLong = 30 - currentThread->sleep_time;
	  currentThread->sleep_time = 30;
	} else {
	  currentThread->sleep_time += howLong;
	}
	
	IntStatus oldLevel = interrupt->SetLevel(IntOff);
	sleepList->SortedInsert(currentThread, stats->totalTicks + howLong*50);
	currentThread->Sleep();
	(void) interrupt->SetLevel(oldLevel);
      } else {
	printf("%s is too lazy and the system terminated it forever!\n", currentThread->getName());
	return -1;
      }
    } else {
      printf("%s is too lazy and the system terminated it forever!\n", currentThread->getName());
      return -1;
    }
  } else {
    return -1;
  }
  // ...
  //
  // ticks = howLong in number of ticks
  // wakeup_time = stats->totalTicks + ticks
  //
  // ...
  return 0;
}


void
SWTimer::WakeUp() {
  done = 0;
  while(done == 0){
    //printf("p");
    int when;
    if(!sleepList->IsEmpty()){
      Thread *wake = (Thread *)sleepList->SortedRemove(&when);
      if(wake != NULL){
	if(when <= stats->totalTicks){
	  IntStatus oldLevel = interrupt->SetLevel(IntOff);
	  scheduler->ReadyToRun(wake);
	  (void) interrupt->SetLevel(oldLevel);
	}
	else{
	  sleepList->SortedInsert(wake, when);
	  done = 1;
	}
	if(sleepList->IsEmpty()){
	  done = 1;
	}
      } else {
	//printf("stuck in NULL");
	done = 1;
      }
    } else {
      //printf("stuck in !sleeplist");
      done = 1;
    }
  }
  // for each sleeping thread in sleepList:
  //   if (stats->totalTicks == wakeup_time):
  //     wake thread up
}

