package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        String code = "class C { Module module; Module mOdule; }";
        CharStream input = CharStreams.fromString(code);
        org.example.JavaLexer lexer = new org.example.JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        org.example.JavaParser parser = new org.example.JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        JL jl = new JL();
        ParseTreeWalker.DEFAULT.walk(jl, tree);
    }
}

class JL extends org.example.JavaParserBaseListener {
    @Override
    public void enterVariableDeclaratorId(org.example.JavaParser.VariableDeclaratorIdContext ctx) {
        String s = ctx.identifier().getChild(0).toString();
        System.out.println(s);
    }
}
