/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel;

import io.proleap.vb6.VisualBasic6Parser.ArgContext;

public interface ProcedureDeclaration extends ScopedElement, Declaration {

	Arg addArg(ArgContext ctx);

}
