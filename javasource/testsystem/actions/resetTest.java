// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package testsystem.actions;

import java.util.HashMap;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class resetTest extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String module;
	private java.lang.String microflow;
	private IMendixObject __test;
	private testsystem.proxies.Test test;

	public resetTest(IContext context, java.lang.String module, java.lang.String microflow, IMendixObject test)
	{
		super(context);
		this.module = module;
		this.microflow = microflow;
		this.__test = test;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.test = __test == null ? null : testsystem.proxies.Test.initialize(getContext(), __test);

		// BEGIN USER CODE
    String mfPath = module + "." + microflow;
  
  if (!Core.getMicroflowNames().contains(mfPath))
   return false;
  
  HashMap<String, Object> parameters = new HashMap<String, Object>();
  parameters.put("Test", this.test.getMendixObject());
  
  Core.execute(getContext(), mfPath, parameters);
  
  return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "resetTest";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
