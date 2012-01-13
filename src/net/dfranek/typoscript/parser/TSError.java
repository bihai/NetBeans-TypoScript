/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2011 Daniel Franek.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 * 
 */
package net.dfranek.typoscript.parser;

import org.netbeans.modules.csl.api.Severity;
import org.openide.filesystems.FileObject;

/**
 *
 * @author daniel
 */
public class TSError implements org.netbeans.modules.csl.api.Error{

	private final String displayName;

    private final FileObject file;
    private final int startPosition;
    private final int endPosition;
    private final Severity severity;
    private final Object[] parameters;

	public TSError(String name, FileObject file, int start, int end, Severity severity, Object[] params) {
		displayName = name;
		this.file = file;
		startPosition = start;
		endPosition = end;
		this.severity = severity;
		this.parameters = params;
	}
	
	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getKey() {
		return "[" + startPosition + "," + endPosition + "]-" + displayName ;
	}

	@Override
	public FileObject getFile() {
		return this.file;
	}

	@Override
	public int getStartPosition() {
		return startPosition;
	}

	@Override
	public int getEndPosition() {
		return endPosition;
	}

	@Override
	public boolean isLineError() {
		return true;
	}

	@Override
	public Severity getSeverity() {
		return severity;
	}

	@Override
	public Object[] getParameters() {
		return parameters;
	}
	
}