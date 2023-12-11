package io.proleap.vb6.ast.calls;

import java.io.File;

import org.junit.Test;
import io.proleap.vb6.runner.VbParseTestRunner;
import io.proleap.vb6.runner.impl.VbParseTestRunnerImpl;

public class Module1Test {

	@Test
	public void test() throws Exception {
		final File inputFile = new File("src/test/resources/io/proleap/vb6/ast/calls/Module1.cls");
		final VbParseTestRunner runner = new VbParseTestRunnerImpl();
		runner.parseFile(inputFile);
	}
}