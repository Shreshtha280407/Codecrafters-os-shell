[![progress-banner](https://backend.codecrafters.io/progress/shell/677ed0af-79c0-4d5a-9271-33b410aa556e)](https://app.codecrafters.io/users/nipunkalsotra?r=2qF)

# 🐚 Custom POSIX-Compliant Java Shell

A high-performance, robust, and feature-rich Unix-like shell implementation built entirely in modern **Java 26** (utilizing preview features). This shell supports command parsing with advanced quote handling, redirection, multi-stage pipelines, background execution, and multiple shell builtins.

Developed as part of the [CodeCrafters Build Your Own Shell Challenge](https://app.codecrafters.io/courses/shell/overview).

---

## ⚡ Live Terminal Demonstration

Below is a simulated, real-time animation of the Java Shell parsing inputs, resolving executables, handling output redirections, managing concurrent background processes, and piping output.

![Java Shell Demo](assets/demo.svg)

---

## 🚀 Key Features

*   **Robust REPL Loop:** Prompts the user with `$ ` and handles user interrupts, empty commands, and whitespace-padded lines seamlessly.
*   **Quote-Aware Parser:** Parses arguments while respecting:
    *   Single quotes (`'...'`) to preserve literal contents.
    *   Double quotes (`"..."`) with backslash escaping (`\"`, `\\`, etc.).
    *   Unquoted backslash escapes (`\`).
*   **Command Resolution:** Resolves commands against a pre-defined set of builtins or dynamically searches the system's `PATH` environment variable for executables.
*   **Redirection Engine:**
    *   Stdout redirection: Write (`>`, `1>`) and Append (`>>`, `1>>`).
    *   Stderr redirection: Write (`2>`) and Append (`2>>`).
*   **Multi-Stage Pipeling (`|`):** Supports chaining multiple commands by connecting the stdout of one command to the stdin of the next using multi-threaded piped streams.
*   **Background Jobs (`&`):** Executes commands asynchronously in the background. Tracks running processes, prints their PIDs, and notifies the user with job details (e.g. `[1]+ Done <command>`) upon completion.
*   **Built-in Commands:**
    *   `exit`: Terminates the shell session.
    *   `echo`: Outputs text (with support for redirected streams).
    *   `type`: Identifies whether a command is a shell builtin or locate its path on disk.
    *   `pwd`: Prints the current working directory.
    *   `cd`: Changes the working directory (handles relative paths, absolute paths, and home shortcut `~`).
    *   `jobs`: Lists all running/active background jobs.

---

## 🛠️ Architecture & Flow

The shell is built on a clean, single-threaded execution pump for interactive command reading, coupled with a multi-threaded execution model for parallel pipeline streams and background processes.

```mermaid
graph TD
    A[Start Shell REPL] --> B[Print Prompt & Read Line]
    B --> C{Is line empty?}
    C -- Yes --> B
    C -- No --> D[Tokenize & Parse Command Line]
    D --> E[Extract Redirection Targets & Background Flag]
    E --> F{Contains Pipings '|'?}
    
    F -- Yes --> G[Split Pipelines & Launch Threaded Stream Pipes]
    G --> B
    
    F -- No --> H{Is Builtin?}
    H -- Yes --> I[Execute In-Process & Apply Redirections]
    H -- No --> J[Resolve Command in PATH]
    
    J -- Found --> K{Background Flag '&'?}
    K -- Yes --> L[Spawn Async Thread / Process & Register to Job Monitor]
    K -- No --> M[Execute Sync Process & Wait for Exit]
    J -- Not Found --> N[Print Command Not Found]
    
    I --> B
    L --> B
    M --> B
    N --> B
```

---

## 📂 Project Structure

```text
├── .codecrafters/           # Metadata for remote compilation & execution
├── assets/
│   └── demo.svg             # Terminal typing animation
├── src/
│   └── main/
│       └── java/
│           └── Main.java    # Main REPL, parser, redirection, and job control logic
├── pom.xml                  # Maven configuration targeting Java 26
└── your_program.sh          # Helper script to compile and launch the shell locally
```

---

## ⚙️ Getting Started

### Prerequisites

*   **Java Development Kit (JDK) 26** or higher
*   **Apache Maven**

### Compilation & Local Execution

To compile and launch the shell on your local machine, execute:

```bash
chmod +x your_program.sh
./your_program.sh
```

This compiles the codebase using Maven into a self-contained jar file (`/tmp/codecrafters-build-shell-java/codecrafters-shell.jar`) with `--enable-preview` flags and starts the shell REPL.

---

## 🧪 Testing and Submission

To submit your progress or run remotable test cases:

1. Install the [CodeCrafters CLI](https://codecrafters.io/cli).
2. Execute the submission command:
   ```bash
   codecrafters submit
   ```
