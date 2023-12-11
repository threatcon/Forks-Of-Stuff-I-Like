/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.call.impl;

import org.antlr.v4.runtime.ParserRuleContext;

import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Scope;
import io.proleap.vb6.asg.metamodel.call.Call;
import io.proleap.vb6.asg.metamodel.impl.ScopedElementImpl;
import io.proleap.vb6.asg.metamodel.type.Type;

public class CallDelegateImpl extends ScopedElementImpl implements Call {

	protected final Call delegate;

	public CallDelegateImpl(final Call delegate, final Module module, final Scope scope, final ParserRuleContext ctx) {
		super(module.getProgram(), module, scope, ctx);

		this.delegate = delegate;
	}

	@Override
	public boolean equals(final Object obj) {
		final boolean result;

		if (super.equals(obj)) {
			result = true;
		} else if (obj instanceof Call) {
			final Call otherCall = (Call) obj;
			result = delegate.getName().toLowerCase().equals(otherCall.getName().toLowerCase());
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public CallType getCallType() {
		return delegate.getCallType();
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public Type getType() {
		return delegate.getType();
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	@Override
	public Call unwrap() {
		return delegate.unwrap();
	}

}
