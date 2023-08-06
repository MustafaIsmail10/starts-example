package mop;
import java.util.*;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging.Level;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import java.lang.ref.*;
import org.aspectj.lang.*;

public aspect ServiceLoader_MultipleConcurrentThreadsMonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public ServiceLoader_MultipleConcurrentThreadsMonitorAspect(){
	}

	// Declarations for the Lock
	static ReentrantLock ServiceLoader_MultipleConcurrentThreads_MOPLock = new ReentrantLock();
	static Condition ServiceLoader_MultipleConcurrentThreads_MOPLock_cond = ServiceLoader_MultipleConcurrentThreads_MOPLock.newCondition();

	pointcut MOP_CommonPointCut() : !within(com.runtimeverification.rvmonitor.java.rt.RVMObject+) && !adviceexecution() ;
	pointcut ServiceLoader_MultipleConcurrentThreads_gooduse(ServiceLoader s) : ((call(* ServiceLoader+.iterator()) || call(* ServiceLoader+.reload())) && target(s)) && MOP_CommonPointCut();
	before (ServiceLoader s) : ServiceLoader_MultipleConcurrentThreads_gooduse(s) {
		Thread t2 = Thread.currentThread();
		//ServiceLoader_MultipleConcurrentThreads_baduse
		//ServiceLoader_MultipleConcurrentThreads_gooduse
	}

	pointcut ServiceLoader_MultipleConcurrentThreads_create() : (call(ServiceLoader ServiceLoader+.load*(..))) && MOP_CommonPointCut();
	after () returning (ServiceLoader s) : ServiceLoader_MultipleConcurrentThreads_create() {
		Thread t2 = Thread.currentThread();
	}

}
