/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.reporting.web.widget.handler;

import java.io.IOException;

import org.openmrs.annotation.Handler;
import org.openmrs.module.reporting.web.widget.WidgetTag;
import org.openmrs.module.reporting.web.widget.html.TextWidget;
import org.openmrs.module.util.ReflectionUtil;

/**
 * FieldGenHandler for String Types
 */
@Handler(supports={String.class, Character.class}, order=50)
public class StringHandler extends WidgetHandler {
	
	/** 
	 * @see WidgetHandler#handle(WidgetTag)
	 */
	@Override
	public void handle(WidgetTag tag) throws IOException {
		
		TextWidget w = WidgetHandler.getWidgetInstance(tag, TextWidget.class);
		Class<?> clazz = ReflectionUtil.getFieldType(tag.getField());
		
		if (clazz == Character.class) {
			w.configureAttribute("size", "2");
			w.configureAttribute("maxLength", "1");
		}
		else {
			w.configureAttribute("size", "20");
		}
		w.render(tag.getPageContext());
	}
}