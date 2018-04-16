package nghia.command.application.ex2;

public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //observer method
    public final void play(){

        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
