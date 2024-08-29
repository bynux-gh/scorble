# scorble
## A score calculator for Scrabble

Scorble is a simple command line calculator for quickly counting up points on a
word in Scrabble. It supports double and triple letter and word scores and blank
tiles, and can even calculate properly if two word score tiles are covered!

### Installation

#### From Releases

Scorble is available both as a Java-compatible executable (all platforms) or as
a Linux native executable via Scala Native (Linux x86_64 only). Either version can be
downloaded from Releases. I will also be making it available on the AUR in the
near future for Arch/EndeavourOS/Manjaro users.

#### From Source

Building this requires [Scala CLI](https://scala-cli.virtuslab.org/), Scala's default command
line tool. Install it from the link above.

- Clone the repository to your computer
```sh
git clone https://github.com/digital-diplomat/scorble.git
```

- Navigate into the directory
```sh
cd scorble
```

- Compile the program using either Scala Native…
```sh
scala-cli --power package --native -o scorble --native-mode release-fast scorble.scala
```

- …or to an executable Java package (requires a modern JRE install)
```sh
scala-cli --power package -o scorble --assembly
```

Either option will create an executable that can be run in the terminal with `./scorble`.

### Usage

Running Scorble without a word will start an interactive loop, e.g. for an ongoing game.

- Use `_` for a blank tile. This will automatically be calculated as 0.
- Use `2` or `3` after a letter for double/triple letter scores respectively.
  - (Ex: `driv3ers` means the 'v' tile is on a triple letter square)
- Use them at the beginning of a word to signify a double/triple word score.
  - Ex: `3fork2s` if _any_ letter is on the triple word square.

You can then exit the program with Ctrl-D or by pressing Enter with no input.
