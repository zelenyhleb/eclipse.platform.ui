/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.tests.dynamicplugins;

//import java.io.IOException;

import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
//import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.internal.IWorkbenchConstants;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
//import org.eclipse.ui.internal.registry.IActionSetDescriptor;
import org.eclipse.ui.tests.util.UITestCase;
//import org.osgi.framework.Bundle;
//import org.osgi.framework.BundleException;

/**
 * Tests to ensure the addition of new action sets with dynamic plug-ins.
 */

public class ActionSetTests extends UITestCase implements IRegistryChangeListener {
	private ActionSetRegistry fReg;
	volatile boolean actionSetRegistryUpdated = false;
		
	public ActionSetTests(String testName) {
		super(testName);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IRegistryChangeListener#registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent)
	 */
	public void registryChanged(IRegistryChangeEvent event) {
		// Just retrieve any changes relating to the extension point
		// org.eclipse.ui.actionSets
		IExtensionDelta delta = event.getExtensionDelta(WorkbenchPlugin.PI_WORKBENCH, IWorkbenchConstants.PL_ACTION_SETS, "org.eclipse.newActionSet1.testDynamicActionSetAddition");
		if (delta != null && delta.getKind() == IExtensionDelta.ADDED)
			actionSetRegistryUpdated = true;
	}

	public void testFindActionSetInRegistry() {
		// Need to disable this test for now.  It causes a dialog to 
		// pop up asking if you would like to reset the current perspective.
		// This dialog will be removed eventually (when we can handle 
		// changes to the internal UI registries).  At that time, this
		// test can be enabled again.
		
//		Platform.getExtensionRegistry().addRegistryChangeListener(this);
//		actionSetRegistryUpdated = false;
//		Bundle newBundle = null;
//		try {
//			newBundle = DynamicUtils.installPlugin("data/org.eclipse.newActionSet1");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//			fail("Dynamic install generated an IOException");
//		} catch (BundleException e1) {
//			e1.printStackTrace();
//			fail("Dynamic install generated a BundleException");
//		} catch (IllegalStateException e1) {
//			e1.printStackTrace();
//			fail("Dynamic install generated an IllegalStateException - this plugin has been installed previously");
//		}
//		try {
//			long startTime = System.currentTimeMillis();
//			long potentialEndTime = startTime + 1000;
//			boolean timeToFail = false;
//			while (!actionSetRegistryUpdated && !timeToFail) {
//				processEvents();
//				timeToFail = System.currentTimeMillis() > potentialEndTime;
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			assertEquals("Test failed due to timeout", false, timeToFail);
//			fReg = WorkbenchPlugin.getDefault().getActionSetRegistry();
//			IActionSetDescriptor found = fReg.findActionSet("org.eclipse.newActionSet1.newActionSet1");
//			assertNotNull(found);
//		} finally {
//			try {
//				Platform.getExtensionRegistry().removeRegistryChangeListener(this);
//				DynamicUtils.uninstallPlugin(newBundle);
//			} catch (BundleException e) {
//				// just cleaning up
//			}
//		}
	}
}
