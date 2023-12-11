// Generated from c:/Users/otek/OneDrive/Documents/Coding/proleap-vb6-parser/src/main/antlr4/io/proleap/vb6/VbaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VbaParser}.
 */
public interface VbaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VbaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(VbaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(VbaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterReservedIdentifier(VbaParser.ReservedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitReservedIdentifier(VbaParser.ReservedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statementKeyword}.
	 * @param ctx the parse tree
	 */
	void enterStatementKeyword(VbaParser.StatementKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statementKeyword}.
	 * @param ctx the parse tree
	 */
	void exitStatementKeyword(VbaParser.StatementKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#markerKeyword}.
	 * @param ctx the parse tree
	 */
	void enterMarkerKeyword(VbaParser.MarkerKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#markerKeyword}.
	 * @param ctx the parse tree
	 */
	void exitMarkerKeyword(VbaParser.MarkerKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#operatorIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterOperatorIdentifier(VbaParser.OperatorIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#operatorIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitOperatorIdentifier(VbaParser.OperatorIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedName}.
	 * @param ctx the parse tree
	 */
	void enterReservedName(VbaParser.ReservedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedName}.
	 * @param ctx the parse tree
	 */
	void exitReservedName(VbaParser.ReservedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#specialForm}.
	 * @param ctx the parse tree
	 */
	void enterSpecialForm(VbaParser.SpecialFormContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#specialForm}.
	 * @param ctx the parse tree
	 */
	void exitSpecialForm(VbaParser.SpecialFormContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterReservedTypeIdentifier(VbaParser.ReservedTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitReservedTypeIdentifier(VbaParser.ReservedTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#literalIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterLiteralIdentifier(VbaParser.LiteralIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#literalIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitLiteralIdentifier(VbaParser.LiteralIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#booleanLiteralIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralIdentifier(VbaParser.BooleanLiteralIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#booleanLiteralIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralIdentifier(VbaParser.BooleanLiteralIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedForImplementationUse}.
	 * @param ctx the parse tree
	 */
	void enterReservedForImplementationUse(VbaParser.ReservedForImplementationUseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedForImplementationUse}.
	 * @param ctx the parse tree
	 */
	void exitReservedForImplementationUse(VbaParser.ReservedForImplementationUseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#futureReserved}.
	 * @param ctx the parse tree
	 */
	void enterFutureReserved(VbaParser.FutureReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#futureReserved}.
	 * @param ctx the parse tree
	 */
	void exitFutureReserved(VbaParser.FutureReservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(VbaParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(VbaParser.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typedName}.
	 * @param ctx the parse tree
	 */
	void enterTypedName(VbaParser.TypedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typedName}.
	 * @param ctx the parse tree
	 */
	void exitTypedName(VbaParser.TypedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typeSuffix}.
	 * @param ctx the parse tree
	 */
	void enterTypeSuffix(VbaParser.TypeSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typeSuffix}.
	 * @param ctx the parse tree
	 */
	void exitTypeSuffix(VbaParser.TypeSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(VbaParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(VbaParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void enterUnrestrictedName(VbaParser.UnrestrictedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void exitUnrestrictedName(VbaParser.UnrestrictedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(VbaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(VbaParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#untypedName}.
	 * @param ctx the parse tree
	 */
	void enterUntypedName(VbaParser.UntypedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#untypedName}.
	 * @param ctx the parse tree
	 */
	void exitUntypedName(VbaParser.UntypedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#declarationSection}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSection(VbaParser.DeclarationSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#declarationSection}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSection(VbaParser.DeclarationSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#directiveElement}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveElement(VbaParser.DirectiveElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#directiveElement}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveElement(VbaParser.DirectiveElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionCompareDirective}.
	 * @param ctx the parse tree
	 */
	void enterOptionCompareDirective(VbaParser.OptionCompareDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionCompareDirective}.
	 * @param ctx the parse tree
	 */
	void exitOptionCompareDirective(VbaParser.OptionCompareDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionBaseDirective}.
	 * @param ctx the parse tree
	 */
	void enterOptionBaseDirective(VbaParser.OptionBaseDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionBaseDirective}.
	 * @param ctx the parse tree
	 */
	void exitOptionBaseDirective(VbaParser.OptionBaseDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionExplicitDirective}.
	 * @param ctx the parse tree
	 */
	void enterOptionExplicitDirective(VbaParser.OptionExplicitDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionExplicitDirective}.
	 * @param ctx the parse tree
	 */
	void exitOptionExplicitDirective(VbaParser.OptionExplicitDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionPrivateDirective}.
	 * @param ctx the parse tree
	 */
	void enterOptionPrivateDirective(VbaParser.OptionPrivateDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionPrivateDirective}.
	 * @param ctx the parse tree
	 */
	void exitOptionPrivateDirective(VbaParser.OptionPrivateDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#defDirective}.
	 * @param ctx the parse tree
	 */
	void enterDefDirective(VbaParser.DefDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#defDirective}.
	 * @param ctx the parse tree
	 */
	void exitDefDirective(VbaParser.DefDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#letterSpec}.
	 * @param ctx the parse tree
	 */
	void enterLetterSpec(VbaParser.LetterSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#letterSpec}.
	 * @param ctx the parse tree
	 */
	void exitLetterSpec(VbaParser.LetterSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#defType}.
	 * @param ctx the parse tree
	 */
	void enterDefType(VbaParser.DefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#defType}.
	 * @param ctx the parse tree
	 */
	void exitDefType(VbaParser.DefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(VbaParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(VbaParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#variableDclList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDclList(VbaParser.VariableDclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#variableDclList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDclList(VbaParser.VariableDclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(VbaParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(VbaParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#variableDcl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDcl(VbaParser.VariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#variableDcl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDcl(VbaParser.VariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void enterTypedVariableDcl(VbaParser.TypedVariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void exitTypedVariableDcl(VbaParser.TypedVariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#untypedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void enterUntypedVariableDcl(VbaParser.UntypedVariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#untypedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void exitUntypedVariableDcl(VbaParser.UntypedVariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#arrayClause}.
	 * @param ctx the parse tree
	 */
	void enterArrayClause(VbaParser.ArrayClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#arrayClause}.
	 * @param ctx the parse tree
	 */
	void exitArrayClause(VbaParser.ArrayClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#asClause}.
	 * @param ctx the parse tree
	 */
	void enterAsClause(VbaParser.AsClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#asClause}.
	 * @param ctx the parse tree
	 */
	void exitAsClause(VbaParser.AsClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#witheventsVariableDcl}.
	 * @param ctx the parse tree
	 */
	void enterWitheventsVariableDcl(VbaParser.WitheventsVariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#witheventsVariableDcl}.
	 * @param ctx the parse tree
	 */
	void exitWitheventsVariableDcl(VbaParser.WitheventsVariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#classTypeName}.
	 * @param ctx the parse tree
	 */
	void enterClassTypeName(VbaParser.ClassTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#classTypeName}.
	 * @param ctx the parse tree
	 */
	void exitClassTypeName(VbaParser.ClassTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#arrayDim}.
	 * @param ctx the parse tree
	 */
	void enterArrayDim(VbaParser.ArrayDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#arrayDim}.
	 * @param ctx the parse tree
	 */
	void exitArrayDim(VbaParser.ArrayDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#boundsList}.
	 * @param ctx the parse tree
	 */
	void enterBoundsList(VbaParser.BoundsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#boundsList}.
	 * @param ctx the parse tree
	 */
	void exitBoundsList(VbaParser.BoundsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dimSpec}.
	 * @param ctx the parse tree
	 */
	void enterDimSpec(VbaParser.DimSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dimSpec}.
	 * @param ctx the parse tree
	 */
	void exitDimSpec(VbaParser.DimSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#asAutoObject}.
	 * @param ctx the parse tree
	 */
	void enterAsAutoObject(VbaParser.AsAutoObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#asAutoObject}.
	 * @param ctx the parse tree
	 */
	void exitAsAutoObject(VbaParser.AsAutoObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#asType}.
	 * @param ctx the parse tree
	 */
	void enterAsType(VbaParser.AsTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#asType}.
	 * @param ctx the parse tree
	 */
	void exitAsType(VbaParser.AsTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpec(VbaParser.TypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpec(VbaParser.TypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#fixedLengthStringSpec}.
	 * @param ctx the parse tree
	 */
	void enterFixedLengthStringSpec(VbaParser.FixedLengthStringSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#fixedLengthStringSpec}.
	 * @param ctx the parse tree
	 */
	void exitFixedLengthStringSpec(VbaParser.FixedLengthStringSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#stringLength}.
	 * @param ctx the parse tree
	 */
	void enterStringLength(VbaParser.StringLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#stringLength}.
	 * @param ctx the parse tree
	 */
	void exitStringLength(VbaParser.StringLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#constantName}.
	 * @param ctx the parse tree
	 */
	void enterConstantName(VbaParser.ConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#constantName}.
	 * @param ctx the parse tree
	 */
	void exitConstantName(VbaParser.ConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(VbaParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(VbaParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#constItemList}.
	 * @param ctx the parse tree
	 */
	void enterConstItemList(VbaParser.ConstItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#constItemList}.
	 * @param ctx the parse tree
	 */
	void exitConstItemList(VbaParser.ConstItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#constItem}.
	 * @param ctx the parse tree
	 */
	void enterConstItem(VbaParser.ConstItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#constItem}.
	 * @param ctx the parse tree
	 */
	void exitConstItem(VbaParser.ConstItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(VbaParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(VbaParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#udtDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUdtDeclaration(VbaParser.UdtDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#udtDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUdtDeclaration(VbaParser.UdtDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#udtMemberList}.
	 * @param ctx the parse tree
	 */
	void enterUdtMemberList(VbaParser.UdtMemberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#udtMemberList}.
	 * @param ctx the parse tree
	 */
	void exitUdtMemberList(VbaParser.UdtMemberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#udtElement}.
	 * @param ctx the parse tree
	 */
	void enterUdtElement(VbaParser.UdtElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#udtElement}.
	 * @param ctx the parse tree
	 */
	void exitUdtElement(VbaParser.UdtElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#udtMember}.
	 * @param ctx the parse tree
	 */
	void enterUdtMember(VbaParser.UdtMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#udtMember}.
	 * @param ctx the parse tree
	 */
	void exitUdtMember(VbaParser.UdtMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#untypedNameMemberDcl}.
	 * @param ctx the parse tree
	 */
	void enterUntypedNameMemberDcl(VbaParser.UntypedNameMemberDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#untypedNameMemberDcl}.
	 * @param ctx the parse tree
	 */
	void exitUntypedNameMemberDcl(VbaParser.UntypedNameMemberDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedNameMemberDcl}.
	 * @param ctx the parse tree
	 */
	void enterReservedNameMemberDcl(VbaParser.ReservedNameMemberDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedNameMemberDcl}.
	 * @param ctx the parse tree
	 */
	void exitReservedNameMemberDcl(VbaParser.ReservedNameMemberDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionalArrayClause}.
	 * @param ctx the parse tree
	 */
	void enterOptionalArrayClause(VbaParser.OptionalArrayClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionalArrayClause}.
	 * @param ctx the parse tree
	 */
	void exitOptionalArrayClause(VbaParser.OptionalArrayClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#reservedMemberName}.
	 * @param ctx the parse tree
	 */
	void enterReservedMemberName(VbaParser.ReservedMemberNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#reservedMemberName}.
	 * @param ctx the parse tree
	 */
	void exitReservedMemberName(VbaParser.ReservedMemberNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(VbaParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(VbaParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#memberList}.
	 * @param ctx the parse tree
	 */
	void enterMemberList(VbaParser.MemberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#memberList}.
	 * @param ctx the parse tree
	 */
	void exitMemberList(VbaParser.MemberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#enumElement}.
	 * @param ctx the parse tree
	 */
	void enterEnumElement(VbaParser.EnumElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#enumElement}.
	 * @param ctx the parse tree
	 */
	void exitEnumElement(VbaParser.EnumElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#enumMember}.
	 * @param ctx the parse tree
	 */
	void enterEnumMember(VbaParser.EnumMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#enumMember}.
	 * @param ctx the parse tree
	 */
	void exitEnumMember(VbaParser.EnumMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#extProcDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExtProcDeclaration(VbaParser.ExtProcDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#extProcDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExtProcDeclaration(VbaParser.ExtProcDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#externalProcDcl}.
	 * @param ctx the parse tree
	 */
	void enterExternalProcDcl(VbaParser.ExternalProcDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#externalProcDcl}.
	 * @param ctx the parse tree
	 */
	void exitExternalProcDcl(VbaParser.ExternalProcDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#externalSub}.
	 * @param ctx the parse tree
	 */
	void enterExternalSub(VbaParser.ExternalSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#externalSub}.
	 * @param ctx the parse tree
	 */
	void exitExternalSub(VbaParser.ExternalSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#externalFunction}.
	 * @param ctx the parse tree
	 */
	void enterExternalFunction(VbaParser.ExternalFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#externalFunction}.
	 * @param ctx the parse tree
	 */
	void exitExternalFunction(VbaParser.ExternalFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#libInfo}.
	 * @param ctx the parse tree
	 */
	void enterLibInfo(VbaParser.LibInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#libInfo}.
	 * @param ctx the parse tree
	 */
	void exitLibInfo(VbaParser.LibInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#implementsDirective}.
	 * @param ctx the parse tree
	 */
	void enterImplementsDirective(VbaParser.ImplementsDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#implementsDirective}.
	 * @param ctx the parse tree
	 */
	void exitImplementsDirective(VbaParser.ImplementsDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eventDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEventDeclaration(VbaParser.EventDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eventDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEventDeclaration(VbaParser.EventDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eventParameterList}.
	 * @param ctx the parse tree
	 */
	void enterEventParameterList(VbaParser.EventParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eventParameterList}.
	 * @param ctx the parse tree
	 */
	void exitEventParameterList(VbaParser.EventParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#moduleCodeSection}.
	 * @param ctx the parse tree
	 */
	void enterModuleCodeSection(VbaParser.ModuleCodeSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#moduleCodeSection}.
	 * @param ctx the parse tree
	 */
	void exitModuleCodeSection(VbaParser.ModuleCodeSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#moduleCodeElement}.
	 * @param ctx the parse tree
	 */
	void enterModuleCodeElement(VbaParser.ModuleCodeElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#moduleCodeElement}.
	 * @param ctx the parse tree
	 */
	void exitModuleCodeElement(VbaParser.ModuleCodeElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#subroutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineDeclaration(VbaParser.SubroutineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#subroutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineDeclaration(VbaParser.SubroutineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(VbaParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(VbaParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#propGetDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropGetDeclaration(VbaParser.PropGetDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#propGetDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropGetDeclaration(VbaParser.PropGetDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#propLhsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropLhsDeclaration(VbaParser.PropLhsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#propLhsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropLhsDeclaration(VbaParser.PropLhsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#endLabel}.
	 * @param ctx the parse tree
	 */
	void enterEndLabel(VbaParser.EndLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#endLabel}.
	 * @param ctx the parse tree
	 */
	void exitEndLabel(VbaParser.EndLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#procedureScope}.
	 * @param ctx the parse tree
	 */
	void enterProcedureScope(VbaParser.ProcedureScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#procedureScope}.
	 * @param ctx the parse tree
	 */
	void exitProcedureScope(VbaParser.ProcedureScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineName(VbaParser.SubroutineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineName(VbaParser.SubroutineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(VbaParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(VbaParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedName(VbaParser.PrefixedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedName(VbaParser.PrefixedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(VbaParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(VbaParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#arrayDesignator}.
	 * @param ctx the parse tree
	 */
	void enterArrayDesignator(VbaParser.ArrayDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#arrayDesignator}.
	 * @param ctx the parse tree
	 */
	void exitArrayDesignator(VbaParser.ArrayDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void enterProcedureParameters(VbaParser.ProcedureParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void exitProcedureParameters(VbaParser.ProcedureParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#propertyParameters}.
	 * @param ctx the parse tree
	 */
	void enterPropertyParameters(VbaParser.PropertyParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#propertyParameters}.
	 * @param ctx the parse tree
	 */
	void exitPropertyParameters(VbaParser.PropertyParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(VbaParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(VbaParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#positionalParameters}.
	 * @param ctx the parse tree
	 */
	void enterPositionalParameters(VbaParser.PositionalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#positionalParameters}.
	 * @param ctx the parse tree
	 */
	void exitPositionalParameters(VbaParser.PositionalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionalParameters}.
	 * @param ctx the parse tree
	 */
	void enterOptionalParameters(VbaParser.OptionalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionalParameters}.
	 * @param ctx the parse tree
	 */
	void exitOptionalParameters(VbaParser.OptionalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#valueParam}.
	 * @param ctx the parse tree
	 */
	void enterValueParam(VbaParser.ValueParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#valueParam}.
	 * @param ctx the parse tree
	 */
	void exitValueParam(VbaParser.ValueParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#positionalParam}.
	 * @param ctx the parse tree
	 */
	void enterPositionalParam(VbaParser.PositionalParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#positionalParam}.
	 * @param ctx the parse tree
	 */
	void exitPositionalParam(VbaParser.PositionalParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionalParam}.
	 * @param ctx the parse tree
	 */
	void enterOptionalParam(VbaParser.OptionalParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionalParam}.
	 * @param ctx the parse tree
	 */
	void exitOptionalParam(VbaParser.OptionalParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#paramArray}.
	 * @param ctx the parse tree
	 */
	void enterParamArray(VbaParser.ParamArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#paramArray}.
	 * @param ctx the parse tree
	 */
	void exitParamArray(VbaParser.ParamArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#paramDcl}.
	 * @param ctx the parse tree
	 */
	void enterParamDcl(VbaParser.ParamDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#paramDcl}.
	 * @param ctx the parse tree
	 */
	void exitParamDcl(VbaParser.ParamDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#untypedNameParamDcl}.
	 * @param ctx the parse tree
	 */
	void enterUntypedNameParamDcl(VbaParser.UntypedNameParamDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#untypedNameParamDcl}.
	 * @param ctx the parse tree
	 */
	void exitUntypedNameParamDcl(VbaParser.UntypedNameParamDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typedNameDcl}.
	 * @param ctx the parse tree
	 */
	void enterTypedNameDcl(VbaParser.TypedNameDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typedNameDcl}.
	 * @param ctx the parse tree
	 */
	void exitTypedNameDcl(VbaParser.TypedNameDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#optionalPrefix}.
	 * @param ctx the parse tree
	 */
	void enterOptionalPrefix(VbaParser.OptionalPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#optionalPrefix}.
	 * @param ctx the parse tree
	 */
	void exitOptionalPrefix(VbaParser.OptionalPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#parameterMechanism}.
	 * @param ctx the parse tree
	 */
	void enterParameterMechanism(VbaParser.ParameterMechanismContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#parameterMechanism}.
	 * @param ctx the parse tree
	 */
	void exitParameterMechanism(VbaParser.ParameterMechanismContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(VbaParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(VbaParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(VbaParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(VbaParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eventHandlerName}.
	 * @param ctx the parse tree
	 */
	void enterEventHandlerName(VbaParser.EventHandlerNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eventHandlerName}.
	 * @param ctx the parse tree
	 */
	void exitEventHandlerName(VbaParser.EventHandlerNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#implementedName}.
	 * @param ctx the parse tree
	 */
	void enterImplementedName(VbaParser.ImplementedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#implementedName}.
	 * @param ctx the parse tree
	 */
	void exitImplementedName(VbaParser.ImplementedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lifecycleHandlerName}.
	 * @param ctx the parse tree
	 */
	void enterLifecycleHandlerName(VbaParser.LifecycleHandlerNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lifecycleHandlerName}.
	 * @param ctx the parse tree
	 */
	void exitLifecycleHandlerName(VbaParser.LifecycleHandlerNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void enterProcedureBody(VbaParser.ProcedureBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void exitProcedureBody(VbaParser.ProcedureBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(VbaParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(VbaParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(VbaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(VbaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(VbaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(VbaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statementLabelDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStatementLabelDefinition(VbaParser.StatementLabelDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statementLabelDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStatementLabelDefinition(VbaParser.StatementLabelDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statementLabel}.
	 * @param ctx the parse tree
	 */
	void enterStatementLabel(VbaParser.StatementLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statementLabel}.
	 * @param ctx the parse tree
	 */
	void exitStatementLabel(VbaParser.StatementLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#statementLabelList}.
	 * @param ctx the parse tree
	 */
	void enterStatementLabelList(VbaParser.StatementLabelListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#statementLabelList}.
	 * @param ctx the parse tree
	 */
	void exitStatementLabelList(VbaParser.StatementLabelListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lineNumberLabel}.
	 * @param ctx the parse tree
	 */
	void enterLineNumberLabel(VbaParser.LineNumberLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lineNumberLabel}.
	 * @param ctx the parse tree
	 */
	void exitLineNumberLabel(VbaParser.LineNumberLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterControlStatement(VbaParser.ControlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitControlStatement(VbaParser.ControlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#controlStatementExceptMultilineIf}.
	 * @param ctx the parse tree
	 */
	void enterControlStatementExceptMultilineIf(VbaParser.ControlStatementExceptMultilineIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#controlStatementExceptMultilineIf}.
	 * @param ctx the parse tree
	 */
	void exitControlStatementExceptMultilineIf(VbaParser.ControlStatementExceptMultilineIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void enterCallStatement(VbaParser.CallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void exitCallStatement(VbaParser.CallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(VbaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(VbaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(VbaParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(VbaParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#simpleForStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleForStatement(VbaParser.SimpleForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#simpleForStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleForStatement(VbaParser.SimpleForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#explicitForStatement}.
	 * @param ctx the parse tree
	 */
	void enterExplicitForStatement(VbaParser.ExplicitForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#explicitForStatement}.
	 * @param ctx the parse tree
	 */
	void exitExplicitForStatement(VbaParser.ExplicitForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#nestedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterNestedForStatement(VbaParser.NestedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#nestedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitNestedForStatement(VbaParser.NestedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(VbaParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(VbaParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#stepClause}.
	 * @param ctx the parse tree
	 */
	void enterStepClause(VbaParser.StepClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#stepClause}.
	 * @param ctx the parse tree
	 */
	void exitStepClause(VbaParser.StepClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStatement(VbaParser.ForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStatement(VbaParser.ForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#simpleForEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleForEachStatement(VbaParser.SimpleForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#simpleForEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleForEachStatement(VbaParser.SimpleForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#explicitForEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterExplicitForEachStatement(VbaParser.ExplicitForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#explicitForEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitExplicitForEachStatement(VbaParser.ExplicitForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#forEachClause}.
	 * @param ctx the parse tree
	 */
	void enterForEachClause(VbaParser.ForEachClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#forEachClause}.
	 * @param ctx the parse tree
	 */
	void exitForEachClause(VbaParser.ForEachClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#exitForStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitForStatement(VbaParser.ExitForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#exitForStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitForStatement(VbaParser.ExitForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(VbaParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(VbaParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#conditionClause}.
	 * @param ctx the parse tree
	 */
	void enterConditionClause(VbaParser.ConditionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#conditionClause}.
	 * @param ctx the parse tree
	 */
	void exitConditionClause(VbaParser.ConditionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#exitDoStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitDoStatement(VbaParser.ExitDoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#exitDoStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitDoStatement(VbaParser.ExitDoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(VbaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(VbaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(VbaParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(VbaParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(VbaParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(VbaParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#singleLineIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleLineIfStatement(VbaParser.SingleLineIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#singleLineIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleLineIfStatement(VbaParser.SingleLineIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#ifWithNonEmptyThen}.
	 * @param ctx the parse tree
	 */
	void enterIfWithNonEmptyThen(VbaParser.IfWithNonEmptyThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#ifWithNonEmptyThen}.
	 * @param ctx the parse tree
	 */
	void exitIfWithNonEmptyThen(VbaParser.IfWithNonEmptyThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#ifWithEmptyThen}.
	 * @param ctx the parse tree
	 */
	void enterIfWithEmptyThen(VbaParser.IfWithEmptyThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#ifWithEmptyThen}.
	 * @param ctx the parse tree
	 */
	void exitIfWithEmptyThen(VbaParser.IfWithEmptyThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#singleLineElseClause}.
	 * @param ctx the parse tree
	 */
	void enterSingleLineElseClause(VbaParser.SingleLineElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#singleLineElseClause}.
	 * @param ctx the parse tree
	 */
	void exitSingleLineElseClause(VbaParser.SingleLineElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#listOrLabel}.
	 * @param ctx the parse tree
	 */
	void enterListOrLabel(VbaParser.ListOrLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#listOrLabel}.
	 * @param ctx the parse tree
	 */
	void exitListOrLabel(VbaParser.ListOrLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#sameLineStatement}.
	 * @param ctx the parse tree
	 */
	void enterSameLineStatement(VbaParser.SameLineStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#sameLineStatement}.
	 * @param ctx the parse tree
	 */
	void exitSameLineStatement(VbaParser.SameLineStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#selectCaseStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectCaseStatement(VbaParser.SelectCaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#selectCaseStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectCaseStatement(VbaParser.SelectCaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(VbaParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(VbaParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#caseElseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseElseClause(VbaParser.CaseElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#caseElseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseElseClause(VbaParser.CaseElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#rangeClause}.
	 * @param ctx the parse tree
	 */
	void enterRangeClause(VbaParser.RangeClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#rangeClause}.
	 * @param ctx the parse tree
	 */
	void exitRangeClause(VbaParser.RangeClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(VbaParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(VbaParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#stopStatement}.
	 * @param ctx the parse tree
	 */
	void enterStopStatement(VbaParser.StopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#stopStatement}.
	 * @param ctx the parse tree
	 */
	void exitStopStatement(VbaParser.StopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(VbaParser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(VbaParser.GotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#onGotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterOnGotoStatement(VbaParser.OnGotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#onGotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitOnGotoStatement(VbaParser.OnGotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#gosubStatement}.
	 * @param ctx the parse tree
	 */
	void enterGosubStatement(VbaParser.GosubStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#gosubStatement}.
	 * @param ctx the parse tree
	 */
	void exitGosubStatement(VbaParser.GosubStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(VbaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(VbaParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#onGosubStatement}.
	 * @param ctx the parse tree
	 */
	void enterOnGosubStatement(VbaParser.OnGosubStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#onGosubStatement}.
	 * @param ctx the parse tree
	 */
	void exitOnGosubStatement(VbaParser.OnGosubStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#exitSubStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitSubStatement(VbaParser.ExitSubStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#exitSubStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitSubStatement(VbaParser.ExitSubStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#exitFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitFunctionStatement(VbaParser.ExitFunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#exitFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitFunctionStatement(VbaParser.ExitFunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#exitPropertyStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitPropertyStatement(VbaParser.ExitPropertyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#exitPropertyStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitPropertyStatement(VbaParser.ExitPropertyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#raiseEventStatement}.
	 * @param ctx the parse tree
	 */
	void enterRaiseEventStatement(VbaParser.RaiseEventStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#raiseEventStatement}.
	 * @param ctx the parse tree
	 */
	void exitRaiseEventStatement(VbaParser.RaiseEventStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eventArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterEventArgumentList(VbaParser.EventArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eventArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitEventArgumentList(VbaParser.EventArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(VbaParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(VbaParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dataManipulationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDataManipulationStatement(VbaParser.DataManipulationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dataManipulationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDataManipulationStatement(VbaParser.DataManipulationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(VbaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(VbaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#staticVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticVariableDeclaration(VbaParser.StaticVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#staticVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticVariableDeclaration(VbaParser.StaticVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#localConstDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalConstDeclaration(VbaParser.LocalConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#localConstDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalConstDeclaration(VbaParser.LocalConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#redimStatement}.
	 * @param ctx the parse tree
	 */
	void enterRedimStatement(VbaParser.RedimStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#redimStatement}.
	 * @param ctx the parse tree
	 */
	void exitRedimStatement(VbaParser.RedimStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#redimDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterRedimDeclarationList(VbaParser.RedimDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#redimDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitRedimDeclarationList(VbaParser.RedimDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#redimVariableDcl}.
	 * @param ctx the parse tree
	 */
	void enterRedimVariableDcl(VbaParser.RedimVariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#redimVariableDcl}.
	 * @param ctx the parse tree
	 */
	void exitRedimVariableDcl(VbaParser.RedimVariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#redimTypedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void enterRedimTypedVariableDcl(VbaParser.RedimTypedVariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#redimTypedVariableDcl}.
	 * @param ctx the parse tree
	 */
	void exitRedimTypedVariableDcl(VbaParser.RedimTypedVariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#redimUntypedDcl}.
	 * @param ctx the parse tree
	 */
	void enterRedimUntypedDcl(VbaParser.RedimUntypedDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#redimUntypedDcl}.
	 * @param ctx the parse tree
	 */
	void exitRedimUntypedDcl(VbaParser.RedimUntypedDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dynamicArrayDim}.
	 * @param ctx the parse tree
	 */
	void enterDynamicArrayDim(VbaParser.DynamicArrayDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dynamicArrayDim}.
	 * @param ctx the parse tree
	 */
	void exitDynamicArrayDim(VbaParser.DynamicArrayDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dynamicBoundsList}.
	 * @param ctx the parse tree
	 */
	void enterDynamicBoundsList(VbaParser.DynamicBoundsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dynamicBoundsList}.
	 * @param ctx the parse tree
	 */
	void exitDynamicBoundsList(VbaParser.DynamicBoundsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dynamicDimSpec}.
	 * @param ctx the parse tree
	 */
	void enterDynamicDimSpec(VbaParser.DynamicDimSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dynamicDimSpec}.
	 * @param ctx the parse tree
	 */
	void exitDynamicDimSpec(VbaParser.DynamicDimSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dynamicArrayClause}.
	 * @param ctx the parse tree
	 */
	void enterDynamicArrayClause(VbaParser.DynamicArrayClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dynamicArrayClause}.
	 * @param ctx the parse tree
	 */
	void exitDynamicArrayClause(VbaParser.DynamicArrayClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eraseStatement}.
	 * @param ctx the parse tree
	 */
	void enterEraseStatement(VbaParser.EraseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eraseStatement}.
	 * @param ctx the parse tree
	 */
	void exitEraseStatement(VbaParser.EraseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#eraseList}.
	 * @param ctx the parse tree
	 */
	void enterEraseList(VbaParser.EraseListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#eraseList}.
	 * @param ctx the parse tree
	 */
	void exitEraseList(VbaParser.EraseListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#midStatement}.
	 * @param ctx the parse tree
	 */
	void enterMidStatement(VbaParser.MidStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#midStatement}.
	 * @param ctx the parse tree
	 */
	void exitMidStatement(VbaParser.MidStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#modeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterModeSpecifier(VbaParser.ModeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#modeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitModeSpecifier(VbaParser.ModeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#stringArgument}.
	 * @param ctx the parse tree
	 */
	void enterStringArgument(VbaParser.StringArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#stringArgument}.
	 * @param ctx the parse tree
	 */
	void exitStringArgument(VbaParser.StringArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lsetStatement}.
	 * @param ctx the parse tree
	 */
	void enterLsetStatement(VbaParser.LsetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lsetStatement}.
	 * @param ctx the parse tree
	 */
	void exitLsetStatement(VbaParser.LsetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#rsetStatement}.
	 * @param ctx the parse tree
	 */
	void enterRsetStatement(VbaParser.RsetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#rsetStatement}.
	 * @param ctx the parse tree
	 */
	void exitRsetStatement(VbaParser.RsetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(VbaParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(VbaParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(VbaParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(VbaParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#errorHandlingStatement}.
	 * @param ctx the parse tree
	 */
	void enterErrorHandlingStatement(VbaParser.ErrorHandlingStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#errorHandlingStatement}.
	 * @param ctx the parse tree
	 */
	void exitErrorHandlingStatement(VbaParser.ErrorHandlingStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#onErrorStatement}.
	 * @param ctx the parse tree
	 */
	void enterOnErrorStatement(VbaParser.OnErrorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#onErrorStatement}.
	 * @param ctx the parse tree
	 */
	void exitOnErrorStatement(VbaParser.OnErrorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#errorbehavior}.
	 * @param ctx the parse tree
	 */
	void enterErrorbehavior(VbaParser.ErrorbehaviorContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#errorbehavior}.
	 * @param ctx the parse tree
	 */
	void exitErrorbehavior(VbaParser.ErrorbehaviorContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#resumeStatement}.
	 * @param ctx the parse tree
	 */
	void enterResumeStatement(VbaParser.ResumeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#resumeStatement}.
	 * @param ctx the parse tree
	 */
	void exitResumeStatement(VbaParser.ResumeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#errorStatement}.
	 * @param ctx the parse tree
	 */
	void enterErrorStatement(VbaParser.ErrorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#errorStatement}.
	 * @param ctx the parse tree
	 */
	void exitErrorStatement(VbaParser.ErrorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#fileStatement}.
	 * @param ctx the parse tree
	 */
	void enterFileStatement(VbaParser.FileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#fileStatement}.
	 * @param ctx the parse tree
	 */
	void exitFileStatement(VbaParser.FileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void enterOpenStatement(VbaParser.OpenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void exitOpenStatement(VbaParser.OpenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#pathName}.
	 * @param ctx the parse tree
	 */
	void enterPathName(VbaParser.PathNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#pathName}.
	 * @param ctx the parse tree
	 */
	void exitPathName(VbaParser.PathNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#modeClause}.
	 * @param ctx the parse tree
	 */
	void enterModeClause(VbaParser.ModeClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#modeClause}.
	 * @param ctx the parse tree
	 */
	void exitModeClause(VbaParser.ModeClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#accessClause}.
	 * @param ctx the parse tree
	 */
	void enterAccessClause(VbaParser.AccessClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#accessClause}.
	 * @param ctx the parse tree
	 */
	void exitAccessClause(VbaParser.AccessClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lock}.
	 * @param ctx the parse tree
	 */
	void enterLock(VbaParser.LockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lock}.
	 * @param ctx the parse tree
	 */
	void exitLock(VbaParser.LockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lenClause}.
	 * @param ctx the parse tree
	 */
	void enterLenClause(VbaParser.LenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lenClause}.
	 * @param ctx the parse tree
	 */
	void exitLenClause(VbaParser.LenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#fileNumber}.
	 * @param ctx the parse tree
	 */
	void enterFileNumber(VbaParser.FileNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#fileNumber}.
	 * @param ctx the parse tree
	 */
	void exitFileNumber(VbaParser.FileNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#markedFileNumber}.
	 * @param ctx the parse tree
	 */
	void enterMarkedFileNumber(VbaParser.MarkedFileNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#markedFileNumber}.
	 * @param ctx the parse tree
	 */
	void exitMarkedFileNumber(VbaParser.MarkedFileNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void enterCloseStatement(VbaParser.CloseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void exitCloseStatement(VbaParser.CloseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#fileNumberList}.
	 * @param ctx the parse tree
	 */
	void enterFileNumberList(VbaParser.FileNumberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#fileNumberList}.
	 * @param ctx the parse tree
	 */
	void exitFileNumberList(VbaParser.FileNumberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#seekStatement}.
	 * @param ctx the parse tree
	 */
	void enterSeekStatement(VbaParser.SeekStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#seekStatement}.
	 * @param ctx the parse tree
	 */
	void exitSeekStatement(VbaParser.SeekStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lockStatement}.
	 * @param ctx the parse tree
	 */
	void enterLockStatement(VbaParser.LockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lockStatement}.
	 * @param ctx the parse tree
	 */
	void exitLockStatement(VbaParser.LockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#recordRange}.
	 * @param ctx the parse tree
	 */
	void enterRecordRange(VbaParser.RecordRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#recordRange}.
	 * @param ctx the parse tree
	 */
	void exitRecordRange(VbaParser.RecordRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#unlockStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnlockStatement(VbaParser.UnlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#unlockStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnlockStatement(VbaParser.UnlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lineInputStatement}.
	 * @param ctx the parse tree
	 */
	void enterLineInputStatement(VbaParser.LineInputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lineInputStatement}.
	 * @param ctx the parse tree
	 */
	void exitLineInputStatement(VbaParser.LineInputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#widthStatement}.
	 * @param ctx the parse tree
	 */
	void enterWidthStatement(VbaParser.WidthStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#widthStatement}.
	 * @param ctx the parse tree
	 */
	void exitWidthStatement(VbaParser.WidthStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(VbaParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(VbaParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#outputList}.
	 * @param ctx the parse tree
	 */
	void enterOutputList(VbaParser.OutputListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#outputList}.
	 * @param ctx the parse tree
	 */
	void exitOutputList(VbaParser.OutputListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#outputClause}.
	 * @param ctx the parse tree
	 */
	void enterOutputClause(VbaParser.OutputClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#outputClause}.
	 * @param ctx the parse tree
	 */
	void exitOutputClause(VbaParser.OutputClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#charPosition}.
	 * @param ctx the parse tree
	 */
	void enterCharPosition(VbaParser.CharPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#charPosition}.
	 * @param ctx the parse tree
	 */
	void exitCharPosition(VbaParser.CharPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#spcClause}.
	 * @param ctx the parse tree
	 */
	void enterSpcClause(VbaParser.SpcClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#spcClause}.
	 * @param ctx the parse tree
	 */
	void exitSpcClause(VbaParser.SpcClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#tabClause}.
	 * @param ctx the parse tree
	 */
	void enterTabClause(VbaParser.TabClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#tabClause}.
	 * @param ctx the parse tree
	 */
	void exitTabClause(VbaParser.TabClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(VbaParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(VbaParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(VbaParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(VbaParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#inputList}.
	 * @param ctx the parse tree
	 */
	void enterInputList(VbaParser.InputListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#inputList}.
	 * @param ctx the parse tree
	 */
	void exitInputList(VbaParser.InputListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#putStatement}.
	 * @param ctx the parse tree
	 */
	void enterPutStatement(VbaParser.PutStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#putStatement}.
	 * @param ctx the parse tree
	 */
	void exitPutStatement(VbaParser.PutStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#getStatement}.
	 * @param ctx the parse tree
	 */
	void enterGetStatement(VbaParser.GetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#getStatement}.
	 * @param ctx the parse tree
	 */
	void exitGetStatement(VbaParser.GetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(VbaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(VbaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#lExpression}.
	 * @param ctx the parse tree
	 */
	void enterLExpression(VbaParser.LExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#lExpression}.
	 * @param ctx the parse tree
	 */
	void exitLExpression(VbaParser.LExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(VbaParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(VbaParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(VbaParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(VbaParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typeOfIsExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeOfIsExpression(VbaParser.TypeOfIsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typeOfIsExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeOfIsExpression(VbaParser.TypeOfIsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(VbaParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(VbaParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#simpleNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleNameExpression(VbaParser.SimpleNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#simpleNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleNameExpression(VbaParser.SimpleNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#memberAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpression(VbaParser.MemberAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#memberAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpression(VbaParser.MemberAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#indexExpression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(VbaParser.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#indexExpression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(VbaParser.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(VbaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(VbaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#namedArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgumentList(VbaParser.NamedArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#namedArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgumentList(VbaParser.NamedArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgument(VbaParser.NamedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgument(VbaParser.NamedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#argumentExpression}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpression(VbaParser.ArgumentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#argumentExpression}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpression(VbaParser.ArgumentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#dictionaryAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterDictionaryAccessExpression(VbaParser.DictionaryAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#dictionaryAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitDictionaryAccessExpression(VbaParser.DictionaryAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#withExpression}.
	 * @param ctx the parse tree
	 */
	void enterWithExpression(VbaParser.WithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#withExpression}.
	 * @param ctx the parse tree
	 */
	void exitWithExpression(VbaParser.WithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(VbaParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(VbaParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(VbaParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(VbaParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#integerExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpression(VbaParser.IntegerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#integerExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpression(VbaParser.IntegerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(VbaParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(VbaParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#boundVariableExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoundVariableExpression(VbaParser.BoundVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#boundVariableExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoundVariableExpression(VbaParser.BoundVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#typeExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpression(VbaParser.TypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#typeExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpression(VbaParser.TypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#definedTypeExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinedTypeExpression(VbaParser.DefinedTypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#definedTypeExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinedTypeExpression(VbaParser.DefinedTypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VbaParser#addressOfExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddressOfExpression(VbaParser.AddressOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbaParser#addressOfExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddressOfExpression(VbaParser.AddressOfExpressionContext ctx);
}