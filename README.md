# CodeCrafters Shell — Java

```
  ____          _     ____                _          
 / ___|   ___  | |   / ___|  ___ _ __ ___| |__   ___ 
 \___ \  / _ \ | |  | |  _  / _ \ '__/ __| '_ \ / _ \
  ___) ||  __/ | |__| |_| ||  __/ | | (__| | | |  __/
 |____/  \___| |_____\____| \___|_|  \___|_| |_|\___|

      Build Your Own Shell  •  Java Edition
      [ parsing ]  [ executing ]  [ builtin commands ]
```

A Java starter repository for the CodeCrafters "Build Your Own Shell" challenge.

This project is meant to help you implement a simple POSIX-style shell in Java.
The shell should parse commands, execute external programs, and support builtin
commands such as `cd`, `pwd`, `echo`, and others.

## Project Overview

- `src/main/java/Main.java` — main entry point for the shell implementation.
- `your_program.sh` — convenience wrapper to run the shell locally.
- `pom.xml` — Maven project configuration.

## Goals

- Parse and execute shell commands.
- Support a REPL loop for interactive use.
- Implement builtin commands like `cd`, `pwd`, and `echo`.
- Run external programs using the native operating system.

## Run Locally

1. Make sure you have Java and Maven installed.
2. Implement or update the shell logic in `src/main/java/Main.java`.
3. Run the shell locally with:

```sh
./your_program.sh
```

> On Linux or macOS, `./your_program.sh` starts the shell using the Java code in
> `src/main/java/Main.java`.

## Submit and Test

When your implementation is ready, submit it to CodeCrafters with:

```sh
codecrafters submit
```

This command sends your solution to the challenge server and streams test
results to your terminal.

## Notes

- This repository is a starting point for the CodeCrafters challenge.
- If you are viewing this on GitHub, the full interactive challenge is available
  at [codecrafters.io](https://codecrafters.io).
- Keep all shell logic inside `src/main/java/Main.java` unless the challenge
  defines a different entry point.
