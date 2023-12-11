/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.statement.deletesetting.impl;

import io.proleap.vb6.VisualBasic6Parser.DeleteSettingStmtContext;
import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Scope;
import io.proleap.vb6.asg.metamodel.impl.ScopedElementImpl;
import io.proleap.vb6.asg.metamodel.statement.StatementType;
import io.proleap.vb6.asg.metamodel.statement.StatementTypeEnum;
import io.proleap.vb6.asg.metamodel.statement.deletesetting.DeleteSetting;

public class DeleteSettingImpl extends ScopedElementImpl implements DeleteSetting {

	protected final DeleteSettingStmtContext ctx;

	protected final StatementType statementType = StatementTypeEnum.DELETE_SETTING;

	public DeleteSettingImpl(final Module module, final Scope scope, final DeleteSettingStmtContext ctx) {
		super(module.getProgram(), module, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public DeleteSettingStmtContext getCtx() {
		return ctx;
	}

	@Override
	public StatementType getStatementType() {
		return statementType;
	}

}
