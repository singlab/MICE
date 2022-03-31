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

public class MICEAgent extends BehavingEntity {
   int botSpeed = 2;
   public final static Rule[] __$allRuleArray = {};
   public final static Rulegroup[] __$allRulegroupArray = {};
   private final static Object[] __$tempObjArray = new Object[1];
   private final static Class[] __$sensorFactoryArgArray = new Class[1];
   private final static Class[] __$behFactoryArgArray = new Class[7];
   private final static Class[] __$preconditionArgArray = new Class[4];
   private final static Class[] __$conditionalTestArgArray = new Class[3];
   private final static Class[] __$continuousConditionArgArray = new Class[3];
   private final static Class[] __$stepFactoryArgArray = new Class[3];
   private final static Class[] __$argumentStepExecuteArgArray = new Class[3];
   private final static Class[] __$mentalStepExecuteArgArray = new Class[4];
   private final static Class[] __$reinforcementSignalArgArray = new Class[3];
   private final static Class[] __$rlPolicyArgArray = new Class[6];
   private final static Class[] __$stateWMEArgArray = new Class[3];
   private final static Class[] __$successConditionArgArray = new Class[3];
   private final static Class[] __$analysisArgArray = new Class[1];
   private final static Class __$MICEAgent_BehaviorFactories_rfield;
   final static Method __$behaviorFactory0_rfield;
   private final static Class __$MICEAgent_Preconditions_rfield;
   final static Method __$precondition0_rfield;
   private final static Class __$MICEAgent_PreconditionSensorFactories_rfield;
   final static Method __$preconditionSensorFactory0_rfield;
   private final static Class __$MICEAgent_ConditionalTests_rfield;
   final static Method __$conditionalTest0_rfield;
   private final static Class __$MICEAgent_ConditionalTestSensorFactories_rfield;
   final static Method __$conditionalTestSensorFactory0_rfield;
   private final static Class __$MICEAgent_ContextConditions_rfield;
   final static Method __$contextCondition0_rfield;
   private final static Class __$MICEAgent_ContextConditionSensorFactories_rfield;
   final static Method __$contextConditionSensorFactory0_rfield;
   private final static Class __$MICEAgent_StepFactories_rfield;
   final static Method __$stepFactory0_rfield;
   private final static Class __$MICEAgent_ArgumentStepExecute_rfield;
   final static Method __$argumentExecute0_rfield;
   private final static Class __$MICEAgent_MentalStepExecute_rfield;
   final static Method __$mentalExecute0_rfield;
   private final static Class __$MICEAgent_SuccessTests_rfield;
   final static Method __$successTest0_rfield;
   private final static Class __$MICEAgent_SuccessTestSensorFactories_rfield;
   final static Method __$successTestSensorFactory0_rfield;
   private final static Class __$MICEAgent_ReinforcementSignals_rfield;
   final static Method __$reinforcementSignal0_rfield;
   private final static Class __$MICEAgent_ReinforcementSignalSensorFactories_rfield;
   final static Method __$reinforcementSignalSensorFactory0_rfield;
   private final static Class __$MICEAgent_RLPolicy_rfield;
   final static Method __$rlPolicy0_rfield;
   private final static Class __$MICEAgent_StateWMEs_rfield;
   final static Method __$stateWME0_rfield;
   private final static Class __$MICEAgent_StateWMESensorFactories_rfield;
   final static Method __$stateWMESensorFactory0_rfield;
   private final static Class __$MICEAgent_SuccessConditions_rfield;
   final static Method __$successCondition0_rfield;
   private final static Class __$MICEAgent_SuccessConditionSensorFactories_rfield;
   final static Method __$successConditionSensorFactory0_rfield;
   private final static Class __$MICEAgent_Analysis_rfield;
   final static Method __$analysis0_rfield;

