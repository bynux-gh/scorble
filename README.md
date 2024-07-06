# scorble
## A score calculator for Scrabble

Scorble is a simple command line calculator for quickly counting up points on a
word in Scrabble. It supports double and triple letter and word scores and blank
tiles, and can even calculate properly if two word score tiles are covered!

### Installation

#### From Releases

The compiled `.jar` can be found in Releases. Download, place where you want it,
and run it with `java -jar $PATH_TO_JAR [word]`

#### From Source

Building this requires [sbt](https://www.scala-sbt.org/), Scala's de-facto build
tool. After installing sbt on your computer:

- Clone the repository to your computer
```sh
git clone https://github.com/digital-diplomat/scorble.git
```
- Navigate into the directory
```sh
cd scorble
```
- Compile the program, then create a Java-compatible jar.
```sh
sbt compile && sbt assembly
```

The compiled binary can be found in `$PROJECT_ROOT/target/scala-$VERSION/`

### Usage

Run the program with `java -jar $PATH_TO_JAR [word]`. Running Scorble without a
word will start an interactive loop, e.g. for an ongoing game.

- Use `_` for a blank tile. This will automatically be calculated as 0.
- Use `2` or `3` after a letter for double/triple letter scores respectively.
  - (Ex: `driv3ers` means the 'v' tile is on a triple letter square)
- Use them at the beginning of a word to signify a double/triple word score.
  - Ex: `3fork2s` if _any_ letter is on the triple word square.

You can then exit the program with Ctrl-D or by pressing Enter with no input.
