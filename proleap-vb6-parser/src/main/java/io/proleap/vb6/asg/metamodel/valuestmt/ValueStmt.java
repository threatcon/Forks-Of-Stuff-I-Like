/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.valuestmt;

import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.ValueStmtContext;
import io.proleap.vb6.asg.metamodel.ScopedElement;
import io.proleap.vb6.asg.metamodel.type.TypedElement;

public interface ValueStmt extends ScopedElement, TypedElement {

	void addSubValueStmt(ValueStmt subValueStmt);

	@Override
	ValueStmtContext getCtx();

	List<ValueStmt> getSubValueStmts();
}