   static {
      try {
         __$sensorFactoryArgArray[0] = Integer.TYPE;
         __$behFactoryArgArray[0] = Integer.TYPE;
         __$behFactoryArgArray[1] = __$tempObjArray.getClass();
         __$behFactoryArgArray[2] = Class.forName("java.util.Map");
         __$behFactoryArgArray[3] = Class.forName("abl.runtime.GoalStep");
         __$behFactoryArgArray[4] = Class.forName("java.lang.String");
         __$behFactoryArgArray[5] = Class.forName("abl.runtime.BehavingEntity");
         __$behFactoryArgArray[6] = Class.forName("abl.runtime.__BehaviorDesc");
         __$preconditionArgArray[0] = Integer.TYPE;
         __$preconditionArgArray[1] = __$tempObjArray.getClass();
         __$preconditionArgArray[2] = Class.forName("java.util.Map");
         __$preconditionArgArray[3] = Class.forName("abl.runtime.BehavingEntity");
         __$conditionalTestArgArray[0] = Integer.TYPE;
         __$conditionalTestArgArray[1] = __$tempObjArray.getClass();
         __$conditionalTestArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$continuousConditionArgArray[0] = Integer.TYPE;
         __$continuousConditionArgArray[1] = __$tempObjArray.getClass();
         __$continuousConditionArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$stepFactoryArgArray[0] = Integer.TYPE;
         __$stepFactoryArgArray[1] = Class.forName("abl.runtime.Behavior");
         __$stepFactoryArgArray[2] = __$tempObjArray.getClass();
         __$argumentStepExecuteArgArray[0] = Integer.TYPE;
         __$argumentStepExecuteArgArray[1] = __$tempObjArray.getClass();
         __$argumentStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$mentalStepExecuteArgArray[0] = Integer.TYPE;
         __$mentalStepExecuteArgArray[1] = __$tempObjArray.getClass();
         __$mentalStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$mentalStepExecuteArgArray[3] = Class.forName("abl.runtime.MentalStep");
         __$reinforcementSignalArgArray[0] = Integer.TYPE;
         __$reinforcementSignalArgArray[1] = __$tempObjArray.getClass();
         __$reinforcementSignalArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$rlPolicyArgArray[0] = Integer.TYPE;
         __$rlPolicyArgArray[1] = Class.forName("java.lang.Object");
         __$rlPolicyArgArray[2] = Integer.TYPE;
         __$rlPolicyArgArray[3] = Class.forName("java.lang.Object");
         __$rlPolicyArgArray[4] = Double.TYPE;
         __$rlPolicyArgArray[5] = Boolean.TYPE;
         __$stateWMEArgArray[0] = Integer.TYPE;
         __$stateWMEArgArray[1] = __$tempObjArray.getClass();
         __$stateWMEArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$successConditionArgArray[0] = Integer.TYPE;
         __$successConditionArgArray[1] = __$tempObjArray.getClass();
         __$successConditionArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$analysisArgArray[0] = Integer.TYPE;
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_BehaviorFactories_rfield = Class.forName("abl.generated.MICEAgent_BehaviorFactories");
         __$behaviorFactory0_rfield = __$MICEAgent_BehaviorFactories_rfield.getDeclaredMethod("behaviorFactory0", __$behFactoryArgArray);
         __$behaviorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_Preconditions_rfield = Class.forName("abl.generated.MICEAgent_Preconditions");
         __$precondition0_rfield = __$MICEAgent_Preconditions_rfield.getDeclaredMethod("precondition0", __$preconditionArgArray);
         __$precondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_PreconditionSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_PreconditionSensorFactories");
         __$preconditionSensorFactory0_rfield = __$MICEAgent_PreconditionSensorFactories_rfield.getDeclaredMethod("preconditionSensorFactory0", __$sensorFactoryArgArray);
         __$preconditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ConditionalTests_rfield = Class.forName("abl.generated.MICEAgent_ConditionalTests");
         __$conditionalTest0_rfield = __$MICEAgent_ConditionalTests_rfield.getDeclaredMethod("conditionalTest0", __$conditionalTestArgArray);
         __$conditionalTest0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ConditionalTestSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_ConditionalTestSensorFactories");
         __$conditionalTestSensorFactory0_rfield = __$MICEAgent_ConditionalTestSensorFactories_rfield.getDeclaredMethod("conditionalTestSensorFactory0", __$sensorFactoryArgArray);
         __$conditionalTestSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ContextConditions_rfield = Class.forName("abl.generated.MICEAgent_ContextConditions");
         __$contextCondition0_rfield = __$MICEAgent_ContextConditions_rfield.getDeclaredMethod("contextCondition0", __$continuousConditionArgArray);
         __$contextCondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ContextConditionSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_ContextConditionSensorFactories");
         __$contextConditionSensorFactory0_rfield = __$MICEAgent_ContextConditionSensorFactories_rfield.getDeclaredMethod("contextConditionSensorFactory0", __$sensorFactoryArgArray);
         __$contextConditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_StepFactories_rfield = Class.forName("abl.generated.MICEAgent_StepFactories");
         __$stepFactory0_rfield = __$MICEAgent_StepFactories_rfield.getDeclaredMethod("stepFactory0", __$stepFactoryArgArray);
         __$stepFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ArgumentStepExecute_rfield = Class.forName("abl.generated.MICEAgent_ArgumentStepExecute");
         __$argumentExecute0_rfield = __$MICEAgent_ArgumentStepExecute_rfield.getDeclaredMethod("argumentExecute0", __$argumentStepExecuteArgArray);
         __$argumentExecute0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_MentalStepExecute_rfield = Class.forName("abl.generated.MICEAgent_MentalStepExecute");
         __$mentalExecute0_rfield = __$MICEAgent_MentalStepExecute_rfield.getDeclaredMethod("mentalExecute0", __$mentalStepExecuteArgArray);
         __$mentalExecute0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_SuccessTests_rfield = Class.forName("abl.generated.MICEAgent_SuccessTests");
         __$successTest0_rfield = __$MICEAgent_SuccessTests_rfield.getDeclaredMethod("successTest0", __$continuousConditionArgArray);
         __$successTest0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_SuccessTestSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_SuccessTestSensorFactories");
         __$successTestSensorFactory0_rfield = __$MICEAgent_SuccessTestSensorFactories_rfield.getDeclaredMethod("successTestSensorFactory0", __$sensorFactoryArgArray);
         __$successTestSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ReinforcementSignals_rfield = Class.forName("abl.generated.MICEAgent_ReinforcementSignals");
         __$reinforcementSignal0_rfield = __$MICEAgent_ReinforcementSignals_rfield.getDeclaredMethod("reinforcementSignal0", __$reinforcementSignalArgArray);
         __$reinforcementSignal0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_ReinforcementSignalSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_ReinforcementSignalSensorFactories");
         __$reinforcementSignalSensorFactory0_rfield = __$MICEAgent_ReinforcementSignalSensorFactories_rfield.getDeclaredMethod("reinforcementSignalSensorFactory0", __$sensorFactoryArgArray);
         __$reinforcementSignalSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_RLPolicy_rfield = Class.forName("abl.generated.MICEAgent_RLPolicy");
         __$rlPolicy0_rfield = __$MICEAgent_RLPolicy_rfield.getDeclaredMethod("rlPolicy0", __$rlPolicyArgArray);
         __$rlPolicy0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_StateWMEs_rfield = Class.forName("abl.generated.MICEAgent_StateWMEs");
         __$stateWME0_rfield = __$MICEAgent_StateWMEs_rfield.getDeclaredMethod("stateWME0", __$stateWMEArgArray);
         __$stateWME0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_StateWMESensorFactories_rfield = Class.forName("abl.generated.MICEAgent_StateWMESensorFactories");
         __$stateWMESensorFactory0_rfield = __$MICEAgent_StateWMESensorFactories_rfield.getDeclaredMethod("stateWMESensorFactory0", __$sensorFactoryArgArray);
         __$stateWMESensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_SuccessConditions_rfield = Class.forName("abl.generated.MICEAgent_SuccessConditions");
         __$successCondition0_rfield = __$MICEAgent_SuccessConditions_rfield.getDeclaredMethod("successCondition0", __$successConditionArgArray);
         __$successCondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_SuccessConditionSensorFactories_rfield = Class.forName("abl.generated.MICEAgent_SuccessConditionSensorFactories");
         __$successConditionSensorFactory0_rfield = __$MICEAgent_SuccessConditionSensorFactories_rfield.getDeclaredMethod("successConditionSensorFactory0", __$sensorFactoryArgArray);
         __$successConditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$MICEAgent_Analysis_rfield = Class.forName("abl.generated.MICEAgent_Analysis");
         __$analysis0_rfield = __$MICEAgent_Analysis_rfield.getDeclaredMethod("analysis0", __$analysisArgArray);
         __$analysis0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }


   private static void registerBehaviors_0(BehaviorLibrary behaviorLibrary) {
      behaviorLibrary.registerBehavior(new __BehaviorDesc(0, __$behaviorFactory0_rfield, null, null, "MICERoot()", new String[] {"MICERoot()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(1, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "startEventThread()", new String[] {"startEventThread()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(2, __$behaviorFactory0_rfield, null, null, "endEventThread()", new String[] {"endEventThread()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(3, __$behaviorFactory0_rfield, null, null, "milieu()", new String[] {"milieu()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(4, __$behaviorFactory0_rfield, null, null, "inquiry()", new String[] {"inquiry()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(5, __$behaviorFactory0_rfield, null, null, "character()", new String[] {"character()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(6, __$behaviorFactory0_rfield, null, null, "event()", new String[] {"event()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(7, __$behaviorFactory0_rfield, null, null, "Wait(int)", new String[] {"Wait(int)"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(8, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "testBehavior()", new String[] {"testBehavior()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(9, __$behaviorFactory0_rfield, null, null, "MICEAgent_RootCollectionBehavior()", new String[] {"MICEAgent_RootCollectionBehavior()"}, null, (short)0), __$analysis0_rfield);
      behaviorLibrary.registerBehavior(new __BehaviorDesc(10, __$behaviorFactory0_rfield, null, null, "__$defaultMemoryExecuteBehavior()", new String[] {"__$defaultMemoryExecuteBehavior()"}, null, (short)0), __$analysis0_rfield);
   }

   private static void registerBehaviors_1(BehaviorLibrary behaviorLibrary) {
   }

   public static void main(String[] args) {
      MICEAgent ent = new MICEAgent();
      ent.startBehaving();
   }

   public MICEAgent() {
      individualBehaviorLibrary = new BehaviorLibrary(22);
      jointBehaviorLibrary = new BehaviorLibrary(0);
      debugLevel = 2;
      debuggerGUI = new Debugger(this);
      registerBehaviors_0(individualBehaviorLibrary);
      registerBehaviors_1(jointBehaviorLibrary);
      ABT = (CollectionBehavior)MICEAgent_BehaviorFactories.behaviorFactory0(9, null, null, null, "MICEAgent_RootCollectionBehavior()", this, (__BehaviorDesc)((List)individualBehaviorLibrary.lookupBehavior("MICEAgent_RootCollectionBehavior()")).get(0));
      startWMEReflection(ABT);
      registerEntity("MICEAgent", this);
   }

}
