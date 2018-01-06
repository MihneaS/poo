package commands;

import entities.Hero;
import game.GameState;

import static entities.Hero.Direction.*;

public class MoveCommand implements Command {
    Hero hero;
    Hero.Direction dir;

    public MoveCommand(Hero hero, Hero.Direction dir) {
        this.hero = hero;
        this.dir = dir;
    }

	@Override
	public void undo() {
        hero.move(dir.opus());
	}

	@Override
	public void execute() {
        hero.move(dir);
    }

    // TODO implement the move command

    /*  - MoveCommand(Hero, Direction)
        - void undo()
        - void execute()
        - maybe helper method for undo ?
    */
}
