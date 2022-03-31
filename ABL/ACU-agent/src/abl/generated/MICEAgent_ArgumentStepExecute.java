package abl.generated;

import abl.runtime.*;
import wm.WME;
import wm.WorkingMemorySet;
import wm.WMEIndex;
import wm.TrackedWorkingMemory;
import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import abl.learning.*;
import abl.wmes.*;
import abl.actions.*;
import abl.sensors.*;
import java.lang.*;
public class MICEAgent_ArgumentStepExecute {
   static public Object[] argumentExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$stepID) {
         case 3: {
            // startEventThread_1Step2
            final Object[] args = new Object[1];
            args[0] = new String(((java.lang.String)__$behaviorFrame[0]));
            return args;
         }
         case 11: {
            // testBehavior_1Step1
            final Object[] args = new Object[1];
            args[0] = new String(((java.lang.String)__$behaviorFrame[0]));
            return args;
         }
         case 12: {
            // testBehavior_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(1000);
            return args;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
