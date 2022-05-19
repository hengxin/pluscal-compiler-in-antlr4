# pluscal-compiler-in-antlr4

A Compiler for PlusCal in ANTLR4

本项目基于ANTLR4实现了一个PlusCal的编译器，包括词法分析、语法分析、语义分析和代码生成。

相应的词法、语法分析器和语法树遍历器已生成，运行时先输入相应的PlusCal源代码（不输入时默认指定test.pluscal），再运行Main.java即可，

相应的结果将输出到控制台，或者输出到源代码所在文件中，生成的目标代码介于BEGIN TRANSLATION和END TRANSLATION之间。

可将生成的代码拷贝到TLA+Toolbox中运行。

## TODO Lists

### grammar

- [x] Indentation (done at pretreatment)
- [x] function mapping without parens
- [x] user defined operators

### semantic

- [x] symbol table
    - [x] set of process definition
    - [x] recursive function definition
    - [x] macro expansion (done at pretreatment)
    - [x] operator resolves
- [x] built-in operators
- [x] expressions
- [x] goto labels
- [x] errors
    - [x] variable definitions
    - [x] error printings
    - [x] incorrect label using
    - [x] assignment to the same variable in different assignment within the same step
- [x] symmetry
- [ ] out defined constants


### tla+ translation

- [ ] gen Spec
    - [x] safety formula
    - [x] minus labels
    - [x] fair process
    - [ ] plus labels
    - [ ] fair algorithm
- [x] State definition
- [x] unchanged variables
- [x] omit PC
- [x] while true optimization
- [x] procedures
    - [x] return stmt
    - [ ] goto stmt
    - [ ] call return stmt
    - [ ] call goto stmt
- [x] processes
