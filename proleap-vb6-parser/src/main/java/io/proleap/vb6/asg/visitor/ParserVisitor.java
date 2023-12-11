/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.visitor;

import org.antlr.v4.runtime.tree.ParseTree;

public interface ParserVisitor {

	Boolean visit(ParseTree parseTree);
}
